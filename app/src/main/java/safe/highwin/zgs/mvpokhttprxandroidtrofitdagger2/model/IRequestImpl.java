package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.model;


import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.beans.TargetBean;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.builder.APIBuild;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter.IPresenter;

/**
 * Created by zgsHighwin on 2016/4/25.
 */
public class IRequestImpl implements IRequest {

    @Override
    public void requestData(String ip, APIBuild apiBuild, final IPresenter iPresenter) {
        Observable<TargetBean> data = apiBuild.getData(ip);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<TargetBean>() {
                    @Override
                    public void onCompleted() {
                        iPresenter.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iPresenter.OnFailure(e);
                    }

                    @Override
                    public void onNext(TargetBean targetBean) {
                        iPresenter.OnSucces(targetBean);
                    }
                });
    }
}
