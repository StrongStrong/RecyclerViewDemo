package com.example.recyclerviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdaper extends RecyclerView.Adapter<RecyclerAdaper.MyViewHolder> {
    //当前上下文对象
    Context context;
    //RecyclerView填充Item数据的List对象
    List<ImageData> datas;
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public RecyclerAdaper(Context context,List<ImageData> datas){
        this.context = context;
        this.datas = datas;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=View.inflate(context,R.layout.recycler_item,null);
        return new MyViewHolder(v,mOnItemClickListener);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(datas.get(position).content);
        Glide.with(context).load(datas.get(position).imgUrl).into(holder.imageView);
        Log.i("TAG",datas.get(position).content+"------"+datas.get(position).imgUrl);

    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;


        public MyViewHolder(View itemView,OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            this.onRecyclerViewItemClickListener=onRecyclerViewItemClickListener;
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onRecyclerViewItemClickListener != null){
                onRecyclerViewItemClickListener.onItemClick(v,getAdapterPosition());
            }


        }
    }
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view ,int position);
    }

}
