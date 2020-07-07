package cc.tanjin.wuliu.com.tanjin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One_jsq1 extends AppCompatActivity implements View.OnClickListener {
    private Button clear,delete,cheng,clu,num7,num8,num9,charjian,num4,num5,num6,charadd,num1,num2,num3,num0,dian,equal;
    private EditText input;
    private  String ss="";
    private  boolean fu=false;
    private  boolean num=false;
    private  boolean point=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_jsq1);
        input=(EditText) findViewById(R.id.input);
        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.cheng).setOnClickListener(this);
        findViewById(R.id.clu).setOnClickListener(this);
        findViewById(R.id.num7).setOnClickListener(this);
        findViewById(R.id.num8).setOnClickListener(this);
        findViewById(R.id.num9).setOnClickListener(this);
        findViewById(R.id.charjian).setOnClickListener(this);
        findViewById(R.id.num4).setOnClickListener(this);
        findViewById(R.id.num5).setOnClickListener(this);
        findViewById(R.id.num6).setOnClickListener(this);
        findViewById(R.id.charadd).setOnClickListener(this);
        findViewById(R.id.num1).setOnClickListener(this);
        findViewById(R.id.num2).setOnClickListener(this);
        findViewById(R.id.num3).setOnClickListener(this);
        findViewById(R.id.num0).setOnClickListener(this);
        findViewById(R.id.dian).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
            {
                ss="";
                input.setText(ss);
            }
            break;
            case R.id.delete:
            {
                if(ss.indexOf(" ")==ss.length()-3)
                {
                    ss= ss.substring(0,ss.length() - 2);
                }
                if(ss.length()>0)
                {
                    ss= ss.substring(0,ss.length() - 1);
                }
                input.setText(ss);
            }
            break;
            case R.id.cheng:
            {
                if(ss.length()==0)
                {
                    break;
                }
                if(ss.contains(" "))
                {
                    if(ss.indexOf(" ")==ss.length()-3||ss.indexOf(" ")==ss.length()-2||ss.indexOf(" ")==ss.length()-1) break;
                    getResult();
                }
                fu=true;
                ss+=" × ";
                input.setText(ss);
            }
            break;
            case R.id.clu:
            {
                if(ss.length()==0)
                {
                    break;
                }
                if(ss.contains(" "))
                {
                    if(ss.indexOf(" ")==ss.length()-3||ss.indexOf(" ")==ss.length()-2||ss.indexOf(" ")==ss.length()-1) break;
                    getResult();
                }
                fu=true;
                ss+=" ÷ ";
                input.setText(ss);
            }
            break;
            case R.id.num7:
            {
                ss+="7";
                input.setText(ss);
            }
            break;
            case R.id.num8:
            {
                ss+="8";
                input.setText(ss);
            }
            break;
            case R.id.num9:
            {
                ss+="9";
                input.setText(ss);
            }
            break;
            case R.id.charjian:
            {
                if(ss.length()==0)
                {
                    break;
                }
                if(ss.contains(" "))
                {
                    if(ss.indexOf(" ")==ss.length()-3||ss.indexOf(" ")==ss.length()-2||ss.indexOf(" ")==ss.length()-1) break;
                    getResult();
                }
                fu=true;
                ss+=" － ";
                input.setText(ss);
            }
            break;
            case R.id.num4:
            {
                ss+="4";
                input.setText(ss);
            }
            break;
            case R.id.num5:
            {
                ss+="5";
                input.setText(ss);
            }
            break;
            case R.id.num6:
            {
                ss+="6";
                input.setText(ss);
            }
            break;
            case R.id.charadd:
            {
                if(ss.length()==0)
                {
                    break;
                }
                if(ss.contains(" "))
                {
                    if(ss.indexOf(" ")==ss.length()-3||ss.indexOf(" ")==ss.length()-2||ss.indexOf(" ")==ss.length()-1) break;
                    getResult();
                }
                fu=true;
                ss+=" ＋ ";
                input.setText(ss);
            }
            break;
            case R.id.num1:
            {
                ss+="1";
                input.setText(ss);
            }
            break;
            case R.id.num2:
            {
                ss+="2";
                input.setText(ss);
            }
            break;
            case R.id.num3:
            {
                ss+="3";
                input.setText(ss);
            }
            break;
            case R.id.num0:
            {
                ss+="0";
                input.setText(ss);
            }
            break;
            case R.id.dian:
            {
                if(ss.length()==0||ss.indexOf(" ")==ss.length()-3||ss.lastIndexOf(".")>ss.indexOf(" "))
                {
                    break;
                }
                else
                {
                    ss+=".";
                    input.setText(ss);
                }
            }
            break;
            case R.id.equal:
                getResult();
                break;
        }
    }
    private void getResult()
    {
        double result=0;
        if(ss==null||ss.equals("")) return;
        if(!ss.contains(" "))  return;
        String s1=ss.substring(0,ss.indexOf(" "));
        String op=ss.substring(ss.indexOf(" ")+1,ss.indexOf(" ")+2);
        String s2=ss.substring(ss.indexOf(" ")+3);
        if(!s1.equals("")&&!s2.equals(""))
        {
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2 );
            switch (op)
            {
                case "＋": result=d1+d2;break;
                case "－": result=d1-d2;break;
                case "×": result=d1*d2;break;
                case "÷":
                {
                    if(d2==0)
                    {
                        Toast.makeText(this, "不能除以零", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    result=d1/d2*1.0;
                }
                break;
            }

            int r = (int)  result;
            if(r==result)
            {
                input.setText(""+r);
                ss=""+r;
            }
            else
            {
                input.setText(result+"");
                ss=""+result;
            }

        }
    }
}