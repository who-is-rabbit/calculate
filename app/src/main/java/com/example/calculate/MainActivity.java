package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置按钮监听事件
        Button clear=(Button)findViewById(R.id.clear);
        Button delete=(Button)findViewById(R.id.delete);
        Button divide=(Button)findViewById(R.id.divide);
        Button num7=(Button)findViewById(R.id.num7);
        Button num8=(Button)findViewById(R.id.num8);
        Button num9=(Button)findViewById(R.id.num9);
        Button multiply=(Button)findViewById(R.id.multiply);
        Button num4=(Button)findViewById(R.id.num4);
        Button num5=(Button)findViewById(R.id.num5);
        Button num6=(Button)findViewById(R.id.num6);
        Button subtract=(Button)findViewById(R.id.subtract);
        Button num1=(Button)findViewById(R.id.num1);
        Button num2=(Button)findViewById(R.id.num2);
        Button num3=(Button)findViewById(R.id.num3);
        Button add=(Button)findViewById(R.id.add);
        Button sin=(Button)findViewById(R.id.sin);
        Button cos=(Button)findViewById(R.id.cos);
        Button bracket1=(Button)findViewById(R.id.bracket1);
        Button bracket2=(Button)findViewById(R.id.bracket2);
        Button num0=(Button)findViewById(R.id.num0);
        Button point=(Button)findViewById(R.id.point);
        Button result=(Button)findViewById(R.id.result);
        final TextView textView=(TextView)findViewById(R.id.text1);
        final String str;
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

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=textView.getText().toString();
                Calculate c=new Calculate(str);
                textView.setText(c.finalresult()+"");

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"/");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"9");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"*");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"6");
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"-");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"3");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"+");
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"sin");
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"cos");
            }
        });
        bracket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"(");
            }
        });
        bracket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+")");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+"0");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText()+".");
            }
        });
        if(this.getResources().getConfiguration().orientation!= Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main_land);
        }
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
                Intent normal=new Intent(MainActivity.this,MainActivity.class);
                startActivity(normal);
                break;
            case R.id.length:
                Intent length=new Intent(MainActivity.this, com.example.calculate.length.class);
                startActivity(length);
                break;
            case R.id.vol:
                Intent vol=new Intent(MainActivity.this, com.example.calculate.vol.class);
                startActivity(vol);
                break;
            case R.id.bin:
                Intent bin=new Intent(MainActivity.this, com.example.calculate.bin.class);
                startActivity(bin);
                break;
            case R.id.science:
                Intent science=new Intent(MainActivity.this, com.example.calculate.science.class);
                startActivity(science);
                break;
            case R.id.quit:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
