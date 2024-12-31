package com.demo.chemcasio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Unit3 extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    EditText editText12, editText22, editText32, editText42;
    Button buttonSubmit;
    Button buttonSubmit2;
    TextView resultA, resultB,resultF;
    TextView resultF2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        resultA = findViewById(R.id.resultA);
        resultB = findViewById(R.id.resultB);
        resultF = findViewById(R.id.resultF);

        editText12 = findViewById(R.id.editText12);
        editText22 = findViewById(R.id.editText22);
        editText32 = findViewById(R.id.editText32);
        buttonSubmit2 = findViewById(R.id.buttonSubmit2);
        resultF2 = findViewById(R.id.resultF2);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditTexts
                String valueA = editText1.getText().toString();
                String valueB = editText2.getText().toString();
                String valueC = editText3.getText().toString();

                // Convert values to integers and handle invalid input
                try {
                    float a = Float.parseFloat(valueA);
                    float b = Float.parseFloat(valueB);
                    float c = Float.parseFloat(valueC);
                    float resultAValue = calc(a);
                    float resultBValue=calc(b);
                    float xx=resultAValue/resultBValue;
                    float yy;
                    yy = (float) Math.pow(xx, 1.5);
                    float resultCValue =c/yy ;


                    // Display the results
                    resultA.setText("Temperature1 in kelvin    " + resultAValue);
                    resultB.setText("Temperature2 in kelvin    " + resultBValue);
                    resultF.setText("Calculated Diffusivity at T2 is \n" + resultCValue +" Cm²/S");

                    // Make the result TextViews visible
                    resultA.setVisibility(View.VISIBLE);
                    resultB.setVisibility(View.VISIBLE);
                    resultF.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e1) {
                    // Handle invalid input (e.g., non-numeric input)
                    Toast.makeText(Unit3.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueA2 = editText12.getText().toString();
                String valueB2 = editText22.getText().toString();
                String valueC2 = editText32.getText().toString();

                // Convert values to integers and handle invalid input
                try {
                    float a2 = Float.parseFloat(valueA2);
                    float b2 = Float.parseFloat(valueB2);
                    float c2 = Float.parseFloat(valueC2);
                    float resultAValue2 = a2;
                    float resultBValue2= b2;
                    float resultCValue2 = c2;
                    float p1,q1;
                    p1=resultBValue2/resultAValue2;
                    q1=resultCValue2/p1;

                    // Display the results
                    resultF2.setText("Diffusivity at P2 is \n" + q1 +" Cm²/S");

                    // Make the result TextViews visible
                    resultF2.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e1) {
                    // Handle invalid input (e.g., non-numeric input)
                    Toast.makeText(Unit3.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private float calc(float x){
        float pump;
        pump=x+273;
        return pump;
    }
}