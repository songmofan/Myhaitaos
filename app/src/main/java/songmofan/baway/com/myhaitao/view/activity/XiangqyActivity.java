package songmofan.baway.com.myhaitao.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import songmofan.baway.com.myhaitao.R;

public class XiangqyActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqy);
        Intent intent = getIntent();
        String goods_id = intent.getStringExtra("goods_id");
        initView(goods_id);
        Toast.makeText(this, "goods_id"+goods_id, Toast.LENGTH_SHORT).show();
        initData();
    }

    private void initData() {
    }

    private void initView(String goods_id) {
        String url="http://169.254.133.48/mobile/index.php?act=goods&op=goods_body&goods_id="+goods_id;
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(url);
    }

}
