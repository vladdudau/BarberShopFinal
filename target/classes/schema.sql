CREATE DATABASE if NOT EXISTS barbershop;

CREATE TABLE IF NOT EXISTS appointment (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `barber_id` INT NOT NULL,
                                            `iscancelled` TINYINT NOT NULL,
                                            `paymenttype` VARCHAR(45) NOT NULL,
                                            `date` DATE NOT NULL,
                                            `starttime` VARCHAR(45) NOT NULL,
                                            `endtime` VARCHAR(45) NOT NULL,
                                            `appointments_products_id` INT NOT NULL,
                                            PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS barber(
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `name` VARCHAR(45) NOT NULL,
                                       `gender` VARCHAR(45) NOT NULL,
                                       `phonenumber` VARCHAR(10) NOT NULL,
                                       `seatnumber` INT NOT NULL,
                                       PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS product (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(45) NOT NULL,
                                        `purchasePrice` DECIMAL(10,2) NOT NULL,
                                        `productcol` VARCHAR(45) NOT NULL,
                                        `appointments_products_id` INT NOT NULL,
                                        PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS work_schedule (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `barber_id` INT NULL,
                                              `workdays` VARCHAR(100) NOT NULL,
                                              `starttime` VARCHAR(45) NOT NULL,
                                              `endTime` VARCHAR(45) NOT NULL,
                                              PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS customer {
   `id` INT NOT NULL,
   `name` VARCHAR(45) NULL,
    `gender` VARCHAR(45) NULL,
    `phone_number` VARCHAR(10) NULL,
    PRIMARY KEY (`id`));
}