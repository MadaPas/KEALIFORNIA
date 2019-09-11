
$(function () {

    $.getJSON(`/api/hotels`)
        .done(function(hotels) {

                console.log(hotels);
            }
        )

})