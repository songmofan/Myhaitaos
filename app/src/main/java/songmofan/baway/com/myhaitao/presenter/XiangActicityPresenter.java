package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.AddshopBean;
import songmofan.baway.com.myhaitao.model.bean.XiangBean;
import songmofan.baway.com.myhaitao.model.util.ShowpCarUtil;
import songmofan.baway.com.myhaitao.model.util.XiangUtil;
import songmofan.baway.com.myhaitao.view.iview.XiangActivityView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 16
 */

public class XiangActicityPresenter {

    private  XiangActivityView xiangActivityViews;

    public void attach(XiangActivityView xiangActivityView){
        this.xiangActivityViews=xiangActivityView;

    }

    //调用M的列表请求接口
    public  void  getDataXiangq(String goods_id) {
        XiangUtil.getDataFromServer(goods_id, new XiangUtil.GettextbBacks() {
            @Override
            public <T> void gettext(T t) {
                 xiangActivityViews.callBack((XiangBean) t);
            }
        });
    }

    public  void  getDataText(String goods_id,String key,String quantity){
        ShowpCarUtil.getDataFromServer(goods_id,key,quantity, new ShowpCarUtil.GettextbBacks() {
            @Override
            public <T> void gettext(T t) {
                xiangActivityViews.callBackShopCar((AddshopBean) t);
            }
        });

    }

}
