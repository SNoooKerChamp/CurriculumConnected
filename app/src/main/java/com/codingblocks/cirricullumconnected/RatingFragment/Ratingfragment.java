package com.codingblocks.cirricullumconnected.RatingFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.codingblocks.cirricullumconnected.R;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject1;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject2;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject3;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject4;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject5;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * <p>
 * to handle interaction events.
 * Use the {@link Ratingfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ratingfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String Teacher_name = "teachername";
    private static final String Subject_name = "subjectname";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Ratingfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Ratingfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Ratingfragment newInstance(String param1, String param2) {
        Ratingfragment fragment = new Ratingfragment();
        Bundle args = new Bundle();
        args.putString(Teacher_name, param1);
        args.putString(Subject_name, param2);

        fragment.setArguments(args);
        return fragment;
    }

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    DatabaseReference databaseteacherreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(Teacher_name);
            mParam2 = getArguments().getString(Subject_name);


        }
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(mParam2);
        databaseteacherreference = databaseReference.child(mParam1);
    }

    RatingBar userrating;
    Button btnSubmit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        userrating = view.findViewById(R.id.rb_userrating);
        btnSubmit = view.findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String key = databaseteacherreference.push().getKey();

                databaseteacherreference.child(key).setValue(Float.valueOf(userrating.getRating()));


                databaseteacherreference.addValueEventListener(new ValueEventListener() {
                    Double ratingcount = 0.0;
                    int count = 0;
                    Double average = 0.0;


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            ratingcount = ratingcount + snapshot.getValue(Float.class);
                            count = count + 1;

                        }
                        Log.e("Check", "ratingcount: " + ratingcount + "Count: " + count);
                        average = ratingcount / count;
                        Double averagerounded = Math.round(average * 100D) / 100D;
                        Log.e("Doublecheck", "Average: " + averagerounded);
                        switch (mParam2) {
                            case "ManufacturingMachines":
                                Intent i = new Intent(getActivity(), Subject1.class);
                                i.putExtra("Average", String.valueOf(averagerounded));
                                i.putExtra("Teacher", mParam1);
                                startActivity(i);
                                break;
                            case "Thermal Engg II(ME 202)":
                                Intent i1 = new Intent(getActivity(), Subject2.class);
                                i1.putExtra("Average", String.valueOf(averagerounded));
                                i1.putExtra("Teacher", mParam1);
                                startActivity(i1);
                                break;
                            case "Fluid Mechanics(ME 204)":
                                Intent i2 = new Intent(getActivity(), Subject3.class);
                                i2.putExtra("Average", String.valueOf(averagerounded));
                                i2.putExtra("Teacher", mParam1);
                                startActivity(i2);
                                break;

                            case "Kinematics of Machines(ME 204)":
                                Intent i3 = new Intent(getActivity(), Subject4.class);
                                i3.putExtra("Average", String.valueOf(averagerounded));
                                i3.putExtra("Teacher", mParam1);
                                startActivity(i3);
                                break;

                            case "Manufacturing Technology I(ME 208)":
                                Intent i4 = new Intent(getActivity(), Subject5.class);
                                i4.putExtra("Average", String.valueOf(averagerounded));
                                i4.putExtra("Teacher", mParam1);
                                startActivity(i4);
                                break;


                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getActivity(), "Not connected to Internet", Toast.LENGTH_LONG).show();

                    }
                });


            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
