package com.xheghun.covergenius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.login_bg));
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();});
    }
}
