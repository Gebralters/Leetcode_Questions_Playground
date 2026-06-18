package com.lg202507.arrays;

import java.util.Arrays;

public class WrappingArray {
    public static void main(String[] args) {
        int[] array = {4, 8, 3, 6, 4, 10};
        int[] newArray = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            int newIndex = i + 2;
            newIndex = newIndex % array.length;
            newArray[newIndex]=array[i];
        }
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+" ");
        }
    }
}
