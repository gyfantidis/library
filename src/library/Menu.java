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

        LibraryMember lm = new LibraryMember(id, name, memberId);
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


}
