package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ImageData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=Utils.getData();
        final RecyclerAdaper recyclerAdaper=new RecyclerAdaper(this,list);
        recyclerView.setAdapter(recyclerAdaper);

        recyclerAdaper.setOnItemClickListener(new RecyclerAdaper.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("TAG","asdfasdfasdf");
                ImageData data=new ImageData("http://www.youmeitu.com/Upload/20190524/1558689622196147.jpg","修改之后的数据");
                list.set(position,data);
                recyclerAdaper.notifyItemChanged(position);

            }
        });

    }
}
