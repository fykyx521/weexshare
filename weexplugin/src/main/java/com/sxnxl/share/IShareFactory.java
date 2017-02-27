package com.sxnxl.share;

import android.content.Context;

import java.util.Map;

/**
 * Created by fanyk on 2017/2/23.
 */

public interface IShareFactory {
    static final int WX=10;//
    static final int QQ=20;
    IShare createShare(int type,Map data, Context context);


}
