package com.example.email.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.email.R;
import com.example.email.model.EmailItem;

import java.util.List;

public class EmailAdapter extends BaseAdapter implements View.OnCreateContextMenuListener {
    List<EmailItem> items;
    Context context;

    public EmailAdapter(List<EmailItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public List<EmailItem> getItems() {
        return items;
    }

    public void setItems(List<EmailItem> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_email, parent, false);
        }
        convertView.setOnCreateContextMenuListener(this);
        TextView textView = convertView.findViewById(R.id.text_view);
        TextView textTime = convertView.findViewById(R.id.text_time);
        TextView textFrom = convertView.findViewById(R.id.text_from);
        TextView textContent = convertView.findViewById(R.id.text_content);
        final ImageButton checkImportant = convertView.findViewById(R.id.check_important);

        final EmailItem item = items.get(position);


        textView.setText(item.getText());
        GradientDrawable drawable = (GradientDrawable) textView.getBackground();
        drawable.setColor(item.getColor());

        textTime.setText(item.getTime());
        textFrom.setText(item.getFromName());
        textContent.setText(item.getContent());
        if(item.isCheckImportant()){
            checkImportant.setImageResource(R.drawable.ic_baseline_star_24);
        } else {
            checkImportant.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        checkImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.isCheckImportant()){
                    item.setCheckImportant(false);
                } else{
                    item.setCheckImportant(true);
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }
}

