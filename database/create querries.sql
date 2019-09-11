DROP DATABASE kealifornia;
CREATE DATABASE IF NOT EXISTS kealifornia;
USE kealifornia;
CREATE TABLE hotel ( 
	id INT NOT NULL auto_increment, 
    name VARCHAR (255), 
    PRIMARY KEY (id));

CREATE TABLE roomType ( 
	id INT NOT NULL auto_increment, 
	name VARCHAR (255), 
	capacity INT, 
    price DOUBLE, 
	description VARCHAR (255), 
	PRIMARY KEY (id));

CREATE TABLE room ( 
	id INT NOT NULL auto_increment, 
    roomType_id INT, 
    hotel_id INT, 
    room_no INT, 
    PRIMARY KEY (id));
    
CREATE TABLE user ( 
	id INT NOT NULL auto_increment, 
	first_name VARCHAR (255), 
	last_name VARCHAR (255), 
	email VARCHAR (255), 
	PRIMARY KEY (id));
    
CREATE TABLE booking ( 
	id INT NOT NULL auto_increment, 
	room_id INT, 
	user_id INT, 
	start_date DATE NULL, 
	end_date DATE NULL,
	no_of_guests INT, 
	PRIMARY KEY (id));

CREATE TABLE currency ( 
	id INT NOT NULL auto_increment, 
	name VARCHAR (255), 
	rate DOUBLE, 
	PRIMARY KEY (id));