package songmofan.baway.com.myhaitao.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.LoginBean;
import songmofan.baway.com.myhaitao.view.activity.UserLogInAcitviy;
import songmofan.baway.com.myhaitao.view.iview.LoginView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/9 15
 */

public class MeFragment extends Fragment implements View.OnClickListener,LoginView {

    private ListView myFragmentListView;
    private ListView myFragmentListView_1;
    private ImageView fragmentImageviewIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();

    }

    private void initview() {

        //问答动态与为你推荐的两个listview
        myFragmentListView = (ListView) getView().findViewById(R.id.myFragmentListView);
        myFragmentListView_1 = (ListView) getView().findViewById(R.id.myFragmentListView_1);
        //头像图片
        fragmentImageviewIcon = (ImageView) getView().findViewById(R.id.fragmentImageviewIcon);
        fragmentImageviewIcon.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),UserLogInAcitviy.class);
        startActivity(intent);
    }


    @Override
    public void callBack(LoginBean loginBean) {
        String username = loginBean.getDatas().getUsername();
        Toast.makeText(getActivity(), "username"+username, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void callBackErro() {

    }
}
