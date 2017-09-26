package com.aquaq.challenge_e;


public class CharacterManipulator {

    public static void main(String[] args) {

        System.out.println(manipulate("$$$bab$$$"));

    }

    public static String manipulate(String stringToChange) {

        char[] stringToChars = stringToChange.toCharArray();

        boolean containsLetters = false;
        int valueOfFirstLetter = 0;

        for (int i = 0; i < stringToChange.length(); i++) {
            if (Character.isLetter(stringToChars[i])) {
                if (Character.isLowerCase(stringToChars[i])) {
                    stringToChars[i] = Character.toUpperCase(stringToChars[i]);
                } else {
                    stringToChars[i] = Character.toLowerCase(stringToChars[i]);
                }
                containsLetters = true;
                valueOfFirstLetter = i;
                break;
            }
        }

        if (!containsLetters) {
            return stringToChange;
        }

        for (int i = valueOfFirstLetter; i < stringToChange.length() - 1; i++) {

            if (Character.isLowerCase(stringToChars[i])) {

                if (Character.isLowerCase(stringToChars[i - 1])
                        && Character.isLowerCase(stringToChars[i + 1])) {
                    stringToChars[i] = Character.toUpperCase(stringToChars[i]);
                }

            } else {

                if (Character.isUpperCase(stringToChars[i - 1])
                        && Character.isUpperCase(stringToChars[i + 1])) {
                    stringToChars[i] = Character.toLowerCase(stringToChars[i]);
                }

            }


        }

        return stringToChange = String.valueOf(stringToChars);
    }

    /*public char invertCase(char charToInvert) {

    }*/

}
