package android.example.zajecia7_listy_sqlite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class usun_studenta extends AppCompatActivity {
    SharedPreferences shared;
    DatabaseHelper db;
    TextView etID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usun_studenta);
        db=new DatabaseHelper(this);
        shared=getSharedPreferences("A", Context.MODE_PRIVATE);
        etID=(TextView)findViewById(R.id.etIDD);
        etID.setText(shared.getString("id",""));
    }
    public void usun_rekord2(View v)
    {
        db.usundane(etID.getText().toString());
        Toast.makeText(this,"Usuwanie rekordu numer: "+etID.getText().toString(),Toast.LENGTH_SHORT).show();
        this.finish();
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
