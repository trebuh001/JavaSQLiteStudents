package android.example.zajecia7_listy_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class wybor_opcji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybor_opcji);
    }
    public void edytuj_rekord3(View v)
    {
        Intent intent=new Intent(this,edytuj_studenta.class);
        startActivity(intent);
    }
    public void usun_rekord3(View v)
    {
        Intent intent=new Intent(this,usun_studenta.class);
        startActivity(intent);
    }
}
