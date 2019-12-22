package com.example.calculate;

public class bin_calculate {
    private String str;
    public bin_calculate(String str) {
        this.str = str;
    }
    public String result() {
        char[] strChar=str.toCharArray();
        int length=0;
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
        for(int i=0;i<expression.length;i++) {
            System.out.println(expression[i]);
        }
        String result="";

        if(expression[1].equals("10")) {
            int num=Integer.parseInt(expression[0]);
            if(expression[2].equals("2")) {
                result=Integer.toBinaryString(num);
            }
            else if(expression[2].equals("8")) {
                result=Integer.toOctalString(num);
            }
            else if(expression[2].equals("16")) {
                result=Integer.toHexString(num);
            }
        }
        else if(expression[1].equals("2")) {
            int num2=Integer.parseInt(expression[0], 2);
            result=num2+"";
        }
        else if(expression[1].equals("8")) {
            int num8=Integer.parseInt(expression[0], 8);
            result=num8+"";
        }
        else if(expression[1].equals("16")) {
            int num16=Integer.parseInt(expression[0], 16);
            result=num16+"";
        }
        return result;
    }
}
