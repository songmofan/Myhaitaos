package songmofan.baway.com.myhaitao.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.AddshopBean;
import songmofan.baway.com.myhaitao.model.bean.EventBusBean;
import songmofan.baway.com.myhaitao.model.bean.ShopCarBean;
import songmofan.baway.com.myhaitao.presenter.DeleteShopPresenter;
import songmofan.baway.com.myhaitao.presenter.ShopCarLB;
import songmofan.baway.com.myhaitao.view.iview.CarFragmentView;
import songmofan.baway.com.myhaitao.view.iview.DeleteShopView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 20
 */

public class ShopCarAdapter extends BaseAdapter implements DeleteShopView {

    private List<ShopCarBean.DatasBean.CartListBean.GoodsBean> strs = new ArrayList<>();
    private Context context;
    private double dan;
    private double zong;
    private int num;
    private ImageView imageView;
    private TextView textView;
    private TextView textView2;
    private Button button;
    private CheckBox checkBox;
    private Button jian;
    private Button jia;
    private TextView shuliang;
    private boolean ischext;
    private ShopCarLB shopCarLBs;
    private ViewHolder viewHolder;
    private double goods_price;
    private double v;
    private CarFragmentView cartview;

    public ShopCarAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return strs.size();
    }

    //获得ShopCarLB
    public void getShopCarLB(ShopCarLB shopCarLB) {
        this.shopCarLBs = shopCarLB;

    }

    @Override
    public ShopCarBean.DatasBean.CartListBean.GoodsBean getItem(int position) {

        return strs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = convertView.inflate(context, R.layout.xiangactivity_listviewitem, null);

            viewHolder = new ViewHolder();
            viewHolder.jiajia = jia = (Button) convertView.findViewById(R.id.jia);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.chcbox);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        imageView = (ImageView) convertView.findViewById(R.id.im);
        textView = (TextView) convertView.findViewById(R.id.re_text);
        textView2 = (TextView) convertView.findViewById(R.id.re_text2);
        button = (Button) convertView.findViewById(R.id.but_del);


        jian = (Button) convertView.findViewById(R.id.jian);
        shuliang = (TextView) convertView.findViewById(R.id.shuliang);
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (strs.get(position).isshow()) {
                    strs.get(position).setIsshow(false);
                } else {
                    strs.get(position).setIsshow(true);
                }
                notifyDataSetChanged();

                eventbus_Price();


            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //在集合中获得 商品数量，单价，总价
                int i = Integer.parseInt(strs.get(position).getGoods_num());
                double v1 = Double.parseDouble(strs.get(position).getGoods_price());
                dan = (v1 / i);
                num = Integer.parseInt(strs.get(position).getGoods_num()) - 1;
                if (num == 0) {
                    num = 1;
                    Toast.makeText(context, "" + "不能再减了", Toast.LENGTH_SHORT).show();
                }
                zong = (dan * num);
                strs.get(position).setGoods_price(zong + "");
                strs.get(position).setGoods_num(num + "");
                notifyDataSetChanged();
                if (strs.get(position).isshow()) {
                    eventbus_Price();
                }

            }
        });


        //点击加的按钮
        viewHolder.jiajia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在集合中获得 商品数量，单价，总价
                int i = Integer.parseInt(strs.get(position).getGoods_num());
                double v1 = Double.parseDouble(strs.get(position).getGoods_price());
                dan = (v1 / i);
                num = i + 1;
                zong = (dan * num);
                strs.get(position).setGoods_price(zong + "");
                strs.get(position).setGoods_num(num + "");
                notifyDataSetChanged();
                if (strs.get(position).isshow()) {
                    eventbus_Price();
                }
            }
        });
        Glide.with(context).load(strs.get(position).getGoods_image_url()).into(imageView);
        textView.setText(strs.get(position).getGoods_name());
        textView2.setText(strs.get(position).getGoods_price());
        shuliang.setText(strs.get(position).getGoods_num());
        //
        viewHolder.checkBox.setChecked(strs.get(position).isshow());


        //点击删除按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeleteShopPresenter deleteShopPresenter = new DeleteShopPresenter();
               deleteShopPresenter.attach(ShopCarAdapter.this);
                String cart_id = strs.get(position).getCart_id();
                deleteShopPresenter.deleteshop(cart_id, "83d09dae50232e10db7cf287ebc22328", 1 + "");




            }
        });

        return convertView;
    }

    private void eventbus_Price() {
        goods_price = 0;
        for (int i = 0; i < strs.size(); i++) {
            if (strs.get(i).isshow()) {
                v = Double.parseDouble(strs.get(i).getGoods_price());
                goods_price = v + goods_price;


            }
        }

        EventBusBean eventBusBean = new EventBusBean();
        eventBusBean.setNuch(goods_price);
        EventBus.getDefault().post(eventBusBean);

    }

    public void setCarFragmentView(CarFragmentView cartFragment) {
        this.cartview=cartFragment;

    }
    private class ViewHolder {
        private Button jiajia;
        private CheckBox checkBox;

    }
    public void setAll() {
        for (int i = 0; i < strs.size(); i++) {
            ShopCarBean.DatasBean.CartListBean.GoodsBean goodsBean = strs.get(i);
            goodsBean.setIsshow(true);
        }
        notifyDataSetChanged();
        eventbus_Price();
    }
    public void setAllNo() {

        boolean isNo = false;
        for (int i = 0; i < strs.size(); i++) {
            ShopCarBean.DatasBean.CartListBean.GoodsBean goodsBean = strs.get(i);
            if (goodsBean.isshow()) {
                isNo = true;
            }
        }

        if (isNo) {
            for (int i = 0; i < strs.size(); i++) {

                ShopCarBean.DatasBean.CartListBean.GoodsBean goodsBean = strs.get(i);
                goodsBean.setIsshow(false);
            }
        } else {
            setAll();
        }
        notifyDataSetChanged();
        eventbus_Price();
    }
    @Override
    public void callBack(AddshopBean addshopBean) {
        ShopCarLB  shopCarLB = new ShopCarLB();
        shopCarLB.attach(cartview);
        shopCarLB.getShopCarLB("dc234beaf85dc177d0c277c8ed8320c3");
    }

    public void setData(List<ShopCarBean.DatasBean.CartListBean.GoodsBean> sortList, boolean ischext) {

        if (sortList != null) {
            strs=sortList;
        }

        notifyDataSetChanged();
    }
}
