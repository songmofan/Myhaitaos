package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.bean.LoginBean;
import songmofan.baway.com.myhaitao.model.util.Myutil;
import songmofan.baway.com.myhaitao.view.iview.LoginView;


/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/12 21
 */

public class LoginPresenter {
    private LoginView l;
    private String usernamel;
    private String passwordl;
    public void attach(LoginView loginView){
        this.l=loginView;

    }

//登陆
    public  void Login(String username,String password){
        this.usernamel=username;
        this.passwordl=password;
        Myutil.GetDataFromeServes(usernamel, passwordl, new Myutil.GettextbBack() {
            @Override
            public <T> void gettext(T t) {
                l.callBack((LoginBean) t);
            }
        });
    }



}
