package songmofan.baway.com.myhaitao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.LineBean;
import songmofan.baway.com.myhaitao.presenter.LineActicityPresenter;
import songmofan.baway.com.myhaitao.view.adapter.Recycal_Adapter;
import songmofan.baway.com.myhaitao.view.iview.LineActivityView;
import songmofan.baway.com.myhaitao.view.iview.Mylistener;

public class LineActivity extends AppCompatActivity implements LineActivityView,Mylistener {

    private RecyclerView recyclerViewiew;
    private Recycal_Adapter adapter;
    private List<LineBean.DatasBean.GoodsListBean> goods_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        initview();
        initdata();
    }

    private void initdata() {
        LineActicityPresenter lineActicityPresenter=new LineActicityPresenter();
        lineActicityPresenter.attach(this);
        lineActicityPresenter.getDataLineText();
        adapter = new Recycal_Adapter();
        adapter.attach(LineActivity.this);
        adapter.setonclick(this);
        recyclerViewiew.setAdapter(adapter);


    }

    private void initview() {

        //设置recyclerViewiew显示的类型
        recyclerViewiew = (RecyclerView) findViewById(R.id.recyclerView);
       // TODO: 2017/7/6 默认分割线
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerViewiew.setLayoutManager(linearLayoutManager);

    }
//// TODO: 2017/7/6
    @Override
    public void callBack(LineBean lineBean) {
        goods_list = lineBean.getDatas().getGoods_list();
         adapter.setData(goods_list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void callBackErro(int code, String msg) {

    }

    @Override
    public void setMyOncliclisener(View view, int position) {
        Intent intent=new Intent(LineActivity.this,XiangqActivity.class);
        String goods_id = goods_list.get(position).getGoods_id();
        intent.putExtra("goods_id",goods_id);
        startActivity(intent);
       //  finish();
    }
}
