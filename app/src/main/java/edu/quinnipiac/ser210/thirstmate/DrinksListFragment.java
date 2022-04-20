package edu.quinnipiac.ser210.thirstmate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinksListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinksListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int counter = 0;

    public DrinksListFragment() {
        // Required empty public constructor
        Log.d("help","inside drinksListFragment constructor");
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

        List<Drink> drinks = new LinkedList<>();

        RecyclerView recyclerView = view.findViewById(R.id.recycleViewDrinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DrinksAdapter adapter = new DrinksAdapter(drinks);
        recyclerView.setAdapter(adapter);

        for(int i = 0; i < Drink.drinks.length; i++){
            drinks.add(Drink.drinks[i]);
            adapter.notifyItemInserted(drinks.size()-1);
        }

        return view;
    }
}