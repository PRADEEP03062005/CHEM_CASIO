package com.demo.chemcasio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unit2 extends AppCompatActivity {
    private static final Map<String, Double> elemWeight = new HashMap<>();


    static {
        elemWeight.put("H", 1.008);
        elemWeight.put("He", 4.0026);
        elemWeight.put("Li", 6.94);
        elemWeight.put("Be", 9.0122);
        elemWeight.put("B", 10.81);
        elemWeight.put("C", 12.011);
        elemWeight.put("N", 14.007);
        elemWeight.put("O", 15.999);
        elemWeight.put("F", 18.998);
        elemWeight.put("Ne", 20.180);
        elemWeight.put("Na", 22.990);
        elemWeight.put("Mg", 24.305);
        elemWeight.put("Al", 26.982);
        elemWeight.put("Si", 28.085);
        elemWeight.put("P", 30.974);
        elemWeight.put("S", 32.06);
        elemWeight.put("Cl", 35.45);
        elemWeight.put("K", 39.098);
        elemWeight.put("Ar", 39.948);
        elemWeight.put("Ca", 40.078);
        elemWeight.put("Sc", 44.956);
        elemWeight.put("Ti", 47.867);
        elemWeight.put("V", 50.942);
        elemWeight.put("Cr", 52.0);
        elemWeight.put("Mn", 54.938);
        elemWeight.put("Fe", 55.845);
        elemWeight.put("Ni", 58.693);
        elemWeight.put("Cu", 63.546);
        elemWeight.put("Zn", 65.38);
        elemWeight.put("Ga", 69.723);
        elemWeight.put("Ge", 72.63);
        elemWeight.put("As", 74.922);
        elemWeight.put("Se", 78.971);
        elemWeight.put("Br", 79.904);
        elemWeight.put("Kr", 83.798);
        elemWeight.put("Rb", 85.468);
        elemWeight.put("Sr", 87.62);
        elemWeight.put("Y", 88.906);
        elemWeight.put("Zr", 91.224);
        elemWeight.put("Nb", 92.906);
        elemWeight.put("Mo", 95.95);
        elemWeight.put("Tc", 98.0);
        elemWeight.put("Ru", 101.07);
        elemWeight.put("Rh", 102.905);
        elemWeight.put("Pd", 106.42);
        elemWeight.put("Ag", 107.868);
        elemWeight.put("Cd", 112.414);
        elemWeight.put("In", 114.818);
        elemWeight.put("Sn", 118.71);
        elemWeight.put("Sb", 121.76);
        elemWeight.put("I", 126.904);
        elemWeight.put("Te", 127.60);
        elemWeight.put("Xe", 131.293);
        elemWeight.put("Cs", 132.905);
        elemWeight.put("Ba", 137.327);
        elemWeight.put("La", 138.905);
        elemWeight.put("Ce", 140.116);
        elemWeight.put("Pr", 140.907);
        elemWeight.put("Nd", 144.242);
        elemWeight.put("Pm", 145.0);
        elemWeight.put("Sm", 150.36);
        elemWeight.put("Eu", 152.0);
        elemWeight.put("Gd", 157.25);
        elemWeight.put("Tb", 158.925);
        elemWeight.put("Dy", 162.5);
        elemWeight.put("Ho", 164.930);
        elemWeight.put("Er", 167.259);
        elemWeight.put("Tm", 168.934);
        elemWeight.put("Yb", 173.04);
        elemWeight.put("Lu", 175.0);
        elemWeight.put("Hf", 178.49);
        elemWeight.put("Ta", 180.948);
        elemWeight.put("W", 183.84);
        elemWeight.put("Re", 186.207);
        elemWeight.put("Os", 190.23);
        elemWeight.put("Ir", 192.217);
        elemWeight.put("Pt", 195.085);
        elemWeight.put("Au", 196.967);
        elemWeight.put("Hg", 200.592);
        elemWeight.put("Tl", 204.38);
        elemWeight.put("Pb", 207.2);
        elemWeight.put("Bi", 208.980);
        elemWeight.put("Po", 209.0);
        elemWeight.put("At", 210.0);
        elemWeight.put("Rn", 222.0);
        elemWeight.put("Fr", 223.0);
        elemWeight.put("Ra", 226.0);
        elemWeight.put("Ac", 227.0);
        elemWeight.put("Th", 232.038);
        elemWeight.put("Pa", 231.035);
        elemWeight.put("U", 238.029);
        elemWeight.put("Np", 237.0);
        elemWeight.put("Pu", 244.0);
        elemWeight.put("Am", 243.0);
        elemWeight.put("Cm", 247.0);
        elemWeight.put("Bk", 247.0);
        elemWeight.put("Cf", 251.0);
        elemWeight.put("Es", 252.0);
        elemWeight.put("Fm", 257.0);
        elemWeight.put("Md", 258.0);
        elemWeight.put("No", 259.0);
        elemWeight.put("Lr", 262.0);
        elemWeight.put("Rf", 267.0);
        elemWeight.put("Db", 270.0);
        elemWeight.put("Sg", 271.0);
        elemWeight.put("Bh", 270.0);
        elemWeight.put("Hs", 277.0);
        elemWeight.put("Mt", 276.0);
        elemWeight.put("Ds", 281.0);
        elemWeight.put("Rg", 280.0);
        elemWeight.put("Cn", 285.0);
        elemWeight.put("Uut", 284.0);
        elemWeight.put("Fl", 289.0);
        elemWeight.put("Uup", 288.0);
        elemWeight.put("Uuh", 293.0);
        elemWeight.put("Uus", 294.0);
        elemWeight.put("Uuo", 294.0);
    }

    EditText editText1, editText2, editText3,editText4,editText5,editText6,formulaInput;
    Button buttonSubmit;
    TextView resultA, resultB,resultC,resultD,resultE,resultF,resultG,resultH,resultI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2);
        // case 1
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        formulaInput = findViewById(R.id.formulaInput);

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
                String formula = formulaInput.getText().toString().trim();

                // Convert values to integers and handle invalid input
                try {
                    float a = Float.parseFloat(valueA);
                    float b = Float.parseFloat(valueB);
                    float c = Float.parseFloat(valueC);
                    float d = Float.parseFloat(valueD);
                    float e = Float.parseFloat(valueE);
                    float f1 = Float.parseFloat(valueF);
                    double totalWeight = calculateMolecularWeight(formula);
                    float X1 = a*1000;
                    float Xf = b/100;
                    float E = (c/100)*a;
                    double Xc= (float) (totalWeight/(totalWeight+(d*18.015)));
                    float Xm=e/(e+f1);
                    double M= (float) (((a*(Xf-Xc)+(E*Xc)))/(Xm-Xc));
                    float C= (float) (a-M-E);

                    float yield= (float) (((C*Xc)/(a*Xf)) * 100);


                    // Display the results
                    resultA.setText("Feed in grams       " + X1 + "  GRAMS");
                    resultB.setText("Result of XF          " + Xf );
                    resultC.setText("Value of E              :" + E + "KG");
                    resultD.setText("Molecular weight  :" + totalWeight + "g/mole");
                    resultE.setText("Value of Xc            :" + Xc);
                    resultF.setText("Value of Xm           :" + Xm);
                    resultG.setText("M Value                 " + M + "KG");
                    resultH.setText("C Value                  :" + C + "KG");
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
                    Toast.makeText(Unit2.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public static double calculateMolecularWeight(String formula) {
        Pattern pattern = Pattern.compile("([A-Z][a-z]?)([0-9]*)");
        Matcher matcher = pattern.matcher(formula);

        double totalWeight = 0.0;
        while (matcher.find()) {
            String element = matcher.group(1);
            String countStr = matcher.group(2);
            int count = countStr.isEmpty() ? 1 : Integer.parseInt(countStr);
            totalWeight += count * elemWeight.getOrDefault(element, 0.0);
        }
        return totalWeight;
    }
}