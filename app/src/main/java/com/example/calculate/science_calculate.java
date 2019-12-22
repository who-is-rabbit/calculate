package com.example.calculate;

public class science_calculate {
    private String str;
    public science_calculate(String str) {
        this.str = str;
    }
    public  String result() {
        char[] strChar=str.toCharArray();
        int length=1;
        String mid="";
        int k=0;
        for(int i=0;i<strChar.length;i++) {
            if(strChar[i]=='!') {
                length=length+1;
            }
        }
        String expression[]=new String[length];
        for(int i=0;i<strChar.length;i++) {
            if(strChar[i]!='!') {
                mid=mid+strChar[i];
            }
            else {
                if(mid!=""){
                    expression[k]=mid;
                    k=k+1;
                }
                mid="";
            }
        }
        String s="";
        if(expression[0].equals("sin")||expression[0].equals("cos")||expression[0].equals("tan")) {
            int num=Integer.parseInt(expression[1]);
            double jiaodu=Math.toRadians(num);
            if(expression[0].equals("sin")) {
                double numsin=Math.sin(jiaodu);
                s=String.format("%.2f", numsin);
            }
            else if(expression[0].equals("cos")) {
                double numcos=Math.cos(jiaodu);
                s=String.format("%.2f", numcos);
            }
            else if(expression[0].equals("tan")) {
                double numtan=Math.tan(jiaodu);
                s=String.format("%.2f", numtan);
            }
        }
        else if(expression[0].equals("log")||expression[0].equals("ln")) {
            double num=Double.valueOf(expression[1]);
            if(expression[0].equals("log")) {
                double log=Math.log(num);
                s=String.format("%.2f",log);
            }
            else if(expression[0].equals("ln")) {
                double ln=Math.log(num);
                s=String.format("%.2f",ln);
            }
        }
        else if(Character.isDigit(strChar[1])==true) {
            if(expression[1].equals("x²")) {
                double r=Double.valueOf(expression[0])*Double.valueOf(expression[0]);
                s=String.format("%.2f",r);
            }
            else if(expression[1].equals("1/x")) {
                double r=1/Double.valueOf(expression[0]);
                s=String.format("%.2f",r);
            }
            else if(expression[1].equals("%")) {
                double r=Double.valueOf(expression[0])/100;
                s=String.format("%.2f",r);
            }
            else if(expression[1].equals("√")) {
                double r=Math.sqrt(Double.valueOf(expression[0]));
                s=String.format("%.2f",r);
            }

        }
        return s;
    }
}
