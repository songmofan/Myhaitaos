package songmofan.baway.com.myhaitao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.AddshopBean;
import songmofan.baway.com.myhaitao.model.bean.XiangBean;
import songmofan.baway.com.myhaitao.presenter.XiangActicityPresenter;
import songmofan.baway.com.myhaitao.view.adapter.XiangAdapter;
import songmofan.baway.com.myhaitao.view.iview.XiangActivityView;

public class XiangqActivity extends AppCompatActivity implements XiangActivityView, View.OnClickListener {

    private ImageView xiang_im;
    private ListView xiang_lv;
    private List<XiangBean.DatasBean.GoodsCommendListBean> goods_commend_list;
    private XiangAdapter adapter;
    private XiangActicityPresenter xiangActicityPresenter;
    private String goods_id;
    private TextView xiang_te;
    private TextView xiang_te2;
    private Button kf_button;
    private Button kf_button2;
    private Button kf_button3;
    private Button kf_button4;
    // TODO: 2017/7/7 先把key写死    11111111111111111111111111
    private String key="dc234beaf85dc177d0c277c8ed8320c3";
    private String datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangq);


        //获取列表页传过来的 goods_id；
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        Toast.makeText(this, "goods_id"+goods_id, Toast.LENGTH_SHORT).show();

        initView();
        initdata();
    }

    private void initView() {
        xiang_im = (ImageView) findViewById(R.id.xiang_im);
        xiang_lv = (ListView) findViewById(R.id.xiang_lv);
        xiang_te = (TextView) findViewById(R.id.xiang_text);
        xiang_te2 = (TextView) findViewById(R.id.xiang_text2);

        adapter = new XiangAdapter(XiangqActivity.this);
        xiang_lv.setAdapter(adapter);
        //点击介绍进入详情
        xiang_te.setOnClickListener(this);

        kf_button = (Button) findViewById(R.id.kf_button);
        kf_button.setOnClickListener(this);
        kf_button2 = (Button) findViewById(R.id.kf_button2);
        kf_button2.setOnClickListener(this);
        kf_button3 = (Button) findViewById(R.id.kf_button3);
        kf_button3.setOnClickListener(this);
        kf_button4 = (Button) findViewById(R.id.kf_button4);
        kf_button4.setOnClickListener(this);
    }

    private void initdata() {
        xiangActicityPresenter = new XiangActicityPresenter();
        xiangActicityPresenter.attach(this);
        xiangActicityPresenter.getDataXiangq(goods_id);

    }
    @Override
    public void callBack(XiangBean xiangBean) {
        goods_commend_list = xiangBean.getDatas().getGoods_commend_list();
        adapter.setData(goods_commend_list);
        adapter.notifyDataSetChanged();

        xiang_te.setText(xiangBean.getDatas().getGoods_info().getGoods_name());
        xiang_te2.setText(xiangBean.getDatas().getGoods_info().getGoods_price());
        Glide.with(XiangqActivity.this).load(xiangBean.getDatas().getGoods_image()).into(xiang_im);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.xiang_text):
                Intent intent2 = new Intent(XiangqActivity.this, XiangqyActivity.class);
                intent2.putExtra("goods_id", goods_id);
                startActivity(intent2);
                break;
            case R.id.kf_button:

                break;
            //点击购物车的按钮
            case R.id.kf_button2:

//                Toast.makeText(this, "gouwuuu", Toast.LENGTH_SHORT).show();
//                EventBusBean eventBusBean = new EventBusBean();
//                eventBusBean.setIndex(2);
//                EventBus.getDefault().post(eventBusBean);

                Intent intent = new Intent(XiangqActivity.this,MainActivity.class);
                startActivity(intent);


                break;
            case R.id.kf_button3:
                xiangActicityPresenter.getDataText(goods_id,key,1+"");

                break;
            case R.id.kf_button4:

                break;
        }
    }
    //回调的添加购物车数据
    @Override
    public void callBackShopCar(AddshopBean addshopBean) {
        datas = addshopBean.getDatas();
        Toast.makeText(this, "添加成功"+datas, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void callBackErro(int code, String msg) {

    }

}
