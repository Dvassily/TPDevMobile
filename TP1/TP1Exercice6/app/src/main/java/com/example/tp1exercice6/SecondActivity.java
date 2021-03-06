package com.example.tp1exercice6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tp1exercice6.MainActivity.EXTRA_NAME;
import static com.example.tp1exercice6.MainActivity.EXTRA_FIRST_NAME;
import static com.example.tp1exercice6.MainActivity.EXTRA_AGE;
import static com.example.tp1exercice6.MainActivity.EXTRA_SKILL;
import static com.example.tp1exercice6.MainActivity.EXTRA_PHONE;

public class SecondActivity extends AppCompatActivity {
    private TextView nameValue, firstNameValue, ageValue, skillValue, phoneValue;
    private Button okButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameValue = findViewById(R.id.nameValue);
        firstNameValue = findViewById(R.id.firstNameValue);
        ageValue = findViewById(R.id.ageValue);
        skillValue = findViewById(R.id.skillValue);
        phoneValue = findViewById(R.id.phoneValue);
        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.backButton);

        Intent intent = getIntent();
        nameValue.setText(intent.getStringExtra(EXTRA_NAME));
        firstNameValue.setText(intent.getStringExtra(EXTRA_FIRST_NAME));
        ageValue.setText(intent.getStringExtra(EXTRA_AGE));
        skillValue.setText(intent.getStringExtra(EXTRA_SKILL));
        phoneValue.setText(intent.getStringExtra(EXTRA_PHONE));

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
