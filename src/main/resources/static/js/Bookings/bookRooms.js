$(function() {

    // get data

    // set up targeting variables
    let selectNoOfGuests = $('#selectNoOfGuests');
    let showRoomTypesButton =   $('#showRoomTypesButton');
    let roomContainer =         $('#roomContainer');
    let userInfoContainer =     $('#userInfoContainer');
    let confirmBookingButton =  $('#confirmBookingButton');

    // values
    let startDate =             moment($('#start-date').innerHTML).format("YYYY-MM-DD");
    let endDate =               moment($('#end-date').innerHTML).format("YYYY-MM-DD");
    let noOfGuests =            $('.dropdown-item').data("attr");
    let selectedRoomType =      $('').val();

    selectNoOfGuests.on('click', 'a', function() {

        showAvailableRoomTypes(getRoomsWithinDatesWithNoOfGuests(startDate, endDate, this.innerHTML));

    });

    // //set up event listeners
    // showRoomTypesButton.on('click', () => {
    //     roomTypes = getAllRoomTypes();
    // })








});