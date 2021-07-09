import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Encryption{

    final File Fname;
    Scanner ch = new Scanner(System.in);
    FileReader fr;
    FileOutputStream fw;
    int offset = 0;
    String eno;
    String SFname;
    char[] letter ;
    String content,Enc;
    int num;

    Encryption(File Fname, int num) throws IOException {


        this.Fname = Fname;
        this.num = num;

        fr = new FileReader(Fname);

        letter = new char[(int) Fname.length()];


        while (offset < letter.length)
        {
            int result = fr.read(letter, offset, letter.length - offset);
            if (result == -1) {
                break;
            }
            offset += result;
        }
        content = new String(letter);


        if (num == 1) {
            cipher();
        }
        else if (num == 2) {
            palindrome();
        }


        fw = new FileOutputStream(Fname);

        DataOutputStream dos = new DataOutputStream(fw);
        dos.writeBytes(Enc);

        dos.close();
        fw.close();
        fr.close();

    }

    Encryption(File Fname) throws IOException {

        this.Fname = Fname;
        this.SFname = Fname.getName();

        this.SFname = SFname.substring(0, SFname.length() - 4) + ".enc";

        fr = new FileReader(Fname);

        letter = new char[(int) Fname.length()];


        while (offset < letter.length)
        {
            int result = fr.read(letter, offset, letter.length - offset);
            if (result == -1) {
                break;
            }
            offset += result;
        }


        content = new String(letter);



        System.out.println(
                """
                        \t1. KEY 1
                        \t2. KEY 2
                        \t3. Exit
                                              
                        Enter The Encryption Technique :"""
        );

        num = ch.nextInt();

        switch (num) {

            case 1 -> this.cipher();

            case 2 -> this.palindrome();

            case 3 -> System.exit(0);

            default -> {
                System.out.println("ERROR!! - Invalid Entry");
                new Encryption(Fname);
            }

        }


        fw = new FileOutputStream(Fname);

        DataOutputStream dos = new DataOutputStream(fw);
        dos.writeBytes(Enc);

        System.out.println("\nEncrypted !!");

        dos.close();
        fw.close();
        fr.close();

        if (Fname.renameTo(new File(SFname))) {

        } else {
            System.out.println("Cannot Rename");
        }


    }

    public void cipher() {

        Random rand = new Random();

        int a=4;
//        while (a == 0) {
//            a = rand.nextInt(100);
//        }
        eno = String.format("%02d",a);

        for (int i=0;i<Fname.length();i++) {

            if (letter[i] == '\n') {
                continue;
            }
            letter[i] = (char) (letter[i] + a);
        }
        Enc = new String(letter);


        Enc += String.valueOf(eno) + String.valueOf(num);
    }

    public void palindrome() {

        char temp;

        for (int i=0;i<letter.length/2;i++){
            temp = letter[i];
            letter[i] = letter[letter.length-1-i];
            letter[letter.length-1-i] = temp;
        }

        Enc = new String(letter);
        Enc += num;

    }

}
