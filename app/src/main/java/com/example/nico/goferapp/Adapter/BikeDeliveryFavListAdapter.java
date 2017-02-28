package com.example.nico.goferapp.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nico.goferapp.Model.BikeDeliveryFavModel;
import com.example.nico.goferapp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Nico on 2/28/2017.
 */

public class BikeDeliveryFavListAdapter extends ArrayAdapter<BikeDeliveryFavModel> {
    Activity activity;
    Context context;
    List<BikeDeliveryFavModel> favorites;
    ViewHolder viewHolder;

    public BikeDeliveryFavListAdapter(Activity activity, final List<BikeDeliveryFavModel> favorites) {
        super(activity, R.layout.item_favorite_list, favorites);
        this.context = activity.getApplicationContext();
        this.activity = activity;
        this.favorites = favorites;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_favorite_list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bikefaveName.setText(this.favorites.get(position).getName());
        final long itemId = this.favorites.get(position).getId();
        viewHolder.bikefavDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(activity)
                        .setTitle("Delete")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                BikeDeliveryFavModel bikeDeliveryFavModel = BikeDeliveryFavModel.findById(BikeDeliveryFavModel.class, itemId);
                                bikeDeliveryFavModel.delete();
                                refresh();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });

        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.bikefaveName)
        TextView bikefaveName;
        @Bind(R.id.bikefavDelete)
        ImageView bikefavDelete;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public void refresh() {
        notifyDataSetChanged();
    }
}
