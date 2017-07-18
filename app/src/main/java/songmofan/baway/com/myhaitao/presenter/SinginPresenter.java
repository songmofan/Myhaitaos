package songmofan.baway.com.myhaitao.presenter;

import songmofan.baway.com.myhaitao.model.util.Myutil;
import songmofan.baway.com.myhaitao.view.iview.Singin;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/13 11
 */

public class SinginPresenter {
    private String passwords;
    private String usernames;
    private String password_confirms;
    private String emails;
    private  Singin singins;

  public void attach(Singin singin){
        this.singins=singin;
    }
    //注册
    public void singin(String username,String password,String password_confirm,String email){
        this.usernames=username;
        this.passwords=password;
        this.password_confirms=password_confirm;
        this.emails=email;
        Myutil.singin(usernames, passwords, password_confirms, emails, new Myutil.GettextbBack() {
            @Override
            public <T> void gettext(T t) {
                singins.callback(t);
            }
        });
    }


}
