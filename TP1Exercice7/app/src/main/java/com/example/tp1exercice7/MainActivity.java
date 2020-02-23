package com.example.tp1exercice7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.tp1exercice7.NAME";
    public static final String EXTRA_FIRST_NAME = "com.example.tp1exercice7.FIRST_NAME";
    public static final String EXTRA_AGE = "com.example.tp1exercice7.AGE";
    public static final String EXTRA_SKILL = "com.example.tp1exercice7.SKILL";
    public static final String EXTRA_PHONE = "com.example.tp1exercice7.PHONE";

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
                                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                System.out.println(fieldValue(nameField));
                                intent.putExtra(EXTRA_NAME, fieldValue(nameField));
                                intent.putExtra(EXTRA_FIRST_NAME, fieldValue(firstNameField));
                                intent.putExtra(EXTRA_AGE, fieldValue(ageField));
                                intent.putExtra(EXTRA_SKILL, radioValue(skillRadio));
                                intent.putExtra(EXTRA_PHONE, fieldValue(phoneField));
                                startActivity(intent);
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

        if (selectedOption == null) {
            return "";
        }

        return selectedOption.getText().toString();
    }
}
