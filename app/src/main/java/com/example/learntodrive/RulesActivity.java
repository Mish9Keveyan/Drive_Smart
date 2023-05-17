package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class RulesActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    RulesViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        SpringDotsIndicator springDotsIndicator = findViewById(R.id.spring_dots_indicator);
        ImageView back= findViewById(R.id.imageRule);

        back.setOnClickListener(view -> finish());

        viewPager=findViewById(R.id.viewpager);
        adapter=new RulesViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        springDotsIndicator.setViewPager(viewPager);
    }
}