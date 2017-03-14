# StatusView   
几行代码设定状态显示，如订单状态，根据不同的状态让文字显示不同的颜色
# Usage
###import   
    compile 'com.andan:statusview:1.0.0'   
xml:   
```
        <andan.statusview.StatusView
        android:layout_weight="1"
        android:paddingLeft="10dp"
        android:id="@+id/statusview1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:sv_textSize="14sp"
        app:sv_imgWidth="20dp"
        app:sv_imgHeight="20dp"
        app:sv_background="#D3D3D3"/>
```
```
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
        statusView1.setBeanList(list).setStatus("1");
        
        //如果只想改变文字颜色不添加图片,这个不用添加xml，直接传入自己的TextView即可
        new StatusText(MainActivity.this).setBeanList(list).with(TextView,"1");
```    
####可配置的选项    

        sv_imgWidth
        sv_imgHeight
        sv_textSize
        sv_background
        sv_textMarginLeft
        sv_textMarginRight
