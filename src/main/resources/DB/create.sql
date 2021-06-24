CREATE DATABASE school_system;
/c school_system;

CREATE TABLE hospital (id serial PRIMARY KEY, name varchar,phoneNumber varchar);
CREATE TABLE administration (id serial PRIMARY KEY, name varchar,phoneNumber varchar);
CREATE TABLE users (id serial PRIMARY KEY, name varchar,phoneNumber varchar);
CREATE TABLE hostels (id serial PRIMARY KEY, name varchar,location varchar);
CREATE TABLE students (id serial PRIMARY KEY, name varchar,admissionNumber varchar, units varchar, email varchar);


