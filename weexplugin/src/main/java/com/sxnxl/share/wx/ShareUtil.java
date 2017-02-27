package com.sxnxl.share.wx;

import android.content.Context;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by fanyk on 2017/2/24.
 */

public class ShareUtil {

    public static String WXAPIKey="wxd930ea5d5a258f4f";

    /**
     *  注册微信APP
     * @param context
     */
    public static void registerWxApp(Context context)
    {
        IWXAPI api=createWxApi(context);
        api.registerApp(ShareUtil.WXAPIKey);
    }

    public static IWXAPI createWxApi(Context context)
    {
        return  WXAPIFactory.createWXAPI(context, ShareUtil.WXAPIKey);
    }

    public void onResp(Context context,BaseResp resp) {
        String result = "";
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                result = "分享成功";
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result = "取消";
                break;
        }
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }
}
