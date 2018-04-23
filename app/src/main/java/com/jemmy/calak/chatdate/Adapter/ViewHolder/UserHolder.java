package com.jemmy.calak.chatdate.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jemmy.calak.chatdate.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by JEMMY CALAK on 4/5/2018.
 */

public class UserHolder extends RecyclerView.ViewHolder {

    public CircleImageView imageUser;
    public ImageView  isRead, isOnline;
    public TextView nmUser, lastChat, timeOline;
    public LinearLayout layoutClick;


    public UserHolder(View itemView) {
        super(itemView);
        imageUser = (CircleImageView)itemView.findViewById(R.id.imageUser);
        isRead = (ImageView)itemView.findViewById(R.id.isRead);
        isOnline = (ImageView)itemView.findViewById(R.id.isOnline);
        nmUser = (TextView)itemView.findViewById(R.id.nameUser);
        lastChat = (TextView)itemView.findViewById(R.id.lastChat);
        timeOline = (TextView)itemView.findViewById(R.id.lastOnline);
        layoutClick = (LinearLayout)itemView.findViewById(R.id.layoutClick);
    }
}
