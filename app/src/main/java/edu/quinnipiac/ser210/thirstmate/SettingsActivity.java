/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    //private ShareActionProvider shareActionProvider;
    private Spinner themeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_settings);

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        themeColor = (Spinner) findViewById(R.id.themeSpinner);
        ArrayAdapter arrayAdapter = (ArrayAdapter) themeColor.getAdapter();
        themeColor.setSelection(arrayAdapter.getPosition(themeUtils.globalTheme));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_settings,menu);
        /*
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("ingredients list");

         */
        return super.onCreateOptionsMenu(menu);
    }

    /*
    //change this method to accept list of ingredients
    public void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
    }

     */

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onThemeTestClick(View view){
        themeUtils.changeToTheme(String.valueOf(themeColor.getSelectedItem()));
        this.finish();
        this.startActivity(new Intent(this, this.getClass()));
    }

    public void onClearUserDrinks(View view) {
        new ClearDrinksTask().execute();
        Toast toast = Toast.makeText(this,"User drinks have been cleared",Toast.LENGTH_SHORT);
        toast.show();
    }

    private class ClearDrinksTask extends AsyncTask<Integer,Void,Boolean>{

        @Override
        protected Boolean doInBackground(Integer... integers) {
            SQLiteOpenHelper thirstMateDBHelper = new ThirstMateDBHelper(SettingsActivity.this);
            try{
                SQLiteDatabase db = thirstMateDBHelper.getWritableDatabase();
                db.execSQL("DELETE FROM DRINK WHERE USER_ENTERED = TRUE;");
                db.close();
                return true;
            } catch (SQLException e){
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success){
            if(!success){
                Toast toast = Toast.makeText(SettingsActivity.this,"Database unavailable",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}