import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NumberGuessingGame
{
    private Scanner scanner;
    private  int[] perfromance = new  int[3];
    {
        perfromance[0]= Integer.MAX_VALUE;//level 1
        perfromance[1]= Integer.MAX_VALUE;// level2
        perfromance[2]= Integer.MAX_VALUE;// level 3
    }
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
        Engine.set_level(difficulty_level);
        Engine.Set_score_by_level(perfromance);
        Engine.startGame();
        

    }
    private void showHighscore()
    {
        for(int i = 0; i < perfromance.length; i++)
        {
            if(perfromance[i] <=10)
                System.out.print("Your best score at level" + " "+ (i+1) + " " + "was" + " " + perfromance[i] + " ");
        }
    }
    public static void main(String[] args)
    {


        Scanner input = new Scanner(System.in);
        NumberGuessingGame Game = new NumberGuessingGame(input);
        while(true) {
            Game.Run();
            System.out.println("Would you like to play again? (Press any char to start a new round or N to quite )");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                Game.showHighscore();
                break;
            }

        }
        input.close();
    }
}