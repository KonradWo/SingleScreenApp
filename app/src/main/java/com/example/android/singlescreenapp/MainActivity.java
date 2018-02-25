package com.example.android.singlescreenapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openGoogleMap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:50.8076198,19.13241579999999");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void dialPhoneNumber(View view) {
        TextView companyPhoneNumber = (TextView) findViewById(R.id.company_phone_number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + companyPhoneNumber.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openUrl(View view) {
        TextView companyUrl = (TextView) findViewById(R.id.company_www);
        Uri companyUri = Uri.parse("http://" + companyUrl.getText().toString() + "/klub/calypso-fitness-czestochowa-galeria-jurajska/");
        Intent intent = new Intent(Intent.ACTION_VIEW, companyUri);
        startActivity(intent);
    }
}
