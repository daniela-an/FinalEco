package appmoviles.com.tcpclienteavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private Button GTA, AC, MCRAFT, W3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GTA = findViewById(R.id.GTA);
        AC = findViewById(R.id.AC);
        MCRAFT = findViewById(R.id.MCRAFT);
        W3 = findViewById(R.id.W3);

        db = FirebaseDatabase.getInstance();

        GTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeData("GTA");
            }
        });

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeData("AC");
            }
        });

        MCRAFT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeData("MCRAFT");
            }
        });

        W3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeData("W3");
            }
        });
    }

    private void writeData(String play) {
        Date rightnow = Calendar.getInstance().getTime();

        DatabaseReference postsRef = db.getReference().child(play);
        DatabaseReference pushedPostRef = postsRef.push();

        postsRef.setValue( new DataModel( rightnow.toString(), pushedPostRef.getKey() ) );
    }
}
