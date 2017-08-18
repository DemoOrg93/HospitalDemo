package com.prakriti.finaldemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Prakriti on 11/08/2017.
 */

public class Facilitiesadapter extends BaseExpandableListAdapter {
    private Context context;
    Typeface typeface;

    static String []parentList = {"Facilities","Services"};
    static String [][]childList = {
            {
                    "General","OPD","MICU","Surgery","ICU"
            },
            {
                    "XRAY","CT","MRT","LAB"
            },


    };

    public Facilitiesadapter(Context context) {
        // TODO Auto-generated constructor stub
        this.context=context;
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return parentList.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return childList[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // typeface=Typeface.createFromAsset(context.getAssets());
        TextView tv = new TextView(context);
        tv.setText(parentList[groupPosition]);
        tv.setPadding(45, 10, 10, 10);
        tv.setTextSize(18);
        tv.setTextColor(Color.BLACK);

        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
//        typeface=Typeface.createFromAsset(context.getAssets(),"fonts/KGTribecaStamp.ttf");
        TextView tv = new TextView(context);
        tv.setText(childList[groupPosition][childPosition]);
        tv.setPadding(60, 10, 10, 10);
        tv.setGravity(30);
        tv.setTextSize(15);
        tv.setTextColor(Color.BLACK);
        // tv.setTypeface(typeface);
        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

}