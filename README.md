# Number Guessing Game (Java CLI)

## Overview

The **Number Guessing Game** is a command-line interface (CLI) game built in **Java** using **IntelliJ IDEA** with **Temurin JDK 23**.  
It demonstrates core programming concepts such as input handling, random number generation, conditional logic, and object-oriented design.

The goal of the game is simple: the computer randomly selects a number between **1 and 100**, and the player must guess it within a limited number of attempts, determined by the selected difficulty level.

---

## Features

- **Interactive CLI gameplay** using the Java `Scanner` class.
    
- **Difficulty levels**:
    
    - Easy → 10 chances
        
    - Medium → 5 chances
        
    - Hard → 3 chances
        
- **Dynamic feedback**:
    
    - Informs the player whether their guess is higher or lower than the target number.
        
- **Input validation** to ensure valid numeric input.
    
- **Encapsulated OOP structure** with dedicated classes for menu display, game engine, and main driver.
    

---

## Project Structure

```
src/
│
├── NumberGuessingGame.java   // Entry point and main game flow
├── MainMenu.java             // Handles difficulty selection and input validation
└── GameEngine.java           // Core logic for game execution and number generation
```

---

## Requirements

### Functional Requirements

- Display a welcome message and game rules at startup.
    
- Randomly generate a number between **1 and 100**.
    
- Allow the user to select a difficulty level (Easy, Medium, Hard).
    
- Limit the number of guessing attempts based on difficulty.
    
- Provide feedback after each guess:
    
    - Indicate if the target number is **greater** or **less** than the user’s guess.
        
- End the game when the player either:
    
    - Guesses correctly (with congratulatory message and attempt count), or
        
    - Runs out of chances (display the correct number).
        

### Technical Requirements

- Java SDK: **Temurin-23**
    
- IDE: **IntelliJ IDEA**
    
- Console-based user interaction only (no GUI components)
    

---

## How to Run

### Prerequisites

- Install **Java 23 (Temurin)** or higher
    
- Install **IntelliJ IDEA** (or any preferred Java IDE)
    

### Steps

1. Clone the repository:
    
    ```bash
    git clone https://github.com/AbdelrahmanAboulfotouh/Number-Guessing-Game.git
    ```
    
2. Open the project in **IntelliJ IDEA**.
    
3. Ensure the **Project SDK** is set to **Temurin-23**:
    
    - _File → Project Structure → Project SDK → Temurin-23_
        
4. Run the program:
    
    - Navigate to `NumberGuessingGame.java`
        
    - Click **Run**
        

---

## Example Gameplay

```
Welcome to the Number Guessing Game!
I'm thinking of a number between 1 and 100.
You have limited chances to guess the correct number.
------------------------------------------------------------

Please select the difficulty level:
1. Easy (10 chances)
2. Medium (5 chances)
3. Hard (3 chances)

Enter your choice: 2
Great! You have selected the Medium difficulty level.
Let's start the game!

Enter your guess:
50
Incorrect! The number is greater than 50.
Enter your guess:
75
Incorrect! The number is less than 75.
Enter your guess:
62
Congratulations! You guessed the correct number in 3 attempts.
```

---

## Object-Oriented Design

|Class|Responsibility|
|---|---|
|**NumberGuessingGame**|Main driver of the program. Displays intro, initializes menu and engine.|
|**MainMenu**|Handles user interaction for difficulty selection and ensures valid input.|
|**GameEngine**|Contains the game logic, manages attempts, generates random numbers, and evaluates guesses.|

This separation of concerns ensures modularity and ease of maintenance.

---

## Future Improvements

- Allow multiple rounds (ask player if they want to play again).
    
- Add a **timer** to track how long it takes the user to guess the number.
    
- Implement a **hint system** for additional guidance.
    
- Maintain a **high score system** to record best performance by difficulty level.
    

---

## License

This project is released under the **MIT License**.  

