package edu.quinnipiac.ser210.thirstmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkViewActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    private int curNum = 0;

    public static final String EXTRA_DRINKNAME = "drinkID";
    public static final String EXTRA_IMGRESID = "imageResourceId";
    public static final String EXTRA_INGNAME = "ing";
    public static final String EXTRA_INGAMT = "ingamt";

    private String ing1Name = "";
    private String ing2Name = "";
    private String ing3Name = "";
    private String ing4Name = "";
    private String ing5Name = "";
    private String ing6Name = "";
    private String ing7Name = "";
    private String ing8Name = "";
    private String ing9Name = "";
    private String ing10Name = "";
    private String ing11Name = "";
    private String ing12Name = "";
    private String ing13Name = "";
    private String ing14Name = "";
    private String ing15Name = "";

    private double ing1Amt;
    private double ing2Amt;
    private double ing3Amt;
    private double ing4Amt;
    private double ing5Amt;
    private double ing6Amt;
    private double ing7Amt;
    private double ing8Amt;
    private double ing9Amt;
    private double ing10Amt;
    private double ing11Amt;
    private double ing12Amt;
    private double ing13Amt;
    private double ing14Amt;
    private double ing15Amt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_view);

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String drinkName = intent.getStringExtra(EXTRA_DRINKNAME);
        TextView drinkNameTextView = (TextView) findViewById(R.id.name);
        drinkNameTextView.setText(drinkName);

        int photoId = intent.getIntExtra(EXTRA_IMGRESID,0);
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(photoId);
        photo.setContentDescription(drinkName);

        if(intent.getStringExtra(EXTRA_INGNAME + "0") != null){
            ing1Name = intent.getStringExtra(EXTRA_INGNAME + "0");
        }
        ing1Amt = intent.getDoubleExtra(EXTRA_INGAMT + "0",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "1") != null){
            ing2Name = intent.getStringExtra(EXTRA_INGNAME + "1");
        }
        ing2Amt = intent.getDoubleExtra(EXTRA_INGAMT + "1",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "2") != null){
            ing3Name = intent.getStringExtra(EXTRA_INGNAME + "2");
        }
        ing3Amt = intent.getDoubleExtra(EXTRA_INGAMT + "2",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "3") != null){
            ing4Name = intent.getStringExtra(EXTRA_INGNAME + "3");
        }
        ing4Amt = intent.getDoubleExtra(EXTRA_INGAMT + "3",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "4") != null){
            ing5Name = intent.getStringExtra(EXTRA_INGNAME + "4");
        }
        ing5Amt = intent.getDoubleExtra(EXTRA_INGAMT + "4",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "5") != null){
            ing6Name = intent.getStringExtra(EXTRA_INGNAME + "5");
        }
        ing6Amt = intent.getDoubleExtra(EXTRA_INGAMT + "5",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "6") != null){
            ing7Name = intent.getStringExtra(EXTRA_INGNAME + "6");
        }
        ing7Amt = intent.getDoubleExtra(EXTRA_INGAMT + "6",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "7") != null){
            ing8Name = intent.getStringExtra(EXTRA_INGNAME + "7");
        }
        ing8Amt = intent.getDoubleExtra(EXTRA_INGAMT + "7",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "8") != null){
            ing9Name = intent.getStringExtra(EXTRA_INGNAME + "8");
        }
        ing9Amt = intent.getDoubleExtra(EXTRA_INGAMT + "8", 0);

        if(intent.getStringExtra(EXTRA_INGNAME + "9") != null){
            ing10Name = intent.getStringExtra(EXTRA_INGNAME + "9");
        }
        ing10Amt = intent.getDoubleExtra(EXTRA_INGAMT + "9",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "10") != null){
            ing11Name = intent.getStringExtra(EXTRA_INGNAME + "10");
        }
        ing11Amt = intent.getDoubleExtra(EXTRA_INGAMT + "10",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "11") != null){
            ing12Name = intent.getStringExtra(EXTRA_INGNAME + "11");
        }
        ing12Amt = intent.getDoubleExtra(EXTRA_INGAMT + "11",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "12") != null){
            ing13Name = intent.getStringExtra(EXTRA_INGNAME + "12");
        }
        ing13Amt = intent.getDoubleExtra(EXTRA_INGAMT + "12",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "13") != null){
            ing14Name = intent.getStringExtra(EXTRA_INGNAME + "13");
        }
        ing14Amt = intent.getDoubleExtra(EXTRA_INGAMT + "13",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "14") != null){
            ing15Name = intent.getStringExtra(EXTRA_INGNAME + "14");
        }
        ing15Amt = intent.getDoubleExtra(EXTRA_INGAMT + "14",0);


        TextView ing1TextView = (TextView)findViewById(R.id.ing1);
        TextView ing1AmtTextView = (TextView)findViewById(R.id.ingamt1);
        TextView ing2TextView = (TextView)findViewById(R.id.ing2);
        TextView ing2AmtTextView = (TextView)findViewById(R.id.ingamt2);
        TextView ing3TextView = (TextView)findViewById(R.id.ing3);
        TextView ing3AmtTextView = (TextView)findViewById(R.id.ingamt3);
        TextView ing4TextView = (TextView)findViewById(R.id.ing4);
        TextView ing4AmtTextView = (TextView)findViewById(R.id.ingamt4);
        TextView ing5TextView = (TextView)findViewById(R.id.ing5);
        TextView ing5AmtTextView = (TextView)findViewById(R.id.ingamt5);
        TextView ing6TextView = (TextView)findViewById(R.id.ing6);
        TextView ing6AmtTextView = (TextView)findViewById(R.id.ingamt6);
        TextView ing7TextView = (TextView)findViewById(R.id.ing7);
        TextView ing7AmtTextView = (TextView)findViewById(R.id.ingamt7);
        TextView ing8TextView = (TextView)findViewById(R.id.ing8);
        TextView ing8AmtTextView = (TextView)findViewById(R.id.ingamt8);
        TextView ing9TextView = (TextView)findViewById(R.id.ing9);
        TextView ing9AmtTextView = (TextView)findViewById(R.id.ingamt9);
        TextView ing10TextView = (TextView)findViewById(R.id.ing10);
        TextView ing10AmtTextView = (TextView)findViewById(R.id.ingamt10);
        TextView ing11TextView = (TextView)findViewById(R.id.ing11);
        TextView ing11AmtTextView = (TextView)findViewById(R.id.ingamt11);
        TextView ing12TextView = (TextView)findViewById(R.id.ing12);
        TextView ing12AmtTextView = (TextView)findViewById(R.id.ingamt12);
        TextView ing13TextView = (TextView)findViewById(R.id.ing13);
        TextView ing13AmtTextView = (TextView)findViewById(R.id.ingamt13);
        TextView ing14TextView = (TextView)findViewById(R.id.ing14);
        TextView ing14AmtTextView = (TextView)findViewById(R.id.ingamt14);
        TextView ing15TextView = (TextView)findViewById(R.id.ing15);
        TextView ing15AmtTextView = (TextView)findViewById(R.id.ingamt15);

        if(!ing1Name.equals("")){
            ing1TextView.setText(ing1Name);
            ing1AmtTextView.setText(""+ing1Amt);
            ing1TextView.setVisibility(View.VISIBLE);
            ing1AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing2Name.equals("")){
            ing2TextView.setText(ing2Name);
            ing2AmtTextView.setText(""+ing2Amt);
            ing2TextView.setVisibility(View.VISIBLE);
            ing2AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing3Name.equals("")){
            ing3TextView.setText(ing3Name);
            ing3AmtTextView.setText(""+ing3Amt);
            ing3TextView.setVisibility(View.VISIBLE);
            ing3AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing4Name.equals("")){
            ing4TextView.setText(ing4Name);
            ing4AmtTextView.setText(""+ing4Amt);
            ing4TextView.setVisibility(View.VISIBLE);
            ing4AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing5Name.equals("")){
            ing5TextView.setText(ing5Name);
            ing5AmtTextView.setText(""+ing5Amt);
            ing5TextView.setVisibility(View.VISIBLE);
            ing5AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing6Name.equals("")){
            ing6TextView.setText(ing6Name);
            ing6AmtTextView.setText(""+ing6Amt);
            ing6TextView.setVisibility(View.VISIBLE);
            ing6AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing7Name.equals("")){
            ing7TextView.setText(ing7Name);
            ing7AmtTextView.setText(""+ing7Amt);
            ing7TextView.setVisibility(View.VISIBLE);
            ing7AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing8Name.equals("")){
            ing8TextView.setText(ing8Name);
            ing8AmtTextView.setText(""+ing8Amt);
            ing8TextView.setVisibility(View.VISIBLE);
            ing8AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing9Name.equals("")){
            ing9TextView.setText(ing9Name);
            ing9AmtTextView.setText(""+ing9Amt);
            ing9TextView.setVisibility(View.VISIBLE);
            ing9AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing10Name.equals("")){
            ing10TextView.setText(ing10Name);
            ing10AmtTextView.setText(""+ing10Amt);
            ing10TextView.setVisibility(View.VISIBLE);
            ing10AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing11Name.equals("")){
            ing11TextView.setText(ing11Name);
            ing11AmtTextView.setText(""+ing11Amt);
            ing11TextView.setVisibility(View.VISIBLE);
            ing11AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing12Name.equals("")){
            ing12TextView.setText(ing12Name);
            ing12AmtTextView.setText(""+ing12Amt);
            ing12TextView.setVisibility(View.VISIBLE);
            ing12AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing13Name.equals("")){
            ing13TextView.setText(ing13Name);
            ing13AmtTextView.setText(""+ing13Amt);
            ing13TextView.setVisibility(View.VISIBLE);
            ing13AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing14Name.equals("")){
            ing14TextView.setText(ing14Name);
            ing14AmtTextView.setText(""+ing14Amt);
            ing14TextView.setVisibility(View.VISIBLE);
            ing14AmtTextView.setVisibility(View.VISIBLE);
        }
        if(!ing15Name.equals("")){
            ing15TextView.setText(ing15Name);
            ing15AmtTextView.setText(""+ing15Amt);
            ing15TextView.setVisibility(View.VISIBLE);
            ing15AmtTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("ingredients list");
        return super.onCreateOptionsMenu(menu);
    }

    //change this method to accept list of ingredients
    public void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_info:
                Intent infoIntent = new Intent(this,InfoActivity.class);
                startActivity(infoIntent);
                return true;
            case R.id.action_home:
                Intent homeIntent = new Intent(this,MainActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this,SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSubtractDrinkQuantity(View view){
        TextView drinkQuantity = (TextView) findViewById(R.id.drink_quantity);
        curNum = Integer.parseInt(String.valueOf(drinkQuantity.getText()));
        if(curNum > 0){
            drinkQuantity.setText("" + (curNum-1));
            curNum--;
        }

    }

    public void onAddDrinkQuantity(View view) {
        TextView drinkQuantity = (TextView) findViewById(R.id.drink_quantity);
        curNum = Integer.parseInt(String.valueOf(drinkQuantity.getText()));
        drinkQuantity.setText("" + (curNum+1));
        curNum++;
    }

    public void onAddIngredients(View view){
        if(!ing1Name.equals("")){
            Ingredient ing1 = new Ingredient(ing1Name,curNum * ing1Amt);
            ShoppingListFragment.ingredientsShopping.add(ing1);
        }
        if(!ing2Name.equals("")){
            Ingredient ing2 = new Ingredient(ing2Name,curNum * ing2Amt);
            ShoppingListFragment.ingredientsShopping.add(ing2);
        }
        if(!ing3Name.equals("")){
            Ingredient ing3 = new Ingredient(ing3Name,curNum * ing3Amt);
            ShoppingListFragment.ingredientsShopping.add(ing3);
        }
        if(!ing4Name.equals("")){
            Ingredient ing4 = new Ingredient(ing4Name,curNum * ing4Amt);
            ShoppingListFragment.ingredientsShopping.add(ing4);
        }
        if(!ing5Name.equals("")){
            Ingredient ing5 = new Ingredient(ing5Name,curNum * ing5Amt);
            ShoppingListFragment.ingredientsShopping.add(ing5);
        }
        if(!ing6Name.equals("")){
            Ingredient ing6 = new Ingredient(ing6Name,curNum * ing6Amt);
            ShoppingListFragment.ingredientsShopping.add(ing6);
        }
        if(!ing7Name.equals("")){
            Ingredient ing7 = new Ingredient(ing7Name,curNum * ing7Amt);
            ShoppingListFragment.ingredientsShopping.add(ing7);
        }
        if(!ing8Name.equals("")){
            Ingredient ing8 = new Ingredient(ing8Name,curNum * ing8Amt);
            ShoppingListFragment.ingredientsShopping.add(ing8);
        }
        if(!ing9Name.equals("")){
            Ingredient ing9 = new Ingredient(ing9Name,curNum * ing9Amt);
            ShoppingListFragment.ingredientsShopping.add(ing9);
        }
        if(!ing10Name.equals("")){
            Ingredient ing10 = new Ingredient(ing10Name,curNum * ing10Amt);
            ShoppingListFragment.ingredientsShopping.add(ing10);
        }
        if(!ing11Name.equals("")){
            Ingredient ing11 = new Ingredient(ing11Name,curNum * ing11Amt);
            ShoppingListFragment.ingredientsShopping.add(ing11);
        }
        if(!ing12Name.equals("")){
            Ingredient ing12 = new Ingredient(ing12Name,curNum * ing12Amt);
            ShoppingListFragment.ingredientsShopping.add(ing12);
        }
        if(!ing13Name.equals("")){
            Ingredient ing13 = new Ingredient(ing13Name,curNum * ing13Amt);
            ShoppingListFragment.ingredientsShopping.add(ing13);
        }
        if(!ing14Name.equals("")){
            Ingredient ing14 = new Ingredient(ing14Name,curNum * ing14Amt);
            ShoppingListFragment.ingredientsShopping.add(ing14);
        }
        if(!ing15Name.equals("")){
            Ingredient ing15 = new Ingredient(ing15Name,curNum * ing15Amt);
            ShoppingListFragment.ingredientsShopping.add(ing15);
        }
    }
}