package songmofan.baway.com.myhaitao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import songmofan.baway.com.myhaitao.R;
import songmofan.baway.com.myhaitao.view.fragment.CartFragment;
import songmofan.baway.com.myhaitao.view.fragment.ClassifyFragment;
import songmofan.baway.com.myhaitao.view.fragment.HomeFragment;
import songmofan.baway.com.myhaitao.view.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mainRadioGroup;
    private DrawerLayout main_drawerlayout;
    private ArrayList<Fragment> fragments;
    private RadioButton mainRadioButtomCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolBar();
      //  initData();
        initview();
        deflountFragment();

    }

    @Override
    protected void onRestart() {

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new CartFragment()).commit();
        mainRadioButtomCart.setChecked(true);
        super.onRestart();


    }

    private void initData() {

        HomeFragment homeFragment = new HomeFragment();
        MeFragment meFragment = new MeFragment();
        CartFragment cartFragment = new CartFragment();
        ClassifyFragment classifyFragment = new ClassifyFragment();

        fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(classifyFragment);
        fragments.add(cartFragment);
        fragments.add(meFragment);

        // addFragment(fragments);

    }

    //***************Event*********
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    //   @Subscribe(threadMode = ThreadMode.MAIN)
//    public void dataEventBus(EventBusBean eventBusBean) {
//
//        int index = eventBusBean.getIndex();
//        Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();
//
////        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
////        fragmentTransaction.add(R.id.mainFrameLayout,new CartFragment());
////        fragmentTransaction.commitAllowingStateLoss();
//
//
//            //ReplceFragment(index);
//    }
    private void myToolBar() {
        //重要的两段代码
        Toolbar too = (Toolbar) findViewById(R.id.toolbar);
        //替代ActionBar
        setSupportActionBar(too);
        //
        main_drawerlayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.sandaogang);

        }


    }

    //************************ToolBar*************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载 res/menu/toolbar.xml 文件
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                main_drawerlayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 0);
                break;
            case R.id.delete:
                Toast.makeText(this, "You Clicked delete", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }

    //************************ToolBar*************************


    private void deflountFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new HomeFragment()).commit();
    }


    private void initview() {

        mainRadioGroup = (RadioGroup) findViewById(R.id.mainRadioGroup);
        mainRadioButtomCart = (RadioButton) findViewById(R.id.mainRadioButtomCart);

        mainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {

                    case R.id.mainRadioButtomHome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new HomeFragment()).commit();
                        break;
                    case R.id.mainRadioButtomClassify:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new ClassifyFragment()).commit();
                        break;
                    case R.id.mainRadioButtomCart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new CartFragment()).commit();
                        break;
                    case R.id.mainRadioButtomMe:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new MeFragment()).commit();
                        break;
                }
                //  ReplceFragment(position);
                // showFragment(position);
            }
        });


    }

//    private void ReplceFragment(int position) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.mainFrameLayout, fragments.get(position)).commit();
//    }
//
//    private void addFragment(ArrayList<Fragment> fragments) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        for (int i = 0; i < fragments.size(); i++) {
//            fragmentTransaction.add(R.id.mainFrameLayout, fragments.get(i));
//        }
//        fragmentTransaction.commit();
//    }
//
//    private void showFragment(int position) {
//
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        for (int i = 0; i < fragments.size(); i++) {
//            fragmentTransaction.hide(fragments.get(i));
//
//        }
//        fragmentTransaction.show(fragments.get(position));
//        fragmentTransaction.commitAllowingStateLoss();
//
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String result = data.getExtras().getString("result");
            // TODO: 2017/6/17 扫描的结果 
        }
    }
}
