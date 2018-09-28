package com.SCL;


import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.System.*;


public class Arithmetic {

    public static ArrayList<Double> correct = new ArrayList<>();
    public static ArrayList<Double> wrong = new ArrayList<>();
    public static ArrayList<String> dd = new ArrayList<>();

    public static ArrayList<Double> cc = new ArrayList<>();
    public static ArrayList<String> ss = new ArrayList<String>();
    public static ArrayList<Double> aa = new ArrayList<Double>();
    static int count;
    static int max;


    public static void read() throws IOException {

//        ArrayList<Double> cc = new ArrayList<>();

        BufferedReader bre = null;
        String line = "";

        int i = 0;
        String file = "./Answers1.txt";
        bre = new BufferedReader(new FileReader(file));//此时获取到的bre就是整个文件的缓存流
        while ((line = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
        {
            cc.add(Double.parseDouble(line));

        }

        bre.close();
        for (; i < cc.size(); i++) {
            out.print((i + 1) + ".     ");
            out.println((cc.get(i)));
        }
        File file4 = new File("./Answers.txt");
        FileOutputStream fops4 = null;

        try {
            fops4 = new FileOutputStream(file4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps4 = new PrintStream(fops4);
        for (i = 0; i < count; i++) {
            ps4.print((i + 1) + ".     ");
            ps4.println((FloatToFraction.xs2fs(cc.get(i))));
        }
        // out.println("cc" + cc.size());
    }


    public static void method2() throws IOException {
        int i = 0;

        out.print("请输入生成题目个数：");

        count = new Scanner(in).nextInt();

        out.print("请输入数最大数值：");
        Scanner r = new Scanner(in);
        max = r.nextInt();


        File file2 = new File("./Answers1.txt");
        FileOutputStream fops2 = null;

        try {
            fops2 = new FileOutputStream(file2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps2 = new PrintStream(fops2);
        File file = new File("./Exercises.txt");
        FileOutputStream fops = null;

        try {
            fops = new FileOutputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fops);
        //+ express.getExpresult()
        boolean f = true;

        for (i = 0; i < count; i++) {
            String data = Data();
            String input = data;
            ss.add(input);
            if (input.equals("q"))
                break;
            else {
                com.SCL.Expression express = new com.SCL.Expression(input);

                f = express.getResult();
                if (!f) i--;
                else {


                    ps.println(data + "=" + express.getExpresult());
                    ps2.println(express.getExpresult());
                }
            }
        }

    }

    /*  //if (cc.size() != 0&&aa.size() != 0) {
          out.println("来到这里");
          for (i = 0; i < count; i++) {

              //if (cc.get(i) == (aa.get(i)))
                 // correct.add(i);
              //else wrong.add(i);
          }
          for (double g : cc)
              out.println("correct" + g);
          for (double h : aa)
              out.println("wrong" + h);


      //}else out.println("输入未完成");
  }*/
    public static void main(String[] args) throws NullPointerException, IOException {
        // 输出面板
        out.println("\n---------------------3116005153 WC程序---------------------");
        out.println("************                                    ***********");
        out.println("  **       -n    控制生成题目的个数        ");
        out.println("  **       -r    参数控制题目中数值范围，不包括该数（必填且大于等于1）   ");
        out.println("-----------------------------------------------------------");
        Arithmetic arithmetic = new Arithmetic();
        method2();
        out.println("已生成生成" + count + "道题目：");
        arithmetic.method1();


        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        arithmetic.match();


    }

    //随机产生算式
    public static String Data() {

        Random rand = new Random();
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        ArrayList<String> express = new ArrayList<String>();
        //产生随机数

        for (int i = 0; i < 3; i++) {
            numlist.add(rand.nextInt(max));
        }
        // out.print(numlist);
        String[] operator = new String[]{"+", "-", "*", "/"};
        int size = numlist.size();
        String[] num = new String[size];
        for (int i = 0; i < numlist.size(); i++) {
            num[i] = String.valueOf(numlist.get(i));
        }
        String exp = "";
        for (int j = 0; j < num.length; j++) {
            express.add(num[j]);
            express.add(operator[rand.nextInt(4)]);
        }
        //System.out.print(express);

        for (int i = 0; i < express.size() - 1; i++)
            exp += express.get(i);
        return exp;
    }

    public void method1() {
        int i;
        out.println("请输入答案：");
        Scanner in_t1 = new Scanner(in);//循环输入T1数组
        for (i = 0; i < count; i++) {
            aa.add((in_t1.nextDouble()));

        }
        out.println("用户答案：");
        for (i = 0; i < count; i++) {
            out.print((i + 1) + ".     ");
            out.println(FloatToFraction.xs2fs((aa.get(i))));


        }
    }

    public void match() {

        File file3 = new File("./Grade.txt");
        FileOutputStream fops3 = null;

        try {
            fops3 = new FileOutputStream(file3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps3 = new PrintStream(fops3);
        int i=0;

        if (cc.size() != 0 && aa.size() != 0) {

            double idex = 1;
            System.out.println(cc.get(i));
            System.out.println(aa.get(i));
            for (i = 0; i < count; i++,idex++) {


                if (cc.get(i).toString().equals(aa.get(i).toString()) ){
                    correct.add(idex);
                } else {
                    wrong.add(idex);
                }


            }
            ps3.print("correct"+"(");
            for (i = 0; i < correct.size(); i++) {
                ps3.print(FloatToFraction.xs2fs(correct.get(i)));
                ps3.print("，");
            }
            ps3.println(")");

            ps3.print("wrong"+"(");
            for (i = 0; i < wrong.size(); i++) {
                ps3.print(FloatToFraction.xs2fs(wrong.get(i)));
                ps3.print("，");
            }
            ps3.print(")");
           /* out.println("correct" );
            for (double g : correct)
                out.println( g);
            for (double h :wrong)
                out.println("wrong" + h);
            }else out.println("ERROR");*/

        }
    }
}

