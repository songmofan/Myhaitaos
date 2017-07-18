package songmofan.baway.com.myhaitao.view.iview;

import songmofan.baway.com.myhaitao.model.bean.AddshopBean;
import songmofan.baway.com.myhaitao.model.bean.XiangBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 16
 */

public interface XiangActivityView {
    void  callBack(XiangBean xiangBean);
    void callBackShopCar(AddshopBean addshopBean);

    void  callBackErro(int code, String msg);


}
