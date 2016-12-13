package yuanjin.imageloaderdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 *  Created by WuZhanQiang on 2016/12/13.
 */

public abstract  class BaseActivity extends Activity {

    protected ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_clear_memory_cache:
                imageLoader.clearMemoryCache();     // 清除内存缓存
                return true;
            case R.id.item_clear_disc_cache:
                imageLoader.clearDiscCache();       // 清除SD卡中的缓存
                return true;
            default:
                return false;
        }
    }
}
