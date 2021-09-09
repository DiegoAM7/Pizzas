package com.mao.pizzas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mao.pizzas.adapter.PizzaAdapter;
import com.mao.pizzas.model.Pizza;

import java.util.ArrayList;

public class ListPizzaActivity extends AppCompatActivity {
    RecyclerView recyclerPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        recyclerPizza = findViewById(R.id.recyclerPizza);

        ArrayList<Pizza> pizzaArrayList = Data.getInstance().getArrayList();

        recyclerPizza.setLayoutManager(new LinearLayoutManager(this));
        PizzaAdapter adapter = new PizzaAdapter(pizzaArrayList);
        recyclerPizza.setAdapter(adapter);
    }
}
