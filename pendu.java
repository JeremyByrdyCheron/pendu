import java.util.Random;
import java.util.Scanner;

class pendu {
    public static String[] possibleWords = { "Java", "Python", "Javascript", "Gnome" };

    public static Scanner scan = new Scanner(System.in);

    public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void display(char[] hiddenWord) {
        System.out.println(hiddenWord);
    }

    public static void main() {
        String wordToFind = possibleWords[new Random().nextInt(possibleWords.length - 0) + 0];
        char[] letters = wordToFind.toCharArray();
        char[] hiddenWord = hideWord(letters);
        int numberOfTry = 0;
        boolean fullyUncovered = wordFund(hiddenWord);
        while (numberOfTry < 10) {
            display(hiddenWord);
            numberOfTry = propose(hiddenWord, letters, numberOfTry);
            wordFund(hiddenWord);

            if (fullyUncovered) {
                System.out.println("Vous avez gagné en " + numberOfTry);

            }
        }
        rematch(numberOfTry, fullyUncovered);

    }

    // convertit le mot en différents '_'
    public static char[] hideWord(char[] letters) {
        char[] hiddenletters = letters;
        for (int i = 0; i < hiddenletters.length; i++) {
            hiddenletters[i] = '_';
        }
        return hiddenletters;
    }

    public static int propose(char[] hiddenWord, char[] letters, int numberOfTry) {
        char letterProposed = Character.toLowerCase(scan.next().charAt(0));
        // convertit la lettre proposée du scanner en valeur de code
        letterProposed = convert(letterProposed);
        boolean isLetterFound = false;
        // regarde si c'est une lettre de l'alphabet
        for (char letterToFind : alphabet) {

            if (letterToFind == letterProposed) {
                isLetterFound = true;
                break;
            }
        }
        // si la lettre n'est trouvée
        if (!isLetterFound) {
            System.out.println("Vous devez rentrer une lettre");
        } else {
            int i = 0;
            int finded = 0;
            // si la lettre est trouvée, on regarde dans le mot originel non codé si la
            // lettre est présente, et si c'est le cas, la lettre vient désormais apparaitre
            // dans le mot codé à la place d'un '_'
            for (char letter : letters) {
                if (letterProposed == letter) {
                    hiddenWord[i] = letterProposed;
                    finded++;
                }
            }
            if (finded == 0) {
                System.out.println("Il n'y a pas la lettre " + letterProposed + " dans le mot que vous recherchez");
            }
            numberOfTry++;
            System.out.println("Il vous reste " + (10 - numberOfTry) + " essais");

        }
        display(hiddenWord);
        return numberOfTry;
    }

    // si le mot est trouvé complètement
    public static boolean wordFund(char[] hiddenWord) {
        boolean fullyUncovered = false;
        for (char letter : hiddenWord) {
            if (letter == '_') {
                return fullyUncovered;
            }
        }
        fullyUncovered = true;
        return fullyUncovered;
    }

    public static char convert(char letterProposed) {
        switch (letterProposed) {
            case 'a':
                letterProposed = 'a';
                break;
            case 'b':
                letterProposed = 'b';
                break;
            case 'c':
                letterProposed = 'c';
                break;
            case 'd':
                letterProposed = 'd';
                break;
            case 'e':
                letterProposed = 'e';
                break;
            case 'f':
                letterProposed = 'f';
                break;
            case 'g':
                letterProposed = 'g';
                break;
            case 'h':
                letterProposed = 'h';
                break;

            case 'i':
                letterProposed = 'i';
                break;
            case 'j':
                letterProposed = 'j';
                break;
            case 'k':
                letterProposed = 'k';
                break;
            case 'l':
                letterProposed = 'l';
                break;
            case 'm':
                letterProposed = 'm';
                break;
            case 'n':
                letterProposed = 'n';
                break;
            case 'o':
                letterProposed = 'o';
                break;

            case 'p':
                letterProposed = 'p';
                break;
            case 'q':
                letterProposed = 'q';

                break;
            case 'r':
                letterProposed = 'r';
                break;
            case 's':
                letterProposed = 's';

                break;
            case 't':
                letterProposed = 't';
                break;
            case 'u':
                letterProposed = 'u';
                break;
            case 'v':
                letterProposed = 'v';
                break;

            case 'w':
                letterProposed = 'w';
                break;
            case 'x':
                letterProposed = 'x';
                break;
            case 'y':
                letterProposed = 'y';
                break;
            case 'z':
                letterProposed = 'z';
                break;
            default:
                break;

        }
        return letterProposed;
    }

    // propose un rematch
    public static void rematch(int numberOfTry, boolean fullyUncovered) {
        if (numberOfTry >= 10 || fullyUncovered) {
            System.out.println("Voulez-vous rejouer ? Veuillez écrire y pour oui et n pour non");
            String response = scan.next();
            char responseChar = response.charAt(0);
            while (responseChar != 'y' || responseChar != 'n') {

                responseChar = response.charAt(0);
                if (responseChar == 'y') {
                    main();
                }
                if (responseChar == 'n') {
                    System.exit(0);
                }
                System.out.println(" Veuillez écrire y pour oui et n pour non");

                response = scan.next();
                responseChar = response.charAt(0);
            }

        }
    }

}

// tentative de dernière minute de subdiviser le code de propose en plusieurs
// fonctions

// import java.util.Random;
// import java.util.Scanner;

