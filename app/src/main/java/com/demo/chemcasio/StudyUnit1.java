package com.demo.chemcasio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import com.github.barteksc.pdfviewer.PDFView;

public class StudyUnit1 extends AppCompatActivity {

    //PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_unit1);

        // Initialize PDFView
        //pdfView = findViewById(R.id.pdfView);

        // Load PDF from assets
        //pdfView.fromAsset("esp32.pdf").load();
    }
}
