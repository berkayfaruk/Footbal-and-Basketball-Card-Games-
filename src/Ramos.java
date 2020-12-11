import javax.swing.*;

public class Ramos extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciyleKarsiKarsiya;
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Ramos(int penalti, int serbestAtis, int kaleciyleKarsiKarsiya,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
        resim = new ImageIcon("Ramos.png");
    }

    public Ramos() {
        setSporcuAdı("Ramos");
        setSporcuTakim("Fenerbahçe");
        this.penalti = 59;
        this.serbestAtis = 56;
        this.kaleciyleKarsiKarsiya = 42;
        resim = new ImageIcon("Ramos.png");
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