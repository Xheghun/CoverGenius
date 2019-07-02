package com.xheghun.covergenius;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;
import com.xheghun.covergenius._interface.NavigationHost;
import com.xheghun.covergenius.fragment.InsuranceProviderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnknownActivity extends AppCompatActivity implements NavigationHost {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unknown);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(view -> {
            final Dialog dialog = new Dialog(mContext);
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.colorTrans));
            dialog.setContentView(R.layout.exit_confirmation_dialog);


            MaterialButton cancel = dialog.findViewById(R.id.dismiss_btn), continue_btn = dialog.findViewById(R.id.continue_btn);
            continue_btn.setOnClickListener(view1 -> dialog.dismiss());
            cancel.setOnClickListener(view12 -> startActivity(new Intent(mContext, HomeActivity.class)));

            dialog.show();
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new InsuranceProviderFragment())
                .commit();
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.fragment_container, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
