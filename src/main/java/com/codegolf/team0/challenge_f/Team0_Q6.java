package com.codegolf.team0.challenge_f;

import java.util.Arrays;

public class Team0_Q6 {

    public static void main(String[] args) {
        int[] array = {1,5,3,2,13,4,7};
        System.out.println(construct(16,0, "", array));
    }

    public static String construct(int finalTarget, int currentValue, String currentConstruct, int[] elements) {
        if (currentValue != finalTarget) {
            if (elements.length == 0) {
                return "error";
            } else {
                if (!construct(
                        finalTarget,
                        currentValue + elements[0],
                        currentConstruct + "+" + elements[0],
                        Arrays.copyOfRange(elements, 1, elements.length)).equalsIgnoreCase("error")) {
                    return construct(
                            finalTarget,
                            currentValue + elements[0],
                            currentConstruct + "+" + elements[0],
                            Arrays.copyOfRange(elements, 1, elements.length));
                }
                if (!construct(
                        finalTarget,
                        currentValue,
                        currentConstruct,
                        Arrays.copyOfRange(elements, 1, elements.length)).equalsIgnoreCase("error")) {
                    return construct(
                            finalTarget,
                            currentValue,
                            currentConstruct,
                            Arrays.copyOfRange(elements, 1, elements.length));
                }
                if (!construct(
                        finalTarget,
                        currentValue - elements[0],
                        currentConstruct + "-" + elements[0],
                        Arrays.copyOfRange(elements, 1, elements.length)).equalsIgnoreCase("error")) {
                    return construct(
                            finalTarget,
                            currentValue - elements[0],
                            currentConstruct + "-" + elements[0],
                            Arrays.copyOfRange(elements, 1, elements.length));
                }
                return "error";
            }
        } else {
            return currentConstruct;
        }
    }

}
