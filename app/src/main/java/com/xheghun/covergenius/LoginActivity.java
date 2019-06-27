package com.xheghun.covergenius;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.login_bg));
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @OnClick(R.id.register_btn)
    void gotoRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @OnClick(R.id.login_btn)
    void HandleLogin() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @OnClick(R.id.reset_pass_btn)
    void gotoRSPass(){
        startActivity(new Intent(this,ResetPasswordActivity.class));
    }
}
