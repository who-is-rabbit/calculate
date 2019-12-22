package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class vol extends AppCompatActivity {
    String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol);
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
        Button translate=(Button)findViewById(R.id.translate);
        Button cm=(Button)findViewById(R.id.cm);
        Button dm=(Button)findViewById(R.id.dm);
        Button m=(Button)findViewById(R.id.m);
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
                vol_calculate vc=new vol_calculate(str);
                textView.setText(vc.result());
            }
        });
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="!";
                textView.append("单位:");
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
        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="cm³";
                textView.append("cm³");
            }
        });
        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="dm³";
                textView.append("dm³");
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="m³";
                textView.append("m³");
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
                Intent normal=new Intent(vol.this,MainActivity.class);
                startActivity(normal);
            case R.id.length:
                Intent length=new Intent(vol.this, com.example.calculate.length.class);
                startActivity(length);
                break;
            case R.id.vol:
                Intent vol=new Intent(vol.this, com.example.calculate.vol.class);
                startActivity(vol);
                break;
            case R.id.bin:
                Intent bin=new Intent(vol.this, com.example.calculate.bin.class);
                startActivity(bin);
                break;
            case R.id.science:
                Intent science=new Intent(vol.this, com.example.calculate.science.class);
                startActivity(science);
                break;
            case R.id.quit:
                android.os.Process.killProcess(android.os.Process.myPid());
        }
        return super.onOptionsItemSelected(item);
    }
}
