package com.company;

class Zad5 {

    static boolean isCorrect(String sequence) {
        int countL = 0;
        int countP = 0;
        String input = sequence.replaceAll("[A-Za-z1-9*+./%\\-\\s]+", "");

        for (int i = 0; i < input.length(); i++) {
            if (Character.toString(input.charAt(i)).equals("(")) {
                countL++;
            } else countP++;
        }
        return countL == countP;
    }
}