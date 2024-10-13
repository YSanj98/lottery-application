
# Lottery Application

This is a Spring Boot application for a lottery system where guests can select a pre-populated lottery ticket, register their details, and participate in a lottery draw. The application calculates winnings based on predefined rules.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [API Endpoints](#api-endpoints)
  - [Register Guest with Ticket](#register-guest-with-ticket)
  - [Retrieve All Lotteries](#retrieve-all-lotteries)
- [Running the Application](#running-the-application)

## Features
- Registration of guest details, including name and mobile number.
- Dynamic lottery draw with random number and letter generation.
- Calculation of winnings based on matching numbers and letters.
- Storage of participant details for future reference.

## Technologies Used
- Spring Boot
- Java
- Maven
- H2 Database

## API Endpoints

### 1. Register Guest with Ticket
- **Endpoint**: `POST /api/tickets`
- **Description**: Registers a guest with their selected ticket and calculates the winnings.

#### Sample Request Body
```json
{
    "name": "YSanj98",
    "mobile": "0771234567",
    "ticket": "4 6 2 7 U"
}
```

#### Sample Response
- **Success (200 OK)**:
```json
{
    "guestId": 1,
    "name": "YSanj98",
    "mobile": "0771234567",
    "ticket": "4 6 2 7 U",
    "amountWon": 200.0,
    "percentageWon": 20,
}
```

### 2. Retrieve All Lotteries
- **Endpoint**: `GET /api/lotteries`
- **Description**: Retrieves all lottery draws and guest details.

#### Sample Response
- **Success (200 OK)**:
```json
[
    {
        "lotteryId": 1,
        "lotterySequence": "4 6 2 7 U",
        "drawnSequence": "2 4 6 7 X",
        "jackpot": 1000.0,
        "guests": [
            {
                "guestId": 1,
                "name": "YSanj98",
                "mobile": "0771234567",
                "ticket": "4 6 2 7 U",
                "amountWon": 200.0,
                "percentageWon": 20
            }
        ]
    }
]
```

## Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/YSanj98/lottery-application.git
   cd lottery-application
   ```

2. Build the application using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the API at `http://localhost:8080/api`.

