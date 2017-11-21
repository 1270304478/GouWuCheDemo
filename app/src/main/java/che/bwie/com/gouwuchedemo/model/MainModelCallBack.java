package che.bwie.com.gouwuchedemo.model;

import che.bwie.com.gouwuchedemo.bean.ShopBean;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/21 15:59
 */
public interface MainModelCallBack {
   public void success(ShopBean bean);
    public void failure(Exception e);

}
