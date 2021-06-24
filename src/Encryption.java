import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Encryption{

    final File Fname;
    Scanner ch = new Scanner(System.in);
    FileReader fr;
    FileWriter fw;
    int offset = 0;
    String eno;
    char[] letter ;
    String content;
    int[] L;


    Encryption(File Fname) throws IOException {

        this.Fname = Fname;
        String P = String.valueOf(Fname);

        fr = new FileReader(Fname);

        letter = new char[(int) Fname.length()];
        L = new int[(int) Fname.length()];

        while (offset < letter.length)
        {
            int result = fr.read(letter, offset, letter.length - offset);
            if (result == -1) {
                break;
            }
            offset += result;
        }
        content = new String(letter);

        String[] p = P.split("\\\\", 0);
        int path = p.length - 1;
        String filename = p[p.length - 1];

        String Path = "";
        for (int i = 0; i < path; i++) {
            Path += p[i] + File.separator;
        }

        File temp = new File(Path + "temp.enc");

        fw = new FileWriter(temp);

        System.out.println(
                """
                        \t1. Cipher
                        \t2. Palindrome
                        \t3. Exit
                                              
                        Enter The Encryption Technique :"""
        );

        int num = ch.nextInt();

        switch (num) {

            case 1 -> this.cipher();

            case 2 -> this.palindrome();

            case 3 -> System.exit(0);

            default -> {
                System.out.println("ERROR!! - Invalid Entry");
                new Encryption(Fname);
            }

        }

        fw.close();
        fr.close();

    }

    public void cipher() throws IOException {



        String content = new String(letter);
        String Enc = "";

        Random rand = new Random();
        int a = rand.nextInt(255);

        eno = String.valueOf(a);
        System.out.println(content);

        int flag = -1;
        System.out.println('\\');
        for (int i=0;i<Fname.length();i++) {

            System.out.println(letter[i]);

            if (letter[i] == '\n') {
                continue;
            }
            letter[i] = (char) (letter[i] + a);
            System.out.println(letter[i]);
            content = new String(letter);
        }
        System.out.println(content);


        System.out.println("Encrypted !!");

    }

    public void palindrome() {


        System.out.println("Encrypted !!");

    }

}
