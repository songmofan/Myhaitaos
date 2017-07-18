package songmofan.baway.com.myhaitao.view.iview;

import songmofan.baway.com.myhaitao.model.bean.LoginBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/12 21
 */

public interface LoginView<T> {

    void callBack(LoginBean loginBean);
    void callBackErro();

}
