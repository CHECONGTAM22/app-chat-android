package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ListUser;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListUserHolder>{
    List<ListUser> mlistuser;

    public ListUserAdapter(List<ListUser> mlistuser) {
        this.mlistuser=mlistuser;
    }


    @NonNull
    @Override
    public ListUserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listuser,parent,false);
        return new ListUserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserHolder holder, int position) {
        ListUser listUser=mlistuser.get(position);
        if (listUser==null){
            return;
        }
        holder.txtname.setText(listUser.getUsername());
        holder.txtdate.setText(listUser.getDate());
        holder.txtmessage.setText(listUser.getMessenger());
    }

    @Override
    public int getItemCount() {
        if (mlistuser!=null){
            return mlistuser.size();
        }
        return 0;
    }

    public class ListUserHolder extends RecyclerView.ViewHolder {

        private TextView txtname,txtdate,txtmessage;

        public ListUserHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.txtname);
            txtdate=itemView.findViewById(R.id.txtdate);
            txtmessage=itemView.findViewById(R.id.txtmessage);
        }
    }
}
