$(function() {

    console.log('bookRooms js loaded');

    let roomTypes;
    let selectedRoomType, selectedRoom;
    let customerInfo, period, guestsNo, booking;
    let roomsWithin;

    getRoomTypeInfo();

    function getRoomTypeInfo() {
        roomTypes = [];
        $.ajax({
            url: `/api/roomtypes`,
            method: 'GET',
            dataType: 'json'
        }).done(
            data => {
                roomTypes.push(data);
            })
    }

    function getRooms(date1, date2) {

        roomsWithin = [];

        $.ajax({
            url:`/api/rooms/from/${date1}/to/${date2}`,
            method: 'GET',
            dataType: 'json'
        }).done(
            data => {
                roomsWithin.push(data);
                return roomsWithin;
            }
        )

    }

    function getAvailableRoomsOfType(rooms, roomtypeid) {

        rooms.forEach((room)=> {
            console.log(room.roomType.id);
            if(room.roomType.id != roomtypeid) {
                rooms.remove(room);
            }
        });

        return rooms;
    }

    $('#showRoomsButton').on('click', function() {

        period = {
            'startDate': $('#start-date').val(),
            'endDate': $('#end-date').val()
        };

        showAvailableRooms(roomTypes);
    });

    function showAvailableRooms(roomTypes) {

        $('#roomContainer').fadeIn(100).html(`<form class="mt-2">
                                                <h2>Available Rooms</h2>
                                                <table class="table">
                                                    <thead>
                                                        <tr class="d-flex">
                                                            <th class="col-3">Room</th>
                                                            <th class="col-2">Capacity</th>
                                                            <th class="col-1">Price</th>
                                                            <th class="col-5">Description</th>
                                                            <th class="col-1"></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="availableRoom-table">
                                                    </tbody>
                                                    </table>
                                                    </form>`);

        roomTypes.forEach(function (roomTypeArray) {
            roomTypeArray.forEach((roomType)=>{
                $('#availableRoom-table').append(` <tr class="d-flex">
                                                            <td class="col-3" id="roomType" data-attr="${roomType.id}">${roomType.name}</td>
                                                            <td class="col-2" id="capacity" data-attr="${roomType.id}">${roomType.capacity}</td>
                                                            <td class="col-1" id="price" data-attr="${roomType.id}">${roomType.price}</td>
                                                            <td class="col-5" id="description" data-attr="${roomType.id}">${roomType.description}</td>
                                                            <td class="col-1" id="clickButton" data-attr="${roomType.id}"><a class="btn btn-outline-dark" id="selectButton">select</a></td>
                                                        </tr>`);
            });

        });

    }

    $('#roomContainer').on('click', 'a', function() {
       selectedRoomType = $(this).parent().attr('data-attr');

       getRooms(period.startDate, period.endDate);
       console.log('roomswithin', roomsWithin);
       getAvailableRoomsOfType(roomsWithin, selectedRoomType);
       //  let roomList =
       //      console.log('roomlist', roomList);
       // selectedRoom = roomList[0];
       // console.log(selectedRoom);

       // if(roomList.length >= 0) {
       //     showCustomerInput();
       //     selectedRoom = roomList[0];
       //     console.log('selectedRoom', selectedRoom);
       // } else {
       //     alert('There is no available room. Please select another room type.')
       // }
       //

       showCustomerInput();

    });

    function showCustomerInput() {

        $('#customerInfoContainer').fadeIn(100).html(`<form id="customer-info">
                                                        <h2>Please fill in the information.</h2>
                                                            <div class="form-group">
                                                                <label for="first-name">First Name</label>
                                                                <input type="text" class="form-control" id="first-name">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="last-name">Last Name</label>
                                                                <input type="text" class="form-control" id="last-name">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="email">Email</label>
                                                                <input type="email" class="form-control" id="email">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="noOfGuests">Number of Guests</label>
                                                                <input type="number" class="form-control" id="noOfGuests">
                                                            </div>
                                                        <div align="center">
                                                            <a class="btn btn-outline-dark btn-lg btn-block" id="confirmButton">Confirm Reservation</a>
                                                        </div>
                                                     </form>`);

    }

    $('#customerInfoContainer').on('click', 'a', function() {

        customerInfo = {
            'firstName': $('#first-name').val(),
            'lastName': $('#last-name').val(),
            'email': $('#email').val()
        };

        guestsNo = $('#noOfGuests').val();

        $.ajax({
            url: `/api/customers`,
            method: 'POST',
            data: JSON.stringify(customerInfo),
            contentType: 'application/json; charset=utf-8',
        }).done(
            data => {
                booking = {

                    'customerId': data

                }
            })
        showModal();
    });

    function showModal() {

        $('.modal').modal('show');

    }

});