package cc.tanjin.wuliu.com.tanjin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class One_txl extends AppCompatActivity implements View.OnClickListener {
    private EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_txl);
        edt1 = (EditText) findViewById(R.id.edt1);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 获取编辑框的输入文本
        String phone = edt1.getText().toString();
        if (v.getId() == R.id.btn_call) { // 点击了直接拨号按钮
            // 拨号功能还需在AndroidManifest.xml中添加拨号权限配置
            Intent intent = new Intent(); // 创建一个新意图
            intent.setAction(Intent.ACTION_CALL); // 设置意图动作为直接拨号
            Uri uri = Uri.parse("tel:" + phone); // 声明一个拨号的Uri
            intent.setData(uri); // 设置意图前往的路径
            startActivity(intent); // 启动意图通往的活动页面
        } else if (v.getId() == R.id.btn_dial) { // 点击了准备拨号按钮
            // 拨号功能还需在AndroidManifest.xml中添加拨号权限配置
            Intent intent = new Intent(); // 创建一个新意图
            intent.setAction(Intent.ACTION_DIAL); // 设置意图动作为准备拨号
            Uri uri = Uri.parse("tel:" + phone); // 声明一个拨号的Uri
            intent.setData(uri); // 设置意图前往的路径
            startActivity(intent); // 启动意图通往的活动页面
        } else if (v.getId() == R.id.btn_sms) { // 点击了发送短信按钮
            // 发送短信还需在AndroidManifest.xml中添加发短信的权限配置
            Intent intent = new Intent(); // 创建一个新意图
            intent.setAction(Intent.ACTION_SENDTO); // 设置意图动作为发短信
            Uri uri = Uri.parse("smsto:" + phone); // 声明一个发送短信的Uri
            intent.setData(uri); // 设置意图前往的路径
            startActivity(intent); // 启动意图通往的活动页面
        }
    }
}
