# EXP03_Android UI组件

## 一、Android ListView的用法

利用SimpleAdapter实现如下界面效果（1）注意列表项的布局 （2）图片使用QQ群附件资源 （3）使用Toast显示选中的列表项信息

![H`G_F_U_U__K@F__U_B4WTT.png](https://i.loli.net/2020/10/26/MIcW19vqku4KLbe.png)

相关知识点：

（1）ListView列表组件： 

> ListView组件是一种以垂直方式列出列表项的常用组件。 
>
> ListView组件的列表项通过适配器创建。
>
> ListView组件可通过不同的适配器展现不同的列表内容，如数据、组件。

（2）SimpleAdapter的参数说明

> 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
> 第二个参数表示生成一个Map(String ,Object)列表选项
> 第三个参数表示界面布局的id 表示该文件作为列表项的组件
> 第四个参数表示该Map对象的哪些key对应value来生成列表项
> 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系

创建一个listview_item.xml文件，代码如下,需要提前将准备好的六张图放入drawable中

```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <!--基线对齐底部-->

    <TextView
        android:id="@+id/name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:paddingLeft="8dp"
        android:textColor="#1D1D1C"
        android:textSize="20sp" />

    <ImageView
        android:id="@+id/header"
        android:layout_width="64dp"
        android:layout_height="64dp"
        android:layout_alignParentRight="true"
        android:layout_marginRight="10dp"
        android:padding="5dp"></ImageView>



</RelativeLayout>

```

activity_main.xml

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ListView
        android:id="@+id/list2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
    </ListView>


</LinearLayout>
```

接下来是MainActivity.java

```java
package com.example.myapplication03_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //用三个数组装载数据
    private String[] names= new String[]{"cat","dog","lion","elephant","tiger","monkey"};
    private int[] imgIds=new int[]{R.drawable.cat,
            R.drawable.dog,R.drawable.lion,
            R.drawable.elephant,R.drawable.tiger,R.drawable.monkey,};//三张图片地址


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //list 集合
        List<Map<String,Object>> listItems=new ArrayList<>();
        for (int i =0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("name",names[i]);
            listItem.put("header",imgIds[i]);
            listItems.add(listItem);
        }
        //创建一个simpleAdapter

        SimpleAdapter myAdapter=new SimpleAdapter(
                this,
                listItems,
                R.layout.listview_item,
                new  String[]{"header","name"},
                new int[]{R.id.header,R.id.name}
        );
        ListView listView=findViewById(R.id.list2);
        listView.setAdapter(myAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.i("-CRAZYIT-", names[position] + "被单击了");
            Toast.makeText(MainActivity.this,names[position]+"被选中",
                    Toast.LENGTH_SHORT).show();
        });
    }
}


```





## 二、创建自定义布局的AlertDialog

创建如图所示的自定义对话框。请创建一个如图所示的布局， 调用 AlertDialog.Builder 对象上的 setView() 将布局添加到 AlertDialog。

![9U_U4QI6`SND_B_WF9SW~VF.png](https://i.loli.net/2020/10/26/LAXFPNDWQRKY6td.png)

**相关知识点：**

AlertDialog功能非常强大，可以实现各种对话框。 
*实现步骤：* 
① 创建AlertDialog.Builder对象。 
② 调用AlertDialog.Builder的setTitle()方法设置标题。 
③ 调用AlertDialog.Builder的SetIcon()方法设置图标。 
④ 调用AlertDialog.Builder的相关设置方法设置对话框内容。 
⑤ 调用AlertDialog.Builder的set来添加按钮。 
⑥ 调用AlertDialog.Builder的create()方法创建对象后show()出该对话框。



myview.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <ImageView
        android:src="@drawable/logo"
        android:layout_width="match_parent"
        android:layout_height="64dp"
        android:scaleType="center"
        android:background="#FFFFBB33"
        android:contentDescription="@string/app_name" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >

        <EditText
            android:id="@+id/username_Et"
            android:layout_width="349dp"
            android:layout_height="wrap_content"
            android:hint="请输入用户名" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >

        <EditText
            android:id="@+id/pwd_Et"
            android:layout_width="349dp"
            android:layout_height="wrap_content"
            android:hint="请输入密码" />

    </LinearLayout>
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >

        <Button
            android:id="@+id/submit_Btn"
            android:layout_width="199dp"
            android:layout_height="wrap_content"
            android:text="确定" />

        <Button
            android:id="@+id/cancel_Btn"
            android:layout_width="199dp"
            android:layout_height="wrap_content"
            android:text="取消" />
    </LinearLayout>
</LinearLayout>
```

activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:text="登录"
        android:onClick="button"/>

</LinearLayout>
```

MainActivity.java

```
package com.example.myapplication03_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button(View view){
        showMyDialog();
    }
    private void showMyDialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view=View.inflate(this, R.layout.myview, null);
        builder.setView(view);
        final AlertDialog alertDialog=	builder.create();
        alertDialog.show();

        final EditText userName_Et=view.findViewById(R.id.username_Et);
        final EditText pwd_Et=view.findViewById(R.id.pwd_Et);
        Button submit_Btn=view.findViewById(R.id.submit_Btn);
        Button cancel_Btn=view.findViewById(R.id.cancel_Btn);

        //确定按钮
        submit_Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String userName=userName_Et.getText().toString();
                String password=pwd_Et.getText().toString();
                //设置toast提示
                Toast.makeText(MainActivity.this,
                        "用户名:"+userName+"\n"+"密码:"+password, Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }


        });
        //取消按钮
        cancel_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"已取消", Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }
        });


    }
}
```



## 三、使用XML定义菜单 

使用XML定义菜单 ,

（1）字体大小（有小，中，大这3个选项；分 别对应10号字，16号字和20号字）；

（2）点击之后设置测试文本的字体, 普通菜单项，点击之后弹出Toast提示

（3）字体颜色（有红色和黑色这2个选项）， 点击之后设置测试文本的字体

![7V_M81Q_XRN16_@0MVQ_3IL.png](https://i.loli.net/2020/10/26/7fG9cZXSCv2KPIg.png)

相关知识点：

（1）Android 提供了两种创建菜单的方式，一种是直接在java文件里写，另一种是在Android开发中使用较广的XML资源文件定义。笔者是使用不会使代码更臃肿的XML方法来定义。

（2）步骤如下：

1. 在/res目录下创建menu文件夹
2. 在menu目录下使用与menu相关的元素定义xml文件，文件名是随意的，android会自动为其生成资源ID。例如：**R.menu.mainmenu**对应menu目录的mainmenu.xml资源文件
3. 使用xml文件的资源ID，将xml文件中定义的菜单项添加到menu对象中
4. 响应菜单项时，使用每个菜单项对应的资源ID



/res/menu/context.xml

```java
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
	<!-- 定义一组单选菜单项 -->
	<group android:checkableBehavior="single">
		<!-- 定义三个菜单项 -->
		<item
			android:id="@+id/red"
			android:title="@string/red_title"
			android:alphabeticShortcut="r"/>
		<item
			android:id="@+id/green"
			android:title="@string/green_title"
			android:alphabeticShortcut="g"/>
		<item
			android:id="@+id/blue"
			android:title="@string/blue_title"
			android:alphabeticShortcut="b"/>
	</group>
