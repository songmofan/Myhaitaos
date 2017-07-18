package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.OrderBer;
import songmofan.baway.com.myhaitao.model.util.OrderUtil;
import songmofan.baway.com.myhaitao.view.iview.OrderView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/14 19
 */

public class OrderPresent {
    private OrderView orderViews;

    public void accath(OrderView orderView) {
        this.orderViews = orderView;

    }

    public void getText(String key, String cart_id) {
        OrderUtil.getDataFromServer(key, cart_id, 1, new OrderUtil.GettextbBacks() {
            @Override
            public <T> void gettext(T t) {
                orderViews.callBack((OrderBer) t);
            }
        });

    }

}
