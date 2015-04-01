package com.weava.vinesauce.drawer;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version Vinesauce v1.0
 * @since 3/31/15
 */
public class DrawerItem
{
    private String mTitle;
    private int mIcon;

    public DrawerItem()
    {

    }

    public DrawerItem(String title, int draw)
    {
        this.mTitle = title;
        this.mIcon = draw;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String mTitle)
    {
        this.mTitle = mTitle;
    }

    public int getIcon()
    {
        return mIcon;
    }

    public void setIcon(int mIcon)
    {
        this.mIcon = mIcon;
    }
}
