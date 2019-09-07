$(function() {

    console.log('bookRooms js loaded');

    let roomType =[];
    let room = [];

    function getRoomTypeInfo() {
        $.ajax({
            url: `/api/roomtypes`,
            method: 'GET',
            dataType: 'json'
        }).done(
            roomType => {
                roomType.push(roomType);
                console.log('after ajax', roomType);
            })
    }

    $('#showRoomsButton').on('click', function() {

        console.log('button clicked');

        roomType.push(getRoomTypeInfo());
        console.log(roomType);
        showAvailableRooms(roomType);
    });

    function showAvailableRooms(roomType) {

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
                                                        <tr class="d-flex">
                                                            <td class="col-3" id="roomType">${roomType.name}</td>
                                                            <td class="col-2" id="capacity">${roomType.capacity}</td>
                                                            <td class="col-1" id="price">${roomType.price}</td>
                                                            <td class="col-5" id="description">${roomType.description}</td>
                                                            <td class="col-1 far fa-check-square"></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </form>`);

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