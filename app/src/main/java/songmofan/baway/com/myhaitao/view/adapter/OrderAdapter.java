package songmofan.baway.com.myhaitao.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.OrderBer;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/14 20
 */

public class OrderAdapter extends BaseAdapter {

    private Context contexts;
    private List<OrderBer.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> list = new ArrayList<>();

    public OrderAdapter(Context context) {
        this.contexts = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = convertView.inflate(contexts, R.layout.orderlist, null);

        }
        ImageView or_im = (ImageView) convertView.findViewById(R.id.or_im);
        TextView or_te = (TextView) convertView.findViewById(R.id.or_text);
        TextView or_te2 = (TextView) convertView.findViewById(R.id.or_text2);

        Glide.with(contexts).load(list.get(position).getGoods_image_url()).into(or_im);
        or_te.setText(list.get(position).getGoods_name());
         or_te2.setText(list.get(position).getGoods_total());
        return convertView;


    }

    public void setData(List<OrderBer.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> goods_list) {
        if (goods_list != null) {
           list.addAll(goods_list);
        }

    }

}
