package com.lg202507.primenumbers;

public class FizzBuzz {
    public static void main(String[] args) {
        int myPrime=-21;
        if (isPrime(myPrime)) {
            System.out.println("is prime");
        } else {
            System.out.println("not prime");
        }


        int myNum=16;
        for (int i = 1; i <= myNum; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3==0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(int num) {
        boolean status = true;
        if (num == 1 || num<1) {
            return false;
        }
        int sqrtNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtNum; i++) {
            if (num % i == 0) {
                status=false;
                break;
            }
        }
        return status;
    }
}
