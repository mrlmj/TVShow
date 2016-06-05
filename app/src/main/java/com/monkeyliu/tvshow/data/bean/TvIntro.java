package com.monkeyliu.tvshow.data.bean;

import cn.bmob.v3.BmobObject;

/**
 * @author monkey
 * @date 2016/6/3 0003.
 */
public class TvIntro extends BmobObject {
    private String tv_name;

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_imageurl() {
        return tv_imageurl;
    }

    public void setTv_imageurl(String tv_imageurl) {
        this.tv_imageurl = tv_imageurl;
    }

    public String getTv_intro() {
        return tv_intro;
    }

    public void setTv_intro(String tv_intro) {
        this.tv_intro = tv_intro;
    }

    public String getTv_type() {
        return tv_type;
    }

    public void setTv_type(String tv_type) {
        this.tv_type = tv_type;
    }

    private String tv_imageurl;
    private String tv_intro;
    private String tv_type;
}
