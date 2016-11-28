package com.styx.gta.donorblood.fragments.donorlist.controller;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.styx.gta.donorblood.fragments.chat.presenter.MessagePresenter;
import com.styx.gta.donorblood.fragments.donorlist.presenter.DonorPresenter;
import com.styx.gta.donorblood.models.Donor;
import com.styx.gta.donorblood.models.Message;

/**
 * Created by amal.george on 28-11-2016.
 */

public class DonorController {

    public static DatabaseReference getDB(String child) {
        return FirebaseDatabase.getInstance().getReference().child(child);
    }

    private final DonorPresenter presenter;
    private final Query query;

    public DonorController(DonorPresenter presenter) {
        this.presenter = presenter;
        DatabaseReference mMessagesRef = getDB("Data/Donor");
        this.query = mMessagesRef.orderByValue().limitToLast(100);
    }

    public void request() {
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                presenter.sendToAdapter(dataSnapshot.getValue(Donor.class));
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
        });
    }
}
