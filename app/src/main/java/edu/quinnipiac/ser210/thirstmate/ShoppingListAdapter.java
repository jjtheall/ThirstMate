package edu.quinnipiac.ser210.thirstmate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListVH>{

    List<Ingredient> ingredients;

    public ShoppingListAdapter(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }
    @NonNull
    @Override
    public ShoppingListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        return new ShoppingListVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListVH holder, int position) {
        holder.nameText.setText(ingredients.get(position).getName());
        if(ingredients.get(position).getQuantity() != 0){ holder.quantityText.setText("" + ingredients.get(position).getQuantity()); }
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}

class ShoppingListVH extends RecyclerView.ViewHolder{

    TextView nameText;
    TextView quantityText;
    private ShoppingListAdapter adapter;

    public ShoppingListVH(@NonNull View itemView){
        super(itemView);

        nameText = itemView.findViewById(R.id.ingredientName);
        quantityText = itemView.findViewById(R.id.ingredientQuantity);
        itemView.findViewById(R.id.deleteIngredient).setOnClickListener(view -> {
            adapter.ingredients.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });
    }

    public ShoppingListVH linkAdapter(ShoppingListAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
