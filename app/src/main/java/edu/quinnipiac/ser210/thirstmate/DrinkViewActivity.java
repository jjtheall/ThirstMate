package edu.quinnipiac.ser210.thirstmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkViewActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_view);

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
        double ing1Amt = intent.getDoubleExtra(EXTRA_INGAMT + "0",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "1") != null){
            ing2Name = intent.getStringExtra(EXTRA_INGNAME + "1");
        }
        double ing2Amt = intent.getDoubleExtra(EXTRA_INGAMT + "1",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "2") != null){
            ing3Name = intent.getStringExtra(EXTRA_INGNAME + "2");
        }
        double ing3Amt = intent.getDoubleExtra(EXTRA_INGAMT + "2",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "3") != null){
            ing4Name = intent.getStringExtra(EXTRA_INGNAME + "3");
        }
        double ing4Amt = intent.getDoubleExtra(EXTRA_INGAMT + "3",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "4") != null){
            ing5Name = intent.getStringExtra(EXTRA_INGNAME + "4");
        }
        double ing5Amt = intent.getDoubleExtra(EXTRA_INGAMT + "4",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "5") != null){
            ing6Name = intent.getStringExtra(EXTRA_INGNAME + "5");
        }
        double ing6Amt = intent.getDoubleExtra(EXTRA_INGAMT + "5",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "6") != null){
            ing7Name = intent.getStringExtra(EXTRA_INGNAME + "6");
        }
        double ing7Amt = intent.getDoubleExtra(EXTRA_INGAMT + "6",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "7") != null){
            ing8Name = intent.getStringExtra(EXTRA_INGNAME + "7");
        }
        double ing8Amt = intent.getDoubleExtra(EXTRA_INGAMT + "7",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "8") != null){
            ing9Name = intent.getStringExtra(EXTRA_INGNAME + "8");
        }
        double ing9Amt = intent.getDoubleExtra(EXTRA_INGAMT + "8", 0);

        if(intent.getStringExtra(EXTRA_INGNAME + "9") != null){
            ing10Name = intent.getStringExtra(EXTRA_INGNAME + "9");
        }
        double ing10Amt = intent.getDoubleExtra(EXTRA_INGAMT + "9",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "10") != null){
            ing11Name = intent.getStringExtra(EXTRA_INGNAME + "10");
        }
        double ing11Amt = intent.getDoubleExtra(EXTRA_INGAMT + "10",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "11") != null){
            ing12Name = intent.getStringExtra(EXTRA_INGNAME + "11");
        }
        double ing12Amt = intent.getDoubleExtra(EXTRA_INGAMT + "11",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "12") != null){
            ing13Name = intent.getStringExtra(EXTRA_INGNAME + "12");
        }
        double ing13Amt = intent.getDoubleExtra(EXTRA_INGAMT + "12",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "13") != null){
            ing14Name = intent.getStringExtra(EXTRA_INGNAME + "13");
        }
        double ing14Amt = intent.getDoubleExtra(EXTRA_INGAMT + "13",0);

        if(intent.getStringExtra(EXTRA_INGNAME + "14") != null){
            ing15Name = intent.getStringExtra(EXTRA_INGNAME + "14");
        }
        double ing15Amt = intent.getDoubleExtra(EXTRA_INGAMT + "14",0);


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
}