package che.bwie.com.gouwuchedemo.view;

import che.bwie.com.gouwuchedemo.bean.ShopBean;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/21 16:13
 */
public interface MainViewListener {
    public void success(ShopBean bean);
    public void failure(Exception e);
}
