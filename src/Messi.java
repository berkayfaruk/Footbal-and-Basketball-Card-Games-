import javax.swing.*;

public class Messi extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciyleKarsiKarsiya;
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Messi(int penalti, int serbestAtis, int kaleciyleKarsiKarsiya,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
        resim = new ImageIcon("Messi.png");
    }

    public Messi() {
        setSporcuAdı("Messi");
        setSporcuTakim("Fenerbahçe");
        this.penalti = 100;
        this.serbestAtis = 98;
        this.kaleciyleKarsiKarsiya = 99;
        resim = new ImageIcon("Messi.png");
    }

    @Override
    public int getPenalti() {
        return penalti;
    }

    @Override
    public int getKaleciyleKarsiKarsiya() {
        return kaleciyleKarsiKarsiya;
    }

    @Override
    public int getSerbestAtis() {
        return serbestAtis;
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