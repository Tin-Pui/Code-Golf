package com.codegolf.team0.challenge_f;

import java.util.Arrays;

/**
 * Challenge F - Basic set construction
 * Given a set of numbers and a target construct a function that will create the target number from any element of the set using the addition and subtraction operators and each element only once.
 * The function should return an error if the target number cannot be met.
 *
 * Eg 1 5 2
 *
 * with target 4= 5-1
 * with target 7= 5+2
 * with target 3= 2+1
 * with target 9= "error"
 */
public class Team0_Q6 {
    public static void main(String[] args) {
        int[] array = {1,2,4,8,16,32,64};
        long start = System.currentTimeMillis();
        for (int target = -130; target <= 130; target++) {
            System.out.println(integerConstruct(target,array));
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " ms");
    }

    public static String integerConstruct(final int targetInteger, final int... elements) {
        return construct(targetInteger, 0, "", elements);
    }

    private static String construct(final int finalTarget, final int currentValue, final String currentConstruct, final int[] elements) {
        if (currentValue != finalTarget || currentConstruct.length() == 0) {
            if (elements.length == 0) {
                // return error when the current construct fails to meet the target
                return "error";
            } else {
                // try adding the element
                String tryAddConstruct = construct(
                        finalTarget,
                        currentValue + elements[0],
                        currentConstruct + "+" + elements[0],
                        Arrays.copyOfRange(elements, 1, elements.length));
                if (!tryAddConstruct.equalsIgnoreCase("error")) {
                    return tryAddConstruct;
                }
                // try ignoring the element
                String tryNothingConstruct = construct(
                        finalTarget,
                        currentValue,
                        currentConstruct,
                        Arrays.copyOfRange(elements, 1, elements.length));
                if (!tryNothingConstruct.equalsIgnoreCase("error")) {
                    return tryNothingConstruct;
                }
                // try subtracting the element
                String trySubtractConstruct = construct(
                        finalTarget,
                        currentValue - elements[0],
                        currentConstruct + "-" + elements[0],
                        Arrays.copyOfRange(elements, 1, elements.length));
                if (!trySubtractConstruct.equalsIgnoreCase("error")) {
                    return trySubtractConstruct;
                }
                // return error if construct is not possible
                return "error";
            }
        } else {
            // return construct if target integer is met
            return finalTarget + " = " + currentConstruct;
        }
    }
}
