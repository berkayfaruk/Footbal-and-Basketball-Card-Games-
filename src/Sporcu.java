

import javax.swing.*;

public class Sporcu {
    private String sporcuAdı;
    private String sporcuTakim;
    private int sporcuId;
    private ImageIcon resim;

    public Sporcu(String sporcuAdı, String sporcuTakim) {
        this.sporcuAdı = sporcuAdı;
        this.sporcuTakim = sporcuTakim;
    }

  public Sporcu(){
    
    }
  
    
    public int getPenalti(){
        return 0;
    }
    public int getSerbestAtis(){
        return 0;
    }
    public int getKaleciyleKarsiKarsiya(){
        return 0;
    }
    public int getIkilik() {
        return 0;
    }

    public int getUcluk() {
        return 0;
    }

   

    public String getSporcuAdı() {
        return sporcuAdı;
    }

    public void setSporcuAdı(String sporcuAdı) {
        this.sporcuAdı = sporcuAdı;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }

    public int getSporcuId() {
        return sporcuId;
    }

    public void setSporcuId(int sporcuId) {
        this.sporcuId = sporcuId;
    }

    public ImageIcon getResim() {
        return resim;
    }

  public void SporcuPuaniGoster(){
      
  }
  
  


}