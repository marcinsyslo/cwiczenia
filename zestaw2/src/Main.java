import java.util.*;

public class Main {

    private static void zad1(){
        System.out.print("Podaj liczbę, następnie zostanie wyświetlona lista liczb nieparzystych, mniejszych od podanej liczby: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] table = new int[number/2 + 1];
        int k = 0;
        for (int i = 1; i <= number; i = i + 2){
            table[k] = i;
            k++;
        }
        for (int temp : table) {
            System.out.printf("%3s",temp);
        }
    }

    private static void zad2(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nPodaj liczbę A: ");
        int A = in.nextInt();
        System.out.print("\nPodaj liczbę B, B > A: ");
        int B = in.nextInt();
        if (B < A) zad2();
        else {
            int temp = A;

            int score = temp;
            while (A != B) {
                score += ++A;
            }
            System.out.print("\n" + score);

            score = temp;
            A = temp;
            do {
                score += ++A;
            } while (A < B);
            System.out.print("\n" + score);

            score = 0;
            for (int i = temp; i <= B; i++) {
                score += i;
            }
            System.out.print("\n" + score);
        }
    }

    private static void zad3(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nPodaj liczbę naturalną n: ");
        int n = in.nextInt();
        int i = 0;
        List<Long> list = new ArrayList<>();
        while (Math.pow(2,i) < n){
            list.add((long) Math.pow(2,i));
            i++;
        }
        System.out.print(list);
    }

    private static List<Integer> zad4(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nProgram będzie wczytywać liczby dopóki nie zostanie podane 0\n");
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        do {
            System.out.print("\nPodaj liczbę: ");
            temp = in.nextInt();
            list.add(temp);
        } while (temp != 0);
        System.out.print(list);
        temp = 0;
        for (Integer aList : list) {
            temp += aList;
        }
        System.out.print("\nSuma: " + temp);
        return list;
    }

    private static void zad5(){
        List<Integer> list = zad4();
        Collections.sort(list);
        System.out.print("\nmin: " + list.get(0) + "\nmax:  " + list.get(list.size()-1));
        System.out.print("\nśrednia: ");
        double temp = 0.0;
        for (Integer aList : list) {
            temp += aList;
        }
        System.out.print(temp/(list.size()-1));
    }

    private static void zad6() {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int number = rand.nextInt(99) + 1;
        int userNumber = 0;
        int n = 0;
        while (userNumber != number){
            n++;
            System.out.print("\nZgadnij wartość od 1 do 100: ");
            userNumber = in.nextInt();
            if (userNumber > number){
                System.out.print("Za dużo!");
            } else if (userNumber < number) {
                System.out.print("Za mało!");
            } else System.out.print("Dobrze! Zgadłeś za " + n + " razem!");
        }
    }

    private static void zad7(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nWprowadź x, y, a, b");
        System.out.print("\nx: ");
        int x = in.nextInt();
        System.out.print("\ny: ");
        int y = in.nextInt();
        System.out.print("\na: ");
        int a = in.nextInt();
        System.out.print("\nb: ");
        int b = in.nextInt();

        for (int j = 1; j < y; j++) {
            System.out.print(">\n");
        }
        for (int k = 0; k < b; k++) {
            for (int j = 1; j < x; j++) System.out.print("_ ");
            for (int i = 0; i < a; i++) System.out.print("X ");
            System.out.print("\n");
        }
    }

    private static void zad8(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nPodaj liczbę: ");
        int number = in.nextInt();
        for (int i = 1; i <= number; i++){
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    private static void zad9(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nPodaj liczbę, n > 1: ");
        int number = in.nextInt();
        if (number < 1) zad9();
        else {
            int k = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    k++;
                }
            }
            if (k == 2) {
                System.out.print("\nLiczba pierwsza!");
            } else {
                System.out.print("To nie jest liczba pierwsza");
            }
        }
    }

    private static void zad10(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nPodaj wartośś: ");
        int number = in.nextInt();
        String numberToString = Integer.toString(number);
        List<Character> tempList = new ArrayList<>();
        for (int i = 0; i < numberToString.length(); i++){
            tempList.add(numberToString.charAt(i));
        }
        System.out.print(tempList);
        int temp = 0;
        for (Character aTempList : tempList) {
            temp += Character.getNumericValue(aTempList);
        }
        System.out.print("\n" + temp);
        double eAverage = 0; //parzyste
        double oAverage = 0; //nieparzyste
        int k = 0;
        int j = 0;
        for (Character aTempList : tempList) {
            if (Character.getNumericValue(aTempList) % 2 == 0) {
                k++;
                eAverage += Character.getNumericValue(aTempList);
            } else {
                j++;
                oAverage += Character.getNumericValue(aTempList);
            }
        }
        eAverage = eAverage/k;
        oAverage = oAverage/j;
        System.out.print("\nśrednia liczb parzystych: " + eAverage + "\nśrednia liczb nieparzystych: " + oAverage);
        System.out.print("\nStosunek średnich: " + eAverage/oAverage);
    }

    private static void zad11(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nPodaj wysokość choinki: ");
        int n = in.nextInt();
        int k = n;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                System.out.print(" ");
            }
            k--;
            for (int m = 0; m < (n - k); m++) System.out.print("* ");
            System.out.print("\n");
        }
    }

    private static void zad12(){
        Scanner in = new Scanner(System.in);
        int[] tableZL = {5, 2, 1};
        int[] tableGR = {50, 20, 10, 5, 2, 1};
        System.out.print("\nPodaj kwotę Zł<spacja>Gr: ");
        String startPrice = in.nextLine();
        StringBuilder priceZL = new StringBuilder();
        StringBuilder priceGR = new StringBuilder();
        int i = 0;
        if (startPrice.contains(" ")) {
            while (!(Character.toString(startPrice.charAt(i)).equals(" "))) {
                priceZL.append(startPrice.charAt(i));
                i++;
            }
            while (i != startPrice.length()-1) {
                i++;
                priceGR.append(startPrice.charAt(i));
            }
            System.out.print("\n" + priceZL + " Zł, " + priceGR + " Gr\n");
        } else {
            System.out.print("\nZły format zapisu. Podaj. Jeśli Zł albo Gr = 0, wpisz 0.");
            zad12();
        }
        int[] tempZL = {0, 0, 0};
        int priceZlInt = Integer.parseInt(priceZL.toString());
        for (int k = 0; k < tableZL.length; k++) {
            while (priceZlInt / tableZL[k] >= 1) {
                tempZL[k] = priceZlInt / tableZL[k];
                priceZlInt -= tempZL[k] * tableZL[k];

            }
        }
        int[] tempGR = {0, 0, 0, 0, 0, 0};
        int priceGrInt = Integer.parseInt(priceGR.toString());
        for (int k = 0; k < tableGR.length; k++) {
            while (priceGrInt / tableGR[k] >= 1) {
                tempGR[k] = priceGrInt / tableGR[k];
                priceGrInt -= tempGR[k] * tableGR[k];
            }
        }
        for (int m = 0; m < tempZL.length; m++){
            if (tempZL[m] != 0) System.out.print(tempZL[m] + " X " + tableZL[m] + "Zł \n");
        }
        for (int m = 0; m < tempGR.length; m++){
            if (tempGR[m] != 0) System.out.print(tempGR[m] + " X " + tableGR[m] + "Gr \n");
        }
    }

    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
        zad6();
        zad7();
        zad8();
        zad9();
        zad10();
        zad11();
        zad12();
    }
}