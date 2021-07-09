import java.io.*;

public class Decryption {

    private final File Fname;
    int eno;
    FileReader fr;
    FileOutputStream fw;
    int offset = 0;
    char[] letter ;
    String content,Enc;

    Decryption(File Fname) throws IOException {

        this.Fname = Fname;

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

        char ch = content.charAt(content.length()-1);

        eno = Integer.parseInt(String.valueOf(ch));

        content = content.substring(0,content.length()-1);

        if (eno == 1) {
            cipher();
        } else {
            palindrome();
        }

        File f = new File(Fname.getName());

        fw = new FileOutputStream(f);

        DataOutputStream dos = new DataOutputStream(fw);
        dos.writeBytes(Enc);

        dos.close();
        fw.close();
        fr.close();


    }

    public void cipher() {

        String Snum = content.substring(content.length()-2);
        int num = Integer.parseInt(Snum);

        for (int i=0;i<content.length()-2;i++) {

            if (letter[i] == '\n') {
                continue;
            }
            letter[i] = (char) (letter[i] - num);
        }
        char[] letter1 = new char[content.length()-2];

        for (int i=0;i<content.length()-2;i++) {
            letter1[i] = letter[i];
        }
        Enc = new String(letter1);

    }

    public void palindrome() {

        char temp;
        char[] letter2 = new char[(int) Fname.length()-1];

        for (int i=0,k=0;i<Fname.length()-1;i++) {
            letter2[k++] = letter[i];
        }

        for (int i=0;i<letter2.length/2;i++){
            temp = letter2[i];
            letter2[i] = letter2[letter2.length-1-i];
            letter2[letter2.length-1-i] = temp;
        }

        Enc = new String(letter2);

    }
}
