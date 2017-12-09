package com.company;

class Zad4 {

    static int zad4(String text) {
        String temp = text.replaceAll("[A-Za-z.,\\s]", "");
        int value = 0;
        for (int i = 0; i < temp.length(); i++) {
            value += Character.getNumericValue(temp.charAt(i));
        }
        return value;
    }
}