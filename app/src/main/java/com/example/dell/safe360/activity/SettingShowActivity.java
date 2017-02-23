package com.example.dell.safe360.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dell.safe360.R;
import com.example.dell.safe360.ui.SettingItemButton;
import com.zcw.togglebutton.ToggleButton;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingShowActivity extends BaseActivity {

    @Bind(R.id.sib_setting_autoupdate)
    SettingItemButton mSibSettingAutoupdate;
    @Bind(R.id.sib_setting_test)
    SettingItemButton mSibSettingTest;
    @Bind(R.id.tb_sib_temp)
    ToggleButton mTbSibTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting_show);
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.sib_setting_autoupdate, R.id.sib_setting_test, R.id.tb_sib_temp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sib_setting_autoupdate:
                mSibSettingAutoupdate.toggle();
                break;
            case R.id.sib_setting_test:
                mSibSettingTest.toggle();
                break;
            case R.id.tb_sib_temp:
                mTbSibTemp.toggle();
                break;
        }
    }
}
