package android.example.zajecia7_listy_sqlite;

public class Student {

    public int id;
    public String imie;
    public String nazwisko;
    public String kierunek;
    public String rok_studiow;
 public Student()
 {

 }
    public Student(int id,String imie,String nazwisko,String kierunek,String rok_studiow)
    {
        this.id=id;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.kierunek=kierunek;
        this.rok_studiow=rok_studiow;
    }

}
