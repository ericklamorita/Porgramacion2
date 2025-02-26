CREATE DATABASE PriceAutoSales;

USE PriceAutoSales;

CREATE TABLE users (
	id int not null,
    user_name varchar(50),
    email varchar(50),
    pwd varchar(100),
    creation_date datetime,
    user_status char,
    PRIMARY KEY (id)
);

INSERT INTO users VALUES (1, "Braulio Sandi", "brav88@hotmail.com", "Admin$1234", CURDATE(), 1);
INSERT INTO users VALUES (2, "Jason Taylor", "jtaylor@gmail.com", "Admin$1234", CURDATE(), 1);

SELECT * FROM users WHERE email = "brav88@hotmail.com" AND pwd = "Admin$1234" AND user_status = 1;

CREATE TABLE cars (
	id int not null,
    brand varchar(50),
    model varchar(50),
    man_year int,
    color varchar(50),
    cc_engine varchar(50),
    fuelType varchar(50),
    mileage int,
    photo varchar(500),
    PRIMARY KEY (id)
);

INSERT INTO cars VALUES(1, "Hyundai", "Tucson", 2022, "White", "1600 Turbo", "Gasoline", 80000, "Images/1.jpg");
INSERT INTO cars VALUES(2, "Mitsubishi", "Montero", 2024, "Black", "2500", "Diesel", 32000, "Images/2.jpg");

SELECT * FROM cars;

DELETE FROM cars where id in (3,4,5,6,7);		

create table brands ( 
 brand varchar(50)
);
insert into brands values('Toyota'),('Honda'),('Ford'),('Chevrolet'),('Nissan'),('BMW'),('Mercedes-Benz'),('Audi'),('Volkswagen'),('Hyundai'),('Kia'),('Subaru'),('Tesla'),('Porsche'),('Ferrari');   
SELECT * FROM brands;

create table fueltype(
fueltype varchar(50)
);
insert into fueltype values ('Gasolina'),('Diésel'),('Eléctrico'),('Hidrógeno');
SELECT * FROM fueltype;

create table models(
models varchar(50)
);
insert into models values ('Camry'),('Corolla'), ('RAV4'),('Civic'),('Accord'),('CR-V'),('Mustang'),('Focus'),('F-150'),('Malibu'),('Silverado'),('Equinox'),('3 Series'),('X5'),('M3'),('C-Class'),('GLC'),('E-Class'),('A4'),('Q5'),('A3'),('Golf'),('Tiguan'),('Jetta'),('Elantra'),('Tucson'),('Sonata'),('Optima'),('Sportage'),('Sorento'),('Outback'),('Forester'),('Impreza'),('Model 3'),('Model S'),('Model X'),('911'),('Cayenne'),('Panamera'),('488 GTB'),('F8 Tributo'),('Portofino');
SELECT * FROM models;	
