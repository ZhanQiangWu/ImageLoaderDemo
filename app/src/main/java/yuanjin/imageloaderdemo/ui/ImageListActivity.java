package yuanjin.imageloaderdemo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import yuanjin.imageloaderdemo.AbsListViewBaseActivity;
import yuanjin.imageloaderdemo.Constants;
import yuanjin.imageloaderdemo.R;

/**
 *  Created by WuZhanQiang on 2016/12/13.
 */

public class ImageListActivity extends AbsListViewBaseActivity{

    DisplayImageOptions options;//DisplayImageOptions是用于设置图片显示的类
    String[] imageUrls;                 // 图片路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_image_list);

        Bundle bundle=getIntent().getExtras();
        imageUrls = bundle.getStringArray(Constants.Extra.IMAGES);

        // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_stub) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)  // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build(); // 创建配置过得DisplayImageOption对象

        listView = (ListView) findViewById(android.R.id.list);
        ((ListView) listView).setAdapter(new ItemAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 点击列表项转入ViewPager显示界面
                startImagePagerActivity(position);
            }
        });
    }

    private void startImagePagerActivity(int position) {
        Intent intent = new Intent(this, ImagePagerActivity.class);
        intent.putExtra(Constants.Extra.IMAGES, imageUrls);
        intent.putExtra(Constants.Extra.IMAGE_POSITION, position);
        startActivity(intent);
    }


    private class ItemAdapter extends BaseAdapter {

        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

        @Override
        public int getCount() {
            return imageUrls.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_list_image, parent, false);
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.text);
                holder.image = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);        // 给View添加一个格外的数据
            } else {
                holder = (ViewHolder) convertView.getTag(); // 把数据取出来
            }

            holder.text.setText("Item " + (position + 1));  // TextView设置文本

            /**
             * 显示图片
             * 参数1：图片url
             * 参数2：显示图片的控件
             * 参数3：显示图片的设置
             * 参数4：监听器
             */
            imageLoader.displayImage(imageUrls[position], holder.image, options, animateFirstListener);

            return convertView;
        }

        private class ViewHolder {
            public TextView text;
            public ImageView image;
        }
    }


    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener{

        static final List<String> displayImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage!=null){
                ImageView imageView = (ImageView) view;
                //是否是第一次显示
                boolean firstDisplay = displayImages.contains(imageUri);
                if (firstDisplay){
                    //图片淡入效果
                    FadeInBitmapDisplayer.animate(imageView,500);
                    displayImages.add(imageUri);
                }
            }
        }
    }
}
