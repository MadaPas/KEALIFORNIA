$(function(){


    //
    $.ajax({
        type: 'POST',
        url:'/api/bookings',
        dataType: 'json',
        data: JSON.stringify(booking),
        contentType: 'application/json; charset=utf-8'
    })
        .done


});