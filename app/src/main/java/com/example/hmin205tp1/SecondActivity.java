package com.example.hmin205tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String age = intent.getStringExtra(getString(R.string.age));
        String name = intent.getStringExtra(getString(R.string.name));
        String surname = intent.getStringExtra(getString(R.string.surname));
        String skills = intent.getStringExtra(getString(R.string.skills));
        final String phone = intent.getStringExtra(getString(R.string.phone));

        ((TextView) findViewById(R.id.nameZone)).setText(name);
        ((TextView) findViewById(R.id.surnameZone)).setText(surname);
        ((TextView) findViewById(R.id.ageZone)).setText(age);
        ((TextView) findViewById(R.id.skillZone)).setText(skills);
        ((TextView) findViewById(R.id.phoneZone)).setText(phone);

        Button validateButton = findViewById(R.id.validateButton2);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra(getString(R.string.phone),phone);
                startActivity(intent);
            }
        });

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}