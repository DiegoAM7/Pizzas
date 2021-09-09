package com.mao.pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        btnList = findViewById(R.id.btnList);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPizza(view);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPizza(view);
            }
        });
    }

    private void createPizza(View view) {
        Intent intent = new Intent(this, CreatePizzaActivity.class);
        startActivity(intent);
    }

    private void listPizza(View view) {
        Intent intent = new Intent(this, ListPizzaActivity.class);
        startActivity(intent);
    }
}
