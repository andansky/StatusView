package andan.statusview;

/**
 * Created by nongyudi on 2017/3/11.
 */

public class StatusBean {
    int imgResourceId;
    int textColorId;
    String desc;
    String status;
    public int getImgResourceId() {
        return imgResourceId;
    }

    public StatusBean setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
        return this;
    }

    public int getTextColorId() {
        return textColorId;
    }

    public StatusBean setTextColorId(int textColorId) {
        this.textColorId = textColorId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public StatusBean setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StatusBean setStatus(String status) {
        this.status = status;
        return this;
    }
}
