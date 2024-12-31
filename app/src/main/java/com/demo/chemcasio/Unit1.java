package com.demo.chemcasio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Unit1 extends AppCompatActivity {
    float finalresult;

    EditText editText1, editText2, editText3, editText4, editText5;
    EditText editText12, editText22, editText32, editText42;
    Button buttonSubmit;
    Button buttonSubmit2;
    TextView resultA, resultB, resultC, resultD, resultE,resultF;
    TextView resultA2, resultB2, resultC2, resultD2,resultF2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1);
        // Initialize views
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        resultA = findViewById(R.id.resultA);
        resultB = findViewById(R.id.resultB);
        resultC = findViewById(R.id.resultC);
        resultD = findViewById(R.id.resultD);
        resultE = findViewById(R.id.resultE);
        resultF = findViewById(R.id.resultF);

        editText12 = findViewById(R.id.editText12);
        editText22 = findViewById(R.id.editText22);
        editText32 = findViewById(R.id.editText32);
        editText42 = findViewById(R.id.editText42);
        buttonSubmit2 = findViewById(R.id.buttonSubmit2);
        resultA2 = findViewById(R.id.resultA2);
        resultB2 = findViewById(R.id.resultB2);
        resultC2 = findViewById(R.id.resultC2);
        resultD2 = findViewById(R.id.resultD2);
        resultF2 = findViewById(R.id.resultF2);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditTexts
                String valueA = editText1.getText().toString();
                String valueB = editText2.getText().toString();
                String valueC = editText3.getText().toString();
                String valueD = editText4.getText().toString();
                String valueE = editText5.getText().toString();

                // Convert values to integers and handle invalid input
                try {
                    int a = Integer.parseInt(valueA);
                    int b = Integer.parseInt(valueB);
                    float c = Integer.parseInt(valueC);
                    float d = Integer.parseInt(valueD);
                    float e = Integer.parseInt(valueE);
                    float resultAValue = calc(a);
                    float resultBValue=calc(b);
                    float resultCValue = dec(c);
                    float resultDValue = dec(d);
                    float resultEValue = e*60;
                    float p,q,r,s,t,num,lnv;
                    p=resultAValue;
                    q=resultBValue;
                    r=resultCValue;
                    s=resultDValue;
                    t=resultEValue;
                    num=(r-s)/(q-s);
                    lnv= (float) ((2.303)*Math.log10(num));
                    finalresult=(t/60)/((p-r)+(r-s)*lnv);


                    // Display the results
                    resultA.setText("Result of X1          " + resultAValue);
                    resultB.setText("Result of X2          " + resultBValue);
                    resultC.setText("Result of Xc          " + resultCValue);
                    resultD.setText("Result of Xe          " + resultDValue);
                    resultE.setText("Time in minutes    " + resultEValue);
                    resultF.setText("Value of LS/ANC  " + finalresult);

                    // Make the result TextViews visible
                    resultA.setVisibility(View.VISIBLE);
                    resultB.setVisibility(View.VISIBLE);
                    resultC.setVisibility(View.VISIBLE);
                    resultD.setVisibility(View.VISIBLE);
                    resultE.setVisibility(View.VISIBLE);
                    resultF.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e1) {
                    // Handle invalid input (e.g., non-numeric input)
                    Toast.makeText(Unit1.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueA2 = editText12.getText().toString();
                String valueB2 = editText22.getText().toString();
                String valueC2 = editText32.getText().toString();
                String valueD2 = editText42.getText().toString();

                // Convert values to integers and handle invalid input
                try {
                    int a2 = Integer.parseInt(valueA2);
                    int b2 = Integer.parseInt(valueB2);
                    float c2 = Integer.parseInt(valueC2);
                    float d2 = Integer.parseInt(valueD2);
                    float resultAValue2 = calc(a2);
                    float resultBValue2= calc(b2);
                    float resultCValue2 = dec(c2);
                    float resultDValue2 = dec(d2);
                    float p1,q1,r1,s1,finalresult1,num1,lnv1;
                    p1= resultAValue2;
                    q1=resultBValue2;
                    r1=resultCValue2;
                    s1=resultDValue2;
                    num1=(r1-s1)/(q1-s1);
                    lnv1= (float) ((2.303)*Math.log10(num1));
                    finalresult1=finalresult*(p1-r1)+finalresult*(r1-s1)*lnv1;


                    // Display the results
                    resultA2.setText("Result of X1          " + resultAValue2);
                    resultB2.setText("Result of X2          " + resultBValue2);
                    resultC2.setText("Result of Xc          " + resultCValue2);
                    resultD2.setText("Result of Xe          " + resultDValue2);
                    resultF2.setText("Value of T is   " + finalresult1 + "Hours");

                    // Make the result TextViews visible
                    resultA2.setVisibility(View.VISIBLE);
                    resultB2.setVisibility(View.VISIBLE);
                    resultC2.setVisibility(View.VISIBLE);
                    resultD2.setVisibility(View.VISIBLE);
                    resultF2.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e1) {
                    // Handle invalid input (e.g., non-numeric input)
                    Toast.makeText(Unit1.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private float calc(int x){
        float x11,x12,pump,input;
        x11 = (float) x / 100;
        x12 = 1- x11;
        input = x11/x12;
        pump=(float) Math.round(input * 10000) / 10000;
        return pump;
    }
    private float dec(float y){
        float input2,pop;
        input2= y/100 ;
        pop = (float) Math.round(input2 * 100000000) / 100000000;
        return pop;
    }
}