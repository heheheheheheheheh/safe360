package com.example.dell.safe360.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dell.safe360.R;
import com.example.dell.safe360.utils.MobsafeUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplanceActivity extends AppCompatActivity {

    @Bind(R.id.tv_splance_version)
    TextView mTvSplanceVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splance);
        ButterKnife.bind(this);
        initView();
        initData();
        checkServerVersion();
    }

    private void checkServerVersion() {

    }

    private void initData() {
    }

    private void initView() {
        int locationVersionCode = MobsafeUtils.getLocationVersionCode(SplanceActivity.this);
        String versionName = locationVersionCode == -1 ? "未知" : "版本:" + locationVersionCode;
        mTvSplanceVersion.setText(versionName);
    }
}
