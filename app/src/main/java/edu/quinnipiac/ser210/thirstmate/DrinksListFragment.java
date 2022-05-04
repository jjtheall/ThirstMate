/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

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

    public DrinksListFragment() {
        // Required empty public constructor
    }

    //passes list of drinks to drinks instance var
    public DrinksListFragment(List<Drink> drinks){
        this.drinks = drinks;
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

        return view;
    }

    //when a drink is clicked in the list, populate intent with name, image resource id
    //and ingredient list as extras, then start DrinkViewActivity
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
            double ingQuantity = ingredients[i].getQuantity();
            intent.putExtra(DrinkViewActivity.EXTRA_INGNAME + i,ingName);
            intent.putExtra(DrinkViewActivity.EXTRA_INGAMT + i,ingQuantity);
        }
        startActivity(intent);
    }
}