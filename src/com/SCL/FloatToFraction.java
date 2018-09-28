package com.SCL;

import java.util.Scanner;


public class FloatToFraction {
    //static String str1="1";
    static String str1="0";
    public static String xs2fs( double fNumber) {
         if (fNumber==0) return str1;

        String sA = String.valueOf(fNumber);

        if (sA.indexOf(".") < 0) {
            // fNumber is an integer

            return sA;
        }

        String sZsbf = sA.substring(0, sA.indexOf("."));
        String sXsbf = sA.substring(sA.indexOf(".") + 1);

        int nXsws = sXsbf.length(); //小数位数

        long lFenmu = 1;
        for (int k = 0; k < nXsws; k++)
            lFenmu *= 10;

        long lFenzi = Long.parseLong(sZsbf + sXsbf);

        long lXs = (lFenzi < lFenmu) ? lFenzi : lFenmu;

        long j = 1; //最大公约数
        for (j = lXs; j > 1; j--) {
            if (lFenzi % j == 0 && lFenmu % j == 0) {
                break;
            }
        }

        lFenzi = lFenzi / j;
        lFenmu = lFenmu / j;

      if (lFenmu==1)
            return String.valueOf(lFenzi);
        else
        return String.valueOf(lFenzi) + "/" + String.valueOf(lFenmu);


    }
}