function showAvailableRoomTypes(roomTypes) {

    console.log(roomTypes);

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
                                                    <tbody id="availableRoomTypes-table"></tbody>
                                                </table>
                                            </form>`);

    roomTypes.forEach((roomType) => {
            $('#availableRoomTypes-table').append(` <tr class="d-flex">
                                                            <td class="col-3" id="roomType" data-attr="${roomType.id}">${roomType.name}</td>
                                                            <td class="col-2" id="capacity" data-attr="${roomType.id}">${roomType.capacity}</td>
                                                            <td class="col-1" id="price" data-attr="${roomType.id}">${roomType.price}</td>
                                                            <td class="col-5" id="description" data-attr="${roomType.id}">${roomType.description}</td>
                                                            <td class="col-1" id="clickButton" data-attr="${roomType.id}"><a class="btn btn-outline-dark" id="selectButton">select</a></td>
                                                        </tr>`);
    });

}


