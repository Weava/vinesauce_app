package com.weava.vinesauce;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.weava.vinesauce.drawer.DrawerActivity;
import com.weava.vinesauce.fragments.HomeFragment;

import butterknife.ButterKnife;


public class HomeActivity extends DrawerActivity
{
    private Toolbar mToolbar;
    private String mTitle = "Home";

    @Override
    protected Toolbar init()
    {
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        //init achievements

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.home_fragment_container, homeFragment);
        fragmentTransaction.commit();

        //Toolbar settings
        //mToolbar.showOverflowMenu();
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        /*
            Testing sugar for achievements
         */
        Log.d("NAV_DRAWER", "Activating nav drawer activity");
        return mToolbar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
