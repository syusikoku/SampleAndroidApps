package com.example.svp2.fragment.old;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.blankj.utilcode.util.LogUtils;
import com.example.svp2.R;
import com.example.svp2.adapter.TestLitAdapter;
import com.example.svp2.utils.RecyclerViewUtils;
import com.example.svp2.widget.SyLinearLayoutManager;
import com.example.svp2.widget.news.MyRecyclerView;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SgListFragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyRecyclerView recyclerView = rootView.findViewById(R.id.testlist);
        recyclerView.setLayoutManager(new SyLinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new TestLitAdapter(Arrays.asList(getResources().getStringArray(R.array.sg_list))));

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height = RecyclerViewUtils.measureViewHeight(recyclerView);
                LogUtils.e("SgListFragment height = " + height);

                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                layoutParams.height = height;
                recyclerView.setLayoutParams(layoutParams);
            }
        });

    }


}
