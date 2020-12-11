import javax.swing.*;
import java.util.List;
import java.util.Random;

public class BilgisayarOyuncusu extends Oyuncu {
    
    public BilgisayarOyuncusu(String oyuncuAdi, int oyuncuID, int skor) {
        super(oyuncuAdi, oyuncuID, skor);
    }

    public BilgisayarOyuncusu() {
    }

    //Bilgisayar oyuncusu için kart secme islemi rastgele yapilir.
    @Override
    public int kartSec(JButton buton1, JButton buton2, JButton buton3, JButton buton4, JButton buton5,JButton buton6,JButton buton7,JButton buton8) {
       
          try {
            Thread.sleep(1250);
        } catch (java.lang.InterruptedException e) {
            System.out.println("Hata");
        }
        Random rand = new Random();
        int indis = rand.nextInt(kartlar.size());
        return indis;
        
        /* try {
            Thread.sleep(1250);
        } catch (java.lang.InterruptedException e) {
            System.out.println("Hata");
        }
        Random rand = new Random();
        boolean secildi=false;
        int indis = 0;
        while (!secildi) {            
            indis = rand.nextInt(8);
           if(indis==0){
               if (buton1.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
             if(indis==1){
               if (buton2.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
               if(indis==2){
               if (buton3.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
                 if(indis==3){
               if (buton4.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
                   if(indis==4){
               if (buton5.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
                     if(indis==5){
               if (buton6.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
                       if(indis==6){
               if (buton7.isEnabled()) {
                   secildi=true;
                   break;
               }
           }
        }
        
        kartlar.remove(indis);
        
        return indis;*/
        
    }

  
}