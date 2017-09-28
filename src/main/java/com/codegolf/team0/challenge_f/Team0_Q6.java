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
        int[] array = {1,1,2,4,8,16,32,64,128,256,512};
        long start = System.currentTimeMillis();
        for (int target = -100; target <= 100; target++) {
            System.out.println(construct(target,0, "", array));
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " ms");
    }

    public static String construct(final int finalTarget,final int currentValue,final String currentConstruct,final int[] elements) {
        if (currentValue != finalTarget || currentConstruct.length() == 0) {
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
            return finalTarget + "=" + currentConstruct;
        }
    }
}
