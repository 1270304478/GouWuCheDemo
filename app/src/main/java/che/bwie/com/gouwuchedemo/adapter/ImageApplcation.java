package che.bwie.com.gouwuchedemo.adapter;

import android.app.Application;

import che.bwie.com.gouwuchedemo.util.ImageLoderUtil;


/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/21 8:52
 */
public class ImageApplcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoderUtil.initConfig(this);
    }
}
