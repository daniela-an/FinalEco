package com.example.danielaangelsarriaparcialfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterGames.OnItemClickListener {

    private FirebaseDatabase db;
    private RecyclerView lista_games;
    private AdapterGames adapterGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_games = findViewById(R.id.lista_games);

        adapterGames = new AdapterGames();
        adapterGames.setListener(this);
        lista_games.setLayoutManager(new LinearLayoutManager(this));
        lista_games.setAdapter(adapterGames);
        lista_games.setHasFixedSize(true);

        db = FirebaseDatabase.getInstance();

        ValueEventListener gameListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String game = dataSnapshot.getValue(String.class);
                adapterGames.showAllGames(dataSnapshot.getValue());
                Log.e("QUE SE VEAAAAA",game);
            }
        
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("holakakakkaka", "loadPost:onCancelled", databaseError.toException());
            }
        };
        db.getReference().child("juegos").addValueEventListener(gameListener);
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        
    }
*/
    @SuppressLint("MissingPermission")
    @Override
    public void onItemClick(GameModel game) {
        Date rightnow = Calendar.getInstance().getTime();

        DatabaseReference postsRef = db.getReference().child("votes/"+game.getName());
        DatabaseReference pushedPostRef = postsRef.push();

        postsRef.setValue( new DataModel( rightnow.toString(), pushedPostRef.getKey() ) );

        Intent intent = new Intent(this, goBack.class);
        startActivity(intent);
    }
}
