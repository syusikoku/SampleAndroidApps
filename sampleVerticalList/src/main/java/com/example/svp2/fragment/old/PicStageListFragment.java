package com.example.svp2.fragment.old;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.example.svp2.R;
import com.example.svp2.databinding.LayoutImgItemBinding;
import com.example.svp2.utils.DataUtils;
import com.example.svp2.utils.GlideUtils;
import com.example.svp2.utils.RecyclerViewUtils;
import com.example.svp2.widget.news.MyRecyclerView;

import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class PicStageListFragment extends Fragment {

    private View rootView;
    private Context mCtx;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mCtx = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_stage_imglist, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyRecyclerView recyclerView = rootView.findViewById(R.id.testlist);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setAdapter(new ImgListAdapter(mCtx, DataUtils.imgUrls().subList(10, 18)));
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(mCtx).resumeRequests();
                } else {
                    Glide.with(mCtx).pauseAllRequests();
                }
            }
        });
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height = RecyclerViewUtils.measureViewHeight(recyclerView);
                LogUtils.e("PicStageListFragment height = " + height);

//                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
//                layoutParams.height = height;
//                recyclerView.setLayoutParams(layoutParams);
            }
        });
    }

    public static class ImgListAdapter extends BaseQuickAdapter<String,
            BaseDataBindingHolder<LayoutImgItemBinding>> {

        private final Random random;
        private final Context mCtx;
        private int lastPos = 0;

        public ImgListAdapter(Context ctx, List<String> data) {
            super(R.layout.layout_img_item, data);
            this.mCtx = ctx;
            random = new Random();
        }

        @Override
        protected void convert(BaseDataBindingHolder<LayoutImgItemBinding> holder, String s) {
            int npos = random.nextInt(getData().size() - 1);
            while (npos == lastPos) {
                npos = random.nextInt(getData().size() - 1);
            }
            ImageView imageView = holder.getDataBinding().ivImg;
            GlideUtils.loadImgWithAutoHeight(mCtx, imageView, getData().get(npos));

            lastPos = npos;
        }
    }


}
