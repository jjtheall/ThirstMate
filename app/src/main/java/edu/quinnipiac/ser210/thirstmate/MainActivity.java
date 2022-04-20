package edu.quinnipiac.ser210.thirstmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //attach SectionsPagerAdapter to ViewPager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        //attach ViewPager to TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
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
                    return new HomepageFragment();
                case 1:
                    return new DrinksListFragment();
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
}