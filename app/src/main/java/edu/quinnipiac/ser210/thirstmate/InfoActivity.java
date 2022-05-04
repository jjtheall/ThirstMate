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

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class InfoActivity extends AppCompatActivity {
    //private ShareActionProvider shareActionProvider;
    private ImageView nipBottle;
    private ImageView fifthBottle;
    private ImageView literBottle;
    private ImageView handleBottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_info);

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nipBottle = (ImageView) this.findViewById(R.id.nipBottle);
        fifthBottle = (ImageView) this.findViewById(R.id.fifthBottle);
        literBottle = (ImageView) this.findViewById(R.id.literBottle);
        handleBottle = (ImageView) this.findViewById(R.id.handleBottle);

        nipBottle.setImageResource(R.drawable.bottle);
        fifthBottle.setImageResource(R.drawable.bottle);
        literBottle.setImageResource(R.drawable.bottle);
        handleBottle.setImageResource(R.drawable.bottle);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_info,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
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
}