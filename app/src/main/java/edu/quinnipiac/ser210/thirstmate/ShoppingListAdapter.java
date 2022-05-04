/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListVH>{

    List<Ingredient> ingredients;
    List<ShoppingListVH> holders = new LinkedList<>();
    private List<String> liquorNames;
    private List<String> liqueurNames;

    public ShoppingListAdapter(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }
    @NonNull
    @Override
    public ShoppingListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        liquorNames = new ArrayList<String>(Arrays.asList(view.getResources().getStringArray(R.array.liquors)));
        liqueurNames = new ArrayList<String>(Arrays.asList(view.getResources().getStringArray(R.array.liqueurs)));
        return new ShoppingListVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListVH holder, int position) {
        Ingredient cur = ingredients.get(position);
        holders.add(holder);
        holder.nameText.setText(cur.getName());

        // Checks if quantity is above 0
        if(cur.getQuantity() != 0) {

            // Checks if ingredient is base liquor
            if (liquorNames.contains(cur.getName())) {
                // Nips
                if (cur.getQuantity() <= 250) {
                    if(cur.getQuantity() <= 50){holder.quantityText.setText("1 Nip");}
                    else{holder.quantityText.setText((int)Math.ceil(cur.getQuantity()/50) + " Nips");}
                }
                // Fifth
                else if(cur.getQuantity() <= 750){ holder.quantityText.setText("1 Fifth");}
                // Liter
                else if(cur.getQuantity() <= 1000){ holder.quantityText.setText("1 Liter");}
                // Handles
                else if(cur.getQuantity() > 1000){
                    if(cur.getQuantity() <= 1750){holder.quantityText.setText("1 Handle");}
                    else{holder.quantityText.setText((int)Math.ceil(cur.getQuantity()/1750) + " Handles");}
                }
            } else if(liqueurNames.contains(cur.getName())){
                // Fifth
                if(cur.getQuantity() <= 750){ holder.quantityText.setText("1 Fifth");}
                else{holder.quantityText.setText((int)Math.ceil(cur.getQuantity()/750) + " Fifths");}
            }
            else{
                holder.quantityText.setText(cur.getQuantity() + "ml");
            }
        }

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
            ShoppingListFragment.ingredientsShopping.remove(getAdapterPosition());
            adapter.ingredients.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });
    }

    public ShoppingListVH linkAdapter(ShoppingListAdapter adapter){
        this.adapter = adapter;
        return this;
    }

}
