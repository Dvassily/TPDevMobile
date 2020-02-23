package com.example.tp1exercice5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Validation")
                        .setMessage("Confirmez-vous les informations saisies?")
                        .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String text = "";

                                text += "Nom : " + fieldValue(nameField) + "\n";
                                text += "Prénom : " + fieldValue(firstNameField) + "\n";
                                text += "Age : " + fieldValue(ageField) + "\n";
                                text += "Domaine de compétence : " + radioValue(skillRadio) + "\n";
                                text += "Numéro de téléphone : " + fieldValue(phoneField) + "\n";

                                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Does nothing
                            }
                        })
                        .setNeutralButton("Effacer les champs", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                nameField.setText("");
                                firstNameField.setText("");
                                ageField.setText("");
                                skillRadio.clearCheck();
                                phoneField.setText("");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

    }

    private String fieldValue(EditText field) {
        return field.getText().toString();
    }

    private String radioValue(RadioGroup radioGroup) {
        int optionId = radioGroup.getCheckedRadioButtonId();

        RadioButton selectedOption = findViewById(optionId);

        return selectedOption.getText().toString();
    }
}
