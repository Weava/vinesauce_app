package com.weava.vinesauce.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.weava.vinesauce.R;

import java.util.ArrayList;

import butterknife.InjectView;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version Vinesauce v1.0
 * @since 3/31/15
 */
public abstract class DrawerActivity extends ActionBarActivity
{

    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private CharSequence mTitle;
    private ArrayList<DrawerItem> mNavDrawerItems;
    private Context mContext = this;
    private DrawerAdapter mNavDrawerAdapter;

    private static int mCurrentSelectionIndex = 1;

    abstract protected Toolbar init();

    @InjectView(R.id.nav_drawer_layout)DrawerLayout mDrawerLayout;
    @InjectView(R.id.left_drawer)ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Init sets content view and
        other specifics based on activity implementation */
        mToolbar = init();

        mTitle = mToolbar.getTitle();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //mNavDrawerItems = getNavDrawerItems();
        mNavDrawerAdapter = new DrawerAdapter(mNavDrawerItems, this);
        mDrawerList.setAdapter(mNavDrawerAdapter);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_closed
        ) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintColor(this.getResources().getColor(R.color.status_bar_color));
        tintManager.setStatusBarTintEnabled(true);

        //mDrawerList.setItemChecked(this.mCurrentSelectionIndex, true);
    }
}
