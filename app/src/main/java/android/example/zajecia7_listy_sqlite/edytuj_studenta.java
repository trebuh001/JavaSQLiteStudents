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

public class edytuj_studenta extends AppCompatActivity {


    SharedPreferences shared;
DatabaseHelper db;
EditText etImie,etNazwisko,etKierunek,etRok_studiow;
    TextView etID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_studenta);
        db= new DatabaseHelper(this);
        shared=getSharedPreferences("A", Context.MODE_PRIVATE);
        etID=(TextView)findViewById(R.id.etIDDD);
        etID.setText(shared.getString("id",""));
        etImie=(EditText)findViewById(R.id.et_Imie);
        etImie.setText(shared.getString("imie",""));
        etNazwisko=(EditText)findViewById(R.id.et_Nazwisko);
        etNazwisko.setText(shared.getString("nazwisko",""));
        etKierunek=(EditText)findViewById(R.id.et_Kierunek);
        etKierunek.setText(shared.getString("kierunek",""));
        etRok_studiow=(EditText)findViewById(R.id.et_Rok);
        etRok_studiow.setText(shared.getString("rok_studiow",""));

    }
    public void edytuj_rekord2(View v)
    {
        db.aktualizuj_dane(etID.getText().toString(),etImie.getText().toString(),etNazwisko.getText().toString(),etKierunek.getText().toString(),etRok_studiow.getText().toString());
        Toast.makeText(this,"Edytowanie rekordu numer: "+etID.getText().toString(),Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
