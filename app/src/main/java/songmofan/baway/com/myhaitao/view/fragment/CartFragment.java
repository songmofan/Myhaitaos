package songmofan.baway.com.myhaitao.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.EventBusBean;
import songmofan.baway.com.myhaitao.model.bean.ShopCarBean;
import songmofan.baway.com.myhaitao.presenter.ShopCarLB;
import songmofan.baway.com.myhaitao.view.activity.OrderMassages;
import songmofan.baway.com.myhaitao.view.adapter.ShopCarAdapter;
import songmofan.baway.com.myhaitao.view.iview.CarFragmentView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/9 15
 */

public class CartFragment extends Fragment implements CarFragmentView, View.OnClickListener {

    private ListView shopcar;
    private ShopCarAdapter shopCarAdapter;
    private List<ShopCarBean.DatasBean.CartListBean.GoodsBean> goods = new ArrayList<>();
    private TextView number;
    private TextView much;
    private Button quan;
    private Button fan;
    private boolean ischcet = false;
    private ShopCarLB shopCarLB;
    private Button fjieshuan;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        //实例化p层 ，调用查看购物车的方法
        shopCarLB = new ShopCarLB();
        shopCarLB.attach(this);
        shopCarLB.getShopCarLB("dc234beaf85dc177d0c277c8ed8320c3");
    }

    private void initView() {
        //找到listview，商品数量，商品价格的方法
        shopcar = (ListView) getView().findViewById(R.id.shopcar_lv);
        number = (TextView) getView().findViewById(R.id.number);
        much = (TextView) getView().findViewById(R.id.much);
        quan = (Button) getView().findViewById(R.id.quan);
        fan = (Button) getView().findViewById(R.id.fan);
        fjieshuan = (Button) getView().findViewById(R.id.jiesuan);


        //button 的点击事件
        fjieshuan.setOnClickListener(this);
        quan.setOnClickListener(this);
        fan.setOnClickListener(this);


        shopCarAdapter = new ShopCarAdapter(getActivity());
        shopCarAdapter.getShopCarLB(shopCarLB);
        shopcar.setAdapter(shopCarAdapter);

        shopCarAdapter.setCarFragmentView(this);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        EventBus.getDefault().register(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataEventBus(EventBusBean eventBusBean) {
        double nuchs = eventBusBean.getNuch();

        much.setText(nuchs + "");
    }

    //p层回调回来的数据
    @Override
    public void callBack(ShopCarBean shopCarBean) {
        if (shopCarBean.getDatas().getCart_list().size() > 0) {
            goods = shopCarBean.getDatas().getCart_list().get(0).getGoods();
            int cart_count = shopCarBean.getDatas().getCart_count();
            number.setText(cart_count + "");
            shopCarAdapter.setData(goods, ischcet);
            shopCarAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void callBacakErro(int code) {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
             //全选
            case R.id.quan:
                shopCarAdapter.setAll();
                break;
            //反选
            case R.id.fan:
                shopCarAdapter.setAllNo();
                break;
            //结算
            case R.id.jiesuan:
                Intent intent =new Intent(getActivity(),OrderMassages.class);
                startActivity(intent);


                break;

        }

    }
}
