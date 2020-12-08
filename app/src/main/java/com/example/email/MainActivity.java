package com.example.email;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;


import com.example.email.adapter.EmailAdapter;
import com.example.email.model.EmailItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<EmailItem> items;
    Boolean check = true;
    EmailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Instagram", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Youtube", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "nguyenlananh@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Youtube", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));
        items.add(new EmailItem("Facebook", "Bạn đã nhận được tin nhắn mới từ Nguyễn Lan Anh, nhấn vào để xem nội dung! ", "15:05 PM", "LananhA1k17@gmail.com"));

        adapter = new EmailAdapter(items, this);

        ListView emailListView = findViewById(R.id.email_list_view);
        emailListView.setAdapter(adapter);

        registerForContextMenu(emailListView);
        emailListView.setLongClickable(true);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 101, 0, "Delete");
        menu.add(0, 102, 0, "Reply");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();
        ListView email = findViewById(R.id.email_list_view);
        if(id == 101){
            adapter.getItems().remove(info.position);
            email.setAdapter(adapter);
        } else if(id == 102){
            String subject = "Reply";
            String[] emailReciever = {items.get(info.position).getFromEmail()};

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra(Intent.EXTRA_EMAIL, emailReciever);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            startActivity(Intent.createChooser(intent, "To complete action choose:"));
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        ListView email = findViewById(R.id.email_list_view);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_action).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<EmailItem> itemList = adapter.getItems();
                List<EmailItem> newList = new ArrayList<>();
                for(EmailItem i: itemList){
                    if(i.getFromEmail().toLowerCase().contains(query.toLowerCase()) || i.getFromName().toLowerCase().contains(query.toLowerCase())){
                        newList.add(i);
                    }
                }
                EmailAdapter newAdapter = new EmailAdapter(newList, MainActivity.this);
                email.setAdapter(newAdapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                email.setAdapter(adapter);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.important){
            ListView email = findViewById(R.id.email_list_view);
            if(check){
                List<EmailItem> listItems = adapter.getItems();
                List<EmailItem> itemsImportant = new ArrayList<>();
                for(EmailItem i: listItems){
                    if(i.isCheckImportant()){
                        itemsImportant.add(i);
                    }
                }
                EmailAdapter newAdapter = new EmailAdapter(itemsImportant, this);
                email.setAdapter(newAdapter);
                check = false;
            } else {
                email.setAdapter(adapter);
                check = true;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}