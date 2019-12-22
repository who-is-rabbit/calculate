package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class bin extends AppCompatActivity {
    String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin);
        Button clear=(Button)findViewById(R.id.clear);
        Button delete=(Button)findViewById(R.id.delete);
        Button num7=(Button)findViewById(R.id.num7);
        Button num8=(Button)findViewById(R.id.num8);
        Button num9=(Button)findViewById(R.id.num9);
        Button num4=(Button)findViewById(R.id.num4);
        Button num5=(Button)findViewById(R.id.num5);
        Button num6=(Button)findViewById(R.id.num6);
        Button num1=(Button)findViewById(R.id.num1);
        Button num2=(Button)findViewById(R.id.num2);
        Button num3=(Button)findViewById(R.id.num3);
        Button num0=(Button)findViewById(R.id.num0);
        Button AC=(Button)findViewById(R.id.AC);
        Button A=(Button)findViewById(R.id.A);
        Button B=(Button)findViewById(R.id.B);
        Button C=(Button)findViewById(R.id.C);
        Button D=(Button)findViewById(R.id.D);
        Button E=(Button)findViewById(R.id.E);
        Button F=(Button)findViewById(R.id.F);
        Button translate=(Button)findViewById(R.id.translate);
        final TextView textView=(TextView)findViewById(R.id.text1);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textView.getText().toString().isEmpty()){
                    String text=textView.getText().toString();
                    text=text.substring(0,text.length()-1);
                    textView.setText(text);
                }
            }
        });
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="!";
                bin_calculate bc=new bin_calculate(str);
                textView.setText(bc.result());
            }
        });
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="!";
                textView.append("进制:");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="0";
                textView.append("0");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="7";
                textView.append("7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="8";
                textView.append("8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="9";
                textView.append("9");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="4";
                textView.append("4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="5";
                textView.append("5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="6";
                textView.append("6");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="1";
                textView.append("1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="2";
                textView.append("2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="3";
                textView.append("3");
            }
        });
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="A";
                textView.append("A");
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="B";
                textView.append("B");
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="C";
                textView.append("C");
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="D";
                textView.append("D");
            }
        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="E";
                textView.append("E");
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="F";
                textView.append("F");
            }
        });
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.help:
                Toast.makeText(this,"Somethings can help you",Toast.LENGTH_LONG).show();
                break;
            case R.id.normal:
                Intent normal=new Intent(bin.this,MainActivity.class);
                startActivity(normal);
            case R.id.length:
                Intent length=new Intent(bin.this, com.example.calculate.length.class);
                startActivity(length);
                break;
            case R.id.vol:
                Intent vol=new Intent(bin.this, com.example.calculate.vol.class);
                startActivity(vol);
                break;
            case R.id.bin:
                Intent bin=new Intent(bin.this, com.example.calculate.bin.class);
                startActivity(bin);
                break;
            case R.id.science:
                Intent science=new Intent(bin.this, com.example.calculate.science.class);
                startActivity(science);
                break;
            case R.id.quit:
                android.os.Process.killProcess(android.os.Process.myPid());
        }
        return super.onOptionsItemSelected(item);
    }
}
