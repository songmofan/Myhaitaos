package songmofan.baway.com.myhaitao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.OrderBer;
import songmofan.baway.com.myhaitao.presenter.OrderPresent;
import songmofan.baway.com.myhaitao.view.adapter.OrderAdapter;
import songmofan.baway.com.myhaitao.view.iview.OrderView;

public class OrderMassages extends AppCompatActivity implements View.OnClickListener,OrderView {

    private Button payonlin;
    private Button payed;
    private Button button;
    private ListView orderListview;
    private TextView ordernuch;
    private Button report;
    private List<OrderBer.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> goods_list;
    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_massages);

        initView();
        initData();

    }

    private void initData() {
        //点击提交的按钮
        OrderPresent orderPresent = new OrderPresent();
        orderPresent.accath(this);
        //提交的接口  key  cart_id   // TODO: 2017/7/14
        orderPresent.getText("","");
    }

    private void initView() {


        payonlin = (Button) findViewById(R.id.payonlin);
        payonlin.setOnClickListener(this);
        payed = (Button) findViewById(R.id.payed);
        payed.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        orderListview = (ListView) findViewById(R.id.orderListview);
        ordernuch = (TextView) findViewById(R.id.ordernuch);
        report = (Button) findViewById(R.id.report);
        report.setOnClickListener(this);
        adapter = new OrderAdapter(this);
        orderListview.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.payonlin:

                break;
            case R.id.payed:

                break;
            case R.id.button:

                break;
            case R.id.report:
                Intent intent =new Intent(OrderMassages.this,PayActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void callBack(OrderBer orderBer) {
        goods_list = orderBer.getDatas().getStore_cart_list().get_$1().getGoods_list();
        adapter.setData(goods_list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void callBackErrow(int code) {

    }
}
