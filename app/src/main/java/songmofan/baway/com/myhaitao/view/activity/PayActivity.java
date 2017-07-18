package songmofan.baway.com.myhaitao.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import songmofan.baway.com.myhaitao.R;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private TextView number;
    private TextView pay_nuchu;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();


    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        number = (TextView) findViewById(R.id.number);
        pay_nuchu = (TextView) findViewById(R.id.pay_nuchu);
        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:

                break;
        }
    }
}
