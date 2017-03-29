package com.example.dellpc.blooddonationsystem;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell pc on 26-Feb-17.
 */

public class AdapterPostReq extends ArrayAdapter<ClassPostReq> {
    public AdapterPostReq(Context context, int resource, List<ClassPostReq> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =  super.getView(position, convertView, parent);
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.custom_newfeed,parent,false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.CLUname);
        TextView unit = (TextView) convertView.findViewById(R.id.CLUnits_group);
        TextView relation = (TextView) convertView.findViewById(R.id.CLHosp_relation);
        TextView urgency = (TextView) convertView.findViewById(R.id.CLurgency);
        TextView instruction = (TextView) convertView.findViewById(R.id.CLaddInst);
        TextView volume = (TextView) convertView.findViewById(R.id.CLvolNow);
        TextView currentReq = (TextView) convertView.findViewById(R.id.CLcurrReq);

        ClassPostReq classPostReq = getItem(position);
        ClassUser classUser = new ClassUser();

        name.setText(classUser.getFirstName());
        unit.setText(classPostReq.getNoUnits());
        relation.setText(classPostReq.getRelation());
        urgency.setText(classPostReq.getUrgency());
        instruction.setText(classPostReq.getAddIns());
        volume.setText("0");
        currentReq.setText(classPostReq.getNoUnits());

        return convertView;
    }
}
