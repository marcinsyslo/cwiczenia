import java.util.Random;
import java.util.Scanner;

public class Main {

/* Zadania z zestawu 3 */

    static void zad1() {
        /*Zadanie 1*/
        int[] randomTable = new int[10];
        Random rand = new Random();

        for (int i = 0; i < randomTable.length; i++) {
            randomTable[i] = rand.nextInt(21) - 10;
        }
        for (int i : randomTable) {
            System.out.print(i + " ");
        }

        int max = 0, min = 0;
        for (int aRandomTable1 : randomTable) {
            if (aRandomTable1 < min) min = aRandomTable1;
            else if (aRandomTable1 > max) max = aRandomTable1;
        }
        System.out.print("\nWartość maksymalna: " + max);
        System.out.print("\nWartość minimalna: " + min);

        double average = 0.0;
        for (int temp : randomTable) {
            average += temp;
        }
        average /= average / randomTable.length;
        System.out.println("\nŚrednia: " + average);
        int more = 0, less = 0;

        for (int aRandomTable : randomTable) {
            if (aRandomTable > average) more++;
            else if (aRandomTable < average) less++;
        }

        System.out.print("\nWiększych od średniej jest: " + more);
        System.out.print("\nMniejszych od średniej jest: " + less);

        int[] reverseTable = new int[randomTable.length];

        for (int j = 0, k = randomTable.length - 1; j < randomTable.length; j++, k--) {
            reverseTable[j] = randomTable[k];
        }
        for (int aReverseTable : reverseTable) {
            System.out.print(aReverseTable + " ");
        }
    }

    static void zad2() {
        /*Zadanie 2*/
        int[] randomTable = new int[20];
        Random rand = new Random();

        for (int i = 0; i < randomTable.length; i++) {
            randomTable[i] = rand.nextInt(10) + 1;
        }

        int[] n = new int[randomTable.length];
        for (int i = 0; i < randomTable.length; i++) {
            System.out.print(randomTable[i] + " ");
            for (int aRandomTable : randomTable) {
                if (i == aRandomTable) n[i]++;
            }
        }
        System.out.print("\n");
        for (int j = 1; j <= 10; j++) {
            System.out.print(j + " - " + n[j] + "\n");
        }
    }

    static void zad3() {
        /*Zadanie 3*/
        Random rand = new Random();
        int[][] matrix = new int[5][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = rand.nextInt(11) - 5;
            }
        }

        System.out.print("Wylosowana macierz: \n");
        for (int[] aM : matrix) {
            for (int temp : aM) {
                System.out.printf("%4s", temp);
            }
            System.out.print("\n");
        }

        int[] maxInColumn = {0, 0, 0, 0, 0};
        int[] minInRow = {0, 0, 0, 0, 0};
        int i = 0;
        for (int[] aM : matrix) {
            for (int temp : aM) {
                if (temp > maxInColumn[i]) maxInColumn[i] = temp;
                i++;
            }
            i = 0;
        }

        i = 0;
        for (int[] aM : matrix) {
            for (int temp : aM) {
                if (temp < minInRow[i]) minInRow[i] = temp;
            }
            i++;
        }

        i = 0;
        System.out.print("\nMinimalne wartości w wierszach: \n");
        for (int temp : minInRow) {
            System.out.print(i + ":");
            System.out.printf("%4s%n", temp);
            i++;
        }

        System.out.print("\nMaksymalne wartości w kolumnach: \n");
        i = 0;
        for (int temp : maxInColumn) {
            System.out.print(i + ":");
            System.out.printf("%4s%n", temp);
            i++;
        }

        int maxInDiagonal = 0;
        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][m] < maxInDiagonal) maxInDiagonal = matrix[m][m];
        }

        int minInDiagonal = 0;
        for (int m = matrix.length - 1; m >= 0; m--) {
            if (matrix[m][m] > minInDiagonal) minInDiagonal = matrix[m][m];
        }
        System.out.print("\nMaksymalna wartość na pierwszej przekątnej: " + maxInDiagonal);
        System.out.print("\nMinimalna wartość na drugiej przekątnej: " + minInDiagonal);
    }

    private static StringBuilder zad4() {
        /*Zadanie 4*/
        Scanner in = new Scanner(System.in);
        StringBuilder sign = new StringBuilder();
        //StringBuilder value = new StringBuilder();
        StringBuilder binaryNumber = new StringBuilder();

        System.out.print("\nPodaj liczbę całkowitą: ");
        String decimalNumberStr = in.next();
        int decimalNumber = Integer.valueOf(decimalNumberStr);

        if (decimalNumberStr.contains("-")) {
            decimalNumber *= -1;
            sign.append("1.");
        } else sign.append("0.");

        /*decimalNumber *= 2;
        while (decimalNumber/2 >= 1){
            decimalNumber /= 2;
            value.append((decimalNumber) % 2);
        }
        value.reverse();*/

        binaryNumber.append(sign).append(Integer.toBinaryString(decimalNumber));

        System.out.print("\nPodana liczba w kodzie binarnym ZM: " + binaryNumber.toString());
        return binaryNumber;
    }

    static void zad5() {
        /*Zadanie 5*/
        StringBuilder binaryNumber = zad4();
        StringBuilder zu1 = new StringBuilder();
        StringBuilder zu2 = new StringBuilder();
        String binaryNumberStr = binaryNumber.toString();

        if (binaryNumberStr.contains("1.")) {
            for (int i = 2; i <= binaryNumberStr.length() - 1; i++) {
                if (isCharacterEquals0(binaryNumberStr, i)) {
                    binaryNumber.replace(i, i + 1, "1");
                } else {
                    binaryNumber.replace(i, i + 1, "0");
                }
            }
            zu2.append(binaryNumber);
            int i = zu2.toString().length() - 1;
            while (isCharacterEquals1(zu2.toString(), i)) {
                zu2.replace(i, i + 1, "0");
                i--;
            }

            zu2.replace(i, i + 1, "1");
        }

        zu1.append(binaryNumber);
        System.out.print("\nZu1: " + zu1.toString());
        System.out.print("\nZu2: " + zu2.toString());
    }

    private static boolean isCharacterEquals0(String str, int i) {
        return String.valueOf(str.charAt(i)).equals("0");
    }

    private static boolean isCharacterEquals1(String str, int i) {
        return String.valueOf(str.charAt(i)).equals("1");
    }

    static void zad6() {
        /*Zadanie 6*/
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj licznę n (n > 0): ");
        int n = in.nextInt();
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = isPrime(i + 1) && isPrime(j + 1);
            }
        }

        System.out.printf("%3s", "");
        for (int d = 1; d <= matrix.length; d++) {
            System.out.printf("%3s", d);
        }
        System.out.print("\n");

        int m = 1;
        for (boolean[] aMatrix : matrix) {
            System.out.printf("%3s", m);
            for (boolean temp : aMatrix) {
                if (temp) System.out.printf("%3s", "+");
                else System.out.printf("%3s", ".");
            }
            System.out.print("\n");
            m++;
        }
    }

    private static boolean isPrime(int n) {
        /*Do zadania 6*/
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k++;
            }
        }
        return k <= 2;
    }

    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
        zad6();
        TheGameOfLife life = new TheGameOfLife();
        life.startLife();
    }
}