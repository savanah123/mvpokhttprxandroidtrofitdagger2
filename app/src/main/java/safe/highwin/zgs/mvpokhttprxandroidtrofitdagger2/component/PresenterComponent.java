package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.component;


import dagger.Component;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.MainActivity;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.module.PresenterModule;

/**
 * Created by zgsHighwin on 2016/4/27.
 */

@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    void inject(MainActivity mainActivity);
}
