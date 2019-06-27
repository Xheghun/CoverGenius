package com.xheghun.covergenius.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.adapter.EditProfileActivity;
import com.xheghun.covergenius.adapter.ExpandableListAdapter;
import com.xheghun.covergenius.classes.DataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment {

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;

    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root_view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, root_view);

        expandableListDetail = DataPump.getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(i -> Toast.makeText(getContext(),
                expandableListTitle.get(i) + " List Expanded.",
                Toast.LENGTH_SHORT).show());

        expandableListView.setOnGroupCollapseListener(i -> Toast.makeText(getContext(),
                expandableListTitle.get(i) + " List Collapsed.",
                Toast.LENGTH_SHORT).show());

        expandableListView.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
            Toast.makeText(
                    getContext(),
                    expandableListTitle.get(i)
                            + " -> "
                            + expandableListDetail.get(
                            expandableListTitle.get(i)).get(
                            i1), Toast.LENGTH_SHORT
            ).show();
            return false;
        });
        return root_view;
    }

    @OnClick(R.id.edit_profile_btn)
    void gotoEditProfile() {
        startActivity(new Intent(getContext(), EditProfileActivity.class));
    }
}
