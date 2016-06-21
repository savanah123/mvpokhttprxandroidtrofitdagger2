package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.component;


import dagger.Component;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.module.RetrofitModule;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter.IPresenterImpl;

/**
 * Created by zgsHighwin on 2016/4/27.
 */
@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {
    void inject(IPresenterImpl iPresenter);
}
