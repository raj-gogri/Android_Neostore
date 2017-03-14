package com.neosoft.neostore.API;




import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nidhi on 10/3/17.
 */
public class ApiClient {



	//public static final String FETCH_URL = "http://staging.php-dev.in:8844/trainingapp/";

	private static Retrofit retrofit = null;

	private static Retrofit ObservableRetrofit = null;

	public static Retrofit getClient(String url) {
		if ( retrofit == null ) {


			HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
			httpLoggingInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY );

//			OkHttpClient client = new OkHttpClient.Builder()
//					.addNetworkInterceptor(new StethoInterceptor())
//					.build();

			OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
			httpClient.addInterceptor( httpLoggingInterceptor );
			httpClient.connectTimeout(30,TimeUnit.SECONDS );
			httpClient.readTimeout( 30,TimeUnit.SECONDS );
			httpClient.writeTimeout( 30,TimeUnit.SECONDS );


			retrofit = new Retrofit.Builder()
					.client( httpClient.build() )
					.baseUrl( url )
					.addConverterFactory( GsonConverterFactory.create() )
					.build();


		}

		return retrofit;

	}

	public static Retrofit getObservableClient(String url1) {

		if ( ObservableRetrofit == null ) {


			HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
			httpLoggingInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY );

//			OkHttpClient client = new OkHttpClient.Builder()
//					.addNetworkInterceptor(new StethoInterceptor())
//					.build();

			OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
			httpClient.addInterceptor( httpLoggingInterceptor );
			httpClient.connectTimeout(30,TimeUnit.SECONDS );
			httpClient.readTimeout( 30,TimeUnit.SECONDS );
			httpClient.writeTimeout( 30,TimeUnit.SECONDS );


			ObservableRetrofit = new Retrofit.Builder()
					.client( httpClient.build() )
					.baseUrl( url1 )
					.addCallAdapterFactory( RxJavaCallAdapterFactory.create() )
					.addConverterFactory( GsonConverterFactory.create() )
					.build();


		}

		return ObservableRetrofit;

	}
}