</menu>

```



/res/menu/menu_main.xml

```java 
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
	<item android:title="@string/font_size"
		android:icon="@drawable/font">
		<menu>
			<!-- 定义一组单选菜单项 -->
			<group android:checkableBehavior="single">
				<!-- 定义多个菜单项 -->
				<item
					android:id="@+id/font_10"
					android:title="@string/font_10"/>
				<item
					android:id="@+id/font_12"
					android:title="@string/font_12"/>
				<item
					android:id="@+id/font_14"
					android:title="@string/font_14"/>
				<item
					android:id="@+id/font_16"
					android:title="@string/font_16"/>
				<item
					android:id="@+id/font_18"
					android:title="@string/font_18"/>
			</group>
		</menu>
	</item>
	<!-- 定义一个普通菜单项 -->
	<item android:id="@+id/plain_item"
		android:title="@string/plain_item">
	</item>
	<item android:title="@string/font_color"
		android:icon="@drawable/color">
		<menu>
			<!-- 定义一组普通菜单项 -->
			<group>
				<!-- 定义三个菜单项 -->
				<item
					android:id="@+id/red_font"
					android:title="@string/red_title"/>
				<item
					android:id="@+id/green_font"
					android:title="@string/green_title"/>
				<item
					android:id="@+id/blue_font"
					android:title="@string/blue_title"/>
			</group>
		</menu>
	</item>
