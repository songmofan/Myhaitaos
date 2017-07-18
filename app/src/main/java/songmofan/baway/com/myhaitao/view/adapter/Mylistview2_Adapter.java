package songmofan.baway.com.myhaitao.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.FuzhuangBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;
import songmofan.baway.com.myhaitao.view.activity.LineActivity;
import songmofan.baway.com.myhaitao.view.activity.MyGradView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/22 16
 */

public class Mylistview2_Adapter extends BaseAdapter {
  private GradView_layoit gradView_layoits;
    private Context context;
    private List<FuzhuangBean.DatasBean.ClassListBean>  strs = new ArrayList<>();
    private MyGradView gv;
    private List<SortBean2.DatasBean.ClassListBean>  str = new ArrayList<>();
    public Mylistview2_Adapter(Context context) {
        this.context = context;

    }
public void getGradAdapter(GradView_layoit gradView_layoit){
    this.gradView_layoits=gradView_layoit;

}
    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public Object getItem(int position) {
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
            convertView = convertView.inflate(context, R.layout.fragment_classify_listviewitem, null);
            holder.textView = (TextView) convertView.findViewById(R.id.tv);

            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }



        holder.textView.setText(strs.get(position).getGc_name());

        //三级2列表的gridview

        if (strs.get(position).isshow()){

            gv = (MyGradView) convertView.findViewById(R.id.gridview);
            gv.setVisibility(View.VISIBLE);
            GradView_layoit gradView_layoit = new GradView_layoit(context);
            gradView_layoit.setData2(str);
            gv.setAdapter(gradView_layoit);
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent =new Intent(context, LineActivity.class);
                    context.startActivity(intent);
                }
            });
        }else{
            gv = (MyGradView) convertView.findViewById(R.id.gridview);
            gv.setVisibility(View.GONE);
        }




        return convertView;
    }

    public void setFalse() {

        for (int i = 0; i < strs.size(); i++) {
            strs.get(i).setIsshow(false);
        }
    }

    class MyHolder extends Handler {
        TextView textView;

    }

    public void setData(List<FuzhuangBean.DatasBean.ClassListBean>  class3) {
        strs.clear();
        if (class3 != null) {
            strs.addAll(class3);
        }
        notifyDataSetChanged();
    }


    public void setData(List<FuzhuangBean.DatasBean.ClassListBean>  class3,List<SortBean2.DatasBean.ClassListBean>  str_child) {

        if (class3 != null && str_child!=null) {
            strs=class3;
            str=str_child;
        }
        notifyDataSetChanged();
    }

}


