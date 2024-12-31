package com.demo.chemcasio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Unit5 extends AppCompatActivity {

    EditText editText1, editText2, editText3,editText4,editText5,editText6;
    Button buttonSubmit;
    TextView resultA, resultB,resultC,resultD,resultE,resultF,resultG,resultH,resultI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5);
        // case 1
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        editText6 = findViewById(R.id.editText6);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        resultA = findViewById(R.id.resultA);
        resultB = findViewById(R.id.resultB);
        resultC = findViewById(R.id.resultC);
        resultD = findViewById(R.id.resultD);
        resultE = findViewById(R.id.resultE);
        resultF = findViewById(R.id.resultF);
        resultG = findViewById(R.id.resultG);
        resultH = findViewById(R.id.resultH);
        resultI = findViewById(R.id.resultI);

        //case 1

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditTexts
                String valueA = editText1.getText().toString();
                String valueB = editText2.getText().toString();
                String valueC = editText3.getText().toString();
                String valueD = editText4.getText().toString();
                String valueE = editText5.getText().toString();
                String valueF = editText6.getText().toString();

                // Convert values to integers and handle invalid input
                try {
                    float a = Float.parseFloat(valueA);
                    float b = Float.parseFloat(valueB);
                    float c = Float.parseFloat(valueC);
                    float d = Float.parseFloat(valueD);
                    float e = Float.parseFloat(valueE);
                    float f1 = Float.parseFloat(valueF);
                    float X1 = a*1000;
                    float Xf = b/100;
                    float E = 0;
                    float Xc= (c/d);
                    float Xm=e/(e+f1);
                    float C=(((a*(Xf-Xm)))/(Xc-Xm));
                    float M=(a-C);

                    float yield= (float) (((C*Xc)/(a*Xf)) * 100);


                    // Display the results
                    resultA.setText("Feed in grams       " + X1 + "  GRAMS");
                    resultB.setText("Result of XF          " + Xf );
                    resultC.setText("Value of E              :" + E);
                    resultD.setText("Molecular weight  :" + c + "g/mole");
                    resultE.setText("Value of Xc            :" + Xc);
                    resultF.setText("Value of Xm           :" + Xm);
                    resultG.setText("M Value                 " + M +"KG");
                    resultH.setText("C Value                  :" + C +"KG");
                    resultI.setText("Calculated Yield is " + yield +" %");

                    // Make the result TextViews visible
                    resultA.setVisibility(View.VISIBLE);
                    resultB.setVisibility(View.VISIBLE);
                    resultC.setVisibility(View.VISIBLE);
                    resultD.setVisibility(View.VISIBLE);
                    resultE.setVisibility(View.VISIBLE);
                    resultF.setVisibility(View.VISIBLE);
                    resultG.setVisibility(View.VISIBLE);
                    resultH.setVisibility(View.VISIBLE);
                    resultI.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e1) {
                    // Handle invalid input (e.g., non-numeric input)
                    Toast.makeText(Unit5.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}