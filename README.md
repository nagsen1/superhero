
# Superhero API

- [Superhero API](#superhero-api)
  * [Overview](#overview)
- [Explore REST APIs](#explore-rest-apis)
  * [superhero]
    + [Create superhero](#create-superhero)
    + [Get all existing superheros](#get-all-existing-superheros)
    + [Get a specified superhero](#get-a-specified-superhero)
    + [Delete superhero](#delete-superhero)

- [Database](#database)
  * [superhero](#superhero)
  * [power](#power)
  * [weapon](#weapon)
  * [association](#association)
- [Testing](#testing)
- [Tech Stack](#tech-stack)

## Overview

- This project is a Superhero `RESTful API` designed to **create Superhero and perform database operation.**
- The user can create a superhero, find all the existing superheroes in the database, and delete a superhero as well.
- The Superhero-API follows a standard "`Controller` <->  (Only interacts with Controller) <-> `Service` <-> `Repository` <-> `Database`" API schema.


# Explore REST APIs

##  Superhero

| Method | Endpoint | Description | Valid API Calls |
| ------ | --- | ----------- | ------------------------- |
| POST | /api/superhero| Create a superhero object | [Create hotel](#create-superhero) |
| GET | /api/superhero | Get all existing hotels | [Get all existing hotels](#get-all-existing-superheros) |
| GET | /api/superhero/{id} | Get a id specified superhero | [Get a user specified hotel](#get-a-id-specified-superhero) |
| DELETE | /api/superhero/{id} | Delete a id specified superhero  | [Delete hotel](#delete-superhero) |


### Create superhero
- Description: Create a superhero object.
- Validation (Throws an `InvalidRequestException` when):
  - Type is not DELUXE, LUXURY, or SUITE
  - Date is not YYYY-MM-DD
  - Only one date is recieved
  - `availableTo` date comes before `availableFrom` date
  - Name is `null`
- Request Body:
   ```json
      { 
      "name" : "String", 
      "type" : "String: (LUXURY, DELUXE, SUITE)", 
      "description" : "String",   
      "availableFrom" : "YYYY-MM-DD", 
      "availableTo" : "YYYY-MM-DD", 
      "status": true 
      }
   ``


### Get all existing hotels
- Description: Get all existing superheros
- Validation (Throws an `InvalidRequestException` when):
  - N/A
-  Request Body: N/A


### Get all available superheros
- Description: Gets all available superhero from the database.


### Get a id specified superheros
- Description: Get a id specified superhero object.
- Validation (Throws an `InvalidRequestException` when):
  -  ID does not exist
-  Request Body: N/A


### Delete superheros
- Description: Delete a id specified superhero.
- Request Body:
  -  Path Variable Integer "id"


# Database
- The database structure contains two tables, a `hotel` table that contains the superhero object.
- And a `reservation` table that contains reservations objects and is associated with the `hotel` table through the `superhero table's Id` by storing it as a foreign key in its "superhero Id" value.
- The table structures and values are as follows:

## hotel
- Id: Integer (Primary Key)
- Name: VarChar
- Type: VarChar [ DELUXE, LUXURY, SUITE ]
- Description: VarChar
- Availiable From: Date YYYY-MM-DD
- Available To: Date YYYY-MM-DD
- Status: Boolean

## reservation
-  Id: Integer (Primary Key)
-  Inventory Id: Integer (Foreign Key)
-  Check in Date: Date YYYY-MM-DD
-  Check out Date: Date YYYY-MM-DD
-  Number of Guests: Integer
-  Status: Boolean


# Testing
- Tests for this project incorporated both JUNit and Integration tests.
- I used Mockito is several unit tests and H2 in memory databases for the integration tests.
- Coverage testing for this project covered 93% of classes, 94% of methods and 85% of lines.
- More elaborate descriptions of the tests and their functionalities can be found in the test folder within this project.


# Tech Stack

- API Creation:
  - Java
  - MySQL
  - SpringBoot
  - Hibernate
  - JPA
  - Lombok
- Testing:
  - JUnit 5
  - Mockito
  - H2
- User Input Testing:
  - Swagger UI
  - Postman




