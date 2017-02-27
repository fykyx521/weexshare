package com.sxnxl.share.wx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.sxnxl.share.IShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

/**
 * Created by fanyk on 2017/2/23.
 */

public class WXShare implements IShare,ShareBuilder.ShareImage {

    protected int type;
    protected Map data;
    protected IWXAPI api=null;
    private int mTargetScene = SendMessageToWX.Req.WXSceneSession;
    public WXShare(int type, Map data, Context context)
    {
        this.type=type;
        this.data=data;
        this.api=this.createWXAPI(context);
    }

    protected IWXAPI createWXAPI(Context context)
    {
        api = ShareUtil.createWxApi(context);
        return api;
    }

    @Override
    public void share() {
        api.sendReq(ShareBuilder.buildRequest(data,this));
    }


    @Override
    public byte[] getImage(String url) {
        return GetLocalOrNetBitmap(url);
    }

    @Override
    public byte[] getThumb(String url) {
        return GetLocalOrNetBitmap(url);
    }

    private static byte[] GetLocalOrNetBitmap(String url) {
        Bitmap bitmap = null;
        InputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new URL(url).openStream(), 1024);
            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
            out = new BufferedOutputStream(dataStream, 1024);
            copy(in, out);
            out.flush();
            byte[] data = dataStream.toByteArray();
            return data;
//            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
//            data = null;
//            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void copy(InputStream in, OutputStream out)
            throws IOException {
        byte[] b = new byte[1024];
        int read;
        while ((read = in.read(b)) != -1) {
            out.write(b, 0, read);
        }
    }

}
