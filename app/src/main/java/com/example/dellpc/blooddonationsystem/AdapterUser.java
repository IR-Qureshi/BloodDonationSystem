package com.example.dellpc.blooddonationsystem;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by dell pc on 26-Feb-17.
 */

public class AdapterUser extends ArrayAdapter<ClassUser> {
    public AdapterUser(Context context, int resource, List<ClassUser> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate()
        }
    }
}
