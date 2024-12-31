package com.demo.chemcasio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Study extends AppCompatActivity {
    // Define your links
    private final String link1 = "https://drive.google.com/file/d/1Dzs4Ep1MuqW-u2ni8oWeInONXcVn9hPr/view?usp=drivesdk";
    private final String link2 = "https://drive.google.com/file/d/1E-NaIY1QrVjOlg9XoYBePBC7Pf0kkQb_/view?usp=drivesdk";
    private final String link3 = "https://drive.google.com/file/d/1EPdtb0YIiLTPPs4XraL1tlliqsfpsP5W/view?usp=drivesdk";
    private final String link4 = "https://drive.google.com/file/d/1EQQM4CpKKFSO8tFkvo9CkLv3yquU6hfy/view?usp=drivesdk";
    private final String link5 = "https://drive.google.com/file/d/1ERO4Q2Y1qe2IvMgnecbCfjlRjzZjsryi/view?usp=drivesdk";
    private final String link6 = "https://drive.google.com/file/d/1ERwBlK6-E7eAKtVaztD5OtTvJbqcdC1C/view?usp=drivesdk";
    private final String link7 = "https://drive.google.com/file/d/1EWbAgYVFm9FJrvWNW9oL8clnMUO57fJL/view?usp=drivesdk";
    private final String link8 = "https://drive.google.com/file/d/1El4aiOyuQfN3KNe2PY7KIUCyhQfbvL3F/view?usp=drivesdk";
    private final String link9 = "https://drive.google.com/file/d/1EuS2pJzFYiUaLviXnGCDforwc5U4U9QM/view?usp=drivesdk";
    private final String link10 = "https://drive.google.com/file/d/1F9Ka6ONqvFDLlVCfTNUaPDszBlSuhBsx/view?usp=drivesdk";
    private final String link11 = "https://drive.google.com/file/d/1G1U8l-3DoVcxQcIrJb4JOyOC9FRmUZrx/view?usp=drivesdk";
    private final String link12 = "https://drive.google.com/file/d/1G7LX2fXvNHuGqka7GZVnzvtWkvTNmdLV/view?usp=drivesdk";
    private final String link13 = "https://drive.google.com/file/d/1GEix9JAPRCgz2caDUAAETnZywKUD6hR-/view?usp=drivesdk";
    private final String link14 = "https://drive.google.com/file/d/1Ggid45iqXT2TWKZUDKxxuOGgZxlQRq9f/view?usp=drivesdk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
    }

    // Method to open Link 1 in a browser
    public void openLink1(View view) {
        openLink(link1);
    }

    // Method to open Link 2 in a browser
    public void openLink2(View view) {
        openLink(link2);
    }

    // Method to open Link 3 in a browser
    public void openLink3(View view) {
        openLink(link3);
    }
    public void openLink4(View view) {
        openLink(link4);
    }
    public void openLink5(View view) {
        openLink(link5);
    }
    public void openLink6(View view) {
        openLink(link6);
    }
    public void openLink7(View view) {
        openLink(link7);
    }
    public void openLink8(View view) {
        openLink(link8);
    }
    public void openLink9(View view) {
        openLink(link9);
    }
    public void openLink10(View view) {
        openLink(link10);
    }
    public void openLink11(View view) {
        openLink(link11);
    }
    public void openLink12(View view) {
        openLink(link12);
    }
    public void openLink13(View view) {
        openLink(link13);
    }
    public void openLink14(View view) {
        openLink(link14);
    }

    // Helper method to open the link in a browser
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}