package com.xheghun.covergenius.adapter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.UnknownActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        startActivity(new Intent(this, UnknownActivity.class));

    }
}
