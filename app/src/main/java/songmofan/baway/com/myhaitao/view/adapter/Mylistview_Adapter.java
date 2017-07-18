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
import songmofan.baway.com.myhaitao.model.bean.SortBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/22 16
 */

public class Mylistview_Adapter extends BaseAdapter {

    private Context context;
    private List<SortBean.DatasBean.ClassListBean> strs = new ArrayList<>();


    public Mylistview_Adapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public SortBean.DatasBean.ClassListBean getItem(int position) {
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

        return convertView;
    }

    class MyHolder extends Handler {
        TextView textView;

    }

    public void setData(List<SortBean.DatasBean.ClassListBean> sortList) {
        strs.clear();
        if (sortList != null) {
            strs.addAll(sortList);
        }

    }

}


