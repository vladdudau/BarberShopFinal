CREATE DATABASE if NOT EXISTS barbershop;

CREATE TABLE IF NOT EXISTS appointment (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `barber_id` int DEFAULT NULL,
                               `is_cancelled` tinyint DEFAULT NULL,
                               `payment_type` varchar(45) DEFAULT NULL,
                               `date` date DEFAULT NULL,
                               `start_time` varchar(45) DEFAULT NULL,
                               `end_time` varchar(45) DEFAULT NULL,
                               `appointments_products_id` int DEFAULT NULL,
                               `customer_id` int DEFAULT NULL,
                               PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS barber (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) NOT NULL,
                          `gender` varchar(45) NOT NULL,
                          `phone_number` varchar(10) DEFAULT NULL,
                          `seat_number` int NOT NULL,
                          PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `product` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(45) DEFAULT NULL,
                           `purchase_price` decimal(10,2) DEFAULT NULL,
                           `productcol` varchar(45) DEFAULT NULL,
                           `appointments_products_id` int DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `work_schedule` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `barber_id` int DEFAULT NULL,
                                 `workday` varchar(100) NOT NULL,
                                 `start_time` varchar(45) NOT NULL,
                                 `end_Time` varchar(45) NOT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `customer`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(45) DEFAULT NULL,
                            `gender` varchar(45) DEFAULT NULL,
                            `phone_number` varchar(10) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
