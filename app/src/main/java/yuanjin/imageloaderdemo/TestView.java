package yuanjin.imageloaderdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 *  Created by WuZhanQiang on 2016/12/13.
 */

public class TestView extends LinearLayout{


    public TestView(Context context) {
        super(context);
        initView(context);
    }



    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.test,this);
    }

}
