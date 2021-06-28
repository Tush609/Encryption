import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Newfile {

    private final String Fname;
    private final int choice;

    Newfile(String Fname,int num) throws IOException {

        this.Fname = Fname;
        this.choice = num;

        if (num == 1) {
            this.newfile();
        }


        System.out.println(
                """
                        
                        \t1. Edit File
                        \t2. Read File
                        \t3. Encrypt File
                        \t4. Return to Previous Menu
                        \t5. Exit
                        """
        );

        System.out.println("Enter Your Choice : ");

        Scanner a = new Scanner(System.in);
        int ch = a.nextInt();

        switch (ch){

            case 1,2 -> this.Edit();

            case 3 -> new Encryption(new File(Fname));

            case 4 -> new Menu();

            case 5 -> System.exit(0);

            default -> {
                System.out.println("Error!! - Invaid Entry");
                new Newfile(Fname,choice);
            }

        }
    }

    void newfile()
    {
        try{

            File f = new File(Fname);
            if (f.createNewFile()){
                System.out.println("File Created !!\n");
            }
            else {
                System.out.println("Already Exists !!\n");
            }

        } catch(IOException e){

            System.out.println("ERROR !!\n");
            e.printStackTrace();

        }
    }

    void Edit() throws IOException {

        Desktop.getDesktop().open(new File(Fname));


        new Newfile(Fname, choice);



    }

}
