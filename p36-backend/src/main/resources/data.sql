--CREATE DATABASE IF NOT EXISTS p36;
--USE p36;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id int(11) primary key,
  firstName varchar(255),
  lastName varchar(255),
  --username varchar(255),
  email varchar(255),
  password varchar(255),
  role varchar(50)
);

/*
password: duck
*/

INSERT INTO users(id, firstName, lastName,  email, password, role)
 VALUES (1, 'Donald', 'Duck', 'dd@duck.com', '$2a$10$839dntJVZi/hA1uFbMDyOufs2bbGo6gRNQyvUE7r3FiI0Wb1WZMzS', 'ROLE_ADMIN');


DROP TABLE IF EXISTS address;
CREATE TABLE address(
  id int(11) primary key,
  zipCode int(10),
  settlement varchar(255),
  publicPlace varchar(255),
  streetNumber int(10)
);

--INSERT INTO address() VALUES();


DROP TABLE IF EXISTS bankcard;
CREATE TABLE bankcard(
  id int(11) primary key,
);

--INSERT INTO bankcard() VALUES();


DROP TABLE IF EXISTS EURO;
CREATE TABLE EURO(
  id int(11) primary key,
  accountNumber int(50),
  amount int(20)
);

--INSERT INTO EURO() VALUES();


DROP TABLE IF EXISTS HUF;
CREATE TABLE HUF(
  id int(11) primary key,
  accountNumber int(50),
  amount int(20)
);

--INSERT INTO HUF() VALUES();


--DROP TABLE IF EXISTS;
--CREATE TABLE ();

--INSERT INTO () VALUES();


--DROP TABLE IF EXISTS;
--CREATE TABLE ();

--INSERT INTO () VALUES();
