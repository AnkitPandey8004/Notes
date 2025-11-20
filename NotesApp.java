package ansh.Internshipp;
import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n1. Write Notes");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    writeNotes(fileName, sc);
                    break;
                case 2:
                    readNotes(fileName);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Write to file using FileWriter
    public static void writeNotes(String fileName, Scanner sc) {
        try {
            System.out.print("Enter your note: ");
            String note = sc.nextLine();

            FileWriter writer = new FileWriter(fileName, true); // true = append mode
            writer.write(note + "\n");
            writer.close();

            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
        }
    }

    // Read from file using BufferedReader
    public static void readNotes(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\n--- Saved Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}
