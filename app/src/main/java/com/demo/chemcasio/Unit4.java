package com.demo.chemcasio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class Unit4 extends AppCompatActivity {
    float Xf, Xm, Xc, f, yield, Yield2;

    EditText editText1, editText2, editText3, editText4;
    EditText editText12;
    Button buttonSubmit;
    Button buttonSubmit2;
    TextView resultA, resultB, resultC, resultD, resultE, resultF, resultAA, resultCC;
    TextView resultF2, resultA2, resultB2, resultC2;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4);

        // Case 1
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        resultA = findViewById(R.id.resultA);
        resultB = findViewById(R.id.resultB);
        resultC = findViewById(R.id.resultC);
        resultD = findViewById(R.id.resultD);
        resultE = findViewById(R.id.resultE);
        resultF = findViewById(R.id.resultF);
        resultAA = findViewById(R.id.resultAA);
        resultCC = findViewById(R.id.resultCC);

        // Case 2
        editText12 = findViewById(R.id.editText12);
        buttonSubmit2 = findViewById(R.id.buttonSubmit2);
        resultA2 = findViewById(R.id.resultA2);
        resultB2 = findViewById(R.id.resultB2);
        resultC2 = findViewById(R.id.resultC2);
        resultF2 = findViewById(R.id.resultF2);

        // PieChart initialization
        pieChart = findViewById(R.id.pieChart);

        // Case 1 - Submit button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditTexts
                String valueA = editText1.getText().toString();
                String valueB = editText2.getText().toString();
                String valueC = editText3.getText().toString();
                String valueD = editText4.getText().toString();

                // Convert values to float and handle invalid input
                try {
                    float a = Float.parseFloat(valueA);
                    float b = Float.parseFloat(valueB);
                    float c = Float.parseFloat(valueC);
                    float d = Float.parseFloat(valueD);

                    // Perform calculations
                    Xf = c / (c + b);
                    Xm = d / (d + b);
                    f = a / Xf;
                    Xc = 1;
                    float M = (f * (Xf - Xc)) / (Xm - Xc);
                    float C = f - M;
                    yield = (C * Xc) / (f * Xf) * 100;

                    // Display results
                    resultAA.setText("Feed in grams: " + a * 1000 + " GRAMS");
                    resultA.setText("Result of XF: " + Xf);
                    resultB.setText("Result of XM: " + Xm);
                    resultC.setText("Feed Value: " + f + " KG");
                    resultCC.setText("Value of Xc (pure as 1)");
                    resultD.setText("M Value: " + M + " KG");
                    resultE.setText("C Value: " + C + " KG");
                    resultF.setText("Calculated Yield: " + yield + " %");

                    // Show the results
                    resultAA.setVisibility(View.VISIBLE);
                    resultA.setVisibility(View.VISIBLE);
                    resultB.setVisibility(View.VISIBLE);
                    resultC.setVisibility(View.VISIBLE);
                    resultCC.setVisibility(View.VISIBLE);
                    resultD.setVisibility(View.VISIBLE);
                    resultE.setVisibility(View.VISIBLE);
                    resultF.setVisibility(View.VISIBLE);

                    // Generate the pie chart with yield and Yield2
                    generatePieChart(yield, Yield2);
                } catch (NumberFormatException e1) {
                    // Handle invalid input
                    Toast.makeText(Unit4.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Case 2 - Submit button click listener
        buttonSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueA2 = editText12.getText().toString();

                // Convert value to float and handle invalid input
                try {
                    float a2 = Float.parseFloat(valueA2);
                    float E = (a2 / 100) * f;
                    float M1 = ((f * (Xf - Xc)) + (E * Xc)) / (Xm - Xc);
                    float C1 = f - E - M1;
                    Yield2 = (C1 * Xc) / (f * Xf) * 100;

                    // Display results
                    resultA2.setText("Calculated E value: " + E);
                    resultB2.setText("Calculated M value: " + M1);
                    resultC2.setText("Calculated C value: " + C1);
                    resultF2.setText("Crystal Yield2: " + Yield2 + " %");

                    // Show the results
                    resultA2.setVisibility(View.VISIBLE);
                    resultB2.setVisibility(View.VISIBLE);
                    resultC2.setVisibility(View.VISIBLE);
                    resultF2.setVisibility(View.VISIBLE);

                    // Generate the pie chart with yield and Yield2
                    generatePieChart(yield, Yield2);
                } catch (NumberFormatException e1) {
                    // Handle invalid input
                    Toast.makeText(Unit4.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void generatePieChart(float yield, float Yield2) {
        // Prepare PieChart data
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(yield, "Yield"));
        pieEntries.add(new PieEntry(Yield2, "Yield2"));

        // Create PieDataSet
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Calculated Yields");
        pieDataSet.setColors(new int[] { getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_orange_light) });

        // Create PieData and set it on PieChart
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate(); // Refresh the chart
    }
}
