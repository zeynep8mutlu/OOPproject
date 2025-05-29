import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        SystemLibrary library = new SystemLibrary();

        SystemLibrary.addBook(new Book("Three-Body Problem","Cixin Liu","2014",
                "Sci-Fi","E-9781784971540","Ye Winjie witnesses" +
                "Red Guards beat her father to death, this event will shape rest of her life " +
                "and future of mankind"));

        SystemLibrary.addBook(new Book("Mansfield Park","Jane Austen","2011",
                "Romance","13-978-0-00-742029","Young Fanny goes to live" +
                "with her wealthy aunt at her grand house in Mansfield Park"));

        SystemLibrary.addBook(new Book("The Picture Of Dorian Gray","Oscar Wilde",
                "2020","Literature","U-5678-34568721","Dorian" +
                "is a good natured young man until he discovers the power of his beauty"));















        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu");
            System.out.println("1.Open file");
            System.out.println("2.Save file");
            System.out.println("3.Save file as");
            System.out.println("4.Close file");
            System.out.println("5.Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter file path: ");
                    String openPath = scanner.nextLine();
                    SystemLibrary.openFile(openPath);
                    break;
                case "2":
                    SystemLibrary.saveFile();
                    break;
                case "3":
                    System.out.print("Enter new file path: ");
                    String savePath = scanner.nextLine();
                    SystemLibrary.saveFileAs(savePath);
                    break;
                case "4":
                    SystemLibrary.closeFile();
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("error");
            }
        }
        scanner.close();
    }
}





