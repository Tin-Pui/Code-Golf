package com.codegolf.team0.challenge_e;

public class Team0_Q5 {

    public static void main(String[] args) {
        System.out.println(manipulate("#ignore+$ymB01s"));
        System.out.println(manipulate("AA11BB22cc60zyx"));
    }

    public static String manipulate(String string) {
        char[] characterArray = string.toCharArray();
        boolean isFirstCharacter = true;
        boolean nextCharacterToUpper = false;
        for (int index = 0; index < characterArray.length; index++) {
            char character = characterArray[index];
            if (Character.isAlphabetic(character)) {
                if (isFirstCharacter) {
                    if (Character.isUpperCase(character)) {
                        characterArray[index] = Character.toLowerCase(character);
                        nextCharacterToUpper = true;
                    } else {
                        characterArray[index] = Character.toUpperCase(character);
                        nextCharacterToUpper = false;
                    }
                    isFirstCharacter = false;
                } else {
                    if (nextCharacterToUpper) {
                        if (Character.isLowerCase(character)) {
                            characterArray[index] = Character.toUpperCase(character);
                        }
                    } else {
                        if (Character.isUpperCase(character)) {
                            characterArray[index] = Character.toLowerCase(character);
                        }
                    }
                    nextCharacterToUpper = !nextCharacterToUpper;
                }
            }
        }
        return new String(characterArray);
    }
}
