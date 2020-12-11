

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InsanOyuncusu extends Oyuncu {
    private ActionListener kartSecButon1;
    private ActionListener kartSecButon2;
    private ActionListener kartSecButon3;
    private ActionListener kartSecButon4;
    private ActionListener kartSecButon5;
    private ActionListener kartSecButon6;
    private ActionListener kartSecButon7;
    private ActionListener kartSecButon8;
    private int secilenKart;

    //Insan oyuncusu icin her karta bir actionlistener eklenir.
    public InsanOyuncusu(String oyuncuAdi, int oyuncuID, int skor) {
        super(oyuncuAdi, oyuncuID, skor);
        secilenKart = -1;
        kartSecButon1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 0;
            }
        };
        kartSecButon2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 1;
            }
        };
        kartSecButon3 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 2;
            }
        };
        kartSecButon4 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 3;
            }
        };
        
        kartSecButon5 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 4;
            }
        };
        
           kartSecButon6 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 5;
            }
        };
         
         
        kartSecButon7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secilenKart = 6;
            }
        };
          
        kartSecButon8= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secilenKart = 7;
            }
        }; 
      
        

    }

    public InsanOyuncusu() {
        secilenKart = -1;
        kartSecButon1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 0;
            }
        };
        kartSecButon2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 1;
            }
        };
        kartSecButon3 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 2;
            }
        };
        kartSecButon4 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 3;
            }
        };
        
        
        kartSecButon5 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 4;
            }
        };
         kartSecButon6 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 5;
            }
        };
          kartSecButon7 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 6;
            }
        };
          
           kartSecButon8 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secilenKart = 7;
            }
        };
    }

    //Insan oyuncusunda kart secimi elle yapilir, tiklanan kartin indisi dondurulur
    @Override
    public int kartSec(JButton buton1, JButton buton2, JButton buton3, JButton buton4, JButton buton5,JButton buton6,JButton buton7,JButton buton8) {
        secilenKart = -1;
        buton1.addActionListener(kartSecButon1);
        buton2.addActionListener(kartSecButon2);
        buton3.addActionListener(kartSecButon3);
        buton4.addActionListener(kartSecButon4);
        buton5.addActionListener(kartSecButon5);
        buton6.addActionListener(kartSecButon6);
        buton7.addActionListener(kartSecButon7);
        buton8.addActionListener(kartSecButon8);
        while (secilenKart == -1) {
            try {
                Thread.sleep(250);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }
        }
        buton1.removeActionListener(kartSecButon1);
        buton2.removeActionListener(kartSecButon2);
        buton3.removeActionListener(kartSecButon3);
        buton4.removeActionListener(kartSecButon4);
        buton5.removeActionListener(kartSecButon5);
        buton6.removeActionListener(kartSecButon6);
        buton7.removeActionListener(kartSecButon7);
        buton8.removeActionListener(kartSecButon8);
        return secilenKart;
    }

    
 
}
