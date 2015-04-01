package com.weava.vinesauce.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    private final String ITEM_HOME = "Home";
    private final String ITEM_TEAM = "The Team";
    private final String ITEM_COMMUNITY = "Community";
    private final String ITEM_TWITCH_LOGIN = "Login with Twitch";
    private final String ITEM_SETTINGS = "Settings";

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
        mNavDrawerItems = getNavDrawerItems();
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

    public ArrayList<DrawerItem> getNavDrawerItems()
    {
        String[] navDrawerTitles = getResources().getStringArray(R.array.drawer_items);
        ArrayList<DrawerItem> drawerItems = new ArrayList<>();
        DrawerItem drawerItem = null;
        for(int i = 0; i < navDrawerTitles.length; i++)
        {
            drawerItem = new DrawerItem();
            int imageResource = setImageResource(i, navDrawerTitles);
            if(imageResource != 0)
            {
                drawerItem.setIcon(imageResource);
            }
            drawerItem.setTitle(navDrawerTitles[i]);
            drawerItems.add(drawerItem);
        }
        return drawerItems;
    }

    public int setImageResource(int position, String[] drawerTitles)
    {
        int imageResource = 0;
        switch(drawerTitles[position])
        {
            case ITEM_HOME:
                if(mCurrentSelectionIndex == position)
                    imageResource = R.mipmap.ic_launcher;
                else
                    imageResource = R.mipmap.ic_launcher;
                break;
        }

        return imageResource;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch(id)
        {
            case R.id.action_settings:
                Log.d("MENU", "Action settings clicked");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
