package com.sxnxl.share.wx;

import android.graphics.Bitmap;

import com.taobao.weex.utils.WXUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

import java.util.Map;





public class ShareBuilder {

    private ShareData data;
    private WXMediaMessage.IMediaObject mediaObject;
    private WXMediaMessage msg;
    private int shareType=ShareData.TEXT;
    private ShareBuilder(ShareData data)
    {
        this.data=data;
    }

    private static ShareBuilder create(ShareData data)
    {
        return new ShareBuilder(data);
    }

    public ShareBuilder text()
    {
        WXTextObject text=new WXTextObject();
        text.text=data.getText();
        this.mediaObject=text;
        return this;
    }
    public ShareBuilder image(ShareImage image)
    {
        WXImageObject img=new WXImageObject();
        if(image!=null)
        {
            img.imageData=image.getImage(data.getImg());
        }
        this.mediaObject=img;
        return this;
    }
    public ShareBuilder music()
    {
        WXMusicObject musicObject=new WXMusicObject();
        musicObject.musicUrl=data.getMusic();
        this.mediaObject=musicObject;
        return this;
    }
    public ShareBuilder video()
    {
        WXVideoObject video=new WXVideoObject();
        video.videoUrl=data.getVideo();
        this.mediaObject=video;
        return this;
    }
    public ShareBuilder web()
    {
        WXWebpageObject video=new WXWebpageObject();
        video.webpageUrl=data.getWebUrl();
        this.mediaObject=video;
        return this;
    }

    public ShareBuilder media(ShareImage image)
    {
        this.msg = new WXMediaMessage();
        if(image!=null)
        {
            byte[] thumb=image.getThumb(data.getThumb());
            msg.thumbData=thumb;
        }
        msg.mediaObject = this.mediaObject;
        msg.title=this.data.getTitle();
        msg.description = this.data.getDescription();
        return this;
    }

    public SendMessageToWX.Req req(String type)
    {
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(type);
        req.message = this.msg;
        req.scene = this.data.getScene();
        return req;
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    public static SendMessageToWX.Req buildRequest(Map map)
    {
       return buildRequest(map,null);
    }
    public static SendMessageToWX.Req buildRequest(Map map,ShareImage image)
    {
        ShareData data=ShareData.create(map);
        ShareBuilder builder=ShareBuilder.create(data);
        String type="text";
        switch (data.getShareType())
        {
            case ShareData.TEXT: builder.text(); type="text";break;
            case ShareData.IMG:  builder.image(image);type="img";break;
            case ShareData.MUSIC: builder.music();type="music";break;
            case ShareData.VIDEO: builder.video();type="video";break;
            case ShareData.WEB: builder.web();type="webpage";break;
        }
        return builder.media(image).req(type);
    }
    public static interface ShareImage {
        byte[] getImage(String url);
        byte[] getThumb(String url);

    }


}
