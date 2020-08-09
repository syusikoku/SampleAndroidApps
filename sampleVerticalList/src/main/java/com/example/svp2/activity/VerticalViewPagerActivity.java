package com.example.svp2.activity;

import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;

import com.example.svp2.R;
import com.example.svp2.fragment.news.NewArticlesFragment;
import com.example.svp2.fragment.news.NewPicListFragment;
import com.example.svp2.fragment.news.NewPicStageListFragment;
import com.example.svp2.fragment.news.NewSgListFragment;
import com.example.svp2.widget.MyVerticalViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class VerticalViewPagerActivity extends AppCompatActivity {
    private String[] titles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_vertical_vp);

        initView();
    }

    private void initView() {
        MyVerticalViewPager verticalViewPager = findViewById(R.id.myviewpagers);
        TabLayout tabLayout = findViewById(R.id.tablayout);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewArticlesFragment());
        fragments.add(new NewSgListFragment());
        fragments.add(new NewPicListFragment());
        fragments.add(new NewPicStageListFragment());

        titles = getResources().getStringArray(R.array.titles);

        verticalViewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(), fragments,
                titles));

        verticalViewPager.setOffscreenPageLimit(3);

        tabLayout.setupWithViewPager(verticalViewPager);
    }

    public static class MainPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mList;
        private final String[] mTitles;

        public MainPageAdapter(@NonNull FragmentManager fm, List<Fragment> fragments,
                               String[] titles) {
            super(fm);
            this.mList = fragments;
            this.mTitles = titles;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
