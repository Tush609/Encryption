import java.awt.*;
import java.io.File;
import java.io.FileWriter;
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
                        \t4. Decrypt File
                        \t5. Return to Previous Menu
                        \t6. Exit
                        """
        );

        System.out.println("Enter Your Choice : ");

        Scanner a = new Scanner(System.in);
        int choice = a.nextInt();

        switch (choice){

            case 1 -> this.Edit();
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

        Scanner a = new Scanner(System.in);

        Desktop.getDesktop().open(new File(Fname));


        System.out.println("Do you want to Edit ?");
        char ch = a.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {

            fileeditor();

        } else if (ch == 'N' || ch == 'n') {

            new Newfile(Fname, choice);

        }

    }

    private void fileeditor() throws IOException{

        FileWriter fw = new FileWriter(Fname);

        


        fw.close();
    }

}
