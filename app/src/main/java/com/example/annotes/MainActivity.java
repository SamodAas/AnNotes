package com.example.annotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapterNote;

    public static String forNotes = "notes";
    static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listOfNotes);
        notes.clear();

        arrayAdapterNote = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapterNote);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(AddNoteActivity.first){
            String note = sharedPref.getString(forNotes,"NotSet");
            this.notes.add(note);
        }
        this.arrayAdapterNote.notifyDataSetChanged();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addNoteOption:
                Intent i = new Intent(this, AddNoteActivity.class);
                startActivity(i);
                return true;
            case R.id.deleteNoteOption:
                Intent i1 = new Intent(this, DeleteNote.class);
                startActivity(i1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}}