package com.codegolf.team0.challenge_e;

/**
 * Challenge E  - Character Manipulation
 * Given an arbitrary string create a function to perform the following operations:
 * #1: Every character must have a different case to preceding and following characters
 * #2: Ignore non alphabetic characters (everything except [a-z,A-Z]
 * #3: Input strings will only consist of printable characters (ASCII 20 to 7E)
 * #4: The first character case should be inverted
 *
 * Eg
 * #1: ALLONEWORDUPPER -> aLlOnEwOrDuPpEr
 * #2: allonewordlower -> AlLoNeWoRdLoWeR
 * #3: 666 -> 666
 * #4: #ignore+$ymB01s -> #IgNoRe+$YmB01s
 * #5: AA11BB22cc60zyx -> aA11bB22cC60zYx
 */
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
                        characterArray[index] = Character.toUpperCase(character);
                    } else {
                        characterArray[index] = Character.toLowerCase(character);
                    }
                    nextCharacterToUpper = !nextCharacterToUpper;
                }
            }
        }
        return new String(characterArray);
    }
}
