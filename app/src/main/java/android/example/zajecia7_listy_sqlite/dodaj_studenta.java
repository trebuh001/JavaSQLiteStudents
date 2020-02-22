package android.example.zajecia7_listy_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class dodaj_studenta extends AppCompatActivity {
    DatabaseHelper db;
    EditText etImie,etNazwisko,etKierunek,etRok_studiow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_studenta);
        db=new DatabaseHelper(this);
        etImie=(EditText)findViewById(R.id.etImie);
        etNazwisko=(EditText)findViewById(R.id.etNazwisko);
        etKierunek=(EditText)findViewById(R.id.etKierunek);
        etRok_studiow=(EditText)findViewById(R.id.etRok);

    }
    public void dodaj_rekord2(View v)
    {
        db.wstawdane(etImie.getText().toString(),etNazwisko.getText().toString(),etKierunek.getText().toString(),etRok_studiow.getText().toString());
        Toast.makeText(this,"Rekord został dodany pomyślnie",Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
