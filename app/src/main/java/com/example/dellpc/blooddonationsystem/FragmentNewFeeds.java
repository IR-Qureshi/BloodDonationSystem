package com.example.dellpc.blooddonationsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNewFeeds extends Fragment {

    //to read from each child
    private ChildEventListener mChildEventListener;
    private ListView mMessageListView;
    private AdapterPostReq mAdapterPostReq;
    //entry point of a firebase
    private FirebaseDatabase mFirebaseDatabase;

    //referencing a specific database
    private DatabaseReference mDatabaseReference;


    public FragmentNewFeeds() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_new_feeds, container, false);


        //main access point of our database
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        //giving reference till the child node of the firebase database.
        mDatabaseReference = mFirebaseDatabase.getReference().child("UserPostReq");

        // Initialize message ListView and its adapter
        mMessageListView = (ListView) view.findViewById(R.id.ListNewFeeds);
        List<ClassPostReq> classPostReqs = new ArrayList<>();
        mAdapterPostReq = new AdapterPostReq(getActivity(), R.layout.custom_newfeed, classPostReqs);
        mMessageListView.setAdapter(mAdapterPostReq);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ClassPostReq classPostReq = dataSnapshot.getValue(ClassPostReq.class);
                mAdapterPostReq.add(classPostReq);
                mMessageListView.setAdapter(mAdapterPostReq);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mDatabaseReference.addChildEventListener(mChildEventListener);


        return view;
    }

}
