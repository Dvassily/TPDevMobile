package com.example.tp1exercice3java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameField, firstNameField, ageField, phoneField;
    private RadioGroup skillRadio;
    private Button validateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout rootLayout = new ConstraintLayout(this);
        rootLayout.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView nameLabel = new TextView(this);
        nameLabel.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameLabel.setEms(10);
        nameLabel.setText(R.string.name_label);

        nameField = new EditText(this);
        nameField.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameField.setEms(10);
        nameField.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        nameField.setHint(R.string.name_hint);

        TextView firstNameLabel = new TextView(this);
        firstNameLabel.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        firstNameLabel.setEms(10);
        firstNameLabel.setText(R.string.first_name_label);

        firstNameField = new EditText(this);
        firstNameField.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        firstNameField.setEms(10);
        firstNameField.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        firstNameField.setHint(R.string.first_name_hint);

        TextView ageLabel = new TextView(this);
        ageLabel.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ageLabel.setEms(10);
        ageLabel.setText(R.string.first_name_label);

        ageField = new EditText(this);
        ageField.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ageField.setEms(10);
        ageField.setInputType(InputType.TYPE_CLASS_NUMBER);
        ageField.setHint(R.string.age_hint);

        skillRadio = new RadioGroup(this);

        TextView skillLabel = new TextView(this);
        skillLabel.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        skillLabel.setEms(10);
        skillLabel.setText(R.string.skill_label);

        RadioButton cOption = new RadioButton(this);
        cOption.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        cOption.setText("C");

        RadioButton cppOption = new RadioButton(this);
        cppOption.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        cppOption.setText("C++");

        RadioButton javaOption = new RadioButton(this);
        javaOption.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        javaOption.setText("Java");

        skillRadio.addView(skillLabel);
        skillRadio.addView(cOption);
        skillRadio.addView(cppOption);
        skillRadio.addView(javaOption);

        TextView phoneLabel = new TextView(this);
        phoneLabel.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        phoneLabel.setEms(10);
        phoneLabel.setText(R.string.phone_label);

        phoneField = new EditText(this);
        phoneField.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        phoneField.setEms(10);
        phoneField.setInputType(InputType.TYPE_CLASS_PHONE);
        phoneField.setHint(R.string.phone_hint);

        validateButton = new Button(this);
        validateButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        validateButton.setText(R.string.validate_btn_text);
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

        linearLayout.addView(nameLabel);
        linearLayout.addView(nameField);
        linearLayout.addView(firstNameLabel);
        linearLayout.addView(firstNameField);
        linearLayout.addView(ageLabel);
        linearLayout.addView(ageField);
        linearLayout.addView(skillRadio);
        linearLayout.addView(phoneLabel);
        linearLayout.addView(phoneField);
        linearLayout.addView(validateButton);

        rootLayout.addView(linearLayout);

        setContentView(rootLayout);
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
