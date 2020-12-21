package com.example.annotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.annotes.MainActivity.noteNames;
import static com.example.annotes.MainActivity.notes;

public class DeleteNote extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_activity);

        AddNoteActivity.first=false;

        ArrayAdapter arrayAdapterDeletion;
        ListView deleteNameList = findViewById(R.id.listOfNoteNamesDel);
        arrayAdapterDeletion = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noteNames);
        deleteNameList.setAdapter(arrayAdapterDeletion);

        deleteNameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
                int a=(int)id;
                noteNames.remove(a);
                notes.remove(a);

                arrayAdapterDeletion.notifyDataSetChanged();

                finish();
            }
        });}
}
