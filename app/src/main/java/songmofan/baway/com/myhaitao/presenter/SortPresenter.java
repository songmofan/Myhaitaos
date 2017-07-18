package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.FuzhuangBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;
import songmofan.baway.com.myhaitao.model.util.Myutil;
import songmofan.baway.com.myhaitao.view.iview.SortView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/4 14
 */

public class SortPresenter {
    private SortView sortViews;

    public void acctch(SortView sortView) {
        this.sortViews = sortView;

    }
//一级
    public void getSortText() {
        Myutil.getSort(new Myutil.GettextbBack() {
            @Override
            public <T> void gettext(T t) {
                sortViews.callBack((SortBean) t);
            }
        });
    }
    //二级
    public void getSortText2(String gc_id) {
        Myutil.getSort2(gc_id,new Myutil.GettextbBack() {
            @Override
            public <T> void gettext(T t) {
                sortViews.callBack2((FuzhuangBean) t);
            }
        });
    }
    //sa级
    public void getSortText3(String gc_id,String gc_id1) {
        Myutil.getSort3(gc_id,gc_id1,new Myutil.GettextbBack() {
            @Override
            public <T> void gettext(T t) {
                sortViews.callBack3((SortBean2) t);
            }
        });
    }

}