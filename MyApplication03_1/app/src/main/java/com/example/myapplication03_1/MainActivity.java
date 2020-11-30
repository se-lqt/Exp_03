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
        //*******
        ListView listView=findViewById(R.id.list2);
        listView.setAdapter(myAdapter);


        // 为ListView的列表项的单击事件绑定事件监听器
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.i("-CRAZYIT-", names[position] + "被单击了");
            Toast.makeText(MainActivity.this,names[position]+"被选中",
                    Toast.LENGTH_SHORT).show();
        });

//        listView.findViewById(R.id.name);
//        listView.findViewById(R.id.header);
//        listView.setOnClickListener(new View.OnClickListener() {
//
//        });


    }
}

