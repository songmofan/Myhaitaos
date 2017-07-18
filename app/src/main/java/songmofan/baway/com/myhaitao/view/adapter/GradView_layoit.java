package songmofan.baway.com.myhaitao.view.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/5 20
 */

public class GradView_layoit extends BaseAdapter{
    private List<SortBean2.DatasBean.ClassListBean>  str = new ArrayList<>();
    private Context context;
    public GradView_layoit(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return str.size();
    }

    @Override
    public Object getItem(int position) {
        return str.get(position);
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
            convertView = convertView.inflate(context, R.layout.gradview_liem, null);
            holder.textView = (TextView) convertView.findViewById(R.id.text_grad);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        holder.textView.setText(str.get(position).getGc_name());
        return convertView;
    }

    class MyHolder extends Handler {
        TextView textView;

    }
    public void setData2(List<SortBean2.DatasBean.ClassListBean> class4) {
        str.clear();
        if (class4!= null) {
            str.addAll(class4);
        }

    }
}
