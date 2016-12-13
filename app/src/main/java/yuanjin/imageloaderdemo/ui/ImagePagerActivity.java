package yuanjin.imageloaderdemo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import yuanjin.imageloaderdemo.BaseActivity;
import yuanjin.imageloaderdemo.Constants;
import yuanjin.imageloaderdemo.R;

/**
 *  Created by WuZhanQiang on 2016/12/13.
 */

public class ImagePagerActivity extends BaseActivity {

    private static final String STATE_POSITION = "STATE_POSITION";

    DisplayImageOptions options;

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_image_pager);

        Bundle bundle = getIntent().getExtras();
        String[] imageUrls = bundle.getStringArray(Constants.Extra.IMAGES);
        // 当前显示View的位置
        int pagerPosition = bundle.getInt(Constants.Extra.IMAGE_POSITION, 0);

        // 如果之前有保存用户数据
        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_empty)
                .showImageOnFail(R.mipmap.ic_error)
                .resetViewBeforeLoading(true)
                .cacheOnDisc(true)
                .imageScaleType(ImageScaleType.EXACTLY) // TODO: 2016/12/13  
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new ImagePagerAdapter(imageUrls));
        pager.setCurrentItem(pagerPosition);    // 显示当前位置的View

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // 保存用户数据  
        outState.putInt(STATE_POSITION, pager.getCurrentItem());
    }

    private class ImagePagerAdapter extends PagerAdapter {

        private String[] images;
        private LayoutInflater inflater;

        ImagePagerAdapter(String[] images) {
            this.images = images;
            inflater = getLayoutInflater();
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View imageLayout = inflater.inflate(R.layout.item_pager_image, container, false);
            ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
            final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);
            imageLoader.displayImage(images[position], imageView, options,new SimpleImageLoadingListener(){

                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    spinner.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    String message = null;
                    switch (failReason.getType()) {     // 获取图片失败类型
                        case IO_ERROR:              // 文件I/O错误
                            message = "Input/Output error";
                            break;
                        case DECODING_ERROR:        // 解码错误
                            message = "Image can't be decoded";
                            break;
                        case NETWORK_DENIED:        // 网络延迟
                            message = "Downloads are denied";
                            break;
                        case OUT_OF_MEMORY:         // 内存不足
                            message = "Out Of Memory error";
                            break;
                        case UNKNOWN:               // 原因不明
                            message = "Unknown error";
                            break;
                    }
                    Toast.makeText(ImagePagerActivity.this, message, Toast.LENGTH_SHORT).show();
                    spinner.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    spinner.setVisibility(View.GONE);       // 不显示圆形进度条
                }
            });

            ((ViewPager) container).addView(imageLayout, 0);     // 将图片增加到ViewPager
            return imageLayout;
        }
    }
}













