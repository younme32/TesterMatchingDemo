CREATE DATABASE testerDB;
USE testerDB;
CREATE TABLE Tester (
	ID INTEGER,
    FirstName varchar(255),
    LastName varchar(255),
    Country varchar(255),
    LastLogin DATETIME
);
CREATE TABLE Devices(
	ID INTEGER,
    Descr varchar(255)
);
CREATE TABLE Bugs(
	ID INTEGER,
    DeviceID INTEGER,
    TesterID INTEGER
);
CREATE TABLE Tester_Devices(
	TesterID INTEGER,
    DeviceID INTEGER
);