package songmofan.baway.com.myhaitao.view.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.XiangBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 20
 */

public class XiangAdapter extends BaseAdapter {

    private List<XiangBean.DatasBean.GoodsCommendListBean> strs = new ArrayList<>();
    private Context context;

    public XiangAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public XiangBean.DatasBean.GoodsCommendListBean getItem(int position) {

        return strs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder;
        if (convertView == null) {
            holder = new MyHolder();
            convertView = convertView.inflate(context, R.layout.xiangactivity_listviewitem, null);
              holder.imageView= (ImageView) convertView.findViewById(R.id.im);
             holder.textView= (TextView) convertView.findViewById(R.id.re_text);
            holder.textView2= (TextView)convertView.findViewById(R.id.re_text2);

            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        Glide.with(context).load(strs.get(position).getGoods_image_url()).into(holder.imageView);
        holder.textView.setText(strs.get(position).getGoods_name());
        holder.textView2.setText(strs.get(position).getGoods_promotion_price());

        return convertView;
    }

    class MyHolder extends Handler {
        ImageView imageView;
        TextView textView;
        TextView textView2;


    }
    public void setData(List<XiangBean.DatasBean.GoodsCommendListBean> sortList) {
        if (sortList != null) {
            strs.addAll(sortList);
        }

    }
}
