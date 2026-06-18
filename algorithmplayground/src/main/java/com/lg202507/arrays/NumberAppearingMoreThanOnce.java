package com.lg202507.arrays;

import javax.swing.*;
import java.util.ArrayList;

public class NumberAppearingMoreThanOnce {
    public static void main(String[] args) {
        int[] numarray = {1, 2, 3, 2, 4, 5, 1, 2};
        ArrayList<Integer> numFound=new ArrayList<>();
         for (int i = 0; i < numarray.length; i++) {
             for (int j = i+1; j < numarray.length; j++) {
                if (numarray[i] == numarray[j] && !checkDuplicate(numFound,numarray[i])) {
                    numFound.add(numarray[i]);
                    break;
                }
            }
        }

        for (int i = 0; i < numFound.size(); i++) {
            System.out.println(numFound.get(i));
        }
    }
    public static boolean checkDuplicate(ArrayList<Integer> numbers, int num) {
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i)==num) return true;
        }
        return false;
    }
}
