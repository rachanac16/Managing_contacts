package com.example.databaseexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.BreakIterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserLayout extends Fragment implements View.OnClickListener {

    private Button add, read, update, delete;
    OnDbListener OpDbListener;
    public UserLayout() {
        // Required empty public constructor
    }

    public interface OnDbListener{
        public void OnDbPerformed(int method);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user_layout, container, false);
        read=view.findViewById(R.id.view_contact);
        add=view.findViewById(R.id.add_contact);
        add.setOnClickListener(this);
        read.setOnClickListener(this);
        update=view.findViewById(R.id.update_contact);
        update.setOnClickListener(this);
        delete=view.findViewById(R.id.delete_contact);
        delete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_contact:
                OpDbListener.OnDbPerformed(0);
                break;

            case R.id.view_contact:
                OpDbListener.OnDbPerformed(1);
                break;

            case R.id.update_contact:
                OpDbListener.OnDbPerformed(2);
                break;
            case R.id.delete_contact:
                OpDbListener.OnDbPerformed(3);
                break;
        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity) context;
        try{
            OpDbListener=(OnDbListener)activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must implement the interface method");
        }
    }


}
