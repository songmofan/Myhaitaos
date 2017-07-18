package songmofan.baway.com.myhaitao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.LoginBean;
import songmofan.baway.com.myhaitao.presenter.LoginPresenter;
import songmofan.baway.com.myhaitao.view.iview.LoginView;

public class UserLogInAcitviy extends AppCompatActivity implements LoginView<LoginBean>, View.OnClickListener {

    private EditText user;
    private TextView password;
    private Button buttonLogin;
    private LoginPresenter p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log_in_acitviy);
        initview();
        initData();
    }

    private void initData() {
        p = new LoginPresenter();
        p.attach(this);

    }
    private void initview() {
        findViewById(R.id.login).setOnClickListener(this);
        user = (EditText) findViewById(R.id.user);
        password = (TextView) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        //点击登录
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = user.getText().toString();
                String pass = password.getText().toString();
               //登陆传参数
                p.Login(uname,pass);
            }
        });
    }
   //在P层接口回调的值
    @Override
    public void callBack(LoginBean loginBean) {
        Toast.makeText(this, "loginBean"+loginBean.getCode(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void callBackErro() {

    }

    //点击注册跳转
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(UserLogInAcitviy.this,LoginActivity.class);
        startActivity(intent);
    }
    public void backs(View view){
        finish();
    }
}
