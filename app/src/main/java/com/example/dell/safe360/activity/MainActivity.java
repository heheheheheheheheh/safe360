package com.example.dell.safe360.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.safe360.R;
import com.example.dell.safe360.adapter.GridViewAdapter;
import com.example.dell.safe360.bean.ItemMain;
import com.example.dell.safe360.utils.Fields;
import com.example.dell.safe360.utils.SPUtils;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements View.OnClickListener {
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
    private EditText mEtDialogSettingPwd01;
    private EditText mEtDialogSettingPwd02;
    private AlertDialog mDialog;
    private Button mBt_dialog_check_pwd_ok;
    private Button mBt_dialog_check_pwd_cancel;
    private AlertDialog mDialog1;
    private EditText mEt_dialog_check_pwd_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
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
        mGvMainItemsShow.setAdapter(new GridViewAdapter(MainActivity.this, mItemShows));
    }

    private void initIconAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mIvMainIcon, "rotationY", 0f, 90f, 180f, 270f, 360f);
        animator.setRepeatCount(ObjectAnimator.INFINITE);//无限循环
        animator.setRepeatMode(ObjectAnimator.REVERSE);//反转
        animator.setDuration(3000);//3秒
        animator.start();
        /*Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        mIvMainIcon.setAnimation(animation);
        animation.start();*/
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
                switch (i) {
                    case 0:
                        enterSJFD();
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

    private void enterSJFD() {
        String pwdString = SPUtils.getString(MainActivity.this, Fields.SJFDPWD);

        if (pwdString.equals("")) {
            //弹出设置密码对话框
            showSettingPwdDialog();

        } else {
            showCheckPwdDialog();
            enterSJFDSetting();
        }
    }

    private void enterSJFDSetting() {
        startActivity(new Intent(getApplicationContext(), SJFD01Activity.class));
    }

    private void showCheckPwdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = View.inflate(MainActivity.this, R.layout.dialog_check_pwd, null);
        builder.setView(view);
        //显示
        mDialog1 = builder.show();
        //找到控件
        mEt_dialog_check_pwd_01 = (EditText) view.findViewById(R.id.et_dialog_check_pwd_01);
        mBt_dialog_check_pwd_ok = (Button) view.findViewById(R.id.bt_dialog_check_pwd_ok);
        mBt_dialog_check_pwd_cancel = (Button) view.findViewById(R.id.bt_dialog_check_pwd_cancel);
        mBt_dialog_check_pwd_ok.setOnClickListener(this);
        mBt_dialog_check_pwd_cancel.setOnClickListener(this);
    }

    private void showSettingPwdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = View.inflate(this, R.layout.dialog_setting_pwd, null);
        mDialog = builder.setView(view).show();
        mEtDialogSettingPwd01 = (EditText) view.findViewById(R.id.et_dialog_setting_pwd_01);
        mEtDialogSettingPwd02 = (EditText) view.findViewById(R.id.et_dialog_setting_pwd_02);
        Button bt_dialog_setting_pwd_ok = (Button) view.findViewById(R.id.bt_dialog_setting_pwd_ok);
        Button bt_dialog_setting_pwd_cancel = (Button) view.findViewById(R.id.bt_dialog_setting_pwd_cancel);
        bt_dialog_setting_pwd_ok.setOnClickListener(this);
        bt_dialog_setting_pwd_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_main_setting:
                startActivity(new Intent(MainActivity.this, SettingShowActivity.class));
                break;
            case R.id.bt_dialog_setting_pwd_ok:
                String pwd01 = mEtDialogSettingPwd01.getText().toString();
                String pwd02 = mEtDialogSettingPwd02.getText().toString();
                //两个密码都必须要有
                /**
                 * 两个有一个为空
                 */
                if (TextUtils.isEmpty(pwd01) || TextUtils.isEmpty(pwd02)) {
                    Toast.makeText(MainActivity.this, "亲,您的密码呢", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.equals(pwd01, pwd02)) {
                        //保存密码
                        SPUtils.saveString(getApplicationContext(), Fields.SJFDPWD, pwd01);
                        //关闭
                        mDialog.dismiss();
                        //进入设置页面
                        enterSJFDSetting();
                    } else {
                        //提示用户
                        Toast.makeText(getApplicationContext(), "亲,您密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.bt_dialog_setting_pwd_cancel:
                mDialog.dismiss();
                break;
            case R.id.bt_dialog_check_pwd_ok:
                String sp_pwd = SPUtils.getString(MainActivity.this, Fields.SJFDPWD);
                //验证跟我们输入密码是否一致
                String enter_pwd = mEt_dialog_check_pwd_01.getText().toString();

                //密码验证
                if (TextUtils.equals(sp_pwd, enter_pwd)) {
                    //两个一致
                    //关闭
                    mDialog1.dismiss();
                    //进入手机防盗设置
                    enterSJFDSetting();
                }else {
                    Toast.makeText(MainActivity.this, "亲,您密码记了吗,请找管理员", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_dialog_check_pwd_cancel:
                mDialog1.dismiss();
                break;
        }
    }
}
