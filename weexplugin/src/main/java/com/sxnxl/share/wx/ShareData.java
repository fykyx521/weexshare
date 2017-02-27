package com.sxnxl.share.wx;


import java.util.Map;
/**
 * Created by fanyk on 2017/2/23.
 */

public class ShareData
{
    public static final int TEXT=1;
    public static final int IMG=2;
    public static final int MUSIC=3;
    public static final int VIDEO=4;
    public static final int WEB=5;

    private Map data;
    private ShareData(Map data)
    {
        this.data=data;
    }
    public static ShareData create(Map data)
    {
        return new ShareData(data);
    }

    public String getText()
    {
        return getString("text");
    }

    public String getImg()
    {
        return getString("img");
    }

    public String getThumb()
    {
        return getString("thumb");
    }

    public String getUrl()
    {
        return getString("url");
    }

    public String getMusic()
    {
        return getString("musicurl");
    }

    public int getScene()
    {
        return (Integer) data.get("scene");
    }
    public String getDescription()
    {
        return getString("description");
    }
    public String getTitle()
    {
        return getString("title");
    }

    /**
     *  分享类型
     * @return
     */
    public Integer getShareType()
    {
        Integer type=(Integer)data.get("sharetype");
        return type==null?TEXT:type;
    }

    public String getVideo() {
        return getString("videourl");
    }

    public String getWebUrl() {

        return getString("weburl");
    }

    public String getMediaTagName()
    {
        return getString("mediaTagName");
    }
    public String getMessageAction()
    {
        return getString("messageAction");
    }
    public String getMessageExt()
    {
        return getString("messageExt");
    }

    private String getString(String key)
    {
        return getString(key,"");
    }
    private String getString(String key,String defaultValue)
    {
        String value=defaultValue;
        try{
            value=(String) data.get(key);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return value;
    }


}
