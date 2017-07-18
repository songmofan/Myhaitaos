package songmofan.baway.com.myhaitao.view.iview;

import songmofan.baway.com.myhaitao.model.bean.OrderBer;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/14 19
 */

public interface OrderView {

    void callBack(OrderBer orderBer);
    void callBackErrow(int code);
}
