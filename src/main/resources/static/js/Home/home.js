$(function () {

    console.log(localStorage.getItem("hotelID"),localStorage.getItem("hotelName"));
    const hotelName = localStorage.getItem("hotelName");
    $('.navbar-brand').append(hotelName);
    $('.pageTitle').append(hotelName);
})