package com.demo.chemcasio;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowMetrics;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private Button move1, move2, move3, move4, move5, move6, calcu, manule;
    private static String AD_UNIT_ID_BANNER = "ca-app-pub-1880997375774598/2142274187";
    private static String TEST_AD_UNIT_ID_BANNER = "ca-app-pub-3940256099942544/9214589741";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Move MobileAds initialization to onStart() to avoid blocking UI thread
        // Initialization on the main thread directly
        MobileAds.initialize(this, initializationStatus -> {});

        // Load Banner Ad
        loadBanner();

        // Setup Button Click Listeners
        setupButtons();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // You can also initialize ads in onStart() to avoid long delays
    }

    private void setupButtons() {
        manule = findViewById(R.id.manule);
        manule.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        move1 = findViewById(R.id.button_unit1);
        move1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Unit1.class);
            startActivity(intent);
        });

        move2 = findViewById(R.id.button_unit2);
        move2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Unit2.class);
            startActivity(intent);
        });

        move3 = findViewById(R.id.button_unit3);
        move3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Unit3.class);
            startActivity(intent);
        });

        move4 = findViewById(R.id.button_unit4);
        move4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Unit4.class);
            startActivity(intent);
        });

        move5 = findViewById(R.id.button_unit5);
        move5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Unit5.class);
            startActivity(intent);
        });

        move6 = findViewById(R.id.button_unit6);
        move6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Study.class);
            startActivity(intent);
        });

        calcu = findViewById(R.id.button_Molarcalc);
        calcu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MolarCalculator.class);
            startActivity(intent);
        });
    }

    private void loadBanner() {
        AdView adView = new AdView(this);
        adView.setAdUnitId(AD_UNIT_ID_BANNER);
        adView.setAdSize(getAdSize());

        AdView adContainerView = findViewById(R.id.bannerAdView);
        adContainerView.removeAllViews();
        adContainerView.addView(adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int adWidthPixels = displayMetrics.widthPixels;

        // Log for debugging purposes
        Log.d("SDK Version", "API Level: " + Build.VERSION.SDK_INT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For API level 30 (Android 11) and above, use getCurrentWindowMetrics
            WindowMetrics windowMetrics = getWindowManager().getCurrentWindowMetrics();
            adWidthPixels = windowMetrics.getBounds().width();
        } else {
            // For devices with API level below 30, fall back to older methods
            Display display = getWindowManager().getDefaultDisplay();
            android.graphics.Point size = new android.graphics.Point();
            display.getSize(size);
            adWidthPixels = size.x;
        }

        float density = displayMetrics.density;
        int adWidth = (int) (adWidthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
}
