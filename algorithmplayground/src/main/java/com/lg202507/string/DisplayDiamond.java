package com.lg202507.string;

public class DisplayDiamond {
    public static void main(String[] args) {

        int size=5;

        int length=28;
        int width=40;
        int xCenter=width/2;
        int yCenter=length/2;

        int [][]array2d= new int[length][width];


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                array2d[i][j]=0;
            }
        }


        int verticalNum=(length/2)-size;
        int count=1;
        for (int i = verticalNum; i < yCenter; i++) {
            for (int j = (xCenter-count); j < xCenter; j++) {
                array2d[i][j]=1;
            }
            for (int j = xCenter; j < (xCenter+count); j++) {
                array2d[i][j]=1;
            }
            count++;
        }

        count=size;
        for (int i = yCenter; i < (yCenter+size); i++) {
            for (int j = (xCenter-count); j < xCenter; j++) {
                array2d[i][j]=1;
            }
            for (int j = xCenter; j < (xCenter+count); j++) {
                array2d[i][j]=1;
            }
            count--;
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
