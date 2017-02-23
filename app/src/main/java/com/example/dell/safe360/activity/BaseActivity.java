package com.example.dell.safe360.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @version ${Rev}
 * @auther liucz
 * @time 2017/2/23 18:01
 * @des ${TODO}
 * @updateAuther ${Auther}
 * @updateDate ${Date} 18:01
 * @updateDes ${TODO}
 * Created by dell on 2017/2/23.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
