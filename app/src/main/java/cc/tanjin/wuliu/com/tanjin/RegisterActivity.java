package cc.tanjin.wuliu.com.tanjin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mPassword;
    private EditText mPassword2;
    private CheckBox show,show1;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        mUsername = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);
        mPassword2 = (EditText)findViewById(R.id.password2);
        show = (CheckBox) findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show.isChecked()){
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        show1 = (CheckBox) findViewById(R.id.show1);
        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show1.isChecked()){
                    mPassword2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    mPassword2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        mRegister = (Button)findViewById(R.id.register);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUsername.getText().toString().trim();
                String passWord = mPassword.getText().toString().trim();
                String passWord2 = mPassword2.getText().toString().trim();

                if (userName.isEmpty() || passWord.isEmpty() || passWord2.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"不能有空，请输入",Toast.LENGTH_LONG).show();
                    return;
                }

                Log.i("TAG", userName);
                Log.i("TAG", passWord);

                User user = new User();
                user.setUsername(userName);
                user.setPassword(passWord);

                System.out.println(user.getUsername());
                System.out.println(user.getPassword());

                UserService userService = new UserService(getBaseContext());
                boolean flag = userService.Register(user);
                if (flag && passWord.equals(passWord2)) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "注册失败,密码不一致，请重输", Toast.LENGTH_SHORT).show();
                    mPassword.setText("");
                    mPassword2.setText("");
                }
            }
        });
    }
}
