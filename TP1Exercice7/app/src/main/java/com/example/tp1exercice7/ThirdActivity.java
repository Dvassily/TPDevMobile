package com.example.tp1exercice7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        TextView phoneTextView = findViewById(R.id.phoneValue2);
        Intent intent = getIntent();
        phoneNumber = getIntent().getStringExtra(SecondActivity.EXTRA_PHONE);
        phoneTextView.setText(phoneNumber);

        Button callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phoneNumber, null));
                if (ContextCompat.checkSelfPermission(ThirdActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ThirdActivity.this, new String[]{ Manifest.permission.CALL_PHONE}, 0);
                }

                startActivity(intent);
            }
        });
    }
}
