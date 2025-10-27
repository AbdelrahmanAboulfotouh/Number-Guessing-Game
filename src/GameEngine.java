import java.util.Random;
import java.util.Scanner;
public class GameEngine
{
    private int  trials;
    private Scanner scanner;
    GameEngine(Scanner scanner)
    {
        this.scanner = scanner;
    }
    public void Set_trails(Integer level)
    {
        if(level == 1)
        {
            trials = 10;
        }
        else if(level == 2)
            trials = 5;
        else if(level == 3)
            trials = 3;
    }
    public Integer Generate_randome_number(Integer upper_bound)
    {
        Random Rand  = new Random();
        int Random_number = Rand.nextInt(upper_bound) +1;

        return Random_number;
    }
    public void startGame()
    {
        System.out.println("Let's start the game!");
        int Upper_Bound = 100;
        int numberToGuess = Generate_randome_number(Upper_Bound);
        int  attempts =0;
         long startTime = System.currentTimeMillis();

        while (trials > 0)
        {
            System.out.println("Enter your guess: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            int guess = scanner.nextInt();
            scanner.nextLine();
            trials--;
            attempts++;

            if(Won(guess, numberToGuess, attempts, startTime))
                break;

            if (trials == 0)
                System.out.println("Out of chances! The correct number was " + numberToGuess + ".");


        }
    }
    public boolean Won(int guess, int numberToGuess,int attempts, long startTime)
    {
         if(guess == numberToGuess)
         {
             long endtime = System.currentTimeMillis(); long duration = (endtime - startTime) / 1000;
             System.out.println("Congratulations! You guessed the correct number in  " + attempts + "    attempts and " + duration + "   Seconds.");

            return true;
         }
        else if(guess > numberToGuess)
            System.out.println("Incorrect! The number is less than  " + guess + "   .");
        else
            System.out.println("Incorrect! The number is greater than   " + guess + "  .");

        return false;

    }
}
