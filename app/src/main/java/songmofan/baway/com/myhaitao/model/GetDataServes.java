package songmofan.baway.com.myhaitao.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import songmofan.baway.com.myhaitao.model.bean.AddshopBean;
import songmofan.baway.com.myhaitao.model.bean.FuzhuangBean;
import songmofan.baway.com.myhaitao.model.bean.LineBean;
import songmofan.baway.com.myhaitao.model.bean.MyBean;
import songmofan.baway.com.myhaitao.model.bean.ShopCarBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean;
import songmofan.baway.com.myhaitao.model.bean.SortBean2;
import songmofan.baway.com.myhaitao.model.bean.XiangBean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/12 14
 */

public interface GetDataServes {

    //**********登陆注册**************
    @FormUrlEncoded
    @POST("mobile/index.php?act=login")
    Call<MyBean> login(@Field("username") String username,
                       @Field("password") String password,
                       @Field("client") String client);

    @FormUrlEncoded
    @POST("mobile/index.php?act=login")
    Call<MyBean> singin(@Field("username") String username,
                        @Field("password") String password,
                        @Field("password_confirm") String password_confirm,
                        @Field("email") String email,
                        @Field("client") String client);

    //**********分类**********

    //一级
    @GET("mobile/index.php?act=goods_class")
    Call<SortBean> sort();

    //二级
    @GET("mobile/index.php?act=goods_class")
    Call<FuzhuangBean> sort_fuzhuang(@Query("gc_id") String gc_id);
    //三级
    @GET("mobile/index.php?act=goods_class")
    Call<SortBean2> sort3(@Query("gc_id") String gc_id,@Query("gc_id") String gc_id1 );



    //获得列表
    @GET("mobile/index.php?act=goods&op=goods_list&page=100")
    Call<LineBean> getLine();

    //获得介绍
    @GET("mobile/index.php?act=goods&op=goods_detail")
    Call<XiangBean> getXiang(@Query("goods_id") String goods_id);

    //添加购物车
    @FormUrlEncoded
    @POST("mobile/index.php?act=member_cart&op=cart_add")
    Call<AddshopBean> addshowpcar(@Field("goods_id") String gc_id,
                                  @Field("key") String key,
                                  @Field("quantity") String quantity);
//查看购物车
    @FormUrlEncoded
    @POST("mobile/index.php?act=member_cart&op=cart_list")
    Call<ShopCarBean> shopCar(@Field("key") String key);

    //删除购物车
    @FormUrlEncoded
    @POST("mobile/index.php?act=member_cart&op=cart_del")
    Call<AddshopBean> deleteshop(@Field("cart_id") String cart_id,
                                  @Field("key") String key,
                                  @Field("quantity") String quantity);

    //提交
    @FormUrlEncoded
    @POST("mobile/index.php?act=member_buy&op=buy_step1")
    Call<AddshopBean> order(@Field("cart_id") String cart_idkey,
                                 @Field("key") String key,
                                 @Field("ifcart") int ifcart);
}
