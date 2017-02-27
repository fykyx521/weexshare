package com.sxnxl.share;

import android.content.Context;
import android.content.res.Resources;

import com.sxnxl.share.wx.WXShare;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanyk on 2017/2/23.
 */

public class DefaultShareFactory implements IShareFactory {


    public static final Map<String,IShare> shareMap=new HashMap<String,IShare>();
    @Override
    public IShare createShare(int type, Map data, Context context) {
        IShare share=null;
        switch (type)
        {
            case IShareFactory.WX: share=this.createWXShare(type,data,context);
        }
        if(share==null)
        {
            throw new RuntimeException("未找到");
        }
        return share;
    }


    protected IShare createWXShare(int type,Map data,Context context)
    {
        return new WXShare(type,data,context);
    }


}
