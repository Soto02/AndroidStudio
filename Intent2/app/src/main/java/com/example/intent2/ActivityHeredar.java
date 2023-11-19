package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityHeredar {
    private static List<AppCompatActivity> actividades = new ArrayList<>();
    public static void agregarActivity(AppCompatActivity activity) {
        actividades.add(activity);
    }
    public static void aplicarColorEnTodas(int color) {
        for (AppCompatActivity actividad : actividades) {
            aplicarColor(actividad, color);
        }
    }
    private static void aplicarColor(AppCompatActivity actividad, int color) {
        actividad.getWindow().getDecorView().setBackgroundColor(color);
    }

}
