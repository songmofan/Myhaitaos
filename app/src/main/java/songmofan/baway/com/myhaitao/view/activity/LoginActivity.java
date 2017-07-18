package songmofan.baway.com.myhaitao.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.SinginBean;
import songmofan.baway.com.myhaitao.presenter.LoginPresenter;
import songmofan.baway.com.myhaitao.presenter.SinginPresenter;
import songmofan.baway.com.myhaitao.view.iview.Singin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,Singin<SinginBean> {


    private EditText namesingin;
    private EditText passwordsingin;
    private EditText password1singin;
    private EditText emailsingin;
    private Button singinbutton;
    private LoginPresenter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();


    }

    private void initData() {




    }

    public void backa(View v) {
        finish();
    }


    private void initView() {
        namesingin = (EditText) findViewById(R.id.namesingin);
        passwordsingin = (EditText) findViewById(R.id.passwordsingin);
        password1singin = (EditText) findViewById(R.id.password1singin);
        emailsingin = (EditText) findViewById(R.id.emailsingin);
        singinbutton = (Button) findViewById(R.id.singinbutton);
        singinbutton.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String namesinginString = namesingin.getText().toString().trim();
        if (TextUtils.isEmpty(namesinginString)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordsinginString = passwordsingin.getText().toString().trim();
        if (TextUtils.isEmpty(passwordsinginString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String password1singinString = password1singin.getText().toString().trim();
        if (TextUtils.isEmpty(password1singinString)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String emailsinginString = emailsingin.getText().toString().trim();
        if (TextUtils.isEmpty(emailsinginString)) {
            Toast.makeText(this, "请输入邮箱地址", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.singinbutton:
                String name = namesingin.getText().toString();
                String pwd = passwordsingin.getText().toString();
                String pwd1 = password1singin.getText().toString();
                String email = emailsingin.getText().toString();
                SinginPresenter sp = new SinginPresenter();
                sp.singin(name,pwd,pwd1,email);
                break;
        }
    }

    @Override
    public void callback(SinginBean singinBean) {

        Toast.makeText(this, "siginBean"+singinBean.getCode(), Toast.LENGTH_SHORT).show();

    }
}
