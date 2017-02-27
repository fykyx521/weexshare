package com.sxnxl.share;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.MethodInvoker;


/**
 * Created by fanyk on 2017/2/23.
 */

public class ShareModuleFactory extends WXSDKEngine.DestroyableModuleFactory<WXSDKEngine.DestroyableModule> {

    public ShareModuleFactory(Class className)
    {
        super(className);
    }


    @Override
    public WXSDKEngine.DestroyableModule buildInstance() throws IllegalAccessException, InstantiationException {
        ShareModule module= new ShareModule();
        module.setShareFactory(new DefaultShareFactory());
        return module;
    }


//    @Override
//    public String[] getMethods() {
//        return new String[]{"share"};
//    }
//
//    @Override
//    public Invoker getMethodInvoker(String name) {
//        try {
//            return  new MethodInvoker(ShareModule.class.getMethod("share"),true);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
