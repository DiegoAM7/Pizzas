package com.mao.pizzas.model;

public class Pizza {
  String name, principal, base;
  String[] ingredients, condiments;
  Double cost;

  public Pizza(
      String name,
      String principal,
      String base,
      String[] ingredients,
      String[] condiments,
      Double cost) {
    this.name = name;
    this.principal = principal;
    this.base = base;
    this.ingredients = ingredients;
    this.condiments = condiments;
    this.cost = cost;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrincipal() {
    return principal;
  }

  public void setPrincipal(String principal) {
    this.principal = principal;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getIngredients() {
    if (ingredients.length > 0) {
      String text = "";
      for (int i = 0; i < (ingredients.length); i++) {
        if (i < (ingredients.length - 1)) {
          text += ingredients[i] + ", ";
        } else {
          text += ingredients[i] + ".";
        }
      }
      return text;
    }

    return "No seleccionó ingredientes.";
  }

  public void setIngredients(String[] ingredients) {
    this.ingredients = ingredients;
  }

  public String getCondiments() {
    if (condiments.length > 0) {
      String text = "";
      for (int i = 0; i < (condiments.length); i++) {
        if (i < (condiments.length - 1)) {
          text += condiments[i] + ", ";
        } else {
          text += condiments[i] + ".";
        }
      }
      return text;
    }

    return "No seleccionó aliños.";
  }

  public void setCondiments(String[] condiments) {
    this.condiments = condiments;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }
}
