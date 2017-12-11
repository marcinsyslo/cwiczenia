package com.company;

class Zad5 {

    static boolean isCorrect(String sequence) {
        int countL = 0;
        int countP = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (Character.toString(sequence.charAt(i)).equals("(")) {
                countL++;
            } else if (Character.toString(sequence.charAt(i)).equals(")")) {
                countP++;
            }
        }
        return countL == countP;
    }
}