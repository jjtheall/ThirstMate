package edu.quinnipiac.ser210.thirstmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SQLiteOpenHelper ThirstMateDBHelper = new ThirstMateDBHelper(this);
        SQLiteDatabase db = ThirstMateDBHelper.getWritableDatabase();
        db.close();
    }

    public void onSplashButtonPressed(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}