package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.component.DaggerPresenterComponent;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.component.PresenterComponent;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.module.PresenterModule;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.presenter.IPresenterImpl;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.view.IEditText;

public class MainActivity extends AppCompatActivity implements IEditText {


    @InjectView(R.id.et_ip)
    EditText etIp;
    @InjectView(R.id.tv_country)
    TextView tvCountry;
    @InjectView(R.id.ll_country)
    LinearLayout llCountry;
    @InjectView(R.id.tv_country_id)
    TextView tvCountryId;
    @InjectView(R.id.ll_country_id)
    LinearLayout llCountryId;
    @InjectView(R.id.tv_country_ip)
    TextView tvCountryIp;
    @InjectView(R.id.ll_country_ip)
    LinearLayout llCountryIp;
    private PresenterComponent presenterComponent;
    @Inject
    IPresenterImpl mIPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        presenterComponent =  DaggerPresenterComponent.builder().presenterModule(new PresenterModule(this,this)).build();
        presenterComponent.inject(this);
    }


    public void onClick(View v) {
        mIPresenter.getRequestData();
    }

    @Override
    public String getEtIp() {
        return etIp.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCountry(String country) {
        tvCountry.setText(String.valueOf(country));
    }

    @Override
    public void showCountryId(String countryId) {
        tvCountryId.setText(String.valueOf(countryId));
    }

    @Override
    public void showIP(String ip) {
        tvCountryIp.setText(String.valueOf(ip));
    }
}
