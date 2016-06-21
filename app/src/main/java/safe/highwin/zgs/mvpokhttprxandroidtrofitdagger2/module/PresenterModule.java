package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter.IPresenterImpl;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.view.IEditText;

/**
 * Created by zgsHighwin on 2016/4/27.
 */
@Module
public class PresenterModule {

    private Context context;
    private IEditText iEditText;


    public PresenterModule(Context context, IEditText iEditText) {
        this.context = context;
        this.iEditText = iEditText;
    }

    @Provides
    public IPresenterImpl providePersenterModual() {
        return new IPresenterImpl(context, iEditText);
    }
}
