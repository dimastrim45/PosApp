package com.example.androidqu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidqu.R;

import java.net.URI;

public class dashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void kategori(View v) {
        startActivity(new Intent(dashboardActivity.this, kategoriActivity.class));
    }

    public void pos(View v) {
        startActivity(new Intent(dashboardActivity.this, PosActivity.class));
    }

    public void contactUs(View v) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:085155058869"));
            startActivity(callIntent);
        } catch (ActivityNotFoundException activityException){
            Log.e("Calling a Phone Number", "Call failed", activityException);
        }

    }
}