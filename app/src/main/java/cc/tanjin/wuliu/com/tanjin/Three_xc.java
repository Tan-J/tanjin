package cc.tanjin.wuliu.com.tanjin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Three_xc extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImage;
    private TextView mText;
    private int num;
    private int index;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_xc);
        initView();
        initData();
    }

    private void initData() {
        title = new String[]{"第1张图片","第2张图片","第3张图片","第4张图片","第5张图片","第6张图片","第7张图片"};
        images = new int[]{R.mipmap.img_36,R.mipmap.img_37,R.mipmap.img_38,R.mipmap.img_39,R.mipmap.img_40,R.mipmap.img_41,R.mipmap.img_42};
        mImage.setImageResource(images[0]);
        mText.setText(title[0]);
        num = title.length;
        index = 0;
    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.iv_show);
        mText = (TextView) findViewById(R.id.tv_show);
        findViewById(R.id.btn_previous).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_previous:
                if (index == 0){
                    index = title.length - 1;
                }else {
                    index--;
                }
                break;
            case R.id.btn_next:
                if (index == 6){
                    index = 0;
                }else {
                    index++;
                }
                break;
        }
        updateImageAndTitle();
    }

    private void updateImageAndTitle() {
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
    }
}

