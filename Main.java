import java.util.*;
// import java.lang.*;
// import java.io.*;

// Please name your class Main
class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            int shift = scanner.nextInt();
            scanner.nextLine();
            String text = scanner.nextLine().trim();

            if (text.contains("the")) {
                String Etext = encrypt(text, shift);
                System.out.println( Etext);
            } else {
                String Dtext = decrypt(text, shift);
                System.out.println( Dtext);
            }
        }

        scanner.close();
    }

    public static String encrypt(String plaintext, int shift) {

        StringBuilder encrypted = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) (((c - base + shift) % 26) + base));
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String Ctext, int shift) {
        return encrypt(Ctext, 26 - shift);
    }
}
