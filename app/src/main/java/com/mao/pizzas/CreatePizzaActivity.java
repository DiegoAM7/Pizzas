package com.mao.pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mao.pizzas.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class CreatePizzaActivity extends AppCompatActivity {
  Button btnSave;
  EditText name;
  RadioGroup principal, base;
  CheckBox cboxOnion,
      cboxMushroom,
      cboxBellPepper,
      cboxTomato,
      cboxCherryTomato,
      cboxAvocado,
      cboxGarlic,
      cboxBasil,
      cboxOregano;

  // Otras
  Double cost = 0.0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_pizza);

    btnSave = findViewById(R.id.btnSave);
    name = findViewById(R.id.etxtName);
    principal = findViewById(R.id.rgPrincipal);
    base = findViewById(R.id.rgBase);
    cboxOnion = findViewById(R.id.cboxOnion);
    cboxMushroom = findViewById(R.id.cboxMushroom);
    cboxBellPepper = findViewById(R.id.cboxBellPeeper);
    cboxTomato = findViewById(R.id.cboxTomato);
    cboxCherryTomato = findViewById(R.id.cboxCherryTomato);
    cboxAvocado = findViewById(R.id.cboxAvocado);
    cboxGarlic = findViewById(R.id.cboxGarlic);
    cboxBasil = findViewById(R.id.cboxBasil);
    cboxOregano = findViewById(R.id.cboxOregano);

    btnSave.setOnClickListener(this::savePizza);
  }

  public void savePizza(View view) {
    cost = 0.0;
    String name = getName();
    String principal = getPrincipal();
    String base = getBase();
    String[] ingredients = getIngredients();
    String[] condiments = getCondiments();

    Pizza p1 = new Pizza(name, principal, base, ingredients, condiments, cost);

    Data.getInstance().getArrayList().add(p1);

    Toast.makeText(this, "Pizza Creada!", Toast.LENGTH_LONG).show();

    finish();
  }

  public String getName() {
    return name.getText().toString();
  }

  public String getPrincipal() {
    int idPrincipal = principal.getCheckedRadioButtonId();
    RadioButton rbtn = findViewById(idPrincipal);
    String principal = rbtn.getText().toString();

    switch (principal) {
      case "Carne":
      case "Meat":
      case "Pollo":
      case "Chicken":
        cost += 1500;
        break;
      case "Ambos":
      case "Both":
        cost += 2000;
        break;
    }

    return principal;
  }

  public String getBase() {
    int idBase = base.getCheckedRadioButtonId();
    RadioButton rbtn = findViewById(idBase);
    String base = rbtn.getText().toString();

    cost += 500;

    return base;
  }

  public String[] getIngredients() {
    List<String> mString = new ArrayList<>();

    if (cboxOnion.isChecked()) {
      mString.add(cboxOnion.getText().toString());
      cost += 1000;
    }

    if (cboxMushroom.isChecked()) {
      mString.add(cboxMushroom.getText().toString());
      cost += 1000;
    }

    if (cboxBellPepper.isChecked()) {
      mString.add(cboxBellPepper.getText().toString());
      cost += 1000;
    }

    if (cboxTomato.isChecked()) {
      mString.add(cboxTomato.getText().toString());
      cost += 1000;
    }

    if (cboxCherryTomato.isChecked()) {
      mString.add(cboxCherryTomato.getText().toString());
      cost += 1000;
    }

    if (cboxAvocado.isChecked()) {
      mString.add(cboxAvocado.getText().toString());
      cost += 1000;
    }

    String[] strings = new String[mString.size()];
    strings = mString.toArray(strings);

    return strings;
  }

  public String[] getCondiments() {
    List<String> mString = new ArrayList<>();

    if (cboxGarlic.isChecked()) {
      mString.add(cboxGarlic.getText().toString());
      cost += 500;
    }

    if (cboxBasil.isChecked()) {
      mString.add(cboxBasil.getText().toString());
      cost += 500;
    }

    if (cboxOregano.isChecked()) {
      mString.add(cboxOregano.getText().toString());
      cost += 500;
    }

    String[] strings = new String[mString.size()];
    strings = mString.toArray(strings);

    return strings;
  }
}
