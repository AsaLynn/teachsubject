package com.example.think.mytest.month2.m2u14.viewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.think.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<View> views;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater layoutInflater = getLayoutInflater();

        views = new ArrayList<>();
        titleList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            titleList.add("Tab" + i);
            View view = layoutInflater.inflate(R.layout.layout_tab, null);
            TextView textView = view.findViewById(R.id.tv);
            textView.setText("这个页面:" + i);
            views.add(view);
        }


        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

        };
        viewPager.setAdapter(pagerAdapter);
    }
}
