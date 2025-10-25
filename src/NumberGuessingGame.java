import java.util.Scanner;

public class NumberGuessingGame
{
    private Scanner scanner;
    NumberGuessingGame(Scanner scanner)
    {
        this.scanner = scanner;
    }
    public void Run ()
    {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have limited chances to guess the correct number.");
        System.out.println("--------------------------------------------------------------------------------------------");

        MainMenu Menu = new MainMenu(scanner);
        Menu.ShowMenu();
        int difficulty_level = Menu.Get_level();

        GameEngine Engine = new GameEngine(scanner);
        Engine.Set_trails(difficulty_level);
        Engine.startGame();
        

    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        NumberGuessingGame Game = new NumberGuessingGame(input);
        while(true) {
            Game.Run();
            System.out.println("Would you like to play again? (Press any char to start a new round or N to quite )");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("N"))
                break;

        }
        input.close();
    }
}