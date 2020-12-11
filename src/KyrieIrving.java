
import javax.swing.ImageIcon;


public class KyrieIrving extends Sporcu {
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private int ID = 2;
    private boolean kartKullanildiMi = false;
    private ImageIcon resim;

    public KyrieIrving(int ikilik, int ucluk, int serbestAtis,int hasarPuani, ImageIcon resim, String sporcuAdı, String sporcuTakim) {
        super(sporcuAdı, sporcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        
        resim = new ImageIcon("KyrieIrving.png");
    }

    public KyrieIrving() {
        setSporcuAdı("KyrieIrving");
        setSporcuTakim("Fenerbahçe");
        this.ikilik = 64;
        this.ucluk = 42;
        this.serbestAtis = 54;
        resim = new ImageIcon("KyrieIrving.png");
    }

    public KyrieIrving(int ikilik, int ucluk, int serbestAtis) {
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
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
