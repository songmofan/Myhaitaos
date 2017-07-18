package songmofan.baway.com.myhaitao.model.util;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import songmofan.baway.com.myhaitao.model.GetDataServes;
import songmofan.baway.com.myhaitao.model.bean.FuzhuangBean;
import songmofan.baway.com.myhaitao.model.bean.MyBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/9 15
 */

public class Myutil {
    private static final String TAG = "Myutil";

    //注册
    public static void singin(String username, String password, String password_confirm, String email, final GettextbBack gettextbBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.191.113/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<MyBean> login = getDataServes.singin(username, password, password_confirm, email, "android");
        login.enqueue(new Callback<MyBean>() {
            @Override
            public void onResponse(Call<MyBean> call, Response<MyBean> response) {
                Log.i(TAG, "onResponse: " + response);
                //将请求的结果回调
                //gettextbBack.gettext(response.body());
            }

            @Override
            public void onFailure(Call<MyBean> call, Throwable t) {

            }
        });
    }

    //*****************登陆***************

    public static void GetDataFromeServes(String username, String password, final GettextbBack gettextbBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.191.113/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        final GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<MyBean> login = getDataServes.login(username, password, "android");
        login.enqueue(new Callback<MyBean>() {
            @Override
            public void onResponse(Call<MyBean> call, Response<MyBean> response) {
                //将请求的结果回调
                Log.i(TAG, "onResponse: " + response);
                gettextbBack.gettext(response.body());
            }

            @Override
            public void onFailure(Call<MyBean> call, Throwable t) {
            }
        });

    }

    //*****分类的请求接口********
    public static void getSort(final GettextbBack gettextbBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.191.113/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        final GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<SortBean> sort = getDataServes.sort();
        sort.enqueue(new Callback<SortBean>() {
            @Override
            public void onResponse(Call<SortBean> call, Response<SortBean> response) {
                gettextbBack.gettext(response.body());
            }

            @Override
            public void onFailure(Call<SortBean> call, Throwable t) {

            }
        });


    }

    //*************二级列表************
    public static void getSort2(String gc_id,final GettextbBack gettextbBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.191.113/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        final GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<FuzhuangBean> fuzhuangBeanCall = getDataServes.sort_fuzhuang(gc_id);
        fuzhuangBeanCall.enqueue(new Callback<FuzhuangBean>() {
            @Override
            public void onResponse(Call<FuzhuangBean> call, Response<FuzhuangBean> response) {
                gettextbBack.gettext(response.body());
            }

            @Override
            public void onFailure(Call<FuzhuangBean> call, Throwable t) {
            }
        });
    }
//*************三级列表**********

    public static void getSort3(String gc_id,String gc_id1,final GettextbBack gettextbBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.191.113/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        final GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<SortBean2> sortBean2Call = getDataServes.sort3(gc_id,gc_id1);
        sortBean2Call.enqueue(new Callback<SortBean2>() {
            @Override
            public void onResponse(Call<SortBean2> call, Response<SortBean2> response) {
                gettextbBack.gettext(response.body());
            }
            @Override
            public void onFailure(Call<SortBean2> call, Throwable t) {

            }
        });
    }

    //回调接口
    public interface GettextbBack {
        <T> void gettext(T t);
    }
}


