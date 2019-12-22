package com.example.calculate;

public class length_calculate {
    private String str;
    public length_calculate(String str) {
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
		/*for(int i=0;i<expression.length;i++) {
			System.out.println(expression[i]);
		}*/
        String result="";
        double num=Double.parseDouble(expression[0]);
        //System.out.print(num);
        if(expression[1].equals("cm")) {
            if(expression[2].equals("dm")) {
                double d=num/10;
                result=Double.toString(d);
            }
            else if(expression[2].equals("m")) {
                double m=num/100;
                result=Double.toString(m);
            }
        }
        else if(expression[1].equals("dm")) {
            if(expression[2].equals("cm")) {
                double c=num*10;
                result=Double.toString(c);
            }
            else if(expression[2].equals("m")) {
                double m=num/10;
                result=Double.toString(m);
            }
        }
        else if(expression[1].equals("m")) {
            if(expression[2].equals("cm")) {
                double c=num*100;
                result=Double.toString(c);
            }
            else if(expression[2].equals("dm")) {
                double d=num*10;
                result=Double.toString(d);
            }
        }
        return result;
    }
}
