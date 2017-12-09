package com.company;

class Zad1 {

    static int zad1(String text) {
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(text.length() - 1)) j++;
        }
        return j;
    }
}
