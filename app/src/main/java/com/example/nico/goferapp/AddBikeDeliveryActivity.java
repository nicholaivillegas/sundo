package com.example.nico.goferapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.nico.goferapp.Adapter.ViewPagerAdapter;
import com.example.nico.goferapp.Fragment.FromFragment;
import com.example.nico.goferapp.Fragment.NotesFragment;
import com.example.nico.goferapp.Fragment.ToFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Nico on 9/26/2016.
 */

public class AddBikeDeliveryActivity extends AppCompatActivity {


    @Bind(R.id.viewPagerAddDelivery)
    ViewPager viewPagerAddDelivery;
    @Bind(R.id.AddBikeDeliveryTabButton)
    TabLayout AddBikeDeliveryTabButton;
    ViewPagerAdapter viewPagerAdapter;
    ToFragment toFragment;
    FromFragment fromFragment;
    NotesFragment notesFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike_delivery);
        ButterKnife.bind(this);

        AddBikeDeliveryTabButton.setTabGravity(TabLayout.GRAVITY_FILL);
        AddBikeDeliveryTabButton.addTab(AddBikeDeliveryTabButton.newTab().setText("TO"));
        AddBikeDeliveryTabButton.addTab(AddBikeDeliveryTabButton.newTab().setText("FROM"));
        AddBikeDeliveryTabButton.addTab(AddBikeDeliveryTabButton.newTab().setText("NOTES"));

        toFragment = new ToFragment();
        fromFragment = new FromFragment();
        notesFragment = new NotesFragment();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(toFragment, "TO");
        viewPagerAdapter.addFragment(fromFragment, "FROM");
        viewPagerAdapter.addFragment(notesFragment, "NOTES");
        viewPagerAdapter.notifyDataSetChanged();
        viewPagerAddDelivery.setAdapter(viewPagerAdapter);

        viewPagerAdapter.notifyDataSetChanged();
        viewPagerAddDelivery.setAdapter(viewPagerAdapter);
        viewPagerAddDelivery.setOffscreenPageLimit(3);

        viewPagerAddDelivery.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(AddBikeDeliveryTabButton));
        AddBikeDeliveryTabButton.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerAddDelivery.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
