import javax.swing.*;

public class Cengiz extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciyleKarsiKarsiya;
    private int ID = 4;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Cengiz(int penalti, int serbestAtis, int kaleciyleKarsiKarsiya,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
        resim = new ImageIcon("Cengiz.png");
    }

    public Cengiz() {
        setSporcuAdı("Cengiz");
        setSporcuTakim("Fenerbahçe");
        this.penalti = 94;
        this.serbestAtis = 92;
        this.kaleciyleKarsiKarsiya = 95;
        resim = new ImageIcon("Cengiz.png");
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