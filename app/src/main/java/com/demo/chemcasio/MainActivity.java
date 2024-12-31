package com.demo.chemcasio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button move1,move2,move3,move4,move5,move6,calcu,manule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manule=findViewById(R.id.manule);
        manule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        move1=findViewById(R.id.button_unit1);
        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Unit1.class);
                startActivity(intent);
            }
        });
        move2=findViewById(R.id.button_unit2);
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Unit2.class);
                startActivity(intent);
            }
        });
        move3=findViewById(R.id.button_unit3);
        move3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Unit3.class);
                startActivity(intent);
            }
        });
        move4=findViewById(R.id.button_unit4);
        move4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Unit4.class);
                startActivity(intent);
            }
        });
        move5=findViewById(R.id.button_unit5);
        move5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Unit5.class);
                startActivity(intent);
            }
        });
        move6=findViewById(R.id.button_unit6);
        move6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Study.class);
                startActivity(intent);
            }
        });
        calcu=findViewById(R.id.button_Molarcalc);
        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MolarCalculator.class);
                startActivity(intent);
            }
        });


    }
}