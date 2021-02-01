package com.example.hmin205tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = findViewById(R.id.mainLayout);

        EditText name = new EditText(this);
        name.setHint(R.string.name);
        mainLayout.addView(name);

        EditText surname = new EditText(this);
        surname.setHint(R.string.surname);
        mainLayout.addView(surname);

        EditText age = new EditText(this);
        age.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
        age.setHint(R.string.age);
        mainLayout.addView(age);

        EditText skills = new EditText(this);
        skills.setHint(R.string.skills);
        mainLayout.addView(skills);

        EditText phone = new EditText(this);
        phone.setInputType(InputType.TYPE_CLASS_PHONE);
        phone.setHint(R.string.phone);
        mainLayout.addView(phone);

        Button validateButton = new Button(this);
        validateButton.setText(R.string.validate_button);
        mainLayout.addView(validateButton);


    }
}
