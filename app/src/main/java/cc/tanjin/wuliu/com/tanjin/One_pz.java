package cc.tanjin.wuliu.com.tanjin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class One_pz extends AppCompatActivity {
    private Button btn;
    private ImageView img;

    //定义一个保存图片的File变量
    private File currentImageFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_pz);
        btn = (Button) findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent capintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(capintent, 100);*/

                File dir = new File(Environment.getExternalStorageDirectory(),"pictures");
                if(dir.exists()){
                    dir.mkdirs();
                }
                currentImageFile = new File(dir,System.currentTimeMillis() + ".jpg");
                if(!currentImageFile.exists()){
                    try {
                        currentImageFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Intent capintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                capintent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(currentImageFile));
                startActivityForResult(capintent, Activity.DEFAULT_KEYS_DIALER);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (requestCode == 100){
            if (resultCode == RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                img.setImageBitmap(bitmap);
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(Main2Activity.this,"拍照未成功",Toast.LENGTH_SHORT).show();
            }
        }*/

        if (requestCode == Activity.DEFAULT_KEYS_DIALER){
            if (resultCode == RESULT_OK){
                img.setImageURI(Uri.fromFile(currentImageFile));
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(One_pz.this,"拍照未成功",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
