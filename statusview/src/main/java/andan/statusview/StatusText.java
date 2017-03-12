package andan.statusview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nongyudi on 2017/3/12.
 */

public class StatusText {

    private List<StatusBean> beanList;
    private Context mContext;

    public StatusText(Context mContext) {
        this.mContext = mContext;
    }

    public List<StatusBean> getList() {
        return beanList;
    }

    public StatusText setList(List<StatusBean> list) {
        this.beanList = list;
        return this;
    }

    public void with(TextView textView,String status){
        for (StatusBean bean:beanList) {
            if(status.equals(bean.getStatus())){
                textView.setText(bean.getDesc());
                textView.setTextColor(ContextCompat.getColor(mContext,bean.getTextColorId()));
                break;
            }
        }
    }
}
