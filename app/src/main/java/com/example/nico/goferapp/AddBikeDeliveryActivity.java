package com.example.nico.goferapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nico.goferapp.Adapter.BikeDeliveryFavListAdapter;
import com.example.nico.goferapp.Adapter.ViewPagerAdapter;
import com.example.nico.goferapp.Fragment.FromFragment;
import com.example.nico.goferapp.Fragment.NotesFragment;
import com.example.nico.goferapp.Fragment.ToFragment;
import com.example.nico.goferapp.Model.BikeDeliveryFavModel;
import com.orm.SugarContext;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @Bind(R.id.check_photo)
    CheckBox checkPhoto;
    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.button_add_fave)
    Button buttonAddFave;
    @Bind(R.id.divider)
    ImageView divider;
    @Bind(R.id.button_cancel_add)
    Button buttonCancelAdd;
    @Bind(R.id.button_pickup)
    Button buttonPickup;
    @Bind(R.id.linear_add_bike_delivery)
    LinearLayout linearAddBikeDelivery;

    public BikeDeliveryFavModel bikeDeliveryFavModel = new BikeDeliveryFavModel();
    public BikeDeliveryFavListAdapter bikeDeliveryFavListAdapter;

    String NameTo, AddressTo, NumberTo, NameFrom, AddressFrom, NumberFrom, DeliveryNotes;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
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

        populateFavoritesList();

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

    @OnClick({R.id.button_add_fave, R.id.button_cancel_add, R.id.button_pickup})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add_fave:
                receiveBikeDeliveryData();

                if (isBikeDeliveryDataCompleted()) {
                    final String finalNameTo = NameTo;
                    final String finalAddressTo = AddressTo;
                    final String finalNumberTo = NumberTo;
                    final String finalNameFrom = NameFrom;
                    final String finalAddressFrom = AddressFrom;
                    final String finalNumberFrom = NumberFrom;
                    final String finalNotes = DeliveryNotes;
                    final EditText inputFavName = new EditText(AddBikeDeliveryActivity.this);

                    new AlertDialog.Builder(AddBikeDeliveryActivity.this)
                            .setTitle("Save as Favorite")
                            .setMessage("Set Name:")
                            .setView(inputFavName)
                            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    BikeDeliveryFavModel bikeDeliveryFavModel = new BikeDeliveryFavModel(finalNameTo, finalAddressTo, finalNumberTo, finalNameFrom, finalAddressFrom, finalNumberFrom, finalNotes, inputFavName.getText().toString());
                                    bikeDeliveryFavModel.save();
                                    populateFavoritesList();
                                }
                            })
                            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                } else {
                    Toast.makeText(AddBikeDeliveryActivity.this, "Please Complete the Information", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_cancel_add:
                finish();
                break;
            case R.id.button_pickup:
                break;
        }
    }

    private void populateFavoritesList() {
        final List<BikeDeliveryFavModel> bikeDeliveryFavs = BikeDeliveryFavModel.getFavorites();
        bikeDeliveryFavListAdapter = new BikeDeliveryFavListAdapter(this, bikeDeliveryFavs);
        listview.setAdapter(bikeDeliveryFavListAdapter);
        bikeDeliveryFavListAdapter.notifyDataSetChanged();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                toFragment.NameTo().setText(bikeDeliveryFavs.get(position).getNameTo());
                toFragment.AddressTo().setText(bikeDeliveryFavs.get(position).getAddressTo());
                toFragment.NumberTo().setText(bikeDeliveryFavs.get(position).getContactnumberTo());
                fromFragment.NameFrom().setText(bikeDeliveryFavs.get(position).getNameFrom());
                fromFragment.AddressFrom().setText(bikeDeliveryFavs.get(position).getAddressFrom());
                fromFragment.NumberFrom().setText(bikeDeliveryFavs.get(position).getContactnumberFrom());
                notesFragment.DeliveryNotes().setText(bikeDeliveryFavs.get(position).getNotes());
            }
        });
    }

    private void receiveBikeDeliveryData() {
        NameTo = toFragment.NameTo().getText().toString();
        AddressTo = toFragment.AddressTo().getText().toString();
        NumberTo = toFragment.NumberTo().getText().toString();
        NameFrom = fromFragment.NameFrom().getText().toString();
        AddressFrom = fromFragment.AddressFrom().getText().toString();
        NumberFrom = fromFragment.NumberFrom().getText().toString();
        DeliveryNotes = notesFragment.DeliveryNotes().getText().toString();
    }

    private boolean isBikeDeliveryDataCompleted() {
        if (NameTo != null && !NameTo.trim().isEmpty() &&
                AddressTo != null && !AddressTo.trim().isEmpty() &&
                NumberTo != null && !NumberTo.trim().isEmpty() &&
                NameFrom != null && !NameFrom.trim().isEmpty() &&
                AddressFrom != null && !AddressFrom.trim().isEmpty() &&
                NumberFrom != null && !NumberFrom.trim().isEmpty() &&
                DeliveryNotes != null && !DeliveryNotes.trim().isEmpty()) {
            return true;
        } else return false;
    }
}
