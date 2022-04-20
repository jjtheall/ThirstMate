package edu.quinnipiac.ser210.thirstmate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksVH>{

    List<Drink> drinks;

    public DrinksAdapter(List<Drink> drinks){
        this.drinks = drinks;
    }
    @NonNull
    @Override
    public DrinksVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink, parent, false);
        return new DrinksVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksVH holder, int position) {
        holder.nameText.setText(drinks.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }
}

class DrinksVH extends RecyclerView.ViewHolder{

    TextView nameText;
    private DrinksAdapter adapter;

    public DrinksVH(@NonNull View itemView){
        super(itemView);

        nameText = itemView.findViewById(R.id.drinkName);
//        itemView.findViewById(R.id.deleteIngredient).setOnClickListener(view -> {
//            adapter.drinks.remove(getAdapterPosition());
//            adapter.notifyItemRemoved(getAdapterPosition());
//        });
    }

    public DrinksVH linkAdapter(DrinksAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
