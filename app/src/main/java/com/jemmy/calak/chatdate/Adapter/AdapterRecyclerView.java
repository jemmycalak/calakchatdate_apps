package com.jemmy.calak.chatdate.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jemmy.calak.chatdate.Model.User;
import com.jemmy.calak.chatdate.R;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by JEMMY CALAK on 4/5/2018.
 */

public abstract class AdapterRecyclerView<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private int mLayout;
    Class<VH> mViewHolder;
    Class<T> mModel;
    ArrayList<T> mData;
    private Activity activity;
    private Context context;

    public AdapterRecyclerView(int layout, ArrayList<T> data, Class<VH> viewHolder, Class<T> model, Activity activity, Context context){
        this.activity = activity;
        this.context = context;
        this.mData = data;
        this.mLayout = layout;
        this.mViewHolder = viewHolder;
        this.mModel = model;
    }

    public void tukarData(ArrayList<T> data){
        //if apps condition offline
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup)LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        try {
            Constructor<VH> constructor = mViewHolder.getConstructor(View.class);
            return constructor.newInstance(view);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage()+" onCreateViewHolder");
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = mData.get(position);
        bindView(holder, model, position);
    }

    abstract protected void bindView(VH holder, T model, int position);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    ///////////////////////////////////////////method additional///////////////////////////////////////////
}
