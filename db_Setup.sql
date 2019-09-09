create database kealifornia;

CREATE TABLE `kealifornia`.`booking` (
  `id` INT NOT NULL,
  `room_id` INT NULL,
  `customer_id` INT NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `no_of_guest` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `kealifornia`.`customer` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `kealifornia`.`room` (
  `id` INT NOT NULL,
  `isBooked` BIT(1) NULL,
  `type_id` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `kealifornia`.`roomType` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `capacity` INT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`));
