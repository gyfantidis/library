package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library("Library of Kilkis", "Kilkis");
        System.out.println("Menu for Library Management");
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
                    Menu.getLibraryMember(input, library);
                    break;
                case 2:
                    Menu.getAddBook(input, true, library);
                    break;
                case 3:
                    Menu.getAddBook(input, false, library);
                    break;
                case 4:
                    Menu.lendOrSellBook(input, true, library);
                    break;
                case 5:
                    Menu.lendOrSellBook(input, false, library);
                    break;
                case 6:
                    Menu.returnBook(input, library);
                    break;
                case 7:
                    library.printStatus();
                    break;
            }

        } while (choice >= 1 && choice <= 7);

        input.close();
        System.out.println("Exited!!!");
    }
}