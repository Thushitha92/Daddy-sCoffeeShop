package Util;

import com.example.daddycoffie.ProductList;
import com.example.daddycoffie.product;

import retrofit2.Call;
import retrofit2.http.POST;

public interface JSONPlaceHolderApi {

    @POST("posts")
    Call<ProductList> getProducts();


}
