package songmofan.baway.com.myhaitao.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.model.bean.Girl;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/9 15
 */

public class HomeFragment extends Fragment{

    private ViewPager viewPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inirdata();
        initview();


    }

    private void inirdata() {
        ArrayList<Girl> list = new ArrayList<>();
        list.add(new Girl(R.drawable.taeyeon_one));
        list.add(new Girl(R.drawable.taeyeon_two));
        list.add(new Girl(R.drawable.taeyeon_three));
        list.add(new Girl(R.drawable.taeyeon_four));
    }

    private void initview() {
        viewPage = (ViewPager) getView().findViewById(R.id.viewpage);


    }
}
