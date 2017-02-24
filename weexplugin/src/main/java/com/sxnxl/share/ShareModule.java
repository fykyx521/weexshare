package com.sxnxl.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;
import com.taobao.weex.ui.module.WXMetaModule;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by fanyk on 2017/2/22.
 */

public class ShareModule extends WXSDKEngine.DestroyableModule {

    protected IShareFactory factory;
    @Override
    public void onActivityCreate() {
        super.onActivityCreate();
    }

    public void setShareFactory(IShareFactory factory)
    {
        this.factory=factory;
    }


    @JSMethod(uiThread = true)
    public void printLog(Map map) {
        String msg=(String) map.get("msg");
        Toast.makeText(mWXSDKInstance.getContext(),msg,Toast.LENGTH_SHORT).show();
    }


    @JSMethod(uiThread = false)
    public void share(String type,Map data)  {
        try
        {
            int typeInt=Integer.parseInt(type);
            this.beforeShare(mWXSDKInstance.getContext(),typeInt,data);
            IShare share=this.factory.createShare(typeInt,data,mWXSDKInstance.getContext());
            share.share();
            this.afterShare(mWXSDKInstance.getContext(),typeInt,data);
        }catch (Exception e)
        {
            Log.e("com.sxnxl",e.getMessage(),e);
        }
    }

    protected void beforeShare(Context context,int type,Map data)
    {
        Intent it=new Intent();
        it.setAction("com.sxnxl.share");
        it.putExtra("sharetype",type);
        it.putExtra("actiontype","before");
        for(Object o : data.keySet()){
            it.putExtra(o.toString(),data.get(o).toString());
        }
        mWXSDKInstance.getContext().sendBroadcast(it);
    }

    protected void afterShare(Context context,int type,Map data)
    {
        Intent it=new Intent();
        it.setAction("com.sxnxl.share");
        it.putExtra("sharetype",type);
        it.putExtra("actiontype","after");
        for(Object o : data.keySet()){
            it.putExtra(o.toString(),data.get(o).toString());
        }
        mWXSDKInstance.getContext().sendBroadcast(it);
    }



    @Override
    public void destroy() {

    }
}
