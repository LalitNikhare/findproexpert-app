package com.example.com.findproexperttabbed.HomeScreen.Customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.findproexperttabbed.R;

/**
 * Created by faltu on 13-Feb-17.
 */

public class SeeProfessions extends ArrayAdapter<String> {
    private String[] names;
    private String[] desc;
    private int[] worker;
    private Context context;
    private int[] image;

    public SeeProfessions(Context context,int[] image, String[] names, String[] desc, int[] worker) {
        super(context, R.layout.profession_custom_list, names);
        this.context = context;
        this.desc = desc;
        this.names = names;
        //this.worker = worker;
        this.image=image;
    }

    private class ViewHolder {
        TextView name1, desc1, worker1;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater
                    .inflate(R.layout.profession_custom_list, parent, false);
            holder.name1 = (TextView) convertView.findViewById(R.id.profession_name);
            holder.desc1 = (TextView) convertView.findViewById(R.id.profession_desc);
           // holder.worker1 = (TextView) convertView.findViewById(R.id.worker_count);
            holder.img= (ImageView) convertView.findViewById(R.id.profession_image);
            convertView.setTag(holder);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageResource(image[position]);
        holder.name1.setText("" + names[position]);
        holder.desc1.setText("" + desc[position]);
        //holder.worker1.setText("" + worker[position]);


        return convertView;
    }
}

