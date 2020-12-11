
import javax.swing.ImageIcon;


public class Cedi extends Sporcu{
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private int ID = 3;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Cedi(int ikilik, int ucluk, int serbestAtis,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        resim = new ImageIcon("Cedi.png");
    }

    public Cedi() {
        setSporcuAdı("Cedi");
        setSporcuTakim("Fenerbahçe");
        this.ikilik = 99;
        this.ucluk = 97;
        this.serbestAtis = 99;
        resim = new ImageIcon("Cedi.png");
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
