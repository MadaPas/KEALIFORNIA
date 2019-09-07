$(function() {

    console.log('bookRooms js loaded');



    let roomTypes = [];
    let room;

    let getRoomTypeInfo = () => {
        $.ajax({
            type: 'GET',
            url: `/api/roomtypes`,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json'
        }).done(
            data => {
                roomTypes = data;
                console.log('after ajax');
            })
    }


    $('#showRoomsButton').on('click', function() {

        getRoomTypeInfo();
        console.log('button clicked');

        //roomType.push(getRoomTypeInfo());
        //console.log(roomType);
        showAvailableRooms(roomTypes);
    });

    function showAvailableRooms(roomTypes) {

        console.log("showing available rooms"   )
        roomTypes.forEach(createRow);

        /*$('#roomContainer').fadeIn(100).html(`<form class="mt-2">
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
                                                        <tr class="d-flex">
                                                            <td class="col-3" id="roomType">${roomTypes.name}</td>
                                                            <td class="col-2" id="capacity">${roomTypes.capacity}</td>
                                                            <td class="col-1" id="price">${roomTypes.price}</td>
                                                            <td class="col-5" id="description">${roomTypes.description}</td>
                                                            <td class="col-1 far fa-check-square"></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </form>`);*/

    }

    function createRow(item, index){

        console.log(item);

        let html = `
        <tr class="d-flex">
            <td class="col-3" >${item.name}</td>
            <td class="col-2" >${item.capacity}</td>
            <td class="col-1" >${item.price}</td>
            <td class="col-5" >${item.description}</td>
            <td class="col-1 far fa-check-square"></td>
        </tr>
        `
    }

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
                                                        <div align="center">
                                                            <button type="submit" class="btn btn-outline-dark btn-lg btn-block">Confirm Reservation</button>
                                                        </div>
                                                     </form>`);

    }

    function showModal() {
        $('.modal').modal('show');
    }

});