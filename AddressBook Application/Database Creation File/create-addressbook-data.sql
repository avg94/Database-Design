/*
Name: Ajit Vithal Gaikwad
	  avg180001
	  CS 6360.501
Project:- SQL Programming Project - AddressBook Application - Database Creastion in MYSQL
*/

DROP DATABASE IF EXISTS ADDRESSBOOK;

CREATE DATABASE ADDRESSBOOK;

USE ADDRESSBOOK;

DROP TABLE IF EXISTS CONTACT;
CREATE TABLE CONTACT (
	Contact_id INT NOT NULL AUTO_INCREMENT,
	FirstName VARCHAR(25) NOT NULL,
	MiddleName VARCHAR(25),
	LastName VARCHAR(25),
	CONSTRAINT pk_contact PRIMARY KEY (Contact_id)
);

DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE ADDRESS (
	Address_id INT NOT NULL AUTO_INCREMENT,
	Contact_id INT NOT NULL,
	Address_type VARCHAR(10),
	Address VARCHAR(200),
	City VARCHAR(25),
	State VARCHAR(25),
	Zip CHAR(5),
	CONSTRAINT pk_address PRIMARY KEY (Address_id, Contact_id),
	CONSTRAINT fk_address_contact FOREIGN KEY (Contact_id) REFERENCES CONTACT(Contact_id)
);

DROP TABLE IF EXISTS PHONE;
CREATE TABLE PHONE (
	Phone_id INT NOT NULL AUTO_INCREMENT,
	Contact_id INT NOT NULL,
	Phone_type VARCHAR(10),
	AreaCode CHAR(3),
	Numbers CHAR(8),
	CONSTRAINT pk_phone PRIMARY KEY (Phone_id, Contact_id),
	CONSTRAINT fk_phone_contact FOREIGN KEY (Contact_id) REFERENCES CONTACT(Contact_id)
);

DROP TABLE IF EXISTS DATES;
CREATE TABLE DATES (
	Date_id INT NOT NULL AUTO_INCREMENT,
	Contact_id INT NOT NULL,
	Date_type VARCHAR(10),
	Dates DATE,
	CONSTRAINT pk_dates PRIMARY KEY (Date_id, Contact_id),
	CONSTRAINT fk_dates_contact FOREIGN KEY (Contact_id) REFERENCES CONTACT(Contact_id)
);



INSERT INTO CONTACT VALUES
    (1,'Ajit','Vithal','Gaikwad'),
    (2,'Sherwood',NULL,'Spoerl'),
    (3,'Crosby',NULL,'Seide'),
    (4,'Hogan',NULL,'Spafford'),
    (5,'Kenton','Rog','Sibbald');


	
INSERT INTO ADDRESS VALUES
    (1,1,'home','7815 McCallum Blvd R10202','Richardson','Texas',75252),
    (2,1,'work','90103 Glacier Hill Terrace','Plano','Texas',75003),
    (3,2,'home','2287 Sutteridge Park','Dallas','Texas',75062),
    (4,2,'work','37 Sommers Hill','Addison','Texas',75006),
    (5,3,'home',NULL,NULL,NULL,75029),
    (6,4,'home',NULL,NULL,NULL,75099),
    (7,4,'work','37 Sommers Hill','Addison','Texas',75006),
    (8,5,'home','62477 Hovde Hill','Allen','Texas',75061),
    (9,5,'work','35836 Banding Way','Richardson','Texas',75004);
	

	
INSERT INTO PHONE VALUES
    (1,1,'cell',469,'395-1396'),
    (2,1,'work',575,'780-6481'),
    (3,2,'home',441,'557-2835'),
    (4,2,'cell',907,'913-3698'),
    (5,2,'work',526,'691-3663'),
    (6,3,'home',998,'239-4082'),
    (7,3,'cell',637,'715-3867'),
    (8,3,'work',470,'347-7202'),
    (9,4,'cell',359,'747-1907'),
    (10,5,'home',317,'756-0975'),
    (11,5,'cell',543,'710-0843'),
    (12,5,'work',672,'643-5210');


INSERT INTO DATES VALUES
    (1,2,'BirthDate','1986-06-07'),
    (2,3,'BirthDate','1965-06-23'),
    (3,5,'BirthDate','1972-05-11');
