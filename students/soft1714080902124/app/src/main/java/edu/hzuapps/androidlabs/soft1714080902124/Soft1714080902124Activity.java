package edu.hzuapps.androidlabs.soft1714080902124;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myfirstapp.R;


public class Soft1714080902124Activity extends AppCompatActivity {


    private Button button;
    private Button button_search;
//    private Button title_function;
    private Button edit_pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1714080902124_activity);
        ActionBar actionBar = getSupportActionBar();    //标题框
        if (actionBar != null) {
            actionBar.hide();
        }

        button = (Button) findViewById(R.id.button);         //列表页面
        button_search = (Button) findViewById(R.id.search_btn); //搜索
        edit_pas = (Button) findViewById(R.id.edit_pass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Soft1714080902124Activity.this, MyListView.class);
                startActivity(i);
            }
        });
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Soft1714080902124Activity.this, SearchActivity.class);
                startActivity(i);
            }
        });

//        title_function = (Button) findViewById(R.id.title_function);
//        title_function.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Soft1714080902124Activity.this,Lock.class);
//                startActivity(i);
//            }
//        });
        edit_pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Soft1714080902124Activity.this,AlertPassword.class);
                startActivity(i);
            }
        });

        if(!isConn(getApplicationContext())){
            setNetworkMethod(Soft1714080902124Activity.this);
        }
    }

    public static boolean isConn(Context context){
        boolean bisConnFlag=false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if(network!=null){
            bisConnFlag=conManager.getActiveNetworkInfo().isAvailable();
        }
        return bisConnFlag;
    }


    /*没有网络跳转到网络设置页面
     * 打开设置网络界面
     * */
    public static void setNetworkMethod(final Context context){
        //提示对话框
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("网络设置提示").setMessage("网络连接不可用,是否进行设置?").setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent intent=null;
                //判断手机系统的版本 即API大于10 就是3.0或以上版本
                if(Build.VERSION.SDK_INT>10){
                    intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                }else{
                    intent = new Intent();
                    ComponentName component = new ComponentName("com.android.settings","com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                context.startActivity(intent);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).show();
    }
}
