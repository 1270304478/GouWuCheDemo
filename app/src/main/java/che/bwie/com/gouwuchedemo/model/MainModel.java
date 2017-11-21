package che.bwie.com.gouwuchedemo.model;

import che.bwie.com.gouwuchedemo.bean.ShopBean;
import che.bwie.com.gouwuchedemo.okhttp.AbstractUiCallBack;
import che.bwie.com.gouwuchedemo.okhttp.OkhttpUtils;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/21 16:06
 */
public class MainModel {
    public void getData(final MainModelCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<ShopBean>() {


            @Override
            public void success(ShopBean bean) {
                callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {
                callBack.failure(e);
            }
        });
    }
}
