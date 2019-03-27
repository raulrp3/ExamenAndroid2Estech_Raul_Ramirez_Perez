package com.example.examen_android;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputName,inputAge,inputDescription;
    private TextInputLayout inputLayoutName,inputLayoutAge,inputLayoutDescription;
    private Button buttonAdd;

    private List<Enemy> enemies;
    private RecyclerView rv;
    private RVadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initAdapter();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (submit()){
                   Toast.makeText(v.getContext(),"Añadiendo enemigo",Toast.LENGTH_SHORT).show();
                   String name = inputName.getText().toString().trim();
                   String age = inputAge.getText().toString().trim();
                   String description = inputDescription.getText().toString().trim();

                   Enemy enemy = new Enemy(name,age,description);
                   enemies.add(enemy);
                   adapter.notifyDataSetChanged();
               }
            }
        });
    }

    private void initUI(){
        inputName = findViewById(R.id.input_name);
        inputAge = findViewById(R.id.input_age);
        inputDescription = findViewById(R.id.input_description);
        inputLayoutName = findViewById(R.id.input_layout_name);
        inputLayoutAge = findViewById(R.id.input_layout_age);
        inputLayoutDescription = findViewById(R.id.input_layout_description);
        buttonAdd = findViewById(R.id.button_add);

        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        enemies = new ArrayList<>();
    }

    private void initAdapter(){
        adapter = new RVadapter(enemies, MainActivity.this, new CustomItemClick() {
            @Override
            public void onClick(View view, int index) {
                Intent intent = new Intent(MainActivity.this,CardActivity.class);
                String name = enemies.get(index).getName();
                String age = enemies.get(index).getAge();
                String description = enemies.get(index).getDescription();
                intent.putExtra("Name",name);
                intent.putExtra("Age",age);
                intent.putExtra("Description",description);
                startActivity(intent);
            }
        });

        rv.setAdapter(adapter);
    }

    private boolean submit(){
        if (!validateName()){
            Toast.makeText(this,"¡Tienes errores!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!validateAge()){
            Toast.makeText(this, "¡Tienes errores!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validateName(){
        String name = inputName.getText().toString().trim();
        if (name.isEmpty()){
            inputLayoutName.setError(getString(R.string.error_name));
            return false;
        }else{
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAge(){
        int age = Integer.valueOf(inputAge.getText().toString().trim());
        if (age < 0 || age > 150){
            inputLayoutAge.setError(getString(R.string.error_age));
            return false;
        }else{
            inputLayoutAge.setErrorEnabled(false);
        }

        return true;
    }
}
