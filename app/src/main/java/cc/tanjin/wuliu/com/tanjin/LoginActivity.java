package cc.tanjin.wuliu.com.tanjin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mPassword;
    private CheckBox show_password,remeber_password,auto;
    private Button mLogin;
    private Button mRegister;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        show_password = (CheckBox) findViewById(R.id.show_password);
        show_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show_password.isChecked()){
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        remeber_password = (CheckBox) findViewById(R.id.remeber_password);
        pref = getSharedPreferences("file", Context.MODE_PRIVATE);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {// 将账号和密码都设置到文本框中
            String username = pref.getString("username", "");
            String password = pref.getString("password", "");
            mUsername.setText(username);
            mPassword.setText(password);
            remeber_password.setChecked(true);
        }
        auto = (CheckBox) findViewById(R.id.auto);
        //判断自动登陆多选框状态
        if(pref.getBoolean("AUTO_ISCHECK", false)) {
            //设置默认是自动登录状态
            auto.setChecked(true);
            //跳转界面
            Intent intent = new Intent(LoginActivity.this,Main2Activity.class);
            LoginActivity.this.startActivity(intent);
        }
        //监听自动登录多选框事件
        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (auto.isChecked()) {
                    System.out.println("自动登录已选中");
                    pref.edit().putBoolean("AUTO_ISCHECK", true).commit();
                } else {
                    System.out.println("自动登录没有选中");
                    pref.edit().putBoolean("AUTO_ISCHECK", false).commit();
                }
            }
        });
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.register);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String userName = mUsername.getText().toString().trim();
                String passWord = mPassword.getText().toString().trim();
                if (userName.equals("")||passWord.equals("")){
                    Toast.makeText(LoginActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }

                UserService userService = new UserService(LoginActivity.this);

                boolean flag = userService.Login(userName, passWord);
                if (flag) {
                    editor = pref.edit();
                    if (remeber_password.isChecked()){
                        editor.putBoolean("remember_password", true);
                        editor.putString("username", userName);
                        editor.putString("password", passWord);
                    } else {
                        editor.clear();
                    }
                    editor.commit();
                    /*Toast.makeText(LoginActivity.this, "登录成功！",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();*/
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setMessage("正在登录...");
                    progressDialog.show();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                            returnlogin();
                        }
                    }).start();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！",
                            Toast.LENGTH_SHORT).show();
                }
            }

            private void returnlogin() {
                Intent intent = new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
