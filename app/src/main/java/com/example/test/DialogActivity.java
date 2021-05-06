package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void clickCommonBtn(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("This is title")
                .setMessage("This is Message")
                .setNegativeButton("cancel", null)
                .setPositiveButton("make a toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "toast", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }

    public void clickListBtn(View view) {
        final String[] list = {"第一项", "第二项", "第三项", "第四项"};
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("The List")
                .setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                Toast.makeText(DialogActivity.this, "点击了：" + list[i], Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(DialogActivity.this, "点击了：" + list[i], Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                })
                .setNegativeButton("关闭", null)
                .show();
    }

    int score = 0;
    public void clickSingleChoiceBtn(View view) {
        final String[] list = {"一星太差了", "两星不太行", "三星一般般", "四星还不错", "五星炒鸡棒"};
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("Single Choice List")
                .setSingleChoiceItems(list, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                score = 1;
                                break;
                            case 1:
                                score = 2;
                                break;
                            case 2:
                                score = 3;
                                break;
                            case 3:
                                score = 4;
                                break;
                            case 4:
                                score = 5;
                                break;
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .setPositiveButton("提交", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "最终分数：" + score, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    ArrayList<Integer> choices = new ArrayList<Integer>();
    public void clickMultiChoicesBtn(View view) {
        final String[] list = {"选项1", "选项2", "选项3", "选项4", "选项5"};
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("Multiple Choice List")
                .setMultiChoiceItems(list, new boolean[]{false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b == true) {
                            choices.add(i);
                        } else {
                            choices.remove(i);
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .setPositiveButton("提交", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "最终选择：" + choices.toString(), Toast.LENGTH_SHORT).show();
                        choices.clear();
                    }
                })
                .show();
    }

    public void clickCustomizedCtn(View view) {
        //绑定布局的View
        LayoutInflater inflater = LayoutInflater.from(this);
        View myView = inflater.inflate(R.layout.layout_customized_dialog, null);
        //构建对话框
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(myView);
        Dialog dialog = builder.create();
        dialog.show();
//        Dialog dialog = new AlertDialog.Builder(this).setView(myView).create();
//        dialog.show();
        //按钮的点击事件
        myView.findViewById(R.id.customized_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DialogActivity.this, "自定义对话框被关掉了", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    public void clickPopupDownBtn(View view) {
        View myView = LayoutInflater.from(this).inflate(R.layout.layout_customized_dialog, null);
        PopupWindow popupWindow = new PopupWindow(myView, 600, 500);
        popupWindow.showAsDropDown(view);
        //按钮的点击事件
        myView.findViewById(R.id.customized_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DialogActivity.this, "PopupWindow被关掉了", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }

    public void clickPopupLocationBtn(View view) {
        View myView = LayoutInflater.from(this).inflate(R.layout.layout_customized_dialog, null);
        PopupWindow popupWindow = new PopupWindow(myView, 600, 500);
        popupWindow.showAtLocation(view, Gravity.CENTER, 200, 200);
        //按钮的点击事件
        myView.findViewById(R.id.customized_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DialogActivity.this, "PopupWindow被关掉了", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }

    public void clickActivityAsDialogBtn(View view) {
        Intent intent = new Intent(this, DialogWindowActivity.class);
        startActivity(intent);
    }

    public void clickDatePickerDialogBtn(View view) {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String text = "选择了: " + year + "." + (month + 1) + "." + dayOfMonth;
                        Toast.makeText(DialogActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                },
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    public void clickTimePickerDialogBtn(View view) {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String text = "选择了: " + hourOfDay + "." + minute;
                Toast.makeText(DialogActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
    }





    ProgressDialog progressDialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0: //来自转圈加载
                    progressDialog.dismiss();
                    break;
                case 1: //来自水平加载
                    progressDialog.setProgress(msg.arg1);
                    break;
                default:
            }
        }
    };

    public void showSpinnerProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("转圈圈加载");
        progressDialog.setMessage("请稍后...");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }



    public void clickProgressSpinnerBtn(View view) {
        showSpinnerProgress();
        //子线程
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(0);
            }
        }.start();
    }


    public void showHorizontalProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("水平进度条加载");
        progressDialog.setMessage("请稍后...");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(10);
        progressDialog.show();
    }

    public void clickProgressHorizontalBtn(View view){
        showHorizontalProgress();
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message = Message.obtain();
                    message.arg1 = i;
                    message.what = 1;
                    handler.sendMessage(message);
                }
            }
        }.start();
    }

    //按两次退出程序
    private long mExitTime = 0;
    @Override
    public void onBackPressed() {

        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}