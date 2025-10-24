import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private int trials;
    private Scanner scanner;
    private long startTime; // Added to track the start time of the game
    private long endTime;   // Added to track the end time of the game

    GameEngine(Scanner scanner) {
        this.scanner = scanner;
    }

    // Refactored method name from Set_trails to setTrials for Java naming conventions
    public void setTrials(Integer level) {
        if (level == 1) {
            trials = 10;
        } else if (level == 2) {
            trials = 5;
        } else if (level == 3) {
            trials = 3;
        }
    }

    // Refactored method name from Generate_randome_number to generateRandomNumber
    // and variable names for Java naming conventions
    public Integer generateRandomNumber(Integer upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound) + 1;
    }

    public void startGame() {
        System.out.println("Let's start the game!");
        this.startTime = System.currentTimeMillis(); // Record the start time when the game begins
        int upperBound = 100; // Refactored variable name from Upper_Bound to upperBound
        int numberToGuess = generateRandomNumber(upperBound); // Using refactored method
        int attempts = 0;

        while (trials > 0) {
            System.out.println("Enter your guess: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            int guess = scanner.nextInt();
            trials--;
            attempts++;

            // Using refactored method checkGuessResult
            if (checkGuessResult(guess, numberToGuess, attempts)) {
                this.endTime = System.currentTimeMillis(); // Record end time immediately on correct guess
                break; // Exit loop if guess is correct
            }
            if (trials == 0) {
                System.out.println("Out of chances! The correct number was " + numberToGuess + ".");
            }
        }
    }

    // Refactored method name from Won to checkGuessResult for Java naming conventions
    public boolean checkGuessResult(int guess, int numberToGuess, int attempts) {
        if (guess == numberToGuess) {
            System.out.println("Congratulations! You guessed the correct number in  " + attempts + "    attempts.");
            return true;
        } else if (guess > numberToGuess) {
            System.out.println("Incorrect! The number is less than  " + guess + "   .");
        } else {
            System.out.println("Incorrect! The number is greater than   " + guess + "  .");
        }
        return false;
    }

    /**
     * Calculates the elapsed time from the start to the end of a successful game in seconds.
     * @return The elapsed time in seconds, or 0 if the game hasn't been won yet.
     */
    public long getElapsedTimeInSeconds() {
        // Return 0 if timer was not properly set (e.g., game not won yet)
        if (startTime == 0 || endTime == 0) {
            return 0;
        }
        return (endTime - startTime) / 1000;
    }
}