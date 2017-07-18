package songmofan.baway.com.myhaitao.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.FuzhuangBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;
import songmofan.baway.com.myhaitao.presenter.SortPresenter;
import songmofan.baway.com.myhaitao.view.adapter.GradView_layoit;
import songmofan.baway.com.myhaitao.view.adapter.Mylistview2_Adapter;
import songmofan.baway.com.myhaitao.view.adapter.Mylistview_Adapter;
import songmofan.baway.com.myhaitao.view.iview.SortView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/9 15
 */

public class ClassifyFragment extends Fragment implements AdapterView.OnItemClickListener, SortView {


    private ListView listView;
    private Mylistview_Adapter mylistview_adapter;
    private List<FuzhuangBean.DatasBean.ClassListBean> class_list=new ArrayList<>();
    private List<SortBean2.DatasBean.ClassListBean> class3=new ArrayList<>();
    private ListView listView2;
    private Mylistview2_Adapter mylistview_adapter2;
    private GradView_layoit gradView_layoit;
    private List<SortBean.DatasBean.ClassListBean> sortList=new ArrayList<>();
    private SortPresenter sortPresenter;
    private FuzhuangBean.DatasBean.ClassListBean item;
    private String gc_id;
    private  int index=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_classify, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
        initview();
    }

    private void initview() {

        listView = (ListView) getView().findViewById(R.id.listview);
        listView2 = (ListView) getView().findViewById(R.id.listview2);
        //适配器
        mylistview_adapter = new Mylistview_Adapter(getActivity());
        mylistview_adapter2 = new Mylistview2_Adapter(getActivity());
        gradView_layoit = new GradView_layoit(getActivity());

        listView.setAdapter(mylistview_adapter);
        listView2.setAdapter(mylistview_adapter2);
        mylistview_adapter2.getGradAdapter(gradView_layoit);

        listView.setOnItemClickListener(this);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = (FuzhuangBean.DatasBean.ClassListBean) mylistview_adapter2.getItem(position);
                String gc_id1 = item.getGc_id();
                index=position;
                sortPresenter.getSortText3(gc_id, gc_id1);

                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void initdata() {
        sortPresenter = new SortPresenter();
        sortPresenter.acctch(this);
        sortPresenter.getSortText();
        sortPresenter.getSortText2("1");
        sortPresenter.getSortText3("1","4");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SortBean.DatasBean.ClassListBean item = mylistview_adapter.getItem(position);
        gc_id = item.getGc_id();
        sortPresenter.getSortText2(gc_id);
        Toast.makeText(getActivity(), "gc_id"+gc_id, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void callBack(SortBean sortBean) {
        sortList = sortBean.getDatas().getClass_list();
        mylistview_adapter.setData(sortList);
        mylistview_adapter.notifyDataSetChanged();

    }

    @Override
    public void callBack2(FuzhuangBean fuzhuangBean) {
        class_list = fuzhuangBean.getDatas().getClass_list();
        mylistview_adapter2.setData(class_list);
        mylistview_adapter2.notifyDataSetChanged();

    }

    /**
     * @param sortBean2
     */
    @Override
    public void callBack3(SortBean2 sortBean2) {

        class3 = sortBean2.getDatas().getClass_list();
        mylistview_adapter2.setFalse();
        if (class_list.size()>0){
            class_list.get(index).setIsshow(true);
        }
        mylistview_adapter2.setData(class_list,class3);
    }


    @Override
    public void callBacakErro(int code) {




    }


}