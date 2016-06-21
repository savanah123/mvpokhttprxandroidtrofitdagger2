package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.model;


import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.builder.APIBuild;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter.IPresenter;

/**
 * Created by zgsHighwin on 2016/4/25.
 */
public interface IRequest {

    void requestData(String ip, APIBuild apiBuild, IPresenter iPresenter);

}
