package com.example.dellpc.blooddonationsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPostReq extends Fragment {

    Spinner spinBG;
    Spinner spinNoReq;
    Spinner spinUrgency;
    Spinner spinCountry;
    Spinner spinState;
    Spinner spinCity;
    Spinner spinHospital;
    Spinner spinRelation;
    EditText editContactNo;
    EditText editAddInfo;
    ClassPostReq mClassPostReq;
    Button BtnUserPost;

    //firebase
    private FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mUserDatabaseReference;

    public FragmentPostReq() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_post_req, container, false);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mUserDatabaseReference = mFirebaseDatabase.getReference().child("UserPostReq");

        spinBG = (Spinner) view.findViewById(R.id.spinnerBG);
        spinNoReq = (Spinner) view.findViewById(R.id.spinnerNoReq);
        spinUrgency = (Spinner) view.findViewById(R.id.spinnerUrgency);
        spinCountry = (Spinner) view.findViewById(R.id.spinnerCounrty);
        spinState = (Spinner) view.findViewById(R.id.spinnerState);
        spinCity = (Spinner) view.findViewById(R.id.spinnerCity);
        spinHospital = (Spinner) view.findViewById(R.id.spinnerHospital);
        spinRelation = (Spinner) view.findViewById(R.id.spinnerRelation);
        editContactNo = (EditText) view.findViewById(R.id.userContactNo);
        editAddInfo = (EditText) view.findViewById(R.id.addIns);
        BtnUserPost = (Button) view.findViewById(R.id.BtnuserPost);

        BtnUserPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClassPostReq = new ClassPostReq(spinBG.getSelectedItem().toString(),spinNoReq.getSelectedItem().toString(),spinUrgency.getSelectedItem().toString(),spinCountry.getSelectedItem().toString(),spinState.getSelectedItem().toString(),spinCity.getSelectedItem().toString(),spinHospital.getSelectedItem().toString(),spinRelation.getSelectedItem().toString(),editContactNo.getText().toString(),editAddInfo.getText().toString());
                mUserDatabaseReference.push().setValue(mClassPostReq);

            }
        });

        return view;
    }
//    public void Post(View view){
//        mClassPostReq = new ClassPostReq(spinBG.getSelectedItem().toString(),spinNoReq.getSelectedItem().toString(),spinUrgency.getSelectedItem().toString(),spinCountry.getSelectedItem().toString(),spinState.getSelectedItem().toString(),spinCity.getSelectedItem().toString(),spinHospital.getSelectedItem().toString(),spinRelation.getSelectedItem().toString(),editContactNo.getText().toString(),editAddInfo.getText().toString());
//        mUserDatabaseReference.push().setValue(mClassPostReq);
//
//    }


}
