import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choice;
        String Fname;
        System.out.println("Enter the Path of the file : ");
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);


        System.out.println(
                """
                        MENU
                        \t1. Create a New File
                        \t2. Encrypt a File
                        \t3. Edit a File
                        \t4. Read a File

                        Enter your choice :\s"""
        );

        choice = a.nextInt();
        System.out.println("\n\nEnter the name of the File : ");

        Fname = b.nextLine();








    }
}
