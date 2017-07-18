package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.LineBean;
import songmofan.baway.com.myhaitao.model.util.LineUtil;
import songmofan.baway.com.myhaitao.view.iview.LineActivityView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 16
 */

public class LineActicityPresenter {

    private  LineActivityView lineActivityViews;
    public void attach(LineActivityView lineActivityView){
        this.lineActivityViews=lineActivityView;

    }

    //调用M的列表请求接口
    public  void  getDataLineText() {
        LineUtil.getDataFromServer(new LineUtil.GettextbBacks() {
            @Override
            public <T> void gettext(T t) {
                  lineActivityViews.callBack((LineBean) t);
            }
        });
    }
}
