package com.example.gsyplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsyplayer.entry.TestEntry;

import java.util.List;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.TestViewHolder> {
    private final Context mCtx;
    private final List<TestEntry> mList;
    private final LayoutInflater layoutInflater;

    public TestListAdapter(Context context, List<TestEntry> _list) {
        this.mCtx = context;
        this.mList = _list;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestViewHolder(layoutInflater.inflate(R.layout.layout_item_tstlist, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.tvTitle.setText(mList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item);
        }
    }
}
