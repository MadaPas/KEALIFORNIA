$(function(){

let booking;

    booking = {
        "roomId": 1,
        "customerId": 1,
        "startDate": "2019-02-02",
        "endDate": "2019-02-07",
        "noOfGuests": 3
    }


    //
    $.ajax({
        type: 'POST',
        url:'/api/bookings',
        dataType: 'json',
        data: JSON.stringify(booking),
        contentType: 'application/json; charset=utf-8'
    })
        .done(console.log("ajax sent"));

    $.ajax({
        type: 'GET',
        url:'/api/bookings',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8'
    })
        .done(data => {
            console.log(data);
        });


});