package com.weava.vinesauce.drawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version Vinesauce v1.0
 * @since 3/31/15
 */
public class DrawerAdapter extends BaseAdapter
{
    private Context mContext;
    private ArrayList<DrawerItem> mDrawerItems;

    public DrawerAdapter(ArrayList<DrawerItem> drawerItems, Context context)
    {
        this.mContext = context;
        this.mDrawerItems = drawerItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return null;
    }

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}
