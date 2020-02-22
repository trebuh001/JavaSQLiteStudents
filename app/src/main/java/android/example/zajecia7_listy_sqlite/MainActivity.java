package android.example.zajecia7_listy_sqlite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences shared;
    private ListView listView1;
    int id;
String imie,nazwisko,kierunek;
String rok_studiow;
    Student student[],student2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared=getSharedPreferences("A", Context.MODE_PRIVATE);
        DatabaseHelper db= new DatabaseHelper(this);
        SQLiteCursor kursor=db.pobierzdane();
        student=new Student[30];

        if(kursor.getCount()>0)
        {
            int i=0;
           while (kursor.moveToNext())
            {
                id=kursor.getInt(0);
                imie=kursor.getString(1);
                nazwisko=kursor.getString(2);
                kierunek=kursor.getString(3);
                rok_studiow=kursor.getString(4);
                student[i]=new Student(id,imie,nazwisko,kierunek,rok_studiow);
                i++;
            }

            TextView liczba_studentow=findViewById(R.id.liczba_studentow);
           liczba_studentow.setText("Liczba studentów: "+Integer.toString(i));
            student2=new Student[i];
           System.arraycopy(student,0,student2,0,i);
            RowAdapter adapter = new RowAdapter(this,R.layout.layout_item, student2);
            listView1 = (ListView)findViewById(R.id.Lista);
            listView1.setAdapter(adapter);

            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Student p = (Student) parent.getItemAtPosition(position);
                    //Toast.makeText(getApplicationContext(),"Student:"+(position+1)+". "+p.imie+ " "+p.nazwisko+"\nKierunek: "+p.kierunek+"\nRok: "+p.rok_studiow, Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=shared.edit();
                    editor.putString("id",Integer.toString(p.id));
                    editor.putString("imie",p.imie);
                    editor.putString("nazwisko",p.nazwisko);
                    editor.putString("kierunek",p.kierunek);
                    editor.putString("rok_studiow",p.rok_studiow);
                    editor.commit();
                    klik_w_rekord();

                }

            });
        }





    }
    public void klik_w_rekord()
    {
        Intent intent=new Intent(this,wybor_opcji.class);
        startActivity(intent);
    }
    public void dodaj_rekord(View v)
    {
        Intent intent=new Intent(this,dodaj_studenta.class);
        startActivity(intent);
    }

    public void edytuj_rekord(View v)
    {
        Intent intent=new Intent(this,edytuj_studenta.class);
        startActivity(intent);
    }
    public void usun_rekord(View v)
    {
        Intent intent=new Intent(this,usun_studenta.class);
        startActivity(intent);

    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}
