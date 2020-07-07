package cc.tanjin.wuliu.com.tanjin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Three_qhzt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int themeId = getIntent().getIntExtra("themeId",-1);
        if (themeId != -1){
            setTheme(themeId);
        }
        setContentView(R.layout.activity_three_qhzt);
    }
    public void red(View view){
        //结束自己
        finish();
        //紧挨着finsh方法或者startActivity方法就可以
        overridePendingTransition(0,0);
        //重启自己
        Intent intent = new Intent(Three_qhzt.this,Three_qhzt.class);
        //告知需要切换的主题
        intent.putExtra("themeId",R.style.AppTheme_Red);
        startActivity(intent);
        //紧挨着finsh方法或者startActivity方法就可以
        overridePendingTransition(0,0);
    }
    public void pink(View view){
        //结束自己
        finish();
        //紧挨着finsh方法或者startActivity方法就可以
        overridePendingTransition(0,0);
        //重启自己
        Intent intent = new Intent(Three_qhzt.this,Three_qhzt.class);
        //告知需要切换的主题
        intent.putExtra("themeId",R.style.AppTheme_Pink);
        startActivity(intent);
        //紧挨着finsh方法或者startActivity方法就可以
        overridePendingTransition(0,0);
    }
}
