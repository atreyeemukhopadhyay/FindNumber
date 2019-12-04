package com.atreyee.test;

import java.math.BigDecimal;
import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        Stack<Number> inputNumbers = new Stack<Number>();

        //set 1 input
        inputNumbers.add(123.45789);
        inputNumbers.add(-99);
        inputNumbers.add(-999);
        inputNumbers.add(12345678);
        inputNumbers.add(0);
        inputNumbers.add(8.1);
        inputNumbers.add(-12);
        inputNumbers.add(100.998);
        inputNumbers.add(5000);

        //set 2 input
        /*inputNumbers.add(-1.5);
        inputNumbers.add(-0.9);
        inputNumbers.add(-12);
        inputNumbers.add(0);*/

        //set 3 input
        /*inputNumbers.add(1.5);
        inputNumbers.add(-500);
        inputNumbers.add(12);*/


        Number largestNumber = inputNumbers.peek();
        boolean isMatchingNumberAvailable = false;

        while (!inputNumbers.isEmpty()) {
            Number nextNumber = inputNumbers.pop();
            if (nextNumber != null) {
                if (checkNumberSize(nextNumber)) {
                    isMatchingNumberAvailable = true;
                    System.out.println(nextNumber);
                } else {
                    int compareResult = compareValues(nextNumber, largestNumber);
                    largestNumber = compareResult > 0 ? nextNumber : largestNumber;
                }
            }
        }
        if (isMatchingNumberAvailable) {
            System.out.println("Matching number(s) found");
        } else {
            System.out.println("largest number : " + largestNumber);
        }
    }

    /* compare values to check greater number
     */
    public static int compareValues(Number n1, Number n2) {
        BigDecimal convertedValue1 = convertToBigDecimal(n1);
        BigDecimal convertedValue2 = convertToBigDecimal(n2);
        return convertedValue1.compareTo(convertedValue2);
    }

    /* convert input numbers to BigDecimal since inputs are
     * of different datatype(long,int,float,double)
     */
    public static BigDecimal convertToBigDecimal(Number inputNumber) {
        BigDecimal convertedValue = null;
        String inputNumberClassName = inputNumber.getClass().getSimpleName();
        switch (inputNumberClassName) {
            case "Long":
                convertedValue = new BigDecimal(inputNumber.longValue());
            case "Float":
                if (Float.isFinite(inputNumber.floatValue()))
                    convertedValue = new BigDecimal(inputNumber.floatValue());
            case "Double":
                if (Double.isFinite(inputNumber.doubleValue()))
                    convertedValue = new BigDecimal(inputNumber.doubleValue());
            case "Integer":
                convertedValue = new BigDecimal(inputNumber.intValue());
            case "Short":
                convertedValue = new BigDecimal(inputNumber.shortValue());
            default:
                convertedValue = new BigDecimal(inputNumber.toString());
        }
        return convertedValue;
    }

    /* Checking number size by diving by 100 since the size
     * should be equal or more than 3.
     */
    public static boolean checkNumberSize(Number input) {
        boolean isMatching = false;
        String inputNumberClassName = input.getClass().getSimpleName();
        switch (inputNumberClassName) {
            case "Long":
                long longValue = input.longValue();
                isMatching = Math.abs(longValue) / 100 >= 1;
                break;
            case "Float":
                Float floatValue = input.floatValue();
                if (Float.isFinite(floatValue))
                    isMatching = Math.abs(floatValue) / 100 >= 1;
                break;
            case "Double":
                Double doubleValue = input.doubleValue();
                if (Double.isFinite(doubleValue)) {
                    isMatching = Math.abs(doubleValue) / 100 >= 1;
                }
                break;
            case "Integer":
                Integer intValue = input.intValue();
                isMatching = Math.abs(intValue) / 100 >= 1;
                break;
            default:
                Short shortValue = input.shortValue();
                isMatching = Math.abs(shortValue) / 100 >= 1;
                break;
        }
        return isMatching;

    }
}
