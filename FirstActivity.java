package com.zybooks.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class FirstActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "GroceryListPrefs";
    private static final String PREFS_KEY = "groceryList";
    private ArrayList<String> groceryList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groceryList = loadGroceryList();
        loadGroceryList();
        ListView listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groceryList);
        listView.setAdapter(adapter);

        final EditText editText = findViewById(R.id.editText);
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString();
                if (!newItem.isEmpty()) {
                    groceryList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.getText().clear();
                    saveGroceryList(groceryList);
                }
            }
        }
        );

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putStringArrayListExtra("groceryList", groceryList);
                startActivity(intent);
            }
        });

        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groceryList.clear();
                adapter.notifyDataSetChanged();
                saveGroceryList(groceryList);
            }
        });
    }


    private ArrayList<String> loadGroceryList() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Set<String> savedList = sharedPreferences.getStringSet(PREFS_KEY, new HashSet<String>());
        return new ArrayList<>(savedList);
    }

    private void saveGroceryList(ArrayList<String> list) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<>(list);
        editor.putStringSet(PREFS_KEY, set);
        editor.apply();
    }
}
