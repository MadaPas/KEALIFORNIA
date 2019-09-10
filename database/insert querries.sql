USE kealifornia;

INSERT INTO hotel (name)
VALUES ("Hotel 1"),
	   ("Hotel 2"),
	   ("Hotel 3"),
	   ("Hotel 4"),
	   ("Hotel 5");

INSERT INTO roomType (name, price, capacity, description)
VALUES ("Standard Single", 1, 200, "Single bed in a cozy room with free wifi for one person"),
	   ("Standard Double", 2, 300, "Double bed in a cozy room with free wifi for 2 people"),
	   ("Standard Twin", 2, 300, "Twin beds in a cozy room with free wifi for 2 people"),
	   ("Exclusive Double", 4, 500, "Double bed in a cozy and spacious room with an amazing view for maximum 4 people"),
	   ("Exclusive Twin", 4, 500, "Twin beds in a cozy and spacious room with an amazing view for maximum 4 people"),
	   ("Presidential Suite", 5, 700, "Set in higher floors, spacious and comfortable room with mini-bar and private elevator for maximum 5 people" );
       
INSERT INTO room (roomType_id, hotel_id, room_no)
VALUES (1, 1, 1), (1, 2, 1), (1, 3, 1), (1, 4, 1), (2, 5, 1), (2, 1, 2), (2, 2, 2), (2, 3, 2), (3, 4, 2), (3, 5, 2), (3, 1, 3), (3, 2, 3), (4, 3, 3), (4, 4, 3), (4, 5, 3), (4, 1, 4), (5, 2, 4), (5, 3, 4), (5, 4, 4), (5, 5, 4), (6, 1, 5), (6, 2, 5), (6, 3, 5), (6, 4, 5), (6, 5, 5);

INSERT INTO user (first_Name, last_Name, email)
VALUES ("Plamena", "Stef", "plam@mail.com"),
	   ("Madalina", "Pas", "mada@mail.com"),
       ("Yewon", "Seo", "yenny@mail.com"),
       ("Johan", "Naerby", "jfbn@mail.com");
       
INSERT INTO booking (room_id, user_id, start_date, end_date, no_of_guests)
VALUES (1, 1, "2019-09-01", "2019-09-03", 1),
       (5, 2, "2019-09-10", "2019-09-17", 2),
	   (9, 3, "2019-09-15", "2019-09-20", 2),
	   (13, 4, "2019-09-21", "2019-09-25", 4),
	   (17, 1, "2019-08-01", "2019-08-15", 4),
	   (21, 2, "2019-08-25", "2019-09-01", 5);


              
	INSERT INTO currency (name, rate)
    VALUES ("EUR", 7.45926),
           ("USD", 6.75128),
           ("RON", 1.57729),
           ("BGN", 3.81401),
           ("KRW", 0.00565),
           ("SEK", 0.69926),
           ("NOK", 0.75650);