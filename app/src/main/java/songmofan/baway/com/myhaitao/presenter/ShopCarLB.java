package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.ShopCarBean;
import songmofan.baway.com.myhaitao.model.util.ShopCarLBUtil;
import songmofan.baway.com.myhaitao.view.iview.CarFragmentView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/7 16
 */

public class ShopCarLB {

    private CarFragmentView carFragmentViews;

    public  void attach(CarFragmentView carFragmentView){
        this.carFragmentViews=carFragmentView;
    }
    public  void getShopCarLB(String key){
        ShopCarLBUtil.getDataFromServer(key, new ShopCarLBUtil.GettextbBacks() {
            @Override
            public <T> void gettext(T t) {
                carFragmentViews.callBack((ShopCarBean) t);
            }
        });
    }

}