</menu>

```

最后在MainActivity重写方法，响应菜单项。

```
package com.example.myapplication03_3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication03_3.R;

public class MainActivity extends Activity
{
	private TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt = findViewById(R.id.txt);
		// 为文本框注册上下文菜单
		registerForContextMenu(txt);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// 装填R.menu.menu_main对应的菜单，并添加到menu中
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	// 创建上下文菜单时触发该方法
	@Override
	public void onCreateContextMenu(ContextMenu menu,
		View source, ContextMenu.ContextMenuInfo menuInfo)
	{
		// 装填R.menu.context对应的菜单，并添加到menu中
		getMenuInflater().inflate(R.menu.context, menu);
		menu.setHeaderIcon(R.drawable.tools);
		menu.setHeaderTitle("请选择背景色");
	}
	// 上下文菜单中菜单项被单击时触发该方法
	@Override public boolean onContextItemSelected(MenuItem mi)
	{
		// 勾选该菜单项
		mi.setChecked(true);  // ①
		switch(mi.getItemId())
		{
			case R.id.red: txt.setBackgroundColor(Color.RED); break;
			case R.id.green: txt.setBackgroundColor(Color.GREEN); break;
			case R.id.blue: txt.setBackgroundColor(Color.BLUE); break;
		}
		return true;
	}
	// 菜单项被单击后的回调方法
	@Override public boolean onOptionsItemSelected(MenuItem mi)
	{
		// 勾选该菜单项
		if (mi.isCheckable())
		{
			mi.setChecked(true); // ②
		}
		// 判断单击的是哪个菜单项，并有针对性地做出响应
		switch (mi.getItemId())
		{
			case R.id.font_10: txt.setTextSize(10 * 2); break;
			case R.id.font_12: txt.setTextSize(12 * 2); break;
			case R.id.font_16: txt.setTextSize(16 * 2); break;
			case R.id.font_18: txt.setTextSize(18 * 2); break;
			case R.id.red_font: txt.setTextColor(Color.RED); break;
			case R.id.green_font: txt.setTextColor(Color.GREEN); break;
			case R.id.blue_font: txt.setTextColor(Color.BLUE); break;
			case R.id.plain_item:
				Toast.makeText(MainActivity.this,
				"您单击了普通菜单项", Toast.LENGTH_SHORT)
					.show();
				break;
		}
		return true;
	}
}

```



## 四、创建上下文操作模式(ActionMode)的上下文菜单

创建如下图模式的上下文菜单 

（1）使用ListView或者ListActivity创建 List 

（2）为List Item创建ActionMode形式 的上下文菜单

![NM9IHX@D__6YF1_01S871IB.png](https://i.loli.net/2020/11/30/RHOFg1LnxSA4atW.png)

**相关知识点：**

（1）上下文菜单是用户长按某元素时出现的[浮动菜单](https://developer.android.google.cn/guide/topics/ui/menus.html#FloatingContextMenu)。该菜单提供的操作会影响所选内容或上下文框架。

（2）如果你只想在用户选择特定的View对象时，调用上下文操作模式，应该按以下方法来做：

a.实现ActionMode.Callback接口。在它的回调方法中，你能够针对上下文操作栏指定动作，在操作项目上响应点击事件和处理针对这个操作模式的其他生命周期事件。

b.在显示这个操作栏时，调用startActionMode()方法（如用户长按（long-click）对应的view对象时）。

action_bar.xml

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".ContextualActionBarTutorial"
    android:background="@android:color/background_light" >

    <ListView
        android:id="@android:id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:choiceMode="multipleChoice">
    </ListView>

</RelativeLayout>
```











