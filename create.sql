--SET MODE PostgreSQL;

CREATE DATABASE students_system;
\c students_system;

CREATE TABLE users
(
id serial PRIMARY KEY,
name VARCHAR,
email VARCHAR,
username VARCHAR,
password VARCHAR
);

CREATE TABLE students
(
id serial PRIMARY KEY,
name VARCHAR,
phone VARCHAR,
roomnumber int,
floor int,
apartmentid int
);

CREATE TABLE apartments
(
id serial PRIMARY KEY,
name VARCHAR,
location VARCHAR,
type VARCHAR,
numberofrooms int,
numberoffloors int
);

CREATE TABLE issues
(
id serial PRIMARY KEY,
type VARCHAR,
content VARCHAR,
apartmentid VARCHAR,
roomid VARCHAR
);

CREATE DATABASE students_system_test WITH TEMPLATE students_system;