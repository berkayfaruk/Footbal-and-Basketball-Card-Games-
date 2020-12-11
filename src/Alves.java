import javax.swing.*;

public class Alves extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciyleKarsiKarsiya;
    private int ID = 1;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Alves(int penalti, int serbestAtis, int kaleciyleKarsiKarsiya,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim ) {
        super(sporcuAdı, sporcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
        this.resim = ImageIcon("Alves.png");
    }

   

 

    public Alves() {
        setSporcuAdı("Alves");
        setSporcuTakim("Galatasaray");
        this.penalti = 65;
        this.serbestAtis = 80;
        this.kaleciyleKarsiKarsiya = 75;
        resim = new ImageIcon("Alves.png");
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

    private ImageIcon ImageIcon(String alvespng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}