$(function() {

    // get data

    // set up targeting variables
    let selectNoOfGuests = $('#selectNoOfGuests');
    let showRoomTypesButton =   $('#showRoomTypesButton');
    let roomContainer =         $('#roomContainer');
    let userInfoContainer =     $('#userInfoContainer');
    let confirmBookingButton =  $('#confirmBookingButton');

    // values
    let startDate =             moment($('#start-date').val()).format("YYYY-MM-DD");
    let endDate =               moment($('#end-date').val()).format("YYYY-MM-DD");
    let noOfGuests =            $('.dropdown-item').data("attr");
    let selectedRoomType =      $('').val();

    selectNoOfGuests.on('click', 'a', function() {

        //TODO: here is where the problem is
        console.log(startDate, endDate);
        console.log(getRoomsWithinDatesWithNoOfGuests(startDate, endDate, this.innerHTML));
        // showAvailableRoomTypes();

    });

    //set up event listeners
    showRoomTypesButton.on('click', () => {
        roomTypes = getAllRoomTypes();

        console.log(getRoomsWithinDatesWithNoOfGuestsForRoomType("2019-09-10", "2019-09-20", 3, 5));
/*
        console.log(roomTypes);
*/
        //showAvailableRoomTypes(roomTypes);
    })








})