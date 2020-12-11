
import javax.swing.ImageIcon;


public class Lebron extends Sporcu {
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public Lebron(int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        resim = new ImageIcon("Lebron.png");
    }

    public Lebron() {
        setSporcuAdı("Lebron");
        setSporcuTakim("Fenerbahçe");
        this.ikilik = 71;
        this.ucluk = 76;
        this.serbestAtis = 65;
        resim = new ImageIcon("Lebron.png");
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
