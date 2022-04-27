package edu.quinnipiac.ser210.thirstmate;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ThirstMateDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "thirstmate";
    private static final int DB_VERSION = 1;

    ThirstMateDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        updateMyDatabase(sqLiteDatabase,0,DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        updateMyDatabase(sqLiteDatabase,oldVersion,newVersion);
    }

    private static void insertDrink(SQLiteDatabase db, String name, int imageResourceId, String ing1, double ing1amt, String ing2,
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
        db.insert("DRINK",null,drinkValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "IMAGE_RESOURCE_ID INTEGER, " +
                    "ING1 TEXT, " +
                    "ING1AMT REAL, " +
                    "ING2 TEXT, " +
                    "ING2AMT REAL, " +
                    "ING3 TEXT, " +
                    "ING3AMT REAL, " +
                    "ING4 TEXT, " +
                    "ING4AMT REAL, " +
                    "ING5 TEXT, " +
                    "ING5AMT REAL, " +
                    "ING6 TEXT, " +
                    "ING6AMT REAL, " +
                    "ING7 TEXT, " +
                    "ING7AMT REAL, " +
                    "ING8 TEXT, " +
                    "ING8AMT REAL, " +
                    "ING9 TEXT, " +
                    "ING9AMT REAL, " +
                    "ING10 TEXT, " +
                    "ING10AMT REAL, " +
                    "ING11 TEXT, " +
                    "ING11AMT REAL, " +
                    "ING12 TEXT, " +
                    "ING12AMT REAL, " +
                    "ING13 TEXT, " +
                    "ING13AMT REAL, " +
                    "ING14 TEXT, " +
                    "ING14AMT REAL, " +
                    "ING15 TEXT, " +
                    "ING15AMT REAL) ;"
            );

            insertDrink(db,"Rum and Coke",R.drawable.cocktail,"Rum",45.0,"Coke",
                    90.0,"Ice",0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,
                    0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0);
            insertDrink(db,"Blue Hawaiian",R.drawable.cocktail,"Rum",30.0,
                    "Blue Curacao",15.0,"Coconut Cream",15.0,"Pineapple Juice",
                    60.0,"Ice",0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,
                    0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0);
            insertDrink(db,"Vodka Cranberry",R.drawable.cocktail,"Vodka",60.0,
                    "Cranberry Juice",90.0,"Ice",0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,
                    0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,0.0);
            insertDrink(db,"Bay Breeze",R.drawable.cocktail,"Vodka",60.0,
                    "Cranberry Juice",90.0,"Pineapple Juice",90.0,"Ice",
                    0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,
                    0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0);
            insertDrink(db,"Tequila Sunrise",R.drawable.cocktail,"Tequila",45.0,
                    "Orange Juice",90.0,"Grenadine",15.0,"Ice",0.0,
                    null,0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,
                    0.0,null,0.0,null,0.0,null,0.0);
            insertDrink(db,"Margarita",R.drawable.cocktail,"Tequila",35.0,"Cointreau",
                    20.0,"Lime Juice",15.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,0.0,
                    null,0.0,null,0.0,null,0.0,null,
                    0.0,null,0.0,null,0.0);

        }
        if(oldVersion < 2){
            //add extra column
        }
    }
}
