package com.example.tp1exercice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameField, firstNameField, ageField, phoneField;
    private RadioGroup skillRadio;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        firstNameField = findViewById(R.id.firstNameField);
        ageField = findViewById(R.id.ageField);
        skillRadio = findViewById(R.id.skillRadio);
        phoneField = findViewById(R.id.phoneField);
        validateButton = findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";

                text += "Nom : " + fieldValue(nameField) + "\n";
                text += "Prénom : " + fieldValue(firstNameField) + "\n";
                text += "Age : " + fieldValue(ageField) + "\n";
                text += "Domaine de compétence : " + radioValue(skillRadio) + "\n";
                text += "Numéro de téléphone : " + fieldValue(phoneField) + "\n";

                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });

    }

    private String fieldValue(EditText field) {
        return field.getText().toString();
    }

    private String radioValue(RadioGroup radioGroup) {
        int optionId = radioGroup.getCheckedRadioButtonId();

        RadioButton selectedOption = findViewById(optionId);

        if (selectedOption == null) {
            return "";
        }

        return selectedOption.getText().toString();
    }
}
