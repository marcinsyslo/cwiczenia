package com.company;

class Zad6 {

    static String encode(String text, int step) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            temp.append((char) (text.charAt(i) + step));
        }
        return temp.toString();
    }
}