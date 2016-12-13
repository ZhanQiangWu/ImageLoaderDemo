package yuanjin.imageloaderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import yuanjin.imageloaderdemo.ui.ImageListActivity;
import yuanjin.imageloaderdemo.ui.ImagePagerActivity;

import static yuanjin.imageloaderdemo.Constants.IMAGES;

public class MainActivity extends BaseActivity {

    private static final String TEST_FILE_NAME = "Universal Image Loader @#&=+-_.,!()-'%20.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File testImageOnSdCard  = new File("/mnt/sdcard",TEST_FILE_NAME);
        if (!testImageOnSdCard.exists()){
            // 把文件复制到SD卡
            copyTestImageToSdCard(testImageOnSdCard);
        }

    }

    /**
     * 开一个线程把assert目录下的图片复制到SD卡目录下
     * @param testImageOnSdCard
     */
    private void copyTestImageToSdCard(final File testImageOnSdCard) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream is = getAssets().open(TEST_FILE_NAME);
                    FileOutputStream fos = new FileOutputStream(testImageOnSdCard);
                    byte[] buffer = new byte[8192];
                    int read;
                    try {
                        while ((read = is.read(buffer)) != -1) {
                            fos.write(buffer, 0, read); // 写入输出流
                        }
                    } finally {
                        fos.flush();        // 写入SD卡
                        fos.close();        // 关闭输出流
                        is.close();         // 关闭输入流
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 启动线程
    }

    // 点击进入ListView展示界面
    public void onImageListClick(View view) {
        Intent intent = new Intent(this, ImageListActivity.class);
        intent.putExtra(Constants.Extra.IMAGES, IMAGES);
        startActivity(intent);
    }

    // 点击进入ViewPager展示界面
    public void onImagePagerClick(View view) {
        Intent intent = new Intent(this, ImagePagerActivity.class);
        intent.putExtra(Constants.Extra.IMAGES, IMAGES);
        startActivity(intent);
    }

}
