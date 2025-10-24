import java.util.Scanner;


public class MainMenu
{
    private Integer Level;
    private Scanner scanner;
    MainMenu(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public void  Set_level(Integer val)
    {
        if(val >=1 && val<=3)
        {
            Level = val;
        }
        else
            throw  new IllegalArgumentException("Please enter a number between 1 and 3");

        if(Level == 1)
            System.out.println("Great! You have selected the Easy difficulty level.");
        else if(Level == 2)
            System.out.println("Great! You have selected the Medium difficulty level.");
        else if(Level == 3)
            System.out.println("Great! You have selected the Hard difficulty level.");

    }
    public void ShowMenu()
    {
        System.out.println("""
               Please select the difficulty level:
               1. Easy (10 chances)
               2. Medium (5 chances)
               3. Hard (3 chances)
               """);
    }
    public int Get_level()
    {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
            int choice = scanner.nextInt();
            Set_level(choice);

        return Level;
    }
}
