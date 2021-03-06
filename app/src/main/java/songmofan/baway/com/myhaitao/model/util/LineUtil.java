package songmofan.baway.com.myhaitao.model.util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import songmofan.baway.com.myhaitao.model.GetDataServes;
import songmofan.baway.com.myhaitao.model.bean.LineBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/6 11
 */

public class LineUtil {


    public static void getDataFromServer(final GettextbBacks gettextbBacks) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.191.113/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        final GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<LineBean> line = getDataServes.getLine();
        line.enqueue(new Callback<LineBean>() {
            @Override
            public void onResponse(Call<LineBean> call, Response<LineBean> response) {
                gettextbBacks.gettext(response.body());
            }

            @Override
            public void onFailure(Call<LineBean> call, Throwable t) {

            }
        });
    }

    //回调接口
    public interface GettextbBacks {
        <T> void gettext(T t);
    }
}
