package songmofan.baway.com.myhaitao.view.iview;

import songmofan.baway.com.myhaitao.model.bean.ShopCarBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/4 14
 */

public interface CarFragmentView {
    void callBack(ShopCarBean shopCarBean);
    void callBacakErro(int code);


}
