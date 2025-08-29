package com.lg202507.string;

public class DisplayDiamond {
    public static void main(String[] args) {
        int xCenter=11;
        int yCenter=7;
        int size=4;

        int length=14;
        int width=22;

        int [][]array2d= new int[length][width];


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                array2d[i][j]=0;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (array2d[i][j] == 0) {
                    System.out.print("*");
                }
                if (array2d[i][j] == 1) {
                    System.out.print("#");
                }
            }
            System.out.println();
        }



    }
}
