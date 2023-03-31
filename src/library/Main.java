package library;

import java.util.InputMismatchException;
import java.util.Scanner;
import static library.ReadAndWriteToFile.*;
import static library.Menu.*;

public class Main {
    public static void main(String[] args) {

        //Checking if library state exists so as to be loaded
        String fileName = "state.dat";
        Library library = readLibraryState(fileName);
        if (library == null) {
            library = new Library("library of Kilkis", "Kilkis");
        }

        System.out.println("Menu for library Management");
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\nPress 1 for adding new library member");
            System.out.println("Press 2 for adding new lending book");
            System.out.println("Press 3 for adding new selling book");
            System.out.println("Press 4 for lending a book");
            System.out.println("Press 5 for selling a book");
            System.out.println("Press 6 for returning back a book");
            System.out.println("Press 7 for printing library status");
            System.out.println("Press any other number to leave");
            System.out.println("Your choice: ");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Did not give a integer!");
            }
            System.out.println();
            switch (choice) {
                case 1:
                    getLibraryMember(input, library);
                    break;
                case 2:
                    getAddBook(input, true, library);
                    break;
                case 3:
                    getAddBook(input, false, library);
                    break;
                case 4:
                    lendOrSellBook(input, true, library);
                    break;
                case 5:
                    lendOrSellBook(input, false, library);
                    break;
                case 6:
                    returnBook(input, library);
                    break;
                case 7:
                    library.printStatus();
                    break;
            }

            //Store library state pew each method that updates it
            if (choice >= 1 && choice <= 6) {
                writeLibraryState(library, fileName);
            }
        } while (choice >= 1 && choice <= 7);

        input.close();
        System.out.println("Exited!!!");
    }
}