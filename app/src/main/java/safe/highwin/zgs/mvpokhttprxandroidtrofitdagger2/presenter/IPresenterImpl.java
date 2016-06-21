package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import retrofit2.Retrofit;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.BuildConfig;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.beans.TargetBean;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.builder.APIBuild;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.component.DaggerRetrofitComponent;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.component.RetrofitComponent;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.model.IRequest;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.model.IRequestImpl;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.module.RetrofitModule;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.view.IEditText;

/**
 * Created by zgsHighwin on 2016/4/25.
 */
public class IPresenterImpl implements IPresenter {

    private Context context;
    private IEditText iEditText;
    private IRequest iRequest;
    private RetrofitComponent retrofitComponent;

    @Inject
    Retrofit mRetrofit;

    public IPresenterImpl(Context context, IEditText iEditText) {
        this.context = context;
        this.iEditText = iEditText;
        iRequest = new IRequestImpl();
        retrofitComponent = DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule()).build();
        retrofitComponent.inject(this);
    }

    public void getRequestData() {
        String etIp = iEditText.getEtIp();
        if (TextUtils.isEmpty(etIp)) {
            iEditText.showToast("ip不能为空");
            return;
        }
        APIBuild service = mRetrofit.create(APIBuild.class);
        iRequest.requestData(etIp, service, this);
    }


    @Override
    public void OnSucces(TargetBean targetBean) {
        String dataString = targetBean.getData().toString();
        TargetBean.DataBean data = targetBean.getData();
        int code = targetBean.getCode();
        if (BuildConfig.DEBUG) Log.d("IPresenterImpl", dataString);
        if (BuildConfig.DEBUG) Log.d("IPresenterImpl", "code:" + code);
        iEditText.showCountry(data.getCountry().toString().toString().trim());
        iEditText.showCountryId(data.getCountry_id().toString().trim());
        iEditText.showIP(data.getIp().toString().trim());
    }

    @Override
    public void onFinish() {
        iEditText.showToast("finish");
    }

    @Override
    public void OnFailure(Throwable e) {
        if (BuildConfig.DEBUG) Log.d("IPresenterImpl", e.toString());
        iEditText.showToast(e.toString());
    }
}
