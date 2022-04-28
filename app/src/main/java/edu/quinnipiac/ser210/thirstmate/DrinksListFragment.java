package edu.quinnipiac.ser210.thirstmate;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinksListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinksListFragment extends Fragment implements DrinksVH.OnDrinkListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int counter = 0;

    List<Drink> drinks = new LinkedList<>();
    private SQLiteDatabase db;
    private Cursor cursor;

    public DrinksListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinksListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinksListFragment newInstance(String param1, String param2) {
        DrinksListFragment fragment = new DrinksListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycleViewDrinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DrinksAdapter adapter = new DrinksAdapter(drinks, this);
        recyclerView.setAdapter(adapter);

        /*
        for(int i = 0; i < Drink.drinks.length; i++){
            drinks.add(Drink.drinks[i]);
            adapter.notifyItemInserted(drinks.size()-1);
        }
        */

        SQLiteOpenHelper thirstMateDBHelper = new ThirstMateDBHelper(getActivity());
        try{
            db = thirstMateDBHelper.getReadableDatabase();
            cursor = db.query("DRINK", new String[]{"NAME", "IMAGE_RESOURCE_ID", "ING1", "ING1AMT",
                            "ING2", "ING2AMT", "ING3", "ING3AMT", "ING4", "ING4AMT", "ING5", "ING5AMT",
                            "ING6", "ING6AMT", "ING7", "ING7AMT", "ING8", "ING8AMT", "ING9", "ING9AMT",
                            "ING10", "ING10AMT", "ING11", "ING11AMT", "ING12", "ING12AMT", "ING13",
                            "ING13AMT", "ING14", "ING14AMT", "ING15", "ING15AMT"},
                    null,null, null,null,null);
            while(cursor.moveToNext()){
                String drinkName = cursor.getString(0);
                int drinkPhotoId = cursor.getInt(1);
                String ing1 = cursor.getString(2);
                String ing2 = cursor.getString(4);
                String ing3 = cursor.getString(6);
                String ing4 = cursor.getString(8);
                String ing5 = cursor.getString(10);
                String ing6 = cursor.getString(12);
                String ing7 = cursor.getString(14);
                String ing8 = cursor.getString(16);
                String ing9 = cursor.getString(18);
                String ing10 = cursor.getString(20);
                String ing11 = cursor.getString(22);
                String ing12 = cursor.getString(24);
                String ing13 = cursor.getString(26);
                String ing14 = cursor.getString(28);
                String ing15 = cursor.getString(30);
                double ing1amt = cursor.getDouble(3);
                double ing2amt = cursor.getDouble(5);
                double ing3amt = cursor.getDouble(7);
                double ing4amt = cursor.getDouble(9);
                double ing5amt = cursor.getDouble(11);
                double ing6amt = cursor.getDouble(13);
                double ing7amt = cursor.getDouble(15);
                double ing8amt = cursor.getDouble(17);
                double ing9amt = cursor.getDouble(19);
                double ing10amt = cursor.getDouble(21);
                double ing11amt = cursor.getDouble(23);
                double ing12amt = cursor.getDouble(25);
                double ing13amt = cursor.getDouble(27);
                double ing14amt = cursor.getDouble(29);
                double ing15amt = cursor.getDouble(31);

                Ingredient[] ingredients = {
                        new Ingredient(ing1,ing1amt),
                        new Ingredient(ing2,ing2amt),
                        new Ingredient(ing3,ing3amt),
                        new Ingredient(ing4,ing4amt),
                        new Ingredient(ing5,ing5amt),
                        new Ingredient(ing6,ing6amt),
                        new Ingredient(ing7,ing7amt),
                        new Ingredient(ing8,ing8amt),
                        new Ingredient(ing9,ing9amt),
                        new Ingredient(ing10,ing10amt),
                        new Ingredient(ing11,ing11amt),
                        new Ingredient(ing12,ing12amt),
                        new Ingredient(ing13,ing13amt),
                        new Ingredient(ing14,ing14amt),
                        new Ingredient(ing15,ing15amt),
                };

                Drink newDrink = new Drink(drinkName,ingredients,drinkPhotoId);
                drinks.add(newDrink);
                adapter.notifyItemInserted(drinks.size()-1);
            }
            cursor.close();
            db.close();
        } catch (SQLException e){
            Toast toast = Toast.makeText(view.getContext(),"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }

        return view;
    }

    @Override
    public void onDrinkClicked(int pos) {
        Intent intent = new Intent(getActivity(),DrinkViewActivity.class);
        Drink selected = drinks.get(pos);
        
        String drinkName = selected.getName();
        intent.putExtra(DrinkViewActivity.EXTRA_DRINKNAME,drinkName);

        int imageResourceId = selected.getImageResourceId();
        intent.putExtra(DrinkViewActivity.EXTRA_IMGRESID,imageResourceId);

        Ingredient[] ingredients = selected.getIngredients();
        for(int i=0; i< ingredients.length; i++){
            String ingName = ingredients[i].getName();
            //Log.d("ingName in onDrinkClicked",ingName);
            double ingQuantity = ingredients[i].getQuantity();
            intent.putExtra(DrinkViewActivity.EXTRA_INGNAME + i,ingName);
            intent.putExtra(DrinkViewActivity.EXTRA_INGAMT + i,ingQuantity);
        }
        startActivity(intent);
    }
}