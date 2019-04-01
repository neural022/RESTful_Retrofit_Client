package tw.com.flag.retrofit_restful;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager manager = new RetrofitManager();
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private RetrofitManager(){
        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                //  input your ip (http://ip:port)
                .baseUrl("http://127.0.0.1:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public static Retrofit getClient(){
        return manager.retrofit;
    }
}