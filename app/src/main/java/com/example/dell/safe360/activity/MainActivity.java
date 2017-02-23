package com.example.dell.safe360.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.dell.safe360.R;
import com.example.dell.safe360.adapter.GridViewAdapter;
import com.example.dell.safe360.bean.ItemMain;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.iv_main_icon)
    ImageView mIvMainIcon;
    @Bind(R.id.iv_main_setting)
    ImageView mIvMainSetting;
    @Bind(R.id.gv_main_items_show)
    GridView mGvMainItemsShow;
    private ArrayList<ItemMain> mItemShows = new ArrayList<>();
    int[] icons = {R.drawable.sjfd, R.drawable.srlj, R.drawable.rjgj,
            R.drawable.jcgl, R.drawable.lltj, R.drawable.sjsd, R.drawable.hcql,
            R.drawable.cygj};
    String[] mTitles = {"手机防盗", "骚扰拦截", "软件管家", "进程管理", "流量统计", "手机杀毒",
            "缓存管理", "常用工具"};
    String[] mContents = {"远程定位手机", "全面拦截骚扰", "管理您的软件", "管理运行进程", "流量一目了然",
            "病毒远处藏身", "系统快如火箭", "工具大全"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initEvent();//初始化点击事件
        initData();
    }

    private void initData() {
        //初始化头像的动画
        initIconAnim();
        //初始化gridView
        InitGridView();
    }

    private void InitGridView() {
        mItemShows.clear();
        for (int i = 0; i < icons.length; i++) {
            ItemMain itemMain = new ItemMain();
            itemMain.icon = icons[i];
            itemMain.title = mTitles[i];
            itemMain.content = mContents[i];
            mItemShows.add(itemMain);
        }
        mGvMainItemsShow.setAdapter(new GridViewAdapter(MainActivity.this,mItemShows));
    }

    private void initIconAnim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        mIvMainIcon.setAnimation(animation);
        animation.start();
        /*ViewCompat.animate(mIvMainIcon)
                .scaleX(0.5F)
                .scaleY(0.5F)
                .rotation(360)
                .setDuration(1000)
                .start();*/
    }

    private void initEvent() {
        mIvMainSetting.setOnClickListener(this);
        mGvMainItemsShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_main_setting:
                startActivity(new Intent(MainActivity.this, SettingShowActivity.class));
                break;
        }
    }
}
