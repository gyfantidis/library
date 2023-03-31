package library;

import java.io.*;

public class ReadAndWriteToFile {
    //Write to the file
    public static void writeLibraryState(Library l, String filename) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(filename));
        } catch (Exception e) {
            System.out.println("Something went wrong while opening file for writing");
            System.out.println("Cause : " + e.getMessage());
            System.out.println("Exiting!!!");
            //System.exit(-1);
        }

        try {
            oos.writeObject(l);
            oos.close();
        } catch (Exception e) {
            System.out.println("Something went wrong while attempting to write the state");
            System.out.println("Cause : " + e.getMessage());
            System.out.println(e.toString());
            System.out.println("Exiting!!!");
            //System.exit(-1);
        }
    }

    //read from the file
    public static Library readLibraryState(String filename) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Something went wrong while opening file for reading");
            System.out.println("Cause : " + e.getMessage());
            return null;
        }

        try {
            Library l = (Library) ois.readObject();
            ois.close();
            return l;
        } catch (Exception e) {
            System.out.println("Something went wrong while attempting to read the state");
            System.out.println("Cause : " + e.getMessage());
            System.out.println(e.toString());
            System.out.println("Exiting!!!");
            //System.exit(-1);
        }

        return null;


    }
}
