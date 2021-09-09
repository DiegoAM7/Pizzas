package com.mao.pizzas;

import com.mao.pizzas.model.Pizza;

import java.util.ArrayList;

public class Data {
    private final ArrayList<Pizza> arrayList;

    private static Data instance;

    protected Data() {
        arrayList = new ArrayList<>();
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }

        return instance;
    }

    public ArrayList<Pizza> getArrayList() {
        return arrayList;
    }
}
