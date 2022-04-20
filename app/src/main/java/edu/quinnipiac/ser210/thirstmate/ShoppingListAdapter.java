package edu.quinnipiac.ser210.thirstmate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListVH>{

    List<String> items;

    public ShoppingListAdapter(List<String> items){
        this.items = items;
    }
    @NonNull
    @Override
    public ShoppingListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        return new ShoppingListVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListVH holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class ShoppingListVH extends RecyclerView.ViewHolder{

    TextView textView;
    private ShoppingListAdapter adapter;

    public ShoppingListVH(@NonNull View itemView){
        super(itemView);

        textView = itemView.findViewById(R.id.ingredient);
        itemView.findViewById(R.id.deleteIngredient).setOnClickListener(view -> {
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });
    }

    public ShoppingListVH linkAdapter(ShoppingListAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
