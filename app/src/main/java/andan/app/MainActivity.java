package andan.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import andan.statusview.StatusBean;
import andan.statusview.StatusView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<StatusBean> list=new ArrayList<>();
        StatusBean bean=new StatusBean();
        bean.setStatus("1").setDesc("未付款").setImgResourceId(R.drawable.status1).setTextColorId(R.color.red);
        list.add(bean);
        StatusBean bean2=new StatusBean();
        bean2.setStatus("2").setDesc("发货中").setImgResourceId(R.drawable.status2).setTextColorId(R.color.yewllow);
        list.add(bean2);
        StatusBean bean3=new StatusBean();
        bean3.setStatus("3").setDesc("订单完成").setImgResourceId(R.drawable.status3).setTextColorId(R.color.blue);
        list.add(bean3);

        StatusView statusView1= (StatusView) findViewById(R.id.statusview1);
        StatusView statusView2= (StatusView) findViewById(R.id.statusview2);
        StatusView statusView3= (StatusView) findViewById(R.id.statusview3);
        statusView1.setBeanList(list).setStatus("1");
        statusView2.setBeanList(list).setStatus("2");
        statusView3.setBeanList(list).setStatus("3");
    }
}
