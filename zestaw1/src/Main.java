import java.util.*;

public class Main {

    private static void zad1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj wartość temperatury w stopniach Celsjusza: ");
        double celsiusDegree = in.nextFloat();
        System.out.println("Temperatura w stopniach Fahrenheita jest rowna: ");
        System.out.print((1.8 * celsiusDegree) + 32.0);
    }

    private static void zad2() {
        Scanner in = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        System.out.print("Ile liczb chcesz sprawdzic? ");
        int temp = in.nextInt();
        System.out.println("\nWyznaczanie najmniejszej i najwiekszej wartosci z podanych liczb...");
        for (int i = 0; i < temp; ++i) {
            System.out.println("\nPodaj " + (i + 1) + " wartość całkowitą: ");
            values.add(in.nextInt());
        }
        Collections.sort(values);
        System.out.println("Wartowść największa: "
                + values.get(0)
                + "\nWartość najmniejsza: "
                + values.get(values.size()));
    }

    private static void zad3() {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj swoja wage w kilogramach: ");
        double weight = in.nextDouble();
        System.out.print("\nPodaj swój wzrost w metrach: ");
        double height = in.nextDouble();
        double bmi = weight / (height * height);
        if (bmi > 18.5 && bmi < 24.9) {
            System.out.print("\nWszystko w normie!");
        } else if (bmi > 24.9) {
            System.out.print("\nTy grubasie");
        } else {
            System.out.print("\nNiedowaga");
        }
    }

    private static void zad4() {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj dochód: ");
        double income = in.nextDouble();
        logicZad4(income);
    }

    private static void logicZad4(double income) {
        double tax = 0;
        if (income <= 85528) {
            tax = (0.18 * income) - 556.02;
        }
        if (income > 85528) {
            tax = (0.32 * (income - 85528)) + 14839.02;
        }
        System.out.print("Podatek to: " + tax);
    }

    private static void zad5() {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj wartosc towaru: ");
        double priceOfCargo = in.nextDouble();
        System.out.print("Podaj ilosc rat: ");
        int amount = in.nextInt();
        logicZad5(priceOfCargo, amount);
    }

    private static void logicZad5(double priceOfCargo, int amount) {
        double outPrice = 0;
        if (priceOfCargo >= 100 && priceOfCargo <= 10000 && amount >= 6 && amount <= 48) {
            if (amount <= 12) {
                outPrice = 0.025 * priceOfCargo;
            }
            if (amount >= 13 && amount <= 24) {
                outPrice = 0.05 * priceOfCargo;
            }
            if (amount >= 25) {
                outPrice = 0.1 * priceOfCargo;
            }
            System.out.print("Rata wynosi: " + outPrice);
        } else {
            System.out.print("Ups! Złe dane. Wprowadź dane ponownie :)");
            zad5();
        }
    }

    private static void zad6() {
        System.out.println("\n***Prosty kalkulator***\nDostępne operatory matematyczne: +,-,*,/.\n");
        System.out.println("\nWykonaj działanie. Dodaj liczbę, a następnie symbol operacji i drugę liczbę...\n\n");
        Scanner in = new Scanner(System.in);
        double value = in.nextDouble();
        String operationSymbol = in.next();
        double value2 = in.nextDouble();
        System.out.print(
                calculatorOperations(operationSymbol, value, value2)
        );
    }

    private static double calculatorOperations(String operationSymbol, double value, double value2) {
        switch (operationSymbol) {
            case "+":
                return value + value2;
            case "-":
                return value - value2;
            case "*":
                return value * value2;
            case "/":
                System.out.println(division(value, value2));
            default:
                System.out.println("Zły symbol");
                return 0;
        }
    }

    private static double division(double value1, double value2) {
        if (value2 == 0) {
            System.out.println("Błąd! Nie dzielimy przez zero.");
            return 0;
        }
        return value1 / value2;
    }

    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
        zad6();
    }
}