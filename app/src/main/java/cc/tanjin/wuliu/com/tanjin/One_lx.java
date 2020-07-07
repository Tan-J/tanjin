package cc.tanjin.wuliu.com.tanjin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class One_lx extends AppCompatActivity {
    private VideoView videoView;
    private Button button;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lx);
        videoView = (VideoView) findViewById(R.id.videoView);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                file = new File(Environment.getExternalStorageDirectory().getPath(),System.currentTimeMillis() + ".MP4");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,6);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 6){
            if (resultCode == RESULT_OK){
                videoView.setVideoURI(Uri.fromFile(file));
                Toast.makeText(One_lx.this,"录像成功",Toast.LENGTH_SHORT).show();
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(One_lx.this,"录像未成功",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
