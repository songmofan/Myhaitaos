package songmofan.baway.com.myhaitao.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.LineBean;
import songmofan.baway.com.myhaitao.view.iview.Mylistener;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 16
 */

public class Recycal_Adapter extends RecyclerView.Adapter<Recycal_Adapter.MyHolder> {

private  Context contexts;
    private List<LineBean.DatasBean.GoodsListBean> list=new ArrayList<>();
    private Mylistener mylistener;

    public void attach(Context context){
        this.contexts=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(contexts, R.layout.recycal_layout, null);
        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        Glide.with(contexts).load(list.get(position).getGoods_image_url()).into(holder.im);
          holder.textViewew.setText(list.get(position).getGoods_name());
          holder.textView2.setText(list.get(position).getGoods_price());
        holder.textViewew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylistener != null) {
                    mylistener.setMyOncliclisener(v,position);
                }
            }
        });
    }





    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setonclick(Mylistener lineActivity) {
        this.mylistener=lineActivity;


    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private final TextView textViewew;
        private final TextView textView2;
        private final ImageView im;

        public MyHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.im);
            textViewew = (TextView) itemView.findViewById(R.id.re_text);
            textView2 = (TextView) itemView.findViewById(R.id.re_text2);

        }
    }
public  void setData(List<LineBean.DatasBean.GoodsListBean> goods_list){
    if (goods_list!=null) {
        list.addAll(goods_list);

    }


}
}
