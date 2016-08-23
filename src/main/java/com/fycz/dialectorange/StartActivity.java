package com.fycz.dialectorange;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        TextView versionInfo = (TextView)findViewById(R.id.version_info);
        try {
            versionInfo.setText(getVersionInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickWelcomeButton(View view){
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 获取版本名称
     * @return 返回 V + 版本名称 形式字符串
     * @throws Exception
     */
    private String getVersionName() throws Exception {
        PackageManager packageManager = getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
        return "V "+packInfo.versionName;
    }

    /**
     * 获取版本号
     * @return 返回括号括起来的版本号字符串
     * @throws Exception
     */
    private String getVersionCode() throws Exception {
        PackageManager packageManager = getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
        return "("+packInfo.versionCode+")";
    }

    /**
     * 获取版本信息
     * @return 返回版本名称及版本号字符串
     * @throws Exception
     */
    private String getVersionInfo() throws Exception{
        return getVersionName()+getVersionCode();
    }
}
