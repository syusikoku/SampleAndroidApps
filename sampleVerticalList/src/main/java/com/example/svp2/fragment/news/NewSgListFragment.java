package com.example.svp2.fragment.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.svp2.R;
import com.example.svp2.adapter.TestLitAdapter;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewSgListFragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test_n, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = rootView.findViewById(R.id.testlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TestLitAdapter(Arrays.asList(getResources().getStringArray(R.array.sg_list))));

//        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
//        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        recyclerView.setLayoutParams(layoutParams);

    }


}
