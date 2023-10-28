import java.util.*;
// import java.lang.*;
// import java.io.*;

class main4 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean flag = false;
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int shift = sc.nextInt();
            sc.nextLine();
            String text = sc.nextLine().trim();

            if (flag == false) {
                String Etext = encrypt(text, shift);
                flag = true;
                System.out.println(Etext);
            } else {
                String Dtext = decrypt(text, shift);
                System.out.println(Dtext);
            }
        }

        sc.close();
    }

    public static String encrypt(String plaintext, int shift) {

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
       
        int shift2 = shift;
        StringBuilder encrypt2 = new StringBuilder();

        for (char d : Ctext.toCharArray()) {
            if (Character.isLetter(d)) {
                char base2 = Character.isLowerCase(d) ? 'a' : 'A';
                encrypt2.append((char) (((d - base2 + shift2) % 26) + base2));
            } else {
                encrypt2.append(d);
            }
        }

        return encrypt2.toString();
    }
}
