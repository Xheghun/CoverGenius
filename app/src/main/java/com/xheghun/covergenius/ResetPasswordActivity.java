package com.xheghun.covergenius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.email_addr_layout)
    TextInputLayout emailLayout;

    @BindView(R.id.email_addr)
    TextInputEditText email_addr;

    @BindView(R.id.root)
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.login_bg));
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

    }

    @OnClick(R.id.continue_btn)
    void handleReset() {
        if (email_addr.getText() == null || TextUtils.isEmpty(email_addr.getText())) {
            emailLayout.setEnabled(true);
            emailLayout.setError("Please provide your email.");
        }else {
            emailLayout.setEnabled(false);
            emailLayout.setError("");
            Snackbar.make(view,"email sent",Snackbar.LENGTH_SHORT).show();
        }
    }
}
