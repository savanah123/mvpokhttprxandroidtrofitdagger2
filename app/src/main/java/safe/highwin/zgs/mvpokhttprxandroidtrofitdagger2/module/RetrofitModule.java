package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.module;


import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.constants.Constants;

/**
 * Created by zgsHighwin on 2016/4/27.
 */
@Module
public  class RetrofitModule{
    @Provides
    public Retrofit provfideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
