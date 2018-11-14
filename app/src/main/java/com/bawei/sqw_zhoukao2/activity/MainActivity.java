package com.bawei.sqw_zhoukao2.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import com.bawei.sqw_zhoukao2.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText edit_name;
    private EditText edit_pwd;
    private CheckBox check_box;
    private SharedPreferences sp;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sp = getSharedPreferences("config", Context.MODE_WORLD_READABLE);
        boolean flag = sp.getBoolean("flag", false);
        check_box.setChecked(flag);
        if (flag) {
            String newName = sp.getString("name", "");
            String newPwd = sp.getString("pwd", "");
            edit_name.setText(newName);
            edit_pwd.setText(newPwd);
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_name.getText().toString();
                String pwd = edit_pwd.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "输入不能为空", 0).show();
                }else{
                    Editor editor = sp.edit();
                    if (check_box.isChecked()) {
                        editor.putBoolean("flag", true);
                        editor.putString("name", name);
                        editor.putString("pwd", pwd);
                        editor.commit();
                    }else{
                        editor.putBoolean("flag",false).commit();
                    }
                    Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        check_box = findViewById(R.id.check_box);
    }
}
