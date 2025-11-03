import java.util.Random;
import java.util.Scanner;
public class GameEngine
{
    private int  trials;
    private int[] score_by_level;
    private int level;
    private Scanner scanner;
    GameEngine(Scanner scanner)
    {
        this.scanner = scanner;
    }
    public void set_level(int level)
    {
        this.level = level;
    }
    private  void Set_trails()
    {
        if(this.level == 1)
        {
            trials = 10;
        }
        else if(this.level == 2)
            trials = 5;
        else if(this.level == 3)
            trials = 3;
    }
    public void Set_score_by_level(int[]score_by_level)
    {
        this.score_by_level = score_by_level;
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
        Set_trails();
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

            if(trials == attempts )
            {
                suggest_hint(trials, numberToGuess);
            }
            if (trials == 0)
                System.out.println("Out of chances! The correct number was " + numberToGuess + ".");


        }
    }
    private void track_best_score(int attempts)
    {
        if(level == 1)
            score_by_level[0] = Math.min(score_by_level[0], attempts);
        else if(level == 2)
            score_by_level[1] = Math.min(score_by_level[1], attempts);
        else if(level == 3)
            score_by_level[2] = Math.min(score_by_level[2], attempts);
    }
    public boolean Won(int guess, int numberToGuess,int attempts, long startTime)
    {
         if(guess == numberToGuess)
         {
             long endtime = System.currentTimeMillis(); long duration = (endtime - startTime) / 1000;
             System.out.println("Congratulations! You guessed the correct number in  " + attempts + "    attempts and " + duration + "   Seconds.");
             track_best_score(attempts);
            return true;
         }
        else if(guess > numberToGuess)
            System.out.println("Incorrect! The number is less than  " + guess + "   .");
        else
            System.out.println("Incorrect! The number is greater than   " + guess + "  .");

        return false;

    }
    public void suggest_hint(int trials, int targetNumber)
    {
        int upper_bound = Math.min(targetNumber + (trials * 2),100);
        int lower_bound = Math.max(targetNumber - (trials * 2),0);
        System.out.println("\nHint : Number to guess is between " + lower_bound + " and " + upper_bound + ".");
    }
}
