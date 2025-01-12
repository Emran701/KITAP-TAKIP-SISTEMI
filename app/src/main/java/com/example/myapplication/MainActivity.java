package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText bookTitleInput, authorInput, pageCountInput;
    private Button addButton;
    private ListView bookListView;
    private ArrayList<String> bookList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        bookTitleInput = findViewById(R.id.bookTitleInput);
        authorInput = findViewById(R.id.authorInput);
        pageCountInput = findViewById(R.id.pageCountInput);
        addButton = findViewById(R.id.addButton);
        bookListView = findViewById(R.id.bookListView);

        // Initialize list and adapter
        bookList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
        bookListView.setAdapter(adapter);

        // Add button click event
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
            }
        });
    }

    private void addBook() {
        String title = bookTitleInput.getText().toString().trim();
        String author = authorInput.getText().toString().trim();
        String pageCount = pageCountInput.getText().toString().trim();

        if (title.isEmpty() || author.isEmpty() || pageCount.isEmpty()) {
            return; // Do not add empty entries
        }

        String bookEntry = "Title: " + title + ", Author: " + author + ", Pages: " + pageCount;
        bookList.add(bookEntry);
        adapter.notifyDataSetChanged();

        // Clear input fields
        bookTitleInput.setText("");
        authorInput.setText("");
        pageCountInput.setText("");
    }
}
