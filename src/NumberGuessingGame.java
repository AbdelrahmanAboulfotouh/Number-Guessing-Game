import java.util.Scanner;

public class NumberGuessingGame
{


    public void Run ()
    {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have limited chances to guess the correct number.");
        System.out.println("--------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        MainMenu Menu = new MainMenu(input);
        Menu.ShowMenu();
        int difficulty_level = Menu.Get_level();

        GameEngine Engine = new GameEngine(input);
        Engine.Set_trails(difficulty_level);
        Engine.startGame();

    }

    public static void main(String[] args)
    {

        NumberGuessingGame Game = new NumberGuessingGame();
        Game.Run();
    }
}