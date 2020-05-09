package appmoviles.com.tcpclienteavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                //GameModel game = dataSnapshot.getValue(GameModel.class);
                adapterGames.showAllAmigos(dataSnapshot.getValue());
            }
        
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        db.child("juegos").addValueEventListener(gameListener);
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
