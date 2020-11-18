package com.example.annotes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStreamWriter;

import static com.example.annotes.MainActivity.forNotes;

public class AddNoteActivity extends AppCompatActivity {

    EditText noteText;
    public static Boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        noteText = findViewById(R.id.noteContent);
    }

    public void cancelNote(View view) {
        finish();
    }

    public void saveAndCloseNote(View view) {
            SharedPreferences.Editor editor = MainActivity.sharedPref.edit();
            editor.putString(MainActivity.forNotes, this.noteText.getText().toString());
            editor.apply();
            first=true;
            finish();
        }
}
