import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Menu {

    int choice;
    String Fname;
    Scanner a = new Scanner(System.in);
    Scanner b = new Scanner(System.in);

    Menu() throws IOException {


        System.out.println(
                """
                        MENU
                        \t1. Create a New File
                        \t2. Choose a File Path
                        \t3. Exit

                        Enter your choice :\040"""
        );

        choice = a.nextInt();
        boolean exists;

        switch (choice) {

            case 1 -> {
                System.out.println("\nEnter the name of the File : ");
                Fname = b.nextLine();
                Fname += ".enc";
                new Newfile(Fname, choice);
            }

            case 2 -> {
                do {
                    System.out.println("Enter the Path of the File: ");
                    Fname = b.nextLine();
                    File tmpDir = new File(Fname);
                    exists = tmpDir.exists();

                    if (!exists) {
                        System.out.println("\nERROR!! : Incorrect File Path\n");
                    }
                }while (!exists);

                new Newfile(Fname,choice);
            }

            case 3 -> System.exit(0);

            default -> {
                System.out.println("ERROR !! : Enter Number between 1-3 !!\n");
                new Menu();
            }
        }
    }
}
