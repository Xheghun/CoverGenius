package com.xheghun.covergenius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.flexbox.FlexboxLayoutManager;
import com.xheghun.covergenius.adapter.InsuranceItemAdapter;
import com.xheghun.covergenius.model.InsuranceType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyPolicyActivity extends AppCompatActivity {

    @BindView(R.id.insurance_rc)
    RecyclerView recyclerView;

    FlexboxLayoutManager layoutManager;
    List<InsuranceType> insuranceTypeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_policy);
        ButterKnife.bind(this);

        String[] title = {"Travel","Health","Auto","Life","Home","Gadget","Business","Bespoke"};
        int[] iconsRes = {R.drawable.ic_travel,R.drawable.ic_health,R.drawable.ic_auto,
                        R.drawable.ic_life,R.drawable.ic_home,R.drawable.ic_gadget,R.drawable.ic_business,R.drawable.path_ruby};

        insuranceTypeList = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            InsuranceType insuranceType = new InsuranceType();
            insuranceType.setTitle(title[i]);
            insuranceType.setIconRes(iconsRes[i]);
            insuranceTypeList.add(insuranceType);
        }

        layoutManager = new FlexboxLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new InsuranceItemAdapter(this, insuranceTypeList));
        recyclerView.setHasFixedSize(true);
    }
}
