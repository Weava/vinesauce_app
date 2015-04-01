package com.weava.vinesauce;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.weava.vinesauce.drawer.DrawerActivity;
import com.weava.vinesauce.fragments.HomeFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends DrawerActivity
{
    private String mTitle = "Home";

    @InjectView(R.id.main_activity_toolbar)Toolbar mToolbar;

    @Override
    protected Toolbar init()
    {
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.home_fragment_container, homeFragment);
        fragmentTransaction.commit();

        //Toolbar settings
        //mToolbar.showOverflowMenu();
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        return mToolbar;
    }
}
