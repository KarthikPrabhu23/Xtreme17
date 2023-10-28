
import java.util.*;
// import java.lang.*;
// import java.io.*;

class main3 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // boolean flag = false;
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            int shift = scanner.nextInt();
            scanner.nextLine();
            String text = scanner.nextLine().trim();

            if (text.contains(" the ")) {
                String Etext = encrypt(text, shift);
                // flag = true;
                System.out.println(Etext);
            } else {
                String Dtext = decrypt(text, shift);
                System.out.println(Dtext);
            }
        }

        scanner.close();
    }

    public static String encrypt(String plaintext, int shift) {

        System.out.println("Encryption is ");

        StringBuilder encrypted = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) (((c - base + 26 - shift) % 26) + base));
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String Ctext, int shift) {
        return encrypt(Ctext, shift - 26);
        // System.out.println("Decryption is ");
        // int shift2 = shift;
        // StringBuilder encrypted2 = new StringBuilder();

        // for (char d : Ctext.toCharArray()) {
        //     if (Character.isLetter(d)) {
        //         char base2 = Character.isLowerCase(d) ? 'a' : 'A';
        //         encrypted2.append((char) (((d - base2 + shift2) % 26) + base2));
        //     } else {
        //         encrypted2.append(d);
        //     }
        // }

        // return encrypted2.toString();
    }
}
