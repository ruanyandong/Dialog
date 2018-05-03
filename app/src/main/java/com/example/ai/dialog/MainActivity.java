package com.example.ai.dialog;

import android.content.DialogInterface;
import android.graphics.Matrix;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button affirmDialog;
    Button singleDialog;
    Button multiDialog;
    Button listDialog;
    Button customDialog;


    String[] singleDialogList=new String[]{"男","女","博士","硕士"};

    String[] multiDialogList=new String[]{"篮球","足球","乒乓球","羽毛球"};

    String[] listDialogList=new String[]{"翻译","搜索","人事"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        affirmDialog=findViewById(R.id.affirm_dialog);
        affirmDialog.setOnClickListener(this);

        singleDialog=findViewById(R.id.singleDialog);
        singleDialog.setOnClickListener(this);

        multiDialog=findViewById(R.id.multiDialog);
        multiDialog.setOnClickListener(this);

        listDialog=findViewById(R.id.listDialog);
        listDialog.setOnClickListener(this);

        customDialog=findViewById(R.id.customDialog);
        customDialog.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.affirm_dialog:
                showAffirmDialog();
                break;
            case R.id.singleDialog:
                showSingleDialog();
                break;
            case R.id.multiDialog:
                showMultiDialog();
                break;
            case R.id.listDialog:
                showListDialog();
                break;
            case R.id.customDialog:
                showCustomDialog();
                break;
        }
    }

    /**
     *确认对话框
     */
    private void showAffirmDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("提示内容");

        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_LONG).show();
            }
        });


        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_LONG).show();

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    /**
     * 单选对话框
     */
    private void showSingleDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("选择性别");
        builder.setIcon(R.mipmap.ic_launcher);
        /**
         * 第一个参数是数据源，第二个参数是默认选中
         */
        builder.setSingleChoiceItems(singleDialogList, 0, new DialogInterface.OnClickListener() {
            /**
             *
             * @param dialog
             * @param which 选了哪个
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str=singleDialogList[which];
                Toast.makeText(MainActivity.this,"选了"+str,Toast.LENGTH_LONG).show();
            }
        });


        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    /**
     * 多选对话框
     */
    private void showMultiDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("爱好");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setMultiChoiceItems(multiDialogList, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
               if (isChecked){
                   Toast.makeText(MainActivity.this,"喜欢"+multiDialogList[which],Toast.LENGTH_LONG).show();

               }else{
                   Toast.makeText(MainActivity.this,"不喜欢"+multiDialogList[which],Toast.LENGTH_LONG).show();

               }
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();

        alertDialog.show();
    }

    /**
     * 列表对话框
     */
    private void showListDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("部门");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setItems(listDialogList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"选了"+listDialogList[which],Toast.LENGTH_LONG).show();

            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();

        alertDialog.show();
    }

    /**
     * 自定义对话框
     */
    private void showCustomDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自定义对话框");
        builder.setIcon(R.mipmap.ic_launcher);

        View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.custom,null);

        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();

        alertDialog.show();
    }



}
