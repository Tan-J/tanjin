package cc.tanjin.wuliu.com.tanjin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Two_xzcx extends AppCompatActivity {
    private EditText edt_name,edt_year,edt_month,edt_day;
    private TextView text;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_xzcx);
        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_year = (EditText)findViewById(R.id.edt_year);
        edt_month= (EditText)findViewById(R.id.edt_month);
        edt_day = (EditText)findViewById(R.id.edt_day);
        text = (TextView)findViewById(R.id.text);
        img = (ImageView)findViewById(R.id.img);
    }

    public void onSearch(View v){
        String name = edt_name.getText().toString();
        String year = edt_year.getText().toString();
        String month = edt_month.getText().toString();
        String day = edt_day.getText().toString();
        if (name.isEmpty() || year.isEmpty() || month.isEmpty() || day.isEmpty()){
            Toast.makeText(this,"内容不能有空值",Toast.LENGTH_LONG).show();
            return;
        }
        int month1 = Integer.valueOf(month);
        int day1 = Integer.valueOf(day);
        //aquarius 水瓶座1月20日-2月18日
        if ((month1 == 1 && day1 >=20 && day1 <=31) || (month1 == 2 && day1 >=1 && day1 <=18)){
            img.setImageResource(R.mipmap.aquarius);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.aquarius));
        }//pisces 双鱼座2月19日-3月20日
        else if ((month1 == 2 && day1 >=19 && day1 <=28) || (month1 == 3 && day1 >=1 && day1 <=20)){
            img.setImageResource(R.mipmap.pisces);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.pisces));
        }//aries 白羊座 3月21日-4月19日
        else if ((month1 == 3 && day1 >=21 && day1 <=31) || (month1 == 4 && day1 >=1 && day1 <=19)){
            img.setImageResource(R.mipmap.aries);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.aries));
        }//taurus 金牛座 4月20日-5月20日
        else if ((month1 == 4 && day1 >=20 && day1 <=30) || (month1 == 5 && day1 >=1 && day1 <=20)){
            img.setImageResource(R.mipmap.taurus);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.taurus));
        }//gemini 双子座 5月21日-6月21日
        else if ((month1 == 5 && day1 >=21 && day1 <=31) || (month1 == 6 && day1 >=1 && day1 <=21)){
            img.setImageResource(R.mipmap.gemini);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.gemini));
        }//cancer 巨蟹座 6月22日-7月22日
        else if ((month1 == 6 && day1 >=22 && day1 <=30) || (month1 == 7 && day1 >=1 && day1 <=22)){
            img.setImageResource(R.mipmap.cancer);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.cancer));
        }//leo 狮子座 7月23日-8月22日
        else if ((month1 == 7 && day1 >=23 && day1 <=31) || (month1 == 8 && day1 >=1 && day1 <=22)){
            img.setImageResource(R.mipmap.leo);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.leo));
        }//virgo 处女座 8月23日-9月22日
        else if ((month1 == 8 && day1 >=23 && day1 <=31) || (month1 == 9 && day1 >=1 && day1 <=22)){
            img.setImageResource(R.mipmap.virgo);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.virgo));
        }//libra 天秤座9月23日-10月23日
        else if ((month1 == 9 && day1 >=23 && day1 <=30) || (month1 == 10 && day1 >=1 && day1 <=23)){
            img.setImageResource(R.mipmap.libra);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.libra));
        }//scorpio 天蝎座10月24日-11月22
        else if ((month1 == 10 && day1 >=24 && day1 <=31) || (month1 == 11 && day1 >=1 && day1 <=22)){
            img.setImageResource(R.mipmap.scorpio);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.scorpio));
        }//sagittarius 射手座11月23日-12月21日
        else if ((month1 == 11 && day1 >=23 && day1 <=30) || (month1 == 12 && day1 >=1 && day1 <=21)){
            img.setImageResource(R.mipmap.sagittarius);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.sagittarius));
        }//capricornus 摩羯座12月22日-1月19日
        else if ((month1 == 12 && day1 >=22 && day1 <=31) || (month1 == 1 && day1 >=1 && day1 <=19)){
            img.setImageResource(R.mipmap.capricornus);
            text.setText(edt_name.getText().toString() + " " + getString(R.string.capricornus));
        }else {
            Toast.makeText(this,"请输入正确的信息",Toast.LENGTH_LONG).show();
            img.setImageResource(R.mipmap.ic_launcher);
            text.setText("");
        }
    }
}
