package com.mao.pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnList;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        btnList = findViewById(R.id.btnList);
        imgView = findViewById(R.id.imgView);

        imgView.setBackgroundResource(R.drawable.pizza);
        AnimationDrawable animation = (AnimationDrawable) imgView.getBackground();
        animation.run();

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
        if (Data.getInstance().getArrayList().size() <= 0) {
            Toast.makeText(this, "No hay pizzas aún", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, ListPizzaActivity.class);
        startActivity(intent);
    }
}
