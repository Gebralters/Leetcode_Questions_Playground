package com.lg202507.primenumbers;

import java.util.ArrayList;

public class FindingPrimeNumbers {
    public static void main(String[] args) {
        int[] primeNumbers={57, 23, 12, 89, 34, 7, 45, 31, 72, 97, 18, 11, 50, 3, 20};
        int[] myArray = returnArray(primeNumbers);
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i]+", ");
        }
    }

    public static int[] returnArray(int[] arrayNum) {
        ArrayList<Integer> myPrimeNumbers=new ArrayList<>();
        for (int i = 0; i < arrayNum.length; i++) {
            if (isPrime(arrayNum[i])) {
                myPrimeNumbers.add(arrayNum[i]);
            }
        }
        int[] myArray=new int[myPrimeNumbers.size()];
        for (int i = 0; i < myPrimeNumbers.size(); i++) {
            myArray[i]= myPrimeNumbers.get(i);
        }
        return myArray;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int sqtNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqtNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
