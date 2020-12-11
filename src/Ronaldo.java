import javax.swing.*;

public class Ronaldo extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciyleKarsiKarsiya; 
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Ronaldo(int penalti, int serbestAtis, int kaleciyleKarsiKarsiya,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
        resim = new ImageIcon("Ronaldo.png");
    }

    public Ronaldo() {
        setSporcuAdı("Ronaldo");
        setSporcuTakim("Fenerbahçe");
        this.penalti = 100;
        this.serbestAtis = 100;
        this.kaleciyleKarsiKarsiya = 98;
        resim = new ImageIcon("Ronaldo.png");
    }

    @Override
    public int getPenalti() {
        return penalti;
    }

    @Override
    public int getSerbestAtis() {
        return serbestAtis;
    }

    @Override
    public int getKaleciyleKarsiKarsiya() {
        return kaleciyleKarsiKarsiya;
    }

   



    @Override
    public ImageIcon getResim() {
        return resim;
    }



    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    public boolean getkartKullanildiMi() {
        return kartKullanildiMi;
    }

    @Override
    public void SporcuPuaniGoster() {
        super.SporcuPuaniGoster(); //To change body of generated methods, choose Tools | Templates.
    }

    
}