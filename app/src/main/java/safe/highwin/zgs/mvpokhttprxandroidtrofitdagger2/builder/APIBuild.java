package safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.builder;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import safe.highwin.zgs.mvpokhttprxandroidtrofitdagger2.beans.TargetBean;

/**
 * Created by zgsHighwin on 2016/4/25.
 */
public interface APIBuild {
    //http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33

    /**
     * 获取数据
     * @param ip
     * @return
     */
    @GET("service/getIpInfo.php")
    Observable<TargetBean> getData(@Query("ip") String ip);
}
