/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static int counter = 0;

    public static ArrayList<Ingredient> ingredientsShopping = new ArrayList<>();

    public ShoppingListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingListFragment newInstance(String param1, String param2) {
        ShoppingListFragment fragment = new ShoppingListFragment();
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
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        List<Ingredient> ingredients = new LinkedList<>();

        RecyclerView recyclerView = view.findViewById(R.id.recycleViewShopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ShoppingListAdapter adapter = new ShoppingListAdapter(ingredients);
        recyclerView.setAdapter(adapter);

        //adds ingredients in shopping list to list of instance var list of ingredients
        for(int i=0; i<ingredientsShopping.size();i++){
            ingredients.add(ingredientsShopping.get(i));
            adapter.notifyItemInserted(ingredients.size() - 1);
        }

        counter = ingredientsShopping.size();

        //setting onClickListener for add and clear buttons in shopping list
        view.findViewById(R.id.addIngredient).setOnClickListener(view1 -> {
            //creates AddIngredientDialog
            AddIngredientDialog addIngredientDialog = new AddIngredientDialog();
            addIngredientDialog.setIngredients(ingredients);
            addIngredientDialog.setAdapter(adapter);
            addIngredientDialog.show(getFragmentManager(), "addIngredientToShopping");
        });

        view.findViewById(R.id.clearIngredients).setOnClickListener(view1 -> {

            ingredients.clear();
            ingredientsShopping.clear();
            adapter.clearIngredients();

            updateIngredients(ingredients, adapter);
        });

        return view;
    }

    //updates instance ingredient list
    public static void updateIngredients(List<Ingredient> ingredients, ShoppingListAdapter adapter){
        if(ingredientsShopping.size() != 0) {
            ingredients.add(ingredientsShopping.get(counter % ingredientsShopping.size()));
            counter++;
            adapter.notifyItemInserted(ingredients.size() - 1);
        }
        else{
            counter = 0;
            adapter.notifyDataSetChanged();
        }
    }


}