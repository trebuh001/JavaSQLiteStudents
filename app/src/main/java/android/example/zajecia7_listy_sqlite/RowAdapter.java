package android.example.zajecia7_listy_sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RowAdapter extends ArrayAdapter<Student>
{
    Context context;
    int resource;
    Student dane[]=null;

    public RowAdapter( Context context, int resource,Student[] dane)
    {
        super(context,resource,dane);
        this.resource=resource;
        this.context=context;
        this.dane=dane;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row=convertView;
        RowBeanHolder holder=null;

        if(row==null)
        {
            LayoutInflater inflater= ((Activity)context).getLayoutInflater();
            row=inflater.inflate(resource,parent,false);
            holder=new RowBeanHolder();
            holder.txtID=(TextView)row.findViewById(R.id.txtID);
            holder.txtImie=(TextView)row.findViewById(R.id.txtImie);
            holder.txtNazwisko=(TextView)row.findViewById(R.id.txtNazwisko);
            holder.txtKierunek=(TextView)row.findViewById(R.id.txtKierunek);
            holder.txtRok=(TextView)row.findViewById(R.id.txtRok);
            row.setTag(holder);

        }
        else
        {
            holder=(RowBeanHolder)row.getTag();
        }
                Student obiekt=dane[position];
                holder.txtID.setText(obiekt.id+". ");
                holder.txtImie.setText(obiekt.imie+" ");
                holder.txtNazwisko.setText(obiekt.nazwisko);
                holder.txtKierunek.setText("Kierunek: "+obiekt.kierunek);
                holder.txtRok.setText("Rok: "+obiekt.rok_studiow);


        return row;
    }
    static class RowBeanHolder
    {
        TextView txtID,txtImie,txtNazwisko,txtKierunek,txtRok;
    }
}
