package com.SCL;

import java.awt.geom.Path2D;

public class Calculate {
    // 判断是否为操作符号
    public static boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")
                || operator.equals("(") || operator.equals(")"))
            return true;
        else
            return false;
    }
    // 设置操作符号的优先级别
    public static int priority(String operator) {
        if (operator.equals("+") || operator.equals("-"))
            return 1;
        else if (operator.equals("*") || operator.equals("/"))
            return 2;
        else
            return 0;
    }
    // 做2值之间的计算
    public static String twoResult(String operator, String a, String b) {
        try {
            String op = operator;
            String rs = new String();
            String fenzi ;
            String fenmu;
          float x = Float.parseFloat(b);
          float y =Float.parseFloat(a);
            boolean f = true;

          float z = 0;

            if (op.equals("+"))
                z = x + y;
            else if (op.equals("-")) {
                z = x - y;

            }
            else if (op.equals("*"))
                z = x * y;
            else if (op.equals("/"))
            {
                if(y==0) {
                    y=1;
                    z=999999;
                }
                if(x==y&&y!=0){
                    z=1;
                }
                if (y==1){
                    z=x;
                }
               // if(z*y!=x) z=999999;
            }
            else
                z = 999999;
            if(z<0) z=999999;
           // if(z!=(int)z) z=999999;
            return String.valueOf(z);
        } catch (NumberFormatException e) {
            System.out.println("input has something wrong!");
           return" Error" ;
        }
    }
}
