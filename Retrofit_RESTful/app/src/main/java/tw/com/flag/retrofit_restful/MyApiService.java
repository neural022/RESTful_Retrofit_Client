package tw.com.flag.retrofit_restful;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyApiService {
    //  input your sub path
    @GET("/Service/get")
    Call<List<Datas>> getData();

    @GET("/Service/get/{string}")
    Call<List<Datas>> getString(@Path("string") String data);

    @POST("/Service/post/{num}")
    Call<List<Datas>> postData(@Path("num") int data);
}
