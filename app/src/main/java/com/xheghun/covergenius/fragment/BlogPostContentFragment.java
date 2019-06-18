package com.xheghun.covergenius.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.xheghun.covergenius.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogPostContentFragment extends Fragment {

    @BindView(R.id.like_post_fab)
    FloatingActionButton likeFAB;

    @BindView(R.id.post_content)
    TextView post_content;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private boolean flag = true;
    private String lorem_ipsum = "Lorem ipsum dorem santoros elgando jizz... como estas mi amigo\nyo soy void tu estas?";
    private int i = 0;

    public BlogPostContentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog_post_content, container, false);
        ButterKnife.bind(this, view);

        toolbar.setNavigationOnClickListener(view12 -> getActivity().onBackPressed());

        //post_content.setText(lorem_ipsum);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (i < 5) {
                    lorem_ipsum = lorem_ipsum.concat(lorem_ipsum);
                    i++;
                }
            }
        };

        thread.start();

        post_content.setText(lorem_ipsum);

        likeFAB.setOnClickListener(view1 -> {
            if (flag) {
                likeFAB.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_fill));
                flag = false;
            } else if (!flag) {
                likeFAB.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_outlined));
                flag = true;
            }
        });
        return view;
    }
}
