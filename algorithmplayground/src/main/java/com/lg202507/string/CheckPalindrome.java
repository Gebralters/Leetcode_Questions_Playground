package com.lg202507.string;

public class CheckPalindrome {
    public static void main(String[] args) {
        if (isPalindrome("letheba")) System.out.println("Is palindrome");
        else System.out.println("not palindrome");
    }

    public static boolean isPalindrome(String myString) {
        if (myString.equals(reverseString(myString))) {
            return true;
        }
        return false;
    }

    public static String reverseString(String myString) {
        StringBuilder sb=new StringBuilder();
        for (int i = myString.length()-1; i>=0; i--) {
            sb.append(myString.charAt(i));
        }

        return sb.toString();
    }
}
