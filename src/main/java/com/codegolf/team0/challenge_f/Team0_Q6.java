package com.codegolf.team0.challenge_f;

import java.util.Arrays;

public class Team0_Q6 {

    public static void main(String[] args) {
        int[] array = {1,2,4,8,16,32,64,128,256,512};
        long start = System.currentTimeMillis();
        for (int target = -1000; target <= 1000; target++) {
            System.out.println(construct(target,0, "", array));
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " ms");
    }

    public static String construct(final int finalTarget,final int currentValue,final String currentConstruct,final int[] elements) {
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
