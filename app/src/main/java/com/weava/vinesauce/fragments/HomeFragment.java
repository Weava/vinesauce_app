package com.weava.vinesauce.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weava.vinesauce.R;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version Vinesauce v1.0
 * @since 3/31/15
 */
public class HomeFragment extends Fragment
{
    public HomeFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }
}
