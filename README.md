
# Superhero API

- [Superhero API](#superhero-api)
  * [Overview](#overview)
- [Explore REST APIs](#explore-rest-apis)
  * [superhero]
    + [Create superhero](#create-superhero)
    + [Get all existing superheros](#get-all-existing-superheros)
    + [Get a id specified superhero](#get-a-id-specified-superhero)
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
| POST | /api/superhero| Create a superhero object | [Create superhero](#http://localhost:8080/api/superhero) |
| GET | /api/superhero | Get all existing superheros | [Get all existing superheros](#http://localhost:8080/api/superhero) |
| GET | /api/superhero/{id} | Get a id specified superhero | [Get a id specified superhero](#http://localhost:8080/api/superhero/{id}) |
| DELETE | /api/superhero/{id} | Delete a id specified superhero  | [Delete a id specified](#http://localhost:8080/api/superhero/{id}) |


### Create superhero
- API Request Description
This endpoint allows you to create a new superhero by sending a POST request to the specified URL.

## Request Body
- createdAt (string) - The date and time when the superhero was created.
- updatedAt (string) - The date and time when the superhero was last updated.
- alias (string) - The alias or superhero name.
- name (string) - The real name of the superhero.
- origin (string) - The origin or background of the superhero.
- associations (array) - An array of associations with other entities, each containing:
- associationName (string) - The name of the association.

- Request Body:
   ```json
     {
    "createdAt": "2024-06-11T14:00:00.000+00:00",
    "updatedAt": "2024-06-11T14:00:00.000+00:00",
    "alias": "Man Mand",
    "name": "Alien super",
    "origin": "Kidnapped in Afghanistan, created the first iron-man suit to escape.",
    "associations": [
        {
            "associationName": "SPACE_STONE"
        },
        {
            "associationName": "SKRULLS"
        },
        {
            "associationName": "KREE"
        }
    ],
    "powers": [
        {
            "powerName": "GENIUS_INTELLIGENCE"
        },
        {
            "powerName": "WEALTH"
        }
    ],
    "weapons": [
        {
            "weaponName": "ARC_REACTOR"
        },
        {
            "weaponName": "IRON_MAN_SUIT"
        },
        {
            "weaponName": "IRON_LEGION"
        }
    ]
}
  


### Get all existing superheros
- Description: API Request Description
This API endpoint sends an HTTP GET request to retrieve information about a superhero.

## Request Body
This request does not require a request body.

## Response Body
The response is in JSON format and represents an array of superhero objects. Each superhero object contains the following properties:
- id (number): The unique identifier of the superhero.
- createdAt (string): The timestamp when the superhero record was created.
- updatedAt (string): The timestamp when the superhero record was last updated.
- alias (string): The alias or superhero name.
- name (string): The full name of the superhero.
- origin (string): The origin or background of the superhero.
- powers (array): An array of objects representing the powers possessed by the superhero. Each power object contains an id (number) and powerName (string).
- weapons (array): An array of objects representing the weapons used by the superhero. Each weapon object contains an id (number) and weaponName (string).
- associations (array): An array of objects representing the associations or groups the superhero is affiliated with. Each association object contains an id (number) and 
  associationName (string).

- Response Body:
   ```json
   [
    {
        "id": 5,
        "createdAt": "2024-06-11T14:00:00.000+00:00",
        "updatedAt": "2024-06-11T14:00:00.000+00:00",
        "alias": "Iron Man",
        "name": "Tony Stark",
        "origin": "Kidnapped in Afghanistan, created the first iron-man suit to escape.",
        "powers": [
            {
                "id": 9,
                "powerName": "GENIUS_INTELLIGENCE"
            },
            {
                "id": 10,
                "powerName": "WEALTH"
            }
        ],
        "weapons": [
            {
                "id": 4,
                "weaponName": "ARC_REACTOR"
            },
            {
                "id": 5,
                "weaponName": "IRON_MAN_SUIT"
            },
            {
                "id": 6,
                "weaponName": "IRON_LEGION"
            }
        ],
        "associations": [
            {
                "id": 1,
                "associationName": "SPACE_STONE"
            },
            {
                "id": 2,
                "associationName": "SKRULLS"
            },
            {
                "id": 3,
                "associationName": "KREE"
            }
        ]
    },
    {
        "id": 6,
        "createdAt": "2024-06-11T14:00:00.000+00:00",
        "updatedAt": "2024-06-11T14:00:00.000+00:00",
        "alias": "Iron Man",
        "name": "Tony Stark",
        "origin": "Kidnapped in Afghanistan, created the first iron-man suit to escape.",
        "powers": [
            {
                "id": 11,
                "powerName": "GENIUS_INTELLIGENCE"
            },
            {
                "id": 12,
                "powerName": "WEALTH"
            }
        ],
        "weapons": [
            {
                "id": 7,
                "weaponName": "ARC_REACTOR"
            },
            {
                "id": 8,
                "weaponName": "IRON_MAN_SUIT"
            },
            {
                "id": 9,
                "weaponName": "IRON_LEGION"
            }
        ],
        "associations": [
            {
                "id": 4,
                "associationName": "SPACE_STONE"
            },
            {
                "id": 5,
                "associationName": "SKRULLS"
            },
            {
                "id": 6,
                "associationName": "KREE"
            }
        ]
    }
]


### Get a id specified superhero
- Description: Request Description
This endpoint is used to retrieve information about a specific superhero by providing the superhero's ID in the request URL.

## Request Body
This request does not require a request body.

## Response Body
The response will be in JSON format and will contain information about the superhero, including the superhero's ID, creation and update timestamps, alias, name, origin, powers, weapons, and associations.

- Response Body:
```json
{
    "id": 5,
    "createdAt": "2024-06-11T14:00:00.000+00:00",
    "updatedAt": "2024-06-11T14:00:00.000+00:00",
    "alias": "Iron Man",
    "name": "Tony Stark",
    "origin": "Kidnapped in Afghanistan, created the first iron-man suit to escape.",
    "powers": [
        {
            "id": 9,
            "powerName": "GENIUS_INTELLIGENCE"
        },
        {
            "id": 10,
            "powerName": "WEALTH"
        }
    ],
    "weapons": [
        {
            "id": 4,
            "weaponName": "ARC_REACTOR"
        },
        {
            "id": 5,
            "weaponName": "IRON_MAN_SUIT"
        },
        {
            "id": 6,
            "weaponName": "IRON_LEGION"
        }
    ],
    "associations": [
        {
            "id": 1,
            "associationName": "SPACE_STONE"
        },
        {
            "id": 2,
            "associationName": "SKRULLS"
        },
        {
            "id": 3,
            "associationName": "KREE"
        }
    ]
}







