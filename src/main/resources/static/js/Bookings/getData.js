function getAllRooms() {
    return $.ajax({
        url: `/api/rooms`,
        method: 'GET',
        dataType: 'json'
    }).done((data) => {
        return data;
    })
}

function getAllBookings() {
     return $.ajax({
        url: `/api/bookings`,
        method: 'GET',
        dataType: 'json'
    }).done((data) => {
        bookings = data;
    })
}

function getAllRoomTypes() {
    $.getJSON(`/api/roomtypes`).done( function (data) {
        return data.responseJSON;
    })
}

function getRoomsWithinDatesForNoOfGuests(sDate, eDate, noOfGuests, roomTypeId) {
    return $.ajax({
        url: `/api/rooms/from/${sDate}/to/${eDate}/with/${noOfGuests}/for/${roomTypeId}`,
        method: 'GET',
        dataType: 'json'
    })
}

function getAvailableRooms(sDate, eDate, noOfGuests, roomTypeId, hotelId) {
    return $.ajax({
        url: `/api/rooms/from/${sDate}/to/${eDate}/with/${noOfGuests}/for/${roomTypeId}/at/${hotelId}`,
        method: 'GET',
        dataType: 'json'
    })
}
