import javax.swing.*;

public class Ronaldinho extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciyleKarsiKarsiya;
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Ronaldinho(int penalti, int serbestAtis, int kaleciyleKarsiKarsiya,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
        resim = new ImageIcon("Ronaldinho.png");
    }

    public Ronaldinho() {
        setSporcuAdı("Ronaldinho");
        setSporcuTakim("Fenerbahçe");
        this.penalti = 93;
        this.serbestAtis = 89;
        this.kaleciyleKarsiKarsiya = 86;
        resim = new ImageIcon("Ronaldinho.png");
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