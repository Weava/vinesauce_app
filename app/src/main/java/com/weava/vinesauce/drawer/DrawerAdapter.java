package com.weava.vinesauce.drawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.weava.vinesauce.R;

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
    public int getCount()
    {
        return mDrawerItems.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = View.inflate(mContext, R.layout.drawer_list_item, null);

        TextView itemText = (TextView) view.findViewById(R.id.nav_drawer_text);
        ImageView itemIcon = (ImageView) view.findViewById(R.id.drawer_icon);

        itemText.setText(mDrawerItems.get(position).getTitle());
        if(mDrawerItems.get(position).getIcon() > 0)
        {
            itemIcon.setImageResource(mDrawerItems.get(position).getIcon());
        }

        return view;
    }
}
