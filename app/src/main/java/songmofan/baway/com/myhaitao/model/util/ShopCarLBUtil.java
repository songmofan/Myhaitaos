package songmofan.baway.com.myhaitao.model.util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import songmofan.baway.com.myhaitao.model.GetDataServes;
import songmofan.baway.com.myhaitao.model.bean.ShopCarBean;

import static android.media.CamcorderProfile.get;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/7 17
 */

public class ShopCarLBUtil {

    public static void getDataFromServer(String key, final GettextbBacks gettextbBacks) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.133.48/")
                //设置gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //初始化接口对象
        final GetDataServes getDataServes = retrofit.create(GetDataServes.class);
        //调用接口的方法 返回call集合
        Call<ShopCarBean> shopCarBeanCall = getDataServes.shopCar(key);
        shopCarBeanCall.enqueue(new Callback<ShopCarBean>() {
            @Override
            public void onResponse(Call<ShopCarBean> call, Response<ShopCarBean> response) {
                gettextbBacks.gettext(response.body());
            }

            @Override
            public void onFailure(Call<ShopCarBean> call, Throwable t) {

            }
        });
    }





    //回调接口
    public interface GettextbBacks {
        <T> void gettext(T t);
    }

}
