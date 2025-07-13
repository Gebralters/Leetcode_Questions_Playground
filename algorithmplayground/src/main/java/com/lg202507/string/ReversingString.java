package com.lg202507.string;

import java.util.Stack;

public class ReversingString {
    public static void main(String[] args) {
        String myString = ".masesi and luthendo ,wangu ,letheba bethile ke";
        System.out.println(returnString(myString));
    }

    private static String returnString(String originalString) {
        String retString = "";
        String[] arrayString = originalString.split(" ");
        for (int i = arrayString.length - 1; i >= 0; i--) {
            if (arrayString[i].matches("[A-Za-z]+")) {
                retString += arrayString[i] + " ";
            } else {
                retString += removePanctuation(arrayString[i]) + " ";
            }
        }
        return retString;
    }

    public static String removePanctuation(String oddString) {
        StringBuilder sb = new StringBuilder(oddString);
        char ch = sb.charAt(0);
        sb = sb.deleteCharAt(0);
        sb.append(ch);
        return sb.toString();
    }
}
