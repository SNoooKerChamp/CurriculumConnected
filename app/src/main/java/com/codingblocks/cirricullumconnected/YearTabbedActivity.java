package com.codingblocks.cirricullumconnected;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.codingblocks.cirricullumconnected.Interface.OnListFragmentInteractionListener;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject1;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject2;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject3;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject4;
import com.codingblocks.cirricullumconnected.SecondYearSubjects.Subject5;
import com.codingblocks.cirricullumconnected.ThirdYearSubject.ThirdYearSubject2;
import com.codingblocks.cirricullumconnected.ThirdYearSubject.ThirdYearSubject3;
import com.codingblocks.cirricullumconnected.ThirdYearSubject.ThirdyearSubject1;

public class YearTabbedActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_SENDTO);
               intent.setData(Uri.parse("mailto: kbansal_bt2k16@dtu.ac.in" ));
               if(intent.resolveActivity(getPackageManager())!=null){
                   startActivity(intent);

                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_year_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
          startActivity(new Intent(YearTabbedActivity.this,AboutActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        private OnListFragmentInteractionListener mListener;


        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_year_tabbed, container, false);
            RecyclerView rv = rootView.findViewById(R.id.list);
            if (getArguments() != null) {
                int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
                switch (sectionNumber) {
                    case 1:
                        final String[] subjectList = {"Manufacturing Machines(PE 252)", "Thermal Engg II(ME 202)", "Fluid Mechanics(ME 204)", "Kinematics of Machines(ME 204)", "Manufacturing Technology I(ME 208)", "Engineering Economics(HU 202)"};
                        MyItemRecyclerViewAdapter a = new MyItemRecyclerViewAdapter(subjectList);
                        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rv.setAdapter(a);
                        a.setonitemclicklistener(new OnListFragmentInteractionListener() {
                            @Override
                            public void onListFragmentInteraction(String subjectname,View view) {
                                switch(subjectname){
                                    case "Manufacturing Machines(PE 252)":
                                        startActivity(new Intent(getActivity(),Subject1.class));
                                        break;
                                    case "Thermal Engg II(ME 202)" :
                                        startActivity(new Intent(getActivity(),Subject2.class));
                                        break;
                                    case "Fluid Mechanics(ME 204)"  :
                                        startActivity(new Intent(getActivity(),Subject3.class));
                                        break;
                                    case  "Kinematics of Machines(ME 204)" :
                                        startActivity(new Intent(getActivity(),Subject4.class));
                                        break;
                                    case  "Manufacturing Technology I(ME 208)":
                                        startActivity(new Intent(getActivity(),Subject5.class));
                                        break;
                                    case "Engineering Economics(HU 202)" :
                                        Snackbar.make(view,"Notes for this subject will be shortly made available",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                                        break;
                                }

                            }
                        });

                        break;
                    case 2:
                        String[] subjectList1 = {"Heat and Mass Transfer(ME 302)", "Production & Operations Management(ME 304)", "Professional Ethics and Human Values"};
                        MyItemRecyclerViewAdapter a1 = new MyItemRecyclerViewAdapter(subjectList1);
                        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rv.setAdapter(a1);
                        a1.setonitemclicklistener(new OnListFragmentInteractionListener() {
                            @Override
                            public void onListFragmentInteraction(String subjectname,View view) {

                                switch(subjectname){
                                    case "Heat and Mass Transfer(ME 302)":
                                        startActivity(new Intent(getActivity(), ThirdyearSubject1.class));
                                        break;
                                    case "Production & Operations Management(ME 304)":
                                        startActivity(new Intent(getActivity(), ThirdYearSubject2.class));
                                        break;
                                    case  "Professional Ethics and Human Values":
                                        startActivity(new Intent(getActivity(), ThirdYearSubject3.class));
                                        break;
                                }

                            }
                        });
                        break;

                }
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }
}
