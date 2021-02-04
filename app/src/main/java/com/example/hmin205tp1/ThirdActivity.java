package com.example.hmin205tp1;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    final static int CALL_REQUEST_CODE = 1;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
       phone = getIntent().getStringExtra(getString(R.string.phone));

        final Activity activity = this;
        Button callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int callPermission = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
                if (callPermission != PackageManager.PERMISSION_GRANTED) {
                    activity.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
                }
                else{
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode== CALL_REQUEST_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
            }  else {
                Toast.makeText(getApplicationContext(), getString(R.string.permission), Toast.LENGTH_SHORT).show();
            }
        }
    }
}