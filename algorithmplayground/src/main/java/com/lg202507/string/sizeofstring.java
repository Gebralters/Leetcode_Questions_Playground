package com.lg202507.string;

public class sizeofstring {

    public static void main(String[] args) {
        String myStr="H";
        byte[] bytes=myStr.getBytes();
        System.out.println(bytes.length);
    }
}
