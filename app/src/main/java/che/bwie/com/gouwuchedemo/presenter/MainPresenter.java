package che.bwie.com.gouwuchedemo.presenter;

import che.bwie.com.gouwuchedemo.bean.ShopBean;
import che.bwie.com.gouwuchedemo.model.MainModel;
import che.bwie.com.gouwuchedemo.model.MainModelCallBack;
import che.bwie.com.gouwuchedemo.view.MainViewListener;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/21 16:10
 */
public class MainPresenter {
    private MainViewListener listener;
    private MainModel mainModel;
    public MainPresenter(MainViewListener listener){
        this.listener=listener;
        this.mainModel=new MainModel();
    }
    public void getData(){
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void success(ShopBean bean) {
                if (listener!=null){
                    listener.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {
      if(listener!=null){
          listener.failure(e);
      }
            }
        });
    }
    //防止内存泄漏
    public void detach(){
        listener=null;
    }

}
