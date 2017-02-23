package com.example.dell.safe360.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dell.safe360.HttpApi;
import com.example.dell.safe360.R;
import com.example.dell.safe360.bean.ServerVersionInfo;
import com.example.dell.safe360.utils.MobsafeUtils;
import com.example.dell.safe360.utils.RetrofitUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplanceActivity extends AppCompatActivity {

    @Bind(R.id.tv_splance_version)
    TextView mTvSplanceVersion;
    private int mLocationVersionCode;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    installApk((File) msg.obj);
                    break;
            }
        }
    };

    private void installApk(File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splance);
        ButterKnife.bind(this);
        initView();
        checkServerVersion();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                gotoMain();
            }
        }).start();
    }

    private void checkServerVersion() {
        RetrofitUtil.createHttpApiInstance().checkVersion().enqueue(new Callback<ServerVersionInfo>() {
            @Override
            public void onResponse(Call<ServerVersionInfo> call, Response<ServerVersionInfo> response) {
                ServerVersionInfo serverVersionInfo = response.body();
                if (serverVersionInfo == null || serverVersionInfo.versioncode == mLocationVersionCode) {
                } else {
                    showVersionDialog(serverVersionInfo.downurl);
                }
            }

            @Override
            public void onFailure(Call<ServerVersionInfo> call, Throwable t) {
            }
        });
    }

    private void showVersionDialog(final String downurl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("版本更新")
                .setMessage("为我带盐版本")
                .setCancelable(false)
                .setNegativeButton("立刻升级", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        downAPK(downurl);
                    }
                })
                .setPositiveButton("稍后再说", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    private void downAPK(String downurl) {
        new Retrofit
                .Builder()
                .baseUrl(downurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HttpApi.class)
                .download()
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        final String savePath = Environment.getExternalStorageDirectory() + File.separator + "downloadFromServer.flv";
                        final ResponseBody body = response.body();
                        long total = body.contentLength();
                        final InputStream inputStream = body.byteStream();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                                    File file = new File(Environment.getExternalStorageDirectory(), "mobsafe.apk");
                                    try {
                                        FileOutputStream fos = new FileOutputStream(file);
                                        byte[] bytes = new byte[1024];
                                        int len = -1;
                                        while ((len = inputStream.read(bytes)) != -1) {
                                            fos.write(bytes, 0, len);
                                        }
                                        fos.close();
                                        inputStream.close();
                                        Message message = Message.obtain();
                                        message.what = 1;
                                        message.obj = file;
                                        mHandler.sendMessage(message);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        gotoMain();
                                    }
                                } else {
                                    gotoMain();
                                }
                            }
                        }).start();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        gotoMain();
                    }
                });
    }

    private void gotoMain() {
        startActivity(new Intent(SplanceActivity.this, MainActivity.class));
    }

    private void initView() {
        mLocationVersionCode = MobsafeUtils.getLocationVersionCode(SplanceActivity.this);
        String versionName = mLocationVersionCode == -1 ? "未知" : "版本:" + mLocationVersionCode;
        mTvSplanceVersion.setText(versionName);
    }
}
