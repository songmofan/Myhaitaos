package songmofan.baway.com.myhaitao.view.iview;

import songmofan.baway.com.myhaitao.model.bean.LineBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 16
 */

public interface LineActivityView {
    void  callBack(LineBean lineBean);
    void  callBackErro(int code,String msg);


}
