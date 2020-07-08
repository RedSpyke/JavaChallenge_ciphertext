package com.company;

import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

     //  String msg = input.nextLine().toLowerCase().replaceAll(" ", "").replaceAll("\\W", "");
    //    String keyword = input.nextLine();
        String msg = "showoffyourskillsandfindanewamazingjob";
        String keyword = "jobful";
        input.close();

       // System.out.println(msg);
        int msgLength = msg.length();
        int keywordLength = keyword.length();
        int nrRowsMatrix;
        if((msgLength % keywordLength) == 0 ){
           nrRowsMatrix  = msgLength / keywordLength;
        }
        else {
            nrRowsMatrix = msgLength / keywordLength + 1;
        }
      //  System.out.println(nrRowsMatrix);

        char [] msgCh = msg.toCharArray();
        char [] keywordCh = keyword.toCharArray();

        char [][] matrix = new char[nrRowsMatrix + 2][keywordLength];


        int a = 0;

        for (int i = 0; i < nrRowsMatrix + 2; i++) {
            for (int j = 0; j < keywordLength; j++) {
                    if(i == 0){
                        matrix[i][j] = keywordCh[j];
                    }
                    else if (i != nrRowsMatrix +1){
                         if(a < msgCh.length){
                             matrix[i][j] = msgCh[a];
                         }else {
                             matrix[i][j] = 'x';
                         }
                         a++;
                    }
            }
        }

        for (int i = 0; i < nrRowsMatrix + 2; i++) {
            for (int j = 0; j < keywordLength; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

}
