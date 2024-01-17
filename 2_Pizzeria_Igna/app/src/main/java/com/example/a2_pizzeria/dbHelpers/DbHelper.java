package com.example.a2_pizzeria.dbHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a2_pizzeria.model.Ingredient;
import com.example.a2_pizzeria.model.Pizza;
import com.example.a2_pizzeria.model.User;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_pizzeria.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT, "
                + "password TEXT)";
        db.execSQL(createUsersTableQuery);

        String createDefaultPizzasTableQuery = "CREATE TABLE IF NOT EXISTS default_pizzas ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT, "
                + "url TEXT, "
                + "price REAL)";
        db.execSQL(createDefaultPizzasTableQuery);

        if (isTableEmpty("default_pizzas", db)) {
            insertDefaultPizzas(db);
        }

        String createIngredientsTableQuery = "CREATE TABLE IF NOT EXISTS ingredients ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT, "
                + "price REAL)";
        db.execSQL(createIngredientsTableQuery);

        if (isTableEmpty("ingredients", db)) {
            insertIngredients(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean isTableEmpty(String tableName, SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + tableName, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count == 0;
    }

    private void insertDefaultPizzas(SQLiteDatabase db) {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("Pizza Carbonara", "carbonara", 12));
        pizzaList.add(new Pizza("Pizza Pepperoni", "pepperoni", 15));
        pizzaList.add(new Pizza("Pizza Vegetal", "vegetal", 10));
        pizzaList.add(new Pizza("Pizza Hawaiana", "hawaiana", 13));

        for (Pizza pizza : pizzaList) {
            ContentValues values = new ContentValues();
            values.put("name", pizza.getName());
            values.put("url", pizza.getUrl());
            values.put("price", pizza.getPrice(0));

            db.insert("default_pizzas", null, values);
        }
    }

    private void insertIngredients(SQLiteDatabase db) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Queso", 2));
        ingredients.add(new Ingredient("Pepperoni", 6));
        ingredients.add(new Ingredient("Piña", 3));
        ingredients.add(new Ingredient("Pollo", 5.5f));
        ingredients.add(new Ingredient("Salchichas", 6.5f));
        ingredients.add(new Ingredient("Aceitunas", 3.5f));

        for (Ingredient ingredient : ingredients) {
            ContentValues values = new ContentValues();
            values.put("name", ingredient.getName());
            values.put("price", ingredient.getPrice());

            db.insert("ingredients", null, values);
        }
    }

    public boolean signUpUser(String selectedUsername, String selectedPassword) {
        List<User> users = new ArrayList<>();
        boolean isCorrect = false;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("users", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

            users.add(new User(username, password));
        }

        User selectedUser = users.stream()
                .filter(user -> user.getUsername().equals(selectedUsername))
                .findFirst()
                .orElse(null);

        if (selectedUser == null) {
            ContentValues values = new ContentValues();
            values.put("username", selectedUsername);
            values.put("password", selectedPassword);

            db.insert("users", null, values);

            isCorrect = true;
        }

        cursor.close();
        db.close();

        return isCorrect;
    }

    public boolean logInUser(String selectedUsername, String selectedPassword) {
        List<User> users = new ArrayList<>();
        boolean isCorrect = false;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("users", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

            users.add(new User(username, password));
        }

        cursor.close();
        db.close();

        User selectedUser = users.stream()
                .filter(user -> user.getUsername().equals(selectedUsername))
                .findFirst()
                .orElse(null);

        if (selectedUser != null) {
            if (selectedUser.getPassword().equals(selectedPassword)) {
                isCorrect = true;
            }
        }

        return isCorrect;
    }

    public List<Pizza> getDefaultPizzas() {
        List<Pizza> pizzaList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("default_pizzas", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String url = cursor.getString(cursor.getColumnIndexOrThrow("url"));
            float price = (float) cursor.getDouble(cursor.getColumnIndexOrThrow("price"));

            pizzaList.add(new Pizza(name, url, price));
        }

        cursor.close();
        db.close();

        return pizzaList;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("ingredients", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            float price = (float) cursor.getDouble(cursor.getColumnIndexOrThrow("price"));

            ingredients.add(new Ingredient(name, price));
        }

        cursor.close();
        db.close();

        return ingredients;
    }

    /*public void updateRecord(long id, String newName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("column_name", newName);

        // Update the record with the specified ID
        db.update("your_table_name", values, "_id = ?", new String[]{String.valueOf(id)});

        db.close();
    }

    public void deleteRecord(long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Delete the record with the specified ID
        db.delete("your_table_name", "_id = ?", new String[]{String.valueOf(id)});

        db.close();
    }*/
}
