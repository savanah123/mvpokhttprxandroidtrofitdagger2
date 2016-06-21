package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter;


import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.beans.TargetBean;

/**
 * Created by zgsHighwin on 2016/4/25.
 */
public interface IPresenter {

    void OnSucces(TargetBean targetBean);

    void OnFailure(Throwable e);

    void onFinish();


}
