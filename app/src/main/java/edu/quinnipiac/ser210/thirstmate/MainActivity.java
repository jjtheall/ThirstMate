package edu.quinnipiac.ser210.thirstmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;
    List<Drink> drinks = new LinkedList<>();
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //attach SectionsPagerAdapter to ViewPager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        //attach ViewPager to TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        //execute async task
        drinks.clear();
        new FetchDrinksTask().execute();

        Intent intent = getIntent();
        if(intent != null){
            int drinkTab = intent.getIntExtra("tabKey",0);
            pager.setCurrentItem(drinkTab);
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

    //TODO: change this method to accept list of ingredients
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

    public ViewPager getPager(){
        return pager;
    }

    public void updateDrinks(){
        drinks.clear();
        new FetchDrinksTask().execute();
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm){super(fm);}

        @Override
        public int getCount(){
            return 4;
        }

        @Override
        public Fragment getItem(int pos){
            switch(pos){
                case 0:
                    return new HomepageFragment(drinks);
                case 1:
                    return new DrinksListFragment(drinks);
                case 2:
                    return new ShoppingListFragment();
                case 3:
                    return new CreateDrinkFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int pos){
            switch(pos){
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.drinks_tab);
                case 2:
                    return getResources().getText(R.string.shopping_tab);
                case 3:
                    return getResources().getText(R.string.create_drink_tab);
            }
            return null;
        }
    }

    private class FetchDrinksTask extends AsyncTask<Integer,Void,Boolean> {

        @Override
        protected Boolean doInBackground(Integer... integers) {
            SQLiteOpenHelper thirstMateDBHelper = new ThirstMateDBHelper(MainActivity.this);
            try{
                SQLiteDatabase db = thirstMateDBHelper.getReadableDatabase();
                Cursor cursor = db.query("DRINK", new String[]{"NAME", "IMAGE_RESOURCE_ID", "ING1", "ING1AMT",
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
                    //adapter.notifyItemInserted(drinks.size()-1);
                }
                cursor.close();
                db.close();
                return true;
            } catch (SQLException e){
                return false;
            }
        }

        protected void onPostExecute(Boolean success){
            if(!success){
                Toast toast = Toast.makeText(MainActivity.this,"Database unavailable",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}