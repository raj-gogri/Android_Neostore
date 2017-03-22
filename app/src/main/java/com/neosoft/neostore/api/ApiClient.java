package com.neosoft.neostore.api;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(String url) {
        if (retrofit == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            //The logging interceptor will be added to the http client
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            retrofit = new Retrofit.Builder()
                    .client(httpClient.build())
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

//            httpClient.addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Interceptor.Chain chain) throws IOException {
//                    Request original = chain.request();
//
//                    // Request customization: add request headers
//                    Request.Builder requestBuilder = original.newBuilder()
//                            .addHeader("access_token","58578925364ae");
//
//                    Request request = requestBuilder.build();
//                    return chain.proceed(request);
//                }
//            });

        }
        return retrofit;
    }
}
