package andan.statusview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nongyudi on 2017/3/11.
 */

public class StatusView extends LinearLayout {
    private Context mContext;
    private StatusView instance;
    private TextView textView;
    private ImageView imageView;
    private List<StatusBean> beanList;
    public StatusView(Context context) {
        super(context);
        init(context,null);
    }

    public StatusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public StatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void init(Context context, AttributeSet attrs){
        mContext=context;
        LayoutInflater.from(mContext).inflate(R.layout.statusview, this);
        textView= (TextView) findViewById(R.id.textStatus);
        imageView=(ImageView) findViewById(R.id.imageStatus);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.statusview);
        int imgWidth = typedArray.getDimensionPixelSize(R.styleable.statusview_sv_imgWidth, -1);
        int imgHeight = typedArray.getDimensionPixelSize(R.styleable.statusview_sv_imgHeight, -1);
        int textSize = typedArray.getDimensionPixelSize(R.styleable.statusview_sv_textSize, -1);
        int textMarginLeft=typedArray.getDimensionPixelSize(R.styleable.statusview_sv_textMarginLeft,dp2px(10));
        int textMarginRight=typedArray.getDimensionPixelSize(R.styleable.statusview_sv_textMarginRight,dp2px(10));
        int background=typedArray.getColor(R.styleable.statusview_sv_background,0xffffffff);

        typedArray.recycle();
        this.setBackgroundColor(background);

        if(textSize>0){
            textView.setTextSize(px2dp(textSize));
        }
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textParams.setMargins(px2dp(textMarginLeft),0,px2dp(textMarginRight),0);
        textView.setLayoutParams(textParams);
        if(imgHeight>0&&imgWidth>0){
            LayoutParams imgParams = new LayoutParams(imgWidth, imgHeight);
            imageView.setLayoutParams(imgParams);
        }else if (imgWidth > 0) {
            LayoutParams imgParams = new LayoutParams(imgWidth, LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(imgParams);
        }else if (imgHeight > 0) {
            LayoutParams imgParams = new LayoutParams(imgHeight, LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(imgParams);
        }


    }

    public List<StatusBean> getBeanList() {
        return beanList;
    }

    public StatusView setBeanList(List<StatusBean> beanList) {
        this.beanList = beanList;
        return this;
    }
    public void setStatus(String status){
        for (StatusBean bean:beanList) {
            if(status.equals(bean.getStatus())){
                textView.setText(bean.getDesc());
                imageView.setImageResource(bean.getImgResourceId());
                textView.setTextColor(ContextCompat.getColor(mContext,bean.getTextColorId()));
                break;
            }
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public  int dp2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public  int px2dp( float pxValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
