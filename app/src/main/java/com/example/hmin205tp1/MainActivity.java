package com.example.hmin205tp1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity activity = this;
        Button validateButton = findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String age = ((EditText) findViewById(R.id.ageEditText)).getText().toString();
               final String name =((EditText) findViewById(R.id.nameEditText)).getText().toString();
               final String surname =((EditText) findViewById(R.id.surnameEditText)).getText().toString();
               final String skills =((EditText) findViewById(R.id.skillEditText)).getText().toString();
               final String phone =((EditText) findViewById(R.id.phoneEditText)).getText().toString();

                if (age.equals("") || name.equals("") || surname.equals("") || skills.equals("") || phone.equals("")){
                    Toast.makeText(getApplicationContext(),getString(R.string.complete), Toast.LENGTH_SHORT).show();
                    return;
                }

                final ConfirmPopUp confirmPopUp = new ConfirmPopUp(activity);
                confirmPopUp.setTitle(getString(R.string.validate) + " ?");
                confirmPopUp.getConfirmButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        intent.putExtra(getString(R.string.age),age);
                        intent.putExtra(getString(R.string.name),name);
                        intent.putExtra(getString(R.string.surname),surname);
                        intent.putExtra(getString(R.string.skills),skills);
                        intent.putExtra(getString(R.string.phone),phone);
                        startActivity(intent);
                        confirmPopUp.dismiss();
                    }
                });
                confirmPopUp.getCancelButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        confirmPopUp.dismiss();
                    }
                });
                confirmPopUp.build();
            }
        });

    }
}
