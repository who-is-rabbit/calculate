package com.example.calculate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculate {
    //传参
    private String text;
    public Calculate(String text) {
        this.text = text;
    }

    public String finalresult(){
        String mid="";//中间量
        char[] textChar=text.toCharArray();
        int k=0;
        int countSymbol=0;
        int bracket=0;
        //计算运算符
        for(int i = 0; i < textChar.length; i++){//不是数字且不是小数点(计算符号数)
            if(textChar[i]=='+'||textChar[i]=='-'||textChar[i]=='*'||textChar[i]=='/'){
                //符号数
                countSymbol++;
            }
            else if(textChar[i] == '(') {
                bracket=bracket+1;
            }

        }
        //System.out.println("bracket:"+bracket);
        //根据符号数求有小数算式最终长度
        String[] expression = new String[countSymbol*2+1+bracket*2];//有小数算式
        for(int i=0;i<textChar.length;i++) {
            if(Character.isDigit(textChar[i])==true||textChar[i]=='.') {
                mid=mid+textChar[i];
            }
            else if(textChar[i]=='+'||textChar[i]=='-'||textChar[i]=='*'||textChar[i]=='/'||textChar[i]=='('||textChar[i]==')') {
                if(mid!=""){
                    expression[k]=mid;
                    k=k+1;
                }
                mid="";
                expression[k]=""+textChar[i];
                k=k+1;
            }
        }
        if(Character.isDigit(textChar[textChar.length-1])==true) {
            expression[k]=mid;
        }
	    /*for(int i=0;i<expression.length;i++) {
	       System.out.println(expression[i]);
	    }*/
        int s=bracket;
        int left[]=new int[s];
        int right[]=new int[s];
        int m=0;
        int n=0;
        //用left[]、right[]记录左右括号在expression[]中的位置
        for(int i=0;i<expression.length;i++) {
            if(expression[i].equals("(")) {
                left[m]=i;
                m=m+1;
            }
            else if(expression[i].equals(")")){
                right[n]=i;
                n=n+1;
            }
        }
	    /*for(int i=0;i<right.length;i++) {
	     System.out.println(right[i]);
	    }*/
        //算出括号里的值并放入原数组
        String bracketResult[]=new String[s];
        int bracketLength[]=new int[s];//剩余长度
        for(int i=0;i<left.length;i++) {
            String inter[]=new String[right[i]-left[i]-1];
            System.arraycopy(expression, left[i]+1,inter,0,right[i]-left[i]-1);
            String result=result(inter);
            bracketResult[i]=result;
			   /*System.out.println("第"+i+"个inter数组"+":");
			   for(int j=0;j<right[i]-left[i]-1;j++) {
			 	     System.out.println(inter[j]);
			 	    }
			   System.out.println("第"+i+"个inter数组的结果是"+":"+result); */
            bracketLength[i]=right[i]-left[i];
        }

		   /*for(int j=0;j<bracketResult.length;j++) {
		 	     System.out.println(bracketResult[j]);
		 	    }*/
		   /*for(int j=0;j<bracketLength.length;j++) {
		 	     System.out.println(bracketLength[j]);
		 	    }*/

        for(int i=0;i<left.length;i++) {
            expression[left[i]]=bracketResult[i];
        }
        // System.out.println(expression[right[0]+1]);
        // System.out.println(expression[right[0]+1-bracketLength[0]]);
        // expression[right[0]+1-bracketLength[0]]=expression[right[0]+1];
        //System.out.println(expression[right[0]+1-bracketLength[0]]);
        for(int i=0;i<bracketLength.length;i++) {
            for(int j=0;j<expression.length-right[i]-1;j++) {
                expression[right[i]+1+j-bracketLength[i]]=expression[right[i]+1+j];
            }
            String simple[]=new String[expression.length-bracketLength[i]];
            for(int j=0;j<simple.length;j++) {
                simple[j]=expression[j];
            }

            expression = (String[]) arrayReduceLength(expression,bracketLength[i]);
            for(int j=0;j<right.length-1;j++) {
                right[j+1]=right[j+1]-bracketLength[i];
            }
            System.out.println("第"+i+"次移动后：");
            for(int j=0;j<expression.length;j++) {
                System.out.println(expression[j]);
            }
        }
        String a=result(expression);
        return a;
    }
    public String result(String[] expression) {

        // 规则，只能出现数字和加减乘除符号，最前和最后都是数字，即字符串能有效计算的
        // 计算内容分割
        List<String> numList = Arrays.asList(expression);
        List<String> list = new ArrayList<String>();
        Double temp = null; // 用于做乘除计算临时变量
        for (int i = 1; i < numList.size(); i += 2) { // 这里只循环运算符号
            if ("+".equals(numList.get(i)) || "-".equals(numList.get(i))) {
                if (null != temp) { // 存在临时变量，说明前面进行过乘除计算
                    list.add(temp.toString());
                    temp = null;
                } else {
                    list.add(numList.get(i - 1));
                }
                list.add(numList.get(i)); // 把符号加进去
                if (i == numList.size() - 2) { // 处理到最后时遇到直接处理
                    list.add(numList.get(i + 1));
                }
            } else if ("*".equals(numList.get(i))) {
                if (null == temp) {
                    temp = Double.parseDouble(numList.get(i - 1)) * Double.parseDouble(numList.get(i + 1));
                } else {
                    temp = temp * Double.parseDouble(numList.get(i + 1));
                }
                if (i == numList.size() - 2) { // 处理到最后时遇到直接处理
                    list.add(temp.toString());
                    temp = null;
                }
            } else if ("/".equals(numList.get(i))) {
                if (null == temp) {
                    temp = Double.parseDouble(numList.get(i - 1)) / Double.parseDouble(numList.get(i + 1));
                } else {
                    temp = temp / Double.parseDouble(numList.get(i + 1));
                }
                if (i == numList.size() - 2) { // 处理到最后时遇到直接处理
                    list.add(temp.toString());
                    temp = null;
                }
            }
        }
        System.out.println("====乘除后====");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " -> " + list.get(i));
        }
        // 再做加减计算
        Double sum = Double.parseDouble(list.get(0)); // 第一位不会在循环里处理
        for (int i = 1; i < list.size(); i += 2) { // 这里只循环运算符号
            if ("+".equals(list.get(i))) {
                sum += Double.parseDouble(list.get(i + 1));
            } else if ("-".equals(list.get(i))) {
                sum -= Double.parseDouble(list.get(i + 1));
            }
        }
        System.out.println("====最终值====");
        // 打印结果
        System.out.println(sum);
        String result = String.format("%.2f", sum);
        return result;
    }

    public String toString(String[] expression) {
        return text + "=" + result(expression);
    }
//数组长度删除
    public Object arrayReduceLength(Object oldArray, int reduceLength) {
        Class c = oldArray.getClass();
        if (!c.isArray()) return null;
        Class componentType = c.getComponentType();
        int length = Array.getLength(oldArray);
        int newLength = length - reduceLength;
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(oldArray, 0, newArray, 0, newLength);
        return newArray;
    }
}