// class pendu {
// public static String[] possibleWords = { "Java", "Python", "Javascript",
// "Gnome" };

// public static Scanner scan = new Scanner(System.in);

// public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

// public static void display(char[] hiddenWord) {
// System.out.println(hiddenWord);
// }

// public static void main() {
// String wordToFind = possibleWords[new Random().nextInt(possibleWords.length -
// 0) + 0];
// char[] letters = wordToFind.toCharArray();
// char[] hiddenWord = hideWord(letters);
// int numberOfTry = 0;
// boolean fullyUncovered = wordFund(hiddenWord);
// while (numberOfTry < 10) {
// display(hiddenWord);
// numberOfTry = propose(hiddenWord, letters, numberOfTry);
// wordFund(hiddenWord);

// if (fullyUncovered) {
// System.out.println("Vous avez gagné en " + numberOfTry);

// }
// }
// rematch(numberOfTry, fullyUncovered);

// }

// // convertit le mot en différents '_'
// public static char[] hideWord(char[] letters) {
// char[] hiddenletters = letters;
// for (int i = 0; i < hiddenletters.length; i++) {
// hiddenletters[i] = '_';
// }
// return hiddenletters;
// }

// public static int propose(char[] hiddenWord, char[] letters, int numberOfTry)
// {
// char letterProposed = Character.toLowerCase(scan.next().charAt(0));
// // convertit la lettre proposée du scanner en valeur de code
// convert(letterProposed);
// boolean isLetterFound = false;
// // regarde si c'est une lettre de l'alphabet
// for (char letterToFind : alphabet) {

// if (letterToFind == letterProposed) {
// isLetterFound = true;
// break;
// }
// }
// // si la lettre n'est trouvée
// if (!isLetterFound) {
// System.out.println("Vous devez rentrer une lettre");
// } else {
// letterInWord(letters, letterProposed, numberOfTry, hiddenWord);
// }
// display(hiddenWord);
// return numberOfTry;
// }

// public static void convert(char letterProposed) {
// switch (letterProposed) {
// case 'a':
// letterProposed = 'a';
// break;
// case 'b':
// letterProposed = 'b';
// break;
// case 'c':
// letterProposed = 'c';
// break;
// case 'd':
// letterProposed = 'd';
// break;
// case 'e':
// letterProposed = 'e';
// break;
// case 'f':
// letterProposed = 'f';
// break;
// case 'g':
// letterProposed = 'g';
// break;
// case 'h':
// letterProposed = 'h';
// break;

// case 'i':
// letterProposed = 'i';
// break;
// case 'j':
// letterProposed = 'j';
// break;
// case 'k':
// letterProposed = 'k';
// break;
// case 'l':
// letterProposed = 'l';
// break;
// case 'm':
// letterProposed = 'm';
// break;
// case 'n':
// letterProposed = 'n';
// break;
// case 'o':
// letterProposed = 'o';
// break;

// case 'p':
// letterProposed = 'p';
// break;
// case 'q':
// letterProposed = 'q';

// break;
// case 'r':
// letterProposed = 'r';
// break;
// case 's':
// letterProposed = 's';

// break;
// case 't':
// letterProposed = 't';
// break;
// case 'u':
// letterProposed = 'u';
// break;
// case 'v':
// letterProposed = 'v';
// break;

// case 'w':
// letterProposed = 'w';
// break;
// case 'x':
// letterProposed = 'x';
// break;
// case 'y':
// letterProposed = 'y';
// break;
// case 'z':
// letterProposed = 'z';
// break;
// default:
// break;
// }

// }

// // si la lettre est trouvée, on regarde dans le mot originel non codé si la
// // lettre est présente, et si c'est le cas, la lettre vient désormais
// apparaitre
// // dans le mot codé à la place d'un '_'
// public static int letterInWord(char[] letters, char letterProposed, int
// numberOfTry, char[] hiddenWord) {
// int i = 0;
// int finded = 0;

// for (char letter : letters) {
// if (letterProposed == letter) {
// hiddenWord[i] = letterProposed;
// finded++;
// }
// }
// if (finded == 0) {
// System.out.println("Il n'y a pas la lettre " + letterProposed + " dans le mot
// que vous recherchez");
// }
// numberOfTry++;
// System.out.println("Il vous reste " + (10 - numberOfTry) + " essais");
// return numberOfTry;

// }

// // si le mot est trouvé complètement
// public static boolean wordFund(char[] hiddenWord) {
// boolean fullyUncovered = false;
// for (char letter : hiddenWord) {
// if (letter == '_') {
// return fullyUncovered;
// }
// }
// fullyUncovered = true;
// return fullyUncovered;
// }

// // propose un rematch
// public static void rematch(int numberOfTry, boolean fullyUncovered) {
// if (numberOfTry >= 10 || fullyUncovered) {
// System.out.println("Voulez-vous rejouer ? Veuillez écrire y pour oui et n
// pour non");
// String response = scan.next();
// char responseChar = response.charAt(0);
// while (responseChar != 'y' || responseChar != 'n') {

// responseChar = response.charAt(0);
// if (responseChar == 'y') {
// main();
// }
// if (responseChar == 'n') {
// System.exit(0);
// }
// System.out.println(" Veuillez écrire y pour oui et n pour non");

// response = scan.next();
// responseChar = response.charAt(0);
// }

// }
// }

// }
