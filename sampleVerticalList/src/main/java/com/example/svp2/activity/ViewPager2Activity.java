package com.example.svp2.activity;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import android.os.Bundle;

import com.example.svp2.R;
import com.example.svp2.fragment.old.ArticlesFragment;
import com.example.svp2.fragment.old.PicListFragment;
import com.example.svp2.fragment.old.PicStageListFragment;
import com.example.svp2.fragment.old.SgListFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPager2Activity extends AppCompatActivity {

    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles = getResources().getStringArray(R.array.titles);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ArticlesFragment());
        fragments.add(new SgListFragment());
        fragments.add(new PicListFragment());
        fragments.add(new PicStageListFragment());

        TabLayout tabLayout = findViewById(R.id.tablayout);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setAdapter(new MyViewPagerAdapter(this, fragments));

        // 关联tablayout,添加attach方法
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(titles[position]);
                    }
                }).attach();
    }

    public static class MyViewPagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> mFragments;

        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,
                                  List<Fragment> fragments) {
            super(fragmentActivity);
            this.mFragments = fragments;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragments.size();
        }

    }
}
