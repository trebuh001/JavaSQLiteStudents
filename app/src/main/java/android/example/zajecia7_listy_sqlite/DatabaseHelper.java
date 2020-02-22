package android.example.zajecia7_listy_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String database_name="baza";
    public static final String table_name="Studenci";

    public DatabaseHelper( Context context) {
        super(context, database_name, null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table "+ table_name+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMIE TEXT, NAZWISKO TEXT, KIERUNEK TEXT,ROK_STUDIOW INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public void wstawdane(String imie,String nazwisko,String kierunek,String rok)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("imie",imie);
        cv.put("nazwisko",nazwisko);
        cv.put("kierunek",kierunek);
        cv.put("rok_studiow",rok);
        db.insertOrThrow(table_name,null,cv);

    }
    public void aktualizuj_dane(String id,String imie,String nazwisko,String kierunek,String rok)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("id",id);
        cv.put("imie",imie);
        cv.put("nazwisko",nazwisko);
        cv.put("kierunek",kierunek);
        cv.put("rok_studiow",rok);
        db.update(table_name,cv,"ID= ?",new String[] { id});

    }
    public long wszyscy_studenci()
    {
        SQLiteDatabase db=getReadableDatabase();
        SQLiteStatement s = db.compileStatement( "select count(*) from Studenci");
        long ilosc=s.simpleQueryForLong();
        return ilosc;
    }
    public void usundane(String id)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        db.delete(table_name,"ID= ?",new String[] {id});
    }

    public SQLiteCursor pobierzdane()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        SQLiteCursor kursor=(SQLiteCursor)db.rawQuery("select * from "+table_name,null);
        return kursor;

    }
}
