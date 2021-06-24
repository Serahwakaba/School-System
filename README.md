# School_system

### By Muriithi Joyce, Joseph Kabue and Sarah Wakaba

## Description :notebook:

The Project simulates a simple but very functional program to be used to Manage some issues in Schools like: students coursework, Hostel, etc.
### Live Link



### Prerequisites

 * An up-to-date browser, preferably chrome or mozilla
 * Internet connection


### Technologies used

[Java ]
* [Intellij Idea]
* [Spark]
* [HTML]
* [Gradle]
* [Postgres SQL]
* [CSS & Bootstrap]

  ### END POINTS:


                |URL                                            |HTTP            |DESCRIPTIONS         
                          
               |/home                                           |get             |Get home page                       
               |/profile                                        |get             |get student's profile          
               |/user/sign-up                                   |get             |signing up in account
               |/users/new                                      |post            |post  users       
               |/user/login                                     |post            |login in account     
               |/users                                          |get             |get users                       
               |/users/:id                                      |get             |get users Id                               
               |/Students/new                                   |get             |get new stdent
               |/Students/new",                                 |post            |post new student
               |/Apartments"                                    |get             |get Apartments

### Installation guide :notebook:

  If you want to use this as your template, here's how to go about it:

  * Install Git on you machine
  * Maneouver to 'clone or download' button and get the link
  * --Linux Users-- open your terminal and run the 'git clone ...' command in a directory of your choice
  * --for Windows Users-- Navigate to the location you'd want the repository located, right click and select "git bash here"
  * Clone the repository
  * Upon completion, navigate to the cloned repository
  Feel free to edit the files to your prefered taste

  * Now build the Database to enable storing of created instances
### CREATING TABLES:
In Postgres SQL:

    * CREATE DATABASE school_system;

    * CREATE TABLE students (id serial PRIMARY KEY, name varchar,phone varchar, roomNumber int,floor int, apartmentId int);

    * CREATE TABLE apartments (id serial PRIMARY KEY, name varchar,location varchar, type varchar, numberofrooms varchar, numberoffloors int);

    * CREATE TABLE users (id serial PRIMARY KEY, name varchar,email varchar, username varchar, password varchar);

* CREATE TABLE issues (id serial PRIMARY KEY, type varchar, content varchar, apartmentId varchar, roomId varchar);
  * CREATE DATABASE school_system_test;

    ### DROPPING TABLES
     
     *  nativage to main/resources/db 
     
     * run  psql < drop.sql



### support $ contact:

* Phone number's: [+254713951234]
  [+254712455634]
  [+245703661311]
* Email:
  
  joseph@gmail.com,
  
  joyce@gmail.com
  
  sara@gmail.com
### LICENSE
 This website is under the MIT license which can be found [HERE](LICENSE).
 Copyright (c) 2021 waruguru,kabue and wakaba
