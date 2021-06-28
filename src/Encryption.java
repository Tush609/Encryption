import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    String content,Enc;
    int[] L;
    int num;

    Encryption(File Fname) throws IOException {

        this.Fname = Fname;

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

        System.out.println(
                """
                        \t1. Cipher
                        \t2. Palindrome
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


        fw = new FileWriter(Fname);
        fw.write(Enc);

        System.out.println(Enc);


        System.out.println("\nEncrypted !!");

        fw.close();
        fr.close();

    }

    public void cipher() {

        Random rand = new Random();
        int a = rand.nextInt(10);

        eno = String.valueOf(a);
        System.out.println(content);

        for (int i=0;i<Fname.length();i++) {

            if (letter[i] == '\n') {
                continue;
            }
            letter[i] = (char) (letter[i] + a);
        }
        Enc = new String(letter);

        if (a%10 >= 1) {
            Enc += num + String.valueOf(a);
        } else {
            Enc += num + '0' + a;
        }
    }

    public void palindrome() {


        System.out.println("Encrypted !!");

    }

}
