package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

     //  String msg = input.nextLine().toLowerCase().replaceAll(" ", "").replaceAll("\\W", "");
    //    String keyword = input.nextLine();
        String msg = "showoffyourskillsandfindanewamazingjob";
        String keyword = "jobful";
        input.close();

      //  System.out.println(msg);
      //  System.out.println(keyword);

        int msgLength = msg.length();
        int keywordLength = keyword.length();
        int nrRowsMatrix;
        if((msgLength % keywordLength) == 0 ){
           nrRowsMatrix  = msgLength / keywordLength;
        }
        else {
            nrRowsMatrix = msgLength / keywordLength + 1;
        }

        System.out.println(nrRowsMatrix);

      //  char [][] matrix = new char[][];







    }

    



}
