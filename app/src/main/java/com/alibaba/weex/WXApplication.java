package com.alibaba.weex;

import android.app.Application;

import com.alibaba.weex.commons.adapter.ImageAdapter;
import com.alibaba.weex.commons.util.AppConfig;
import com.alibaba.weex.extend.module.WXEventModule;
import com.alibaba.weex.pluginmanager.PluginConfig;
import com.alibaba.weex.pluginmanager.PluginManager;
import com.facebook.drawee.backends.pipeline.Fresco;

import com.sxnxl.share.ShareModule;
import com.sxnxl.share.ShareModuleFactory;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXModule;

public class WXApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
//    initDebugEnvironment(false, "DEBUG_SERVER_HOST");
    WXSDKEngine.addCustomOptions("appName", "WXSample");
    WXSDKEngine.addCustomOptions("appGroup", "WXApp");
    WXSDKEngine.initialize(this,
        new InitConfig.Builder()
            .setImgAdapter(new ImageAdapter())
            .build()
    );

    try {
      WXSDKEngine.registerModule("event", WXEventModule.class);
      ShareModuleFactory factory=new ShareModuleFactory(ShareModule.class);
       WXSDKEngine.registerModuleWithFactory("sharemodule", factory,true);

    } catch (WXException e) {
      e.printStackTrace();
    }
    Fresco.initialize(this);
    AppConfig.init(this);
    PluginConfig.init(this);
    PluginManager.registerComponents(PluginConfig.getComponents());
    PluginManager.registerModules(PluginConfig.getModules());

  }

  /**
   * @param enable enable remote debugger. valid only if host not to be "DEBUG_SERVER_HOST".
   *               true, you can launch a remote debugger and inspector both.
   *               false, you can  just launch a inspector.
   * @param host   the debug server host, must not be "DEBUG_SERVER_HOST", a ip address or domain will be OK.
   *               for example "127.0.0.1".
   */
  private void initDebugEnvironment(boolean enable, String host) {
    if (!"DEBUG_SERVER_HOST".equals(host)) {
      WXEnvironment.sRemoteDebugMode = enable;
      WXEnvironment.sRemoteDebugProxyUrl = "ws://" + host + ":8088/debugProxy/native";
    }
  }

}
