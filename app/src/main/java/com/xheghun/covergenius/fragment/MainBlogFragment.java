package com.xheghun.covergenius.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.adapter.BlogPostRecyclerAdapter;
import com.xheghun.covergenius.model.BlogPostItemData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainBlogFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.posts_rc)
    RecyclerView recyclerView;
    List<BlogPostItemData> blogPostItemDataList;
    LinearLayoutManager linearLayoutManager;

    private boolean flag = true;

    public MainBlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_blog, container, false);
        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        ButterKnife.bind(this, view);

        toolbar.setNavigationOnClickListener(view1 -> Objects.requireNonNull(getActivity()).onBackPressed());

        String title = "New CEO";
        String post = "Hank Pym Announced as the new CEO of Pied Piper, the billion dollar compression company which started as a mere music app";
        String date = "17 may 2020";
        String author = "Mark Helios";
        int img = R.drawable.profile_img;

        blogPostItemDataList = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            BlogPostItemData blogPostItem = new BlogPostItemData();
            blogPostItem.setTitle(title);
            blogPostItem.setText(post.substring(0, 55) + "...");
            blogPostItem.setDate(date);
            blogPostItem.setAuthor(author);
            blogPostItem.setImg(img);
            blogPostItemDataList.add(blogPostItem);
        }


        DividerItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.black_line));
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(new BlogPostRecyclerAdapter(getContext(), blogPostItemDataList, 2));
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

}
