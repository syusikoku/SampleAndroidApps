package com.example.svp2.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.example.svp2.R;
import com.example.svp2.databinding.LayoutItemListBinding;

import java.util.List;

public class TestLitAdapter extends BaseQuickAdapter<String,
        BaseDataBindingHolder<LayoutItemListBinding>> {

    public TestLitAdapter(List<String> data) {
        super(R.layout.layout_item_list, data);
    }


    @Override
    protected void convert(BaseDataBindingHolder<LayoutItemListBinding> holder, String s) {
        holder.getDataBinding().tvItem.setText(s);
    }
}