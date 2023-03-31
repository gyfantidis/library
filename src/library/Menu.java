package library;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    //insert library Member
    public static void getLibraryMember(Scanner input, Library library) {
        System.out.println("Please give id: ");
        String id = input.next();
        System.out.println("Please give name: ");
        String name = input.next();
        System.out.println("Please give member id: ");
        String memberId = input.next();

        LibraryMember lm = new LibraryMember(name, id, memberId);
        boolean result = library.addMember(lm);
        if (result) {
            System.out.println(lm + " added successfully");
        } else {
            System.out.println("Probably " + lm + " already in library");
        }
    }


    public static int getIntInput(Scanner input, String msg) {
        int value = 0;

        do {
            System.out.println(msg);
            try {
                value = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Need to provide a positive integer!");
                input.next();
            }
        } while (value <= 0);
        return value;
    }


    public static Book getBook(Scanner input, boolean lending) {
        System.out.println("Please give isbn: ");
        String isbn = input.next();
        System.out.println("Please give the title: ");
        String title = input.next();
        int copyNum = getIntInput(input, "Please give number of copies: ");

        if (lending) {
            return new LendingBook(isbn, title, copyNum);
        } else {
            return new SellingBook(isbn, title, copyNum);
        }
    }


    public static void getAddBook(Scanner input, boolean lending, Library library) {
        Book book = getBook(input, lending);
        boolean result = false;
        if (lending) {
            result = library.addLendingBook((LendingBook) book);
        } else {
            result = library.addSellingBook((SellingBook) book);
        }

        if (result) {
            System.out.println("Book was successfully added");
        } else {
            System.out.println("Book probably already added in library");
        }
    }


    public static void lendOrSellBook(Scanner input, boolean lending, Library library) {
        System.out.println("Please give isbn: ");
        String isbn = input.next();
        System.out.println("Please give member id: ");
        String memberId = input.next();

        boolean result = false;
        String word1 = "lended";
        String word2 = "lend";

        if (lending) {
            result = library.loanBook(isbn, memberId);
        } else {
            result = library.sellBook(isbn, memberId);
            word1 = "sold";
            word2 = "sell";
        }

        if (result) {
            System.out.println("Book was successfully " + word1);
        } else {
            System.out.println("Something went wrong while trying to " + word2 + " book"
                    + "with isbn: " + isbn + " to member with id: " + memberId);
        }
    }


    public static void returnBook(Scanner input, Library library) {
        System.out.println("Please give isbn: ");
        String isbn = input.next();
        System.out.println("Please give member id: ");
        String memberId = input.next();

        boolean result = library.returnBook(isbn, memberId);
        if (result) {
            System.out.println("Book was successfully returned");
        } else {
            System.out.println("Something went wrong while trying to return book");
        }
    }


}
