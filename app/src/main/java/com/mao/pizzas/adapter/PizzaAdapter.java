package com.mao.pizzas.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.mao.pizzas.R;
import com.mao.pizzas.model.Pizza;

import java.util.ArrayList;
import java.util.Arrays;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {
  ArrayList<Pizza> pizzaArrayList;

  // Constructor
  public PizzaAdapter(ArrayList<Pizza> pizzaArrayList) {
    this.pizzaArrayList = pizzaArrayList;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView txtName, txtPrincipal, txtBase, txtIngredients, txtCondiments, txtCost;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      txtName = itemView.findViewById(R.id.txtName);
      txtPrincipal = itemView.findViewById(R.id.txtPrincipal);
      txtBase = itemView.findViewById(R.id.txtBase);
      txtIngredients = itemView.findViewById(R.id.txtIngredients);
      txtCondiments = itemView.findViewById(R.id.txtCondiments);
      txtCost = itemView.findViewById(R.id.txtCost);
    }

    public void chargeData(Pizza pizza) {
      txtName.setText(pizza.getName());
      txtPrincipal.setText(pizza.getPrincipal());
      txtBase.setText(pizza.getBase());
      txtIngredients.setText(pizza.getIngredients());
      txtCondiments.setText(pizza.getCondiments());
      txtCost.setText(String.valueOf(pizza.getCost()));
    }
  }

  @NonNull
  @Override
  public PizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull PizzaAdapter.ViewHolder holder, int position) {
    holder.chargeData(pizzaArrayList.get(position));
  }

  @Override
  public int getItemCount() {
    return pizzaArrayList.size();
  }
}
