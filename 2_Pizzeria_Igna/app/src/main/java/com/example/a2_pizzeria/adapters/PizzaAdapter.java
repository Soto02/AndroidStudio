package com.example.a2_pizzeria.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2_pizzeria.R;
import com.example.a2_pizzeria.model.Pizza;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    private List<Pizza> pizzaList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Pizza pizza);
    }

    public PizzaAdapter(List<Pizza> pizzaList, OnItemClickListener onItemClickListener) {
        this.pizzaList = pizzaList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Pizza pizza = pizzaList.get(position);
        holder.nameTextView.setText(pizza.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(pizza);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.pizzaNameTextView);
        }
    }
}
