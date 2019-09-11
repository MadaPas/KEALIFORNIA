$(function() {

    console.log('bookRooms js loaded');

    let roomTypes;
    let selectedRoomType, selectedRoomName, selectedRoom;
    let userInfo, period, guestsNo, booking;
    let roomsWithin, roomsWithType;

    // gets roomTypes from the database
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

    // gets rooms that are available of specific type in between two days
    function getRooms(date1, date2, roomtypeid) {

        roomsWithin = [];
        roomsWithType = [];

        $.ajax({
            url:`/api/rooms/from/${date1}/to/${date2}`,
            method: 'GET',
            dataType: 'json'
        }).done(
            data => {
                roomsWithin.push(data);
                roomsWithin.forEach(function (room){
                   room.forEach(function(aroom){

                       if(aroom.roomType.id == roomtypeid) {
                           roomsWithType.push(aroom);
                       }
                   })
                });

                selectedRoom = roomsWithType[0];
                return selectedRoom;
            }
        )

    }

    // click the button and display the roomTypes that are available
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

    // when a roomType selected, see if they have room on that period, display user info input field
    $('#roomContainer').on('click', '.btn-outline-dark', function() {
        console.log('hh');
       selectedRoomType = $(this).parent().attr('data-attr');
       selectedRoomName = $(this).parent().siblings('td')[0].innerHTML;

       getRooms(period.startDate, period.endDate, selectedRoomType);
       showUserInput();

    });

    function showUserInput() {

        $('#userInfoContainer').fadeIn(100).html(`<form id="user-info">
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

    // create a new user and booking objects, send them to backend in order to store the data in the db
    $('#userInfoContainer').on('click', 'a', function() {

        userInfo = {
            'firstName': $('#first-name').val(),
            'lastName': $('#last-name').val(),
            'email': $('#email').val()
        };

        guestsNo = $('#noOfGuests').val();

        $.ajax({
            url: `/api/users`,
            method: 'POST',
            data: JSON.stringify(userInfo),
            contentType: 'application/json; charset=utf-8',
        }).done(
            data => {
                booking = {
                    'roomId': selectedRoom.id,
                    'userId': data,
                    'startDate': period.startDate,
                    'endDate': period.endDate,
                    'noOfGuests': guestsNo
                }

                showModal(booking);

                $.ajax({
                    url:`/api/bookings`,
                    method: 'POST',
                    data: JSON.stringify(booking),
                    contentType: 'application/json; charset=utf-8'
                }).done(
                    data => {
                        console.log('reservation saved', data);
                    })
            })

    });

    // display confirmation modal
    function showModal(booking) {

        $('#confirm-first-name').html(`${userInfo.firstName}`);
        $('#confirm-last-name').html(`${userInfo.lastName}`);
        $('#confirm-email').html(`${userInfo.email}`);
        $('#confirm-dates').html(`${booking.startDate} to ${booking.endDate}`);
        $('#confirm-room-type').html(`${selectedRoomName}`);

        $('.modal').modal('show');

    }

    $('#confirmButton').on('click', function() {
        alert('The reservation is made successfully. Thank you for choosing KEALIFORNIA.');
        $(location).attr('href', `/`);
    })

});