package case_1;

import java.util.Scanner;

public class Case {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Metin analiz uygulamasina hos geldiniz !");

        int length = getMaxLength(scn);
        String text = getText(scn, length);
        boolean isCaseSensitive = getCaseSensitive(scn);
        char characterThatWillAnalyze = getCharacter(scn);

        int frequency = calculteFrequency(text, isCaseSensitive, characterThatWillAnalyze);

        scn.close();
        System.out.println("Girdiginiz cumlede " + characterThatWillAnalyze + " harfi " + frequency + " kere gecmektedir.");
    }

    public static int getMaxLength(Scanner scn) {
        int length;
        while (true) {

            System.out.print("Lutfen metnin maksimum karakter sayisini (Pozitif Tam Sayi) belirleyiniz : ");
            length = scn.nextInt();

            if (length > 0) break;
            else System.out.println("Lutfen pozitif karakter sayisi giriniz !");
        }

        scn.nextLine();

        return length;
    }

    public static String getText(Scanner scn, int length) {
        String text;
        while (true) {

            System.out.print("Lutfen metni giriniz : ");
            text = scn.nextLine();

            if (text.length() > length) {
                System.out.println("Metninizin karakter uzunlugu maksimum karakter uzunlugundan fazladir");
                continue;
            }

            if (!text.matches("[a-zA-Z .,!?'-]+")) {
                System.out.println("Lutfen sadece Latin alfabesi kullaniniz!");
                continue;
            }

            System.out.printf("Metniniz basariyla kaydedilmistir : %s", text);
            return text;
        }
    }

    public static boolean getCaseSensitive(Scanner scn) {
        while (true) {
            System.out.println();
            System.out.print("Buyuk/kucuk harf duyarliligi aktif olsun mu? (Evet/Hayir): ");
            String answer = scn.nextLine();

            switch (answer) {
                case "Evet":
                case "evet":
                    return true;

                case "Hayir":
                case "hayir":
                    return false;
                default:
                    System.out.println("Lutfen Evet veya Hayir secenegini giriniz !");
            }
        }
    }

    public static char getCharacter(Scanner scn) {
        while (true) {
            System.out.print("Lutfen aranacak karakteri giriniz : ");
            String input = scn.nextLine();

            if (input.length() != 1) {
                System.out.println("Lutfen tek bir harf giriniz !");
                continue;
            }

            if (!input.matches("[a-zA-Z .,!?'-]+")) {
                System.out.println("Lutfen sadece Latin alfabesi kullaniniz!");
                continue;
            }

            return input.charAt(0);
        }
    }

    public static int calculteFrequency(String text, boolean isCaseSensitive, char characterThatWillAnalyze) {

        if (!isCaseSensitive) {
            text = text.toLowerCase();
            characterThatWillAnalyze = Character.toLowerCase(characterThatWillAnalyze);
        }

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == characterThatWillAnalyze) count++;
        }

        return count;
    }
}
