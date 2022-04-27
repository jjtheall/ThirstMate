package edu.quinnipiac.ser210.thirstmate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListVH>{

    List<Ingredient> ingredients;
    List<ShoppingListVH> holders = new LinkedList<>();

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
        holders.add(holder);
        holder.nameText.setText(ingredients.get(position).getName());
        if(ingredients.get(position).getQuantity() != 0){ holder.quantityText.setText("" + ingredients.get(position).getQuantity()); }
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public void clearIngredients(){
       ingredients.clear();
       for (int i = 0; i < holders.size(); i++) {
           holders.get(i).nameText.setText("");
           holders.get(i).quantityText.setText("");
       }
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
            nameText.setText("");
            quantityText.setText("");
            adapter.ingredients.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });
    }

    public ShoppingListVH linkAdapter(ShoppingListAdapter adapter){
        this.adapter = adapter;
        return this;
    }

}
