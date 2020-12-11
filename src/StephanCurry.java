import javax.swing.*;

public class StephanCurry extends Sporcu {
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public StephanCurry(int ikilik, int ucluk, int serbestAtis,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        resim = new ImageIcon("StephanCurry.png");
    }

    public StephanCurry() {
        setSporcuAdı("StephanCurry");
        setSporcuTakim("Fenerbahçe");
        this.ikilik = 86;
        this.ucluk = 74;
        this.serbestAtis = 67;
        resim = new ImageIcon("StephanCurry.png");
    }

    @Override
    public int getIkilik() {
        return ikilik;
    }

    @Override
    public int getUcluk() {
        return ucluk;
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