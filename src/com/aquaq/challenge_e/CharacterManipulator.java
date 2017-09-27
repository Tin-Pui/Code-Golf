package com.aquaq.challenge_e;

public class CharacterManipulator {

    public static void main(String[] args) {

        System.out.println(manipulate("AA11BB22cc60zyx"));
    }

    public static String manipulate(String stringToChange) {

        char[] stringToChars = stringToChange.toCharArray();

        boolean firstLetterFound = false;
        boolean nextCharToUpper = false;

        for (int i = 0; i < stringToChange.length(); i++) {
            if (Character.isLetter(stringToChars[i])) {
                if (!firstLetterFound) {
                    if (Character.isLowerCase(stringToChars[i])) {
                        stringToChars[i] = Character.toUpperCase(stringToChars[i]);
                        nextCharToUpper = false;
                        firstLetterFound = true;
                    } else {
                        stringToChars[i] = Character.toLowerCase(stringToChars[i]);
                        nextCharToUpper = true;
                        firstLetterFound = true;
                    }
                } else {
                    if (nextCharToUpper) {
                        stringToChars[i] = Character.toUpperCase(stringToChars[i]);
                        nextCharToUpper = false;
                    } else {
                        stringToChars[i] = Character.toLowerCase(stringToChars[i]);
                        nextCharToUpper = true;
                    }
                }
            }
        }

        return String.valueOf(stringToChars);
    }

}
