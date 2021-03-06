package com.example.hmin205tp1;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmPopUp extends Dialog {

    private String title;
    private Button confirmButton;
    private Button cancelButton;
    private TextView titleView;

    public ConfirmPopUp(Activity activity){
        super(activity, R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.confirm_pop_up_template);
        this.title = "Titre";
        this.confirmButton = findViewById(R.id.btnValider);
        this.cancelButton = findViewById(R.id.btnAnnuler);
        this.titleView = findViewById(R.id.title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }


    public void build(){
        show();
        titleView.setText(title);
        titleView.setTextSize(25);
    }
}