package com.company;

class Zad3 {

    static boolean zad3(String text) {
        StringBuilder str = new StringBuilder().append(text);
        return str.toString().equals(str.reverse().toString());
    }
}
