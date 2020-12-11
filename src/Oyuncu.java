

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Oyuncu {
   public ArrayList<Sporcu> kartlar = new ArrayList<Sporcu>();
    
    private int oyuncuID;
    private String oyuncuAdi;
    private int skor;

    public Oyuncu(String oyuncuAdi, int oyuncuID, int skor) {
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.skor = skor;
    }

    public Oyuncu() {
        this.skor = 0;
    }

    public int getSkor() {
        return skor;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void puanEkle() {
        this.skor += 10;
    }

    public abstract int kartSec(JButton buton1, JButton buton2, JButton buton3, JButton buton4, JButton buton5,JButton buton6,JButton buton7,JButton buton8);

    

}