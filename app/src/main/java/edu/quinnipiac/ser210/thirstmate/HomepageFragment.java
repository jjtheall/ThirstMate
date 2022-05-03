package edu.quinnipiac.ser210.thirstmate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomepageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomepageFragment extends Fragment implements DrinksVH.OnDrinkListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Random rand = new Random();
    private List<Drink> drinksButWhat = new LinkedList<>();
    private ArrayList<Drink> drinksBetter = new ArrayList<>();
    private int randomIndex = 0;
    List<Drink> featuredDrinks = new LinkedList<>();
    int numberOfFeatured = 3;

    public HomepageFragment() {
        // Required empty public constructor
    }

    public HomepageFragment(List<Drink> drinks){
        for(int i = 0; i < drinks.size(); i++){
            Log.d("How many", "" + i);
            drinksBetter.add(drinks.get(i));
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomepageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomepageFragment newInstance(String param1, String param2) {
        HomepageFragment fragment = new HomepageFragment();
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

        for (int i = 0; i < numberOfFeatured; i++) {
            Log.d("How", "" + drinksBetter.size());
            randomIndex = rand.nextInt(drinksBetter.size());
            featuredDrinks.add(drinksBetter.get(randomIndex));
            drinksBetter.remove(randomIndex);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycleViewHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DrinksAdapter adapter = new DrinksAdapter(featuredDrinks, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDrinkClicked(int pos) {
        Intent intent = new Intent(getActivity(),DrinkViewActivity.class);
        Drink selected = featuredDrinks.get(pos);

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