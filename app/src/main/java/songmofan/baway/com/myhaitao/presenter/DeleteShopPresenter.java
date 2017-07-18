package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.AddshopBean;
import songmofan.baway.com.myhaitao.model.util.DeleteShowpCarUtil;
import songmofan.baway.com.myhaitao.view.iview.DeleteShopView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/7 21
 */

public class DeleteShopPresenter {
    private DeleteShopView deleteShopViews;

    public  void attach(DeleteShopView deleteShopView){
        this.deleteShopViews=deleteShopView;
    }
    //
    public  void  deleteshop(String cart_id,String key,String quantity){
        DeleteShowpCarUtil.deleteshops(cart_id, key, quantity, new DeleteShowpCarUtil.GettextbBacks() {
            @Override
            public <T> void gettext(T t) {
                deleteShopViews.callBack((AddshopBean) t);
            }
        });

    }

}
