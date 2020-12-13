package Util;

import Model.Order;
import Model.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JSONPlaceHolderApi {

    @GET("view")
    Call<List<product>> getProducts();

    @POST("add")
    Call<String> addOrder(@Body Order order);

//    @GET("posts")
//    Call<ProductList> getProducts();

}
