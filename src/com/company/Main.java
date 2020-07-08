package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String msg = input.nextLine();
        String keyword = input.nextLine();
        input.close();
        System.out.println(cipherText(msg,keyword));

    }

    public static String cipherText (String message, String keyWord){

        String msg = message.toLowerCase().replaceAll(" ", "").replaceAll("\\W", "");
        // System.out.println(msg);
        int msgLength = msg.length();
        int keywordLength = keyWord.length();
        int nrRowsMatrix;
        if((msgLength % keywordLength) == 0 ){
            nrRowsMatrix  = msgLength / keywordLength;
        }
        else {
            nrRowsMatrix = msgLength / keywordLength + 1;
        }
        //  System.out.println(nrRowsMatrix);

        char [] msgCh = msg.toCharArray();
        char [] keywordCh = keyWord.toCharArray();
        char [][] matrix = new char[nrRowsMatrix + 2][keywordLength];
        int a = 0;
        // fill the matrix with the letters
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
        // order of rows
        Arrays.sort(keywordCh);
        for (int i = 0; i < keywordCh.length; i++) {
            for (int j = 0; j < keywordCh.length; j++) {
                if(matrix[0][j] == keywordCh [i]){
                    matrix [nrRowsMatrix +1][j] = Character.forDigit(i + 1,10);
                }
            }
        }
        // printing matrix
//        for (int i = 0; i < nrRowsMatrix + 2; i++) {
//            for (int j = 0; j < keywordLength; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
        // cipher text
        String cipherText = "";
        for (int k = 1; k <= keywordLength ; k++) {
            for (int i = 0; i < keywordLength; i++) {
                if(Character.forDigit(k,10) == matrix[nrRowsMatrix+1][i]){
                    for (int j = 1; j < nrRowsMatrix + 1; j++) {
                        cipherText += matrix[j][i];
                    }
                }
            }
        }
        // System.out.println(cipherText);
        return  cipherText;
    }

}
