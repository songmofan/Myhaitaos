package songmofan.baway.com.myhaitao.view.iview;

import songmofan.baway.com.myhaitao.model.bean.FuzhuangBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/4 14
 */

public interface SortView{
    void callBack(SortBean sortBean);
    void callBack2(FuzhuangBean fuzhuangBean);
    void callBack3(SortBean2 sortBean2);
    void callBacakErro(int code);


}
