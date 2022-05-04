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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksVH>{

    List<Drink> drinks;
    private DrinksVH.OnDrinkListener mDrinkListener;

    public DrinksAdapter(List<Drink> drinks, DrinksVH.OnDrinkListener drinkListener){
        this.drinks = drinks;
        this.mDrinkListener = drinkListener;
    }
    @NonNull
    @Override
    public DrinksVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink, parent, false);
        return new DrinksVH(view, mDrinkListener).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksVH holder, int position) {
        //setting name and image for each card view
        holder.nameText.setText(drinks.get(position).getName());
        holder.drinkPhoto.setImageResource(drinks.get(position).getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }
}

class DrinksVH extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nameText;
    ImageView drinkPhoto;
    private DrinksAdapter adapter;
    OnDrinkListener drinkListener;

    public DrinksVH(@NonNull View itemView, OnDrinkListener drinkListener){
        super(itemView);

        //getting references to drink listener, name, and photo views
        this.drinkListener = drinkListener;

        nameText = (TextView)itemView.findViewById(R.id.drinkName);
        drinkPhoto = (ImageView)itemView.findViewById(R.id.drinkPhoto);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        drinkListener.onDrinkClicked(getAdapterPosition());
    }

    public DrinksVH linkAdapter(DrinksAdapter adapter){
        this.adapter = adapter;
        return this;
    }

    public interface OnDrinkListener{
        void onDrinkClicked(int pos);
    }
}
