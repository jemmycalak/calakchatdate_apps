package com.jemmy.calak.chatdate.View.Home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jemmy.calak.chatdate.Adapter.AdapterRecyclerView;
import com.jemmy.calak.chatdate.Adapter.ViewHolder.UserHolder;
import com.jemmy.calak.chatdate.Listener.MainActivityListener;
import com.jemmy.calak.chatdate.Model.User;
import com.jemmy.calak.chatdate.R;
import com.jemmy.calak.chatdate.View.Chat.ChatFragment;
import com.jemmy.calak.chatdate.View.MainActivity;
import com.jemmy.calak.chatdate.View.Profile.DetailFotoFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<User> dataUser;
    private AdapterRecyclerView adapter;
    private MainActivityListener mainActivityListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initXml(view);
        getData();
        return view;
    }

    private void getData() {
        dataUser = new ArrayList<>();
        for(int i=0; i<10; i++){
            User user = new User();
            user.setUserNameUser("JemmyCalak");
            user.setNmUser("Jemmy Calak");
            dataUser.add(user);
        }

        adapter = new AdapterRecyclerView<User, UserHolder>(R.layout.layout_item_user, dataUser, UserHolder.class, User.class, getActivity(), getActivity()) {
            @Override
            protected void bindView(UserHolder holder, final User model, int position) {

                holder.nmUser.setText(model.getNmUser());
                holder.imageUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDetailProfile(model);
                    }
                });

                holder.layoutClick.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                        mainActivityListener.SwitchLayout(new ChatFragment());
                       Toast.makeText(getActivity(), "Open detail chat", Toast.LENGTH_SHORT).show();
                   }
               });
            }
        };
        recyclerView.setAdapter(adapter);

    }

    private void initXml(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    public void openDetailProfile(User model){
        Bundle bundle  = new Bundle();
        bundle.putSerializable("dataUser", model);
        DetailFotoFragment detailFotoFragment = new DetailFotoFragment();
        detailFotoFragment.setArguments(bundle);
        detailFotoFragment.show(getFragmentManager(), "dialog");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivityListener){
            mainActivityListener = (MainActivityListener)context;
        }else{
            throw new RuntimeException(context.toString() +" have to implements");
        }
    }
}
