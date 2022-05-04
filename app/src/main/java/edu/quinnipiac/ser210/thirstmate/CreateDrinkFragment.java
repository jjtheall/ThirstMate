/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateDrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateDrinkFragment extends Fragment {
    private Drink newDrink;

    private EditText drinkNameEditText;

    private EditText ing1EditText;
    private EditText ing2EditText;
    private EditText ing3EditText;
    private EditText ing4EditText;
    private EditText ing5EditText;
    private EditText ing6EditText;
    private EditText ing7EditText;
    private EditText ing8EditText;
    private EditText ing9EditText;
    private EditText ing10EditText;
    private EditText ing11EditText;
    private EditText ing12EditText;
    private EditText ing13EditText;
    private EditText ing14EditText;
    private EditText ing15EditText;

    private EditText ing1amtEditText;
    private EditText ing2amtEditText;
    private EditText ing3amtEditText;
    private EditText ing4amtEditText;
    private EditText ing5amtEditText;
    private EditText ing6amtEditText;
    private EditText ing7amtEditText;
    private EditText ing8amtEditText;
    private EditText ing9amtEditText;
    private EditText ing10amtEditText;
    private EditText ing11amtEditText;
    private EditText ing12amtEditText;
    private EditText ing13amtEditText;
    private EditText ing14amtEditText;
    private EditText ing15amtEditText;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateDrinkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateDrinkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateDrinkFragment newInstance(String param1, String param2) {
        CreateDrinkFragment fragment = new CreateDrinkFragment();
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
        View view = inflater.inflate(R.layout.fragment_create_drink, container, false);

        drinkNameEditText = (EditText)view.findViewById(R.id.drink_name);

        ing1EditText = (EditText)view.findViewById(R.id.ing1);
        ing2EditText = (EditText)view.findViewById(R.id.ing2);
        ing3EditText = (EditText)view.findViewById(R.id.ing3);
        ing4EditText = (EditText)view.findViewById(R.id.ing4);
        ing5EditText = (EditText)view.findViewById(R.id.ing5);
        ing6EditText = (EditText)view.findViewById(R.id.ing6);
        ing7EditText = (EditText)view.findViewById(R.id.ing7);
        ing8EditText = (EditText)view.findViewById(R.id.ing8);
        ing9EditText = (EditText)view.findViewById(R.id.ing9);
        ing10EditText = (EditText)view.findViewById(R.id.ing10);
        ing11EditText = (EditText)view.findViewById(R.id.ing11);
        ing12EditText = (EditText)view.findViewById(R.id.ing12);
        ing13EditText = (EditText)view.findViewById(R.id.ing13);
        ing14EditText = (EditText)view.findViewById(R.id.ing14);
        ing15EditText = (EditText)view.findViewById(R.id.ing15);

        ing1amtEditText = (EditText)view.findViewById(R.id.ingamt1);
        ing2amtEditText = (EditText)view.findViewById(R.id.ingamt2);
        ing3amtEditText = (EditText)view.findViewById(R.id.ingamt3);
        ing4amtEditText = (EditText)view.findViewById(R.id.ingamt4);
        ing5amtEditText = (EditText)view.findViewById(R.id.ingamt5);
        ing6amtEditText = (EditText)view.findViewById(R.id.ingamt6);
        ing7amtEditText = (EditText)view.findViewById(R.id.ingamt7);
        ing8amtEditText = (EditText)view.findViewById(R.id.ingamt8);
        ing9amtEditText = (EditText)view.findViewById(R.id.ingamt9);
        ing10amtEditText = (EditText)view.findViewById(R.id.ingamt10);
        ing11amtEditText = (EditText)view.findViewById(R.id.ingamt11);
        ing12amtEditText = (EditText)view.findViewById(R.id.ingamt12);
        ing13amtEditText = (EditText)view.findViewById(R.id.ingamt13);
        ing14amtEditText = (EditText)view.findViewById(R.id.ingamt14);
        ing15amtEditText = (EditText)view.findViewById(R.id.ingamt15);

        Button createButton = (Button)view.findViewById(R.id.create_drink_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //when create drink button is pressed, check to make sure all quantity
            //fields have numerical values, if so, execute CreateDrink async task
            public void onClick(View view) {
                boolean formatted = true;
                try{
                    if(!(ing1amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing1amtEditText.getText().toString());
                    }
                    if(!(ing2amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing2amtEditText.getText().toString());
                    }
                    if(!(ing3amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing3amtEditText.getText().toString());
                    }
                    if(!(ing4amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing4amtEditText.getText().toString());
                    }
                    if(!(ing5amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing5amtEditText.getText().toString());
                    }
                    if(!(ing6amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing6amtEditText.getText().toString());
                    }
                    if(!(ing7amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing7amtEditText.getText().toString());
                    }
                    if(!(ing8amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing8amtEditText.getText().toString());
                    }
                    if(!(ing9amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing9amtEditText.getText().toString());
                    }
                    if(!(ing10amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing10amtEditText.getText().toString());
                    }
                    if(!(ing11amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing11amtEditText.getText().toString());
                    }
                    if(!(ing12amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing12amtEditText.getText().toString());
                    }
                    if(!(ing13amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing13amtEditText.getText().toString());
                    }
                    if(!(ing14amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing14amtEditText.getText().toString());
                    }
                    if(!(ing15amtEditText.getText().toString().equals(""))){
                        Double.parseDouble(ing15amtEditText.getText().toString());
                    }
                } catch (NumberFormatException e){
                    formatted = false;
                    Toast toast = Toast.makeText(getActivity(),"Quantity must be a number",Toast.LENGTH_SHORT);
                    toast.show();
                }
                if(formatted){
                    new CreateDrinkTask().execute();
                }
            }
        });

        return view;
    }

    private class CreateDrinkTask extends AsyncTask<Integer,Void,Boolean> {

        //populate ingredient name and quantities from edit texts, then insert
        //new record using those values into database
        @Override
        protected Boolean doInBackground(Integer... integers) {
            String drinkName = null;
            String ing1 = null;
            String ing2 = null;
            String ing3 = null;
            String ing4 = null;
            String ing5 = null;
            String ing6 = null;
            String ing7 = null;
            String ing8 = null;
            String ing9 = null;
            String ing10 = null;
            String ing11 = null;
            String ing12 = null;
            String ing13 = null;
            String ing14 = null;
            String ing15 = null;

            double ing1amt = 0.0;
            double ing2amt = 0.0;
            double ing3amt = 0.0;
            double ing4amt = 0.0;
            double ing5amt = 0.0;
            double ing6amt = 0.0;
            double ing7amt = 0.0;
            double ing8amt = 0.0;
            double ing9amt = 0.0;
            double ing10amt = 0.0;
            double ing11amt = 0.0;
            double ing12amt = 0.0;
            double ing13amt = 0.0;
            double ing14amt = 0.0;
            double ing15amt = 0.0;

            //getting drink name and ingredient names
            if(!(drinkNameEditText.getText().toString().equals(""))){
                drinkName = drinkNameEditText.getText().toString();
            }
            if(!(ing1EditText.getText().toString().equals(""))){
                ing1 = ing1EditText.getText().toString();
            }
            if(!(ing2EditText.getText().toString().equals(""))){
                ing2 = ing2EditText.getText().toString();
            }
            if(!(ing3EditText.getText().toString().equals(""))){
                ing3 = ing3EditText.getText().toString();
            }
            if(!(ing4EditText.getText().toString().equals(""))){
                ing4 = ing4EditText.getText().toString();
            }
            if(!(ing5EditText.getText().toString().equals(""))){
                ing5 = ing5EditText.getText().toString();
            }
            if(!(ing6EditText.getText().toString().equals(""))){
                ing6 = ing6EditText.getText().toString();
            }
            if(!(ing7EditText.getText().toString().equals(""))){
                ing7 = ing7EditText.getText().toString();
            }
            if(!(ing8EditText.getText().toString().equals(""))){
                ing8 = ing8EditText.getText().toString();
            }
            if(!(ing9EditText.getText().toString().equals(""))){
                ing9 = ing9EditText.getText().toString();
            }
            if(!(ing10EditText.getText().toString().equals(""))){
                ing10 = ing10EditText.getText().toString();
            }
            if(!(ing11EditText.getText().toString().equals(""))){
                ing11 = ing11EditText.getText().toString();
            }
            if(!(ing12EditText.getText().toString().equals(""))){
                ing12 = ing12EditText.getText().toString();
            }
            if(!(ing13EditText.getText().toString().equals(""))){
                ing13 = ing13EditText.getText().toString();
            }
            if(!(ing14EditText.getText().toString().equals(""))){
                ing14 = ing14EditText.getText().toString();
            }
            if(!(ing15EditText.getText().toString().equals(""))){
                ing15 = ing15EditText.getText().toString();
            }

            //getting ingredient quantities
            if(!(ing1amtEditText.getText().toString().equals(""))){
                ing1amt = Double.parseDouble(ing1amtEditText.getText().toString());
            }
            if(!(ing2amtEditText.getText().toString().equals(""))){
                ing2amt = Double.parseDouble(ing2amtEditText.getText().toString());
            }
            if(!(ing3amtEditText.getText().toString().equals(""))){
                ing3amt = Double.parseDouble(ing3amtEditText.getText().toString());
            }
            if(!(ing4amtEditText.getText().toString().equals(""))){
                ing4amt = Double.parseDouble(ing4amtEditText.getText().toString());
            }
            if(!(ing5amtEditText.getText().toString().equals(""))){
                ing5amt = Double.parseDouble(ing5amtEditText.getText().toString());
            }
            if(!(ing6amtEditText.getText().toString().equals(""))){
                ing6amt = Double.parseDouble(ing6amtEditText.getText().toString());
            }
            if(!(ing7amtEditText.getText().toString().equals(""))){
                ing7amt = Double.parseDouble(ing7amtEditText.getText().toString());
            }
            if(!(ing8amtEditText.getText().toString().equals(""))){
                ing8amt = Double.parseDouble(ing8amtEditText.getText().toString());
            }
            if(!(ing9amtEditText.getText().toString().equals(""))){
                ing9amt = Double.parseDouble(ing9amtEditText.getText().toString());
            }
            if(!(ing10amtEditText.getText().toString().equals(""))){
                ing10amt = Double.parseDouble(ing10amtEditText.getText().toString());
            }
            if(!(ing11amtEditText.getText().toString().equals(""))){
                ing11amt = Double.parseDouble(ing11amtEditText.getText().toString());
            }
            if(!(ing12amtEditText.getText().toString().equals(""))){
                ing12amt = Double.parseDouble(ing12amtEditText.getText().toString());
            }
            if(!(ing13amtEditText.getText().toString().equals(""))){
                ing13amt = Double.parseDouble(ing13amtEditText.getText().toString());
            }
            if(!(ing14amtEditText.getText().toString().equals(""))){
                ing14amt = Double.parseDouble(ing14amtEditText.getText().toString());
            }
            if(!(ing15amtEditText.getText().toString().equals(""))){
                ing15amt = Double.parseDouble(ing15amtEditText.getText().toString());
            }

            SQLiteOpenHelper thirstMateDBHelper = new ThirstMateDBHelper(getActivity());
            try{
                SQLiteDatabase db = thirstMateDBHelper.getWritableDatabase();
                insertDrink(db,drinkName,R.drawable.cocktail,ing1,ing1amt,ing2,ing2amt,ing3,ing3amt,ing4,ing4amt,
                        ing5,ing5amt,ing6,ing6amt,ing7,ing7amt,ing8,ing8amt,ing9,ing9amt,ing10,ing10amt,
                        ing11,ing11amt,ing12,ing12amt,ing13,ing13amt,ing14,ing14amt,ing15,ing15amt);
                db.close();
                return true;
            } catch (SQLiteException e){
                return false;
            }
        }

        protected void onPostExecute(Boolean success){
            if(!success){
                Toast toast = Toast.makeText(getActivity(),"Database unavailable",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                //update list of drinks in MainActivity, then switch page to drinks list
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.updateDrinks();
                ViewPager pager = mainActivity.getPager();
                pager.setCurrentItem(1,true);
                //getActivity().recreate();
            }
        }

        private void insertDrink(SQLiteDatabase db, String name, int imageResourceId, String ing1, double ing1amt, String ing2,
                                        double ing2amt, String ing3, double ing3amt, String ing4, double ing4amt,
                                        String ing5, double ing5amt, String ing6, double ing6amt, String ing7,
                                        double ing7amt, String ing8, double ing8amt, String ing9, double ing9amt,
                                        String ing10, double ing10amt, String ing11, double ing11amt, String ing12,
                                        double ing12amt, String ing13, double ing13amt, String ing14, double ing14amt,
                                        String ing15, double ing15amt){

            ContentValues drinkValues = new ContentValues();
            drinkValues.put("NAME",name);
            drinkValues.put("IMAGE_RESOURCE_ID",imageResourceId);
            drinkValues.put("ING1",ing1);
            drinkValues.put("ING1AMT",ing1amt);
            drinkValues.put("ING2",ing2);
            drinkValues.put("ING2AMT",ing2amt);
            drinkValues.put("ING3",ing3);
            drinkValues.put("ING3AMT",ing3amt);
            drinkValues.put("ING4",ing4);
            drinkValues.put("ING4AMT",ing4amt);
            drinkValues.put("ING5",ing5);
            drinkValues.put("ING5AMT",ing5amt);
            drinkValues.put("ING6",ing6);
            drinkValues.put("ING6AMT",ing6amt);
            drinkValues.put("ING7",ing7);
            drinkValues.put("ING7AMT",ing7amt);
            drinkValues.put("ING8",ing8);
            drinkValues.put("ING8AMT",ing8amt);
            drinkValues.put("ING9",ing9);
            drinkValues.put("ING9AMT",ing9amt);
            drinkValues.put("ING10",ing10);
            drinkValues.put("ING10AMT",ing10amt);
            drinkValues.put("ING11",ing11);
            drinkValues.put("ING11AMT",ing11amt);
            drinkValues.put("ING12",ing12);
            drinkValues.put("ING12AMT",ing12amt);
            drinkValues.put("ING13",ing13);
            drinkValues.put("ING13AMT",ing13amt);
            drinkValues.put("ING14",ing14);
            drinkValues.put("ING14AMT",ing14amt);
            drinkValues.put("ING15",ing15);
            drinkValues.put("ING15AMT",ing15amt);
            drinkValues.put("USER_ENTERED",true);
            db.insert("DRINK",null,drinkValues);
        }
    }
}