package com.example.examen_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {

    private TextView inputName,inputAge,inputDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        initUI();

        initData();
    }

    private void initUI(){
        inputName = findViewById(R.id.card_name);
        inputAge = findViewById(R.id.card_age);
        inputDescription = findViewById(R.id.card_description);
    }

    private void initData(){
        Intent intent = getIntent();
        inputName.setText(intent.getStringExtra("Name"));
        inputAge.setText(intent.getStringExtra("Age"));
        inputDescription.setText(intent.getStringExtra("Description"));
    }
}
