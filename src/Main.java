
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main extends Thread {

    private BilgisayarOyuncusu oyuncu1;
    private Oyuncu oyuncu2;
    private boolean kartlariGor; //true ise ikinci oyuncu kartlari hep acik olur
    private List<Sporcu> kartlar;

    private ImageIcon arkasiDonuk;
    private JButton oyuncu1Kart1;
    private JButton oyuncu1Kart2;
    private JButton oyuncu1Kart3;
    private JButton oyuncu1Kart4;
    private JButton oyuncu1Kart5;
    private JButton oyuncu1Kart6;
    private JButton oyuncu1Kart7;
    private JButton oyuncu1Kart8;

    private JButton oyuncu2Kart1;
    private JButton oyuncu2Kart2;
    private JButton oyuncu2Kart3;
    private JButton oyuncu2Kart4;
    private JButton oyuncu2Kart5;
    private JButton oyuncu2Kart6;
    private JButton oyuncu2Kart7;
    private JButton oyuncu2Kart8;
    /*   private JButton ortaKart1;
    private JButton ortaKart2;
    private JButton ortaKart3;
    private JButton ortaKart4;
    private List<JButton> ortaKartlar;*/
    private JLabel yazilar;
    private JLabel oyuncu1Yazi;
    private JLabel oyuncu2Yazi;
    private JLabel oyunSonu;
    private JFrame frame;
    private JButton buton1;
    private JButton buton2;
    private boolean hepsiniGor; //true ise oyundaki tum kartlar hep acik olur
    private JCheckBox hepsiniGorButon;
    private int oyuncu2SecilenKartIndis;
    private int oyuncu1SecilenKartIndis;

    public Main(JFrame alinanFrame) throws java.io.IOException {
        frame = alinanFrame;
        oyuncu1 = new BilgisayarOyuncusu("Bilgisayar", 1, 0);
        arkasiDonuk = new ImageIcon(ImageIO.read(new File("arkasidonuk.png")));

        buton2 = new JButton("play");
        kartlar = new ArrayList<>();
        oyuncu1Kart1 = new JButton();
        oyuncu1Kart2 = new JButton();
        oyuncu1Kart3 = new JButton();
        oyuncu1Kart4 = new JButton();
        oyuncu1Kart5 = new JButton();
        oyuncu1Kart6 = new JButton();
        oyuncu1Kart7 = new JButton();
        oyuncu1Kart8 = new JButton();

        oyuncu2Kart1 = new JButton();
        oyuncu2Kart2 = new JButton();
        oyuncu2Kart3 = new JButton();
        oyuncu2Kart4 = new JButton();
        oyuncu2Kart5 = new JButton();
        oyuncu2Kart6 = new JButton();
        oyuncu2Kart7 = new JButton();
        oyuncu2Kart8 = new JButton();
        /*  ortaKart1 = new JButton();
        ortaKart2 = new JButton();
        ortaKart3 = new JButton();
        ortaKart4 = new JButton();
        ortaKartlar = new ArrayList<>();*/
        yazilar = new JLabel();
        oyuncu1Yazi = new JLabel();
        oyuncu2Yazi = new JLabel();
        oyunSonu = new JLabel();
        hepsiniGorButon = new JCheckBox("Kartlar Acik Olsun");
    }

    //Oyuncu2'yi insan oyuncusu olarak atar
    public void insanOyuncusuOlustur() {
        oyuncu2 = new InsanOyuncusu("Insan", 2, 0);
    }

    //Oyuncu2'yi bilgisayar oyuncusu olarak atar
    public void bilgisayarOyuncusuOlustur() {
        oyuncu2 = new BilgisayarOyuncusu("Bilgisayar 2", 2, 0);
    }

    //Koordinal alir ve o koordinatta bir buton dondurur, default olarak buton gorunmezdir
    public JButton kartButonuOlustur(JButton buton, int x, int y) {
        buton.setIcon(arkasiDonuk);
        buton.setBounds(x, y, 110, 150);
        buton.setVisible(false);
        return buton;
    }

    //Ekrandaki nesneleri yaratıp ekrana yerlestiren fonksiyon
    public void ekranOlustur() {
        /*ortaKartlar.add(ortaKart1);
        ortaKartlar.add(ortaKart2);
        ortaKartlar.add(ortaKart3);
        ortaKartlar.add(ortaKart4);*/
        //x    y     boyut
        yazilar.setBounds(90, 300, 430, 100);
        yazilar.setHorizontalAlignment(SwingConstants.CENTER);
        yazilar.setFont(new Font("Constantia", Font.BOLD, 25));

        oyuncu1Yazi.setBounds(0, 0, 200, 50);
        oyuncu1Yazi.setHorizontalAlignment(SwingConstants.CENTER);
        oyuncu1Yazi.setFont(new Font("Constantia", Font.BOLD, 20));

        oyuncu2Yazi.setBounds(20, 30, 200, 50);
        oyuncu2Yazi.setHorizontalAlignment(SwingConstants.CENTER);
        oyuncu2Yazi.setFont(new Font("Constantia", Font.BOLD, 20));

        oyunSonu.setBounds(0, 270, 1000, 200);
        oyunSonu.setHorizontalAlignment(SwingConstants.CENTER);
        oyunSonu.setFont(new Font("Constantia", Font.BOLD, 60));
        oyunSonu.setForeground(Color.RED);

        frame.add(oyunSonu);
        frame.add(oyuncu1Yazi);
        frame.add(oyuncu2Yazi);
        frame.add(yazilar);

        hepsiniGorButon.setBounds(430, 450, 200, 50);
        hepsiniGorButon.setOpaque(false);
        frame.add(hepsiniGorButon);

        buton2.setBounds(250, 323, 500, 100);
        buton2.setBackground(Color.lightGray);
        buton2.setFont(new Font("Arial", Font.PLAIN, 20));
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insanOyuncusuOlustur();
                kartlariGor = true;
                anaEkranCikis();
            }
        });
        frame.add(buton2);

        frame.add(kartButonuOlustur(oyuncu1Kart1, 160, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart2, 290, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart3, 420, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart4, 550, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart5, 680, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart6, 810, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart7, 940, 10));
        frame.add(kartButonuOlustur(oyuncu1Kart8, 1070, 10));

        frame.add(kartButonuOlustur(oyuncu2Kart1, 160, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart2, 290, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart3, 420, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart4, 550, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart5, 680, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart6, 810, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart7, 940, 490));
        frame.add(kartButonuOlustur(oyuncu2Kart8, 1070, 490));

        /* frame.add(kartButonuOlustur(ortaKart1, 660, 210));
        frame.add(kartButonuOlustur(ortaKart2, 800, 210));
        frame.add(kartButonuOlustur(ortaKart3, 660, 380));
        frame.add(kartButonuOlustur(ortaKart4, 800, 380));*/
        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Ana ekranda bir secim yapildiktan sonra bu fonksiyon cagirilir, ana ekrandaki nesneler gizlenir ve oyun baslatilir
    public void anaEkranCikis() {

        buton2.setVisible(false);
        if (hepsiniGorButon.isSelected() == true) {
            hepsiniGor = true;
        } else {
            hepsiniGor = false;
        }
        hepsiniGorButon.setVisible(false);
        kartlariTanimla();
        kartlariTanimla2();

        this.start();
    }

    //Oyunun dondugu fonksiyon, Thread classinda ana fonksiyondur
    public void run() {
        kartlariSifirla();

        JButton oyuncu1SecilenKart = new JButton();
        JButton oyuncu2SecilenKart = new JButton();

        //Oyuncularin elinde kart oldugu surece oyun devam eder
        //  while (oyuncu1.kartlar.size() > 0 && oyuncu2.kartlar.size() > 0) 
        oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
        oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

        if (kartlariGor) {
            yazilar.setText("Bir kart seçin.");
        } else {
            yazilar.setText(oyuncu2.getOyuncuAdi() + " kart seciyor.");
        }

        //Oyuncu 2 kart secene kadar beklenir, sectigi kart one cikarilir
        int oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

        yazilar.setText("Secilen kartlar aciliyor.");
        if (oyuncu2SecilenKartIndis == 0) {
            oyuncu2Kart1.setVisible(false);
            oyuncu2Kart1.setIcon(arkasiDonuk);
            oyuncu2Kart1.setBounds(550, 250, 120, 200);
            oyuncu2Kart1.setVisible(true);

            oyuncu2SecilenKart = oyuncu2Kart1;

        } else if (oyuncu2SecilenKartIndis == 1) {
            oyuncu2Kart2.setVisible(false);
            oyuncu2Kart2.setIcon(arkasiDonuk);
            oyuncu2Kart2.setBounds(550, 250, 120, 200);
            oyuncu2Kart2.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart2;
        } else if (oyuncu2SecilenKartIndis == 2) {
            oyuncu2Kart3.setVisible(false);
            oyuncu2Kart3.setIcon(arkasiDonuk);
            oyuncu2Kart3.setBounds(550, 250, 120, 200);
            oyuncu2Kart3.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart3;
        } else if (oyuncu2SecilenKartIndis == 3) {
            oyuncu2Kart4.setVisible(false);
            oyuncu2Kart4.setIcon(arkasiDonuk);
            oyuncu2Kart4.setBounds(550, 250, 120, 200);
            oyuncu2Kart4.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart4;
        } else if (oyuncu2SecilenKartIndis == 4) {
            oyuncu2Kart5.setVisible(false);
            oyuncu2Kart5.setIcon(arkasiDonuk);
            oyuncu2Kart5.setBounds(550, 250, 120, 200);
            oyuncu2Kart5.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart5;
        } else if (oyuncu2SecilenKartIndis == 5) {
            oyuncu2Kart6.setVisible(false);
            oyuncu2Kart6.setIcon(arkasiDonuk);
            oyuncu2Kart6.setBounds(550, 250, 120, 200);
            oyuncu2Kart6.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart6;
        } else if (oyuncu2SecilenKartIndis == 6) {
            oyuncu2Kart7.setVisible(false);
            oyuncu2Kart7.setIcon(arkasiDonuk);
            oyuncu2Kart7.setBounds(550, 250, 120, 200);
            oyuncu2Kart7.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart7;
        } else if (oyuncu2SecilenKartIndis == 7) {
            oyuncu2Kart8.setVisible(false);
            oyuncu2Kart8.setIcon(arkasiDonuk);
            oyuncu2Kart8.setBounds(550, 250, 120, 200);
            oyuncu2Kart8.setVisible(true);
            oyuncu2SecilenKart = oyuncu2Kart8;
        }

        if (oyuncu2SecilenKart == oyuncu2Kart1 || oyuncu2SecilenKart == oyuncu2Kart2 || oyuncu2SecilenKart == oyuncu2Kart3 || oyuncu2SecilenKart == oyuncu2Kart4) {
            yazilar.setText(oyuncu1.getOyuncuAdi() + " kart seciyor.");
            //futbolcuları kapat
            oyuncu1Kart5.setEnabled(false);
            oyuncu1Kart6.setEnabled(false);
            oyuncu1Kart7.setEnabled(false);
            oyuncu1Kart8.setEnabled(false);

            int rastgeleSayi = (int) (Math.random() * 4);//0 1 2 3 

            int oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);

            oyuncu1SecilenKartIndis = rastgeleSayi;

            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            Random kistas = new Random();
            String dizi[] = new String[3];
            dizi[0] = "İkilik";//oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik();
            dizi[1] = "Ucluk";//oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk();
            dizi[2] = "SerbestAtis";//oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis();
            int indis = kistas.nextInt(dizi.length);
            if (indis == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            /* if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getHasarPuani() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getHasarPuani()) {
                yazilar.setText(oyuncu1.getOyuncuAdi() + "'a 5 puan eklendi.");
                oyuncu1.puanEkle();
                 
            } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getHasarPuani() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getHasarPuani()) {
                yazilar.setText(oyuncu2.getOyuncuAdi() + "'a 5 puan eklendi.");
                oyuncu2.puanEkle();
            } else {
                yazilar.setText("Berabere!");
            }*/
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            /*  try {
                sleep(2500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }*/
            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();

            oyuncu1Kart5.setEnabled(true);
            oyuncu1Kart6.setEnabled(true);
            oyuncu1Kart7.setEnabled(true);
            oyuncu1Kart8.setEnabled(true);

            //_____________________________________________________________________________________________________________________________           
            //İkinci Kartlar  
            oyuncu1Kart1.setEnabled(false);
            oyuncu1Kart2.setEnabled(false);
            oyuncu1Kart3.setEnabled(false);
            oyuncu2Kart1.setEnabled(false);
            oyuncu2Kart2.setEnabled(false);
            oyuncu2Kart3.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi2 = 3 + (int) (Math.random() * 4);//3 4 5 6

            //   oyuncu1Kart1.setEnabled(false); oyuncu1Kart2.setEnabled(false); oyuncu1Kart3.setEnabled(false);   
            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi2;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            Random kistas2 = new Random();
            String dizi2[] = new String[3];
            dizi2[0] = "Penaltı";
            dizi2[1] = "SerbestAtis";
            dizi2[2] = "KaleciyleKarsiKarsiya";
            int indis2 = kistas2.nextInt(dizi2.length);
            if (indis2 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis2 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }

            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());
            
            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu2Kart2.setEnabled(true);
            oyuncu2Kart3.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);
            oyuncu1Kart2.setEnabled(true);
            oyuncu1Kart3.setEnabled(true);

            //_____________________________________________________________________________________________________________________________                   
            //Üçüncü Kartlar
            oyuncu2Kart4.setEnabled(false);
            oyuncu2Kart5.setEnabled(false);
            oyuncu2Kart6.setEnabled(false);//futbolcuları kapat 3,4,5
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi3 = (int) (Math.random() * 3);//0 1 2

            oyuncu1Kart4.setEnabled(false);
            oyuncu1Kart5.setEnabled(false);
            oyuncu1Kart6.setEnabled(false);
            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi3;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas3 = new Random();
            String dizi3[] = new String[3];
            dizi3[0] = "İkilik";
            dizi3[1] = "Ucluk";
            dizi3[2] = "SerbestAtis";
            int indis3 = kistas.nextInt(dizi.length);
            if (indis3 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis3 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            
            
            
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart4.setEnabled(true);
            oyuncu2Kart5.setEnabled(true);
            oyuncu2Kart6.setEnabled(true);
            oyuncu1Kart4.setEnabled(true);
            oyuncu1Kart5.setEnabled(true);
            oyuncu1Kart6.setEnabled(true);

            //____________________________________________________________________________________________________________________________
            //Dördüncü Kartlar
            oyuncu2Kart1.setEnabled(false);
            oyuncu2Kart2.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi4 = 2 + (int) (Math.random() * 3);// 2 3 4

            oyuncu1Kart1.setEnabled(false);
            oyuncu1Kart2.setEnabled(false);
            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi4;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas4 = new Random();
            String dizi4[] = new String[3];
            dizi4[0] = "Penaltı";
            dizi4[1] = "SerbestAtis";
            dizi4[2] = "KaleciyleKarsiKarsiya";
            int indis4 = kistas2.nextInt(dizi2.length);
            if (indis4 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis4 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu2Kart2.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);
            oyuncu1Kart2.setEnabled(true);

            //_______________________________________________________________________________________________________________________
            //Beşinci Kartlar
            oyuncu2Kart3.setEnabled(false);
            oyuncu2Kart4.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi5 = (int) (Math.random() * 2);// 0 1

            oyuncu1Kart3.setEnabled(false);
            oyuncu1Kart4.setEnabled(false);
            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi5;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
             Random kistas5 = new Random();
            String dizi5[] = new String[3];
            dizi5[0] = "İkilik";
            dizi5[1] = "Ucluk";
            dizi5[2] = "SerbestAtis";
            int indis5 = kistas.nextInt(dizi.length);
            if (indis5 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis5 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart3.setEnabled(true);
            oyuncu2Kart4.setEnabled(true);
            oyuncu1Kart3.setEnabled(true);
            oyuncu1Kart4.setEnabled(true);

            //_______________________________________________________________________________________________________________________-
            //Altıncı Kartlar
            oyuncu2Kart1.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi6 = 1 + (int) (Math.random() * 2);// 0 1

            oyuncu1Kart1.setEnabled(false);
            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi6;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas6 = new Random();
            String dizi6[] = new String[3];
            dizi6[0] = "Penaltı";
            dizi6[1] = "SerbestAtis";
            dizi6[2] = "KaleciyleKarsiKarsiya";
            int indis6 = kistas2.nextInt(dizi2.length);
            if (indis6== 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis6 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }

            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());
            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);

            //_____________________________________________________________________________________________________________________
            //Yedinci Kartlar
            oyuncu2Kart2.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi7 = 0;

            oyuncu1Kart2.setEnabled(false);
            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi7;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
           //Kartinin puani daha yuksek olan oyuncuya puan eklenir
             Random kistas7 = new Random();
            String dizi7[] = new String[3];
            dizi5[0] = "İkilik";
            dizi5[1] = "Ucluk";
            dizi5[2] = "SerbestAtis";
            int indis7 = kistas.nextInt(dizi.length);
            if (indis7 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis7 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }

            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());
            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //Sekizinci Kartlar
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi8 = 0;

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi8;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
           Random kistas8 = new Random();
            String dizi8[] = new String[3];
            dizi8[0] = "Penaltı";
            dizi8[1] = "SerbestAtis";
            dizi8[2] = "KaleciyleKarsiKarsiya";
            int indis8 = kistas2.nextInt(dizi2.length);
            if (indis8== 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis8 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }

            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());
            
            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();

        } // ilk if bloğum
        //**************************************ELSE İF BLOĞUM*********************************************************************        
        else if (oyuncu2SecilenKart == oyuncu2Kart5 || oyuncu2SecilenKart == oyuncu2Kart6 || oyuncu2SecilenKart == oyuncu2Kart7 || oyuncu2SecilenKart == oyuncu2Kart8) {

            yazilar.setText(oyuncu1.getOyuncuAdi() + " kart seciyor.");
            //futbolcuları kapat
            oyuncu1Kart1.setEnabled(false);
            oyuncu1Kart2.setEnabled(false);
            oyuncu1Kart3.setEnabled(false);
            oyuncu1Kart4.setEnabled(false);

            int rastgeleSayi = 4 + (int) (Math.random() * 4);//0 1 2 3 

            int oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);

            oyuncu1SecilenKartIndis = rastgeleSayi;

            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas1 = new Random();
            String dizi1[] = new String[3];
            dizi1[0] = "Penaltı";
            dizi1[1] = "SerbestAtis";
            dizi1[2] = "KaleciyleKarsiKarsiya";
            int indis1 = kistas1.nextInt(dizi1.length);
            if (indis1 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis1 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

           

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();

            // oyuncu2SecilenKart.setVisible(false);
            //oyuncu1SecilenKart.setVisible(false);
            oyuncu1Kart1.setEnabled(true);
            oyuncu1Kart2.setEnabled(true);
            oyuncu1Kart3.setEnabled(true);
            oyuncu1Kart4.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //İkinci Kartlar  
            oyuncu2Kart5.setEnabled(false);
            oyuncu2Kart6.setEnabled(false);
            oyuncu2Kart7.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi2 = (int) (Math.random() * 4);//0 1 2 3

            oyuncu1Kart5.setEnabled(false);
            oyuncu1Kart6.setEnabled(false);
            oyuncu1Kart7.setEnabled(false);

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi2;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
             Random kistas12 = new Random();
            String dizi12[] = new String[3];
            dizi12[0] = "İkilik";
            dizi12[1] = "Ucluk";
            dizi12[2] = "SerbestAtis";
            int indis12 = kistas12.nextInt(dizi12.length);
            if (indis12 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis12 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart5.setEnabled(true);
            oyuncu2Kart6.setEnabled(true);
            oyuncu2Kart7.setEnabled(true);
            oyuncu1Kart5.setEnabled(true);
            oyuncu1Kart6.setEnabled(true);
            oyuncu1Kart7.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //üçüncü Kartlar 
            oyuncu2Kart1.setEnabled(false);
            oyuncu2Kart2.setEnabled(false);
            oyuncu2Kart3.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi3 = 3 + (int) (Math.random() * 3);//0 1 2 

            oyuncu1Kart1.setEnabled(false);
            oyuncu1Kart2.setEnabled(false);
            oyuncu1Kart3.setEnabled(false);

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi3;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
             Random kistas3 = new Random();
            String dizi3[] = new String[3];
            dizi3[0] = "Penaltı";
            dizi3[1] = "SerbestAtis";
            dizi3[2] = "KaleciyleKarsiKarsiya";
            int indis3 = kistas3.nextInt(dizi1.length);
            if (indis3 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis3 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu2Kart2.setEnabled(true);
            oyuncu2Kart3.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);
            oyuncu1Kart2.setEnabled(true);
            oyuncu1Kart3.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //Dördüncü Kartlar 
            oyuncu2Kart4.setEnabled(false);
            oyuncu2Kart5.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi4 = (int) (Math.random() * 3);//0 1 2 

            oyuncu1Kart4.setEnabled(false);
            oyuncu1Kart5.setEnabled(false);

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi4;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas4 = new Random();
            String dizi4[] = new String[3];
            dizi4[0] = "İkilik";
            dizi4[1] = "Ucluk";
            dizi4[2] = "SerbestAtis";
            int indis4 = kistas4.nextInt(dizi12.length);
            if (indis4 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis4 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart4.setEnabled(true);
            oyuncu2Kart5.setEnabled(true);
            oyuncu1Kart4.setEnabled(true);
            oyuncu1Kart5.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //Beşinci Kartlar 
            oyuncu2Kart1.setEnabled(false);
            oyuncu2Kart2.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi5 = 2 + (int) (Math.random() * 2);//0 1 

            oyuncu1Kart1.setEnabled(false);
            oyuncu1Kart2.setEnabled(false);

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi5;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas5 = new Random();
            String dizi5[] = new String[3];
            dizi5[0] = "Penaltı";
            dizi5[1] = "SerbestAtis";
            dizi5[2] = "KaleciyleKarsiKarsiya";
            int indis5 = kistas5.nextInt(dizi5.length);
            if (indis5 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis5 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu2Kart2.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);
            oyuncu1Kart2.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //Altıncı Kartlar 
            oyuncu2Kart3.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi6 = (int) (Math.random() * 2);//0 1 

            oyuncu1Kart3.setEnabled(false);

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi6;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas6 = new Random();
            String dizi6[] = new String[3];
            dizi6[0] = "İkilik";
            dizi6[1] = "Ucluk";
            dizi6[2] = "SerbestAtis";
            int indis6 = kistas6.nextInt(dizi6.length);
            if (indis6 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis6 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart3.setEnabled(true);
            oyuncu1Kart3.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //Yedinci Kartlar 
            oyuncu2Kart1.setEnabled(false);
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi7 = 1;

            oyuncu1Kart1.setEnabled(false);

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi7;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas7 = new Random();
            String dizi7[] = new String[3];
            dizi7[0] = "Penaltı";
            dizi7[1] = "SerbestAtis";
            dizi7[2] = "KaleciyleKarsiKarsiya";
            int indis7= kistas7.nextInt(dizi7.length);
            if (indis7 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " PENALTI\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getPenalti() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " PENALTI\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getPenalti());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis7 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " SERBEST ATIŞ " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getKaleciyleKarsiKarsiya() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "KALECİYLE KARŞI" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getKaleciyleKarsiKarsiya());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

            kartlariSifirla();
            oyuncu2Kart1.setEnabled(true);
            oyuncu2Kart2.setEnabled(true);
            oyuncu1Kart1.setEnabled(true);
            oyuncu1Kart2.setEnabled(true);

            //___________________________________________________________________________________________________________________________
            //Sekizinci Kartlar 
            oyuncu2SecilenKartIndis = oyuncu2.kartSec(oyuncu2Kart1, oyuncu2Kart2, oyuncu2Kart3, oyuncu2Kart4, oyuncu2Kart5, oyuncu2Kart6, oyuncu2Kart7, oyuncu2Kart8);

            if (oyuncu2SecilenKartIndis == 0) {
                oyuncu2Kart1.setVisible(false);
                oyuncu2Kart1.setIcon(arkasiDonuk);
                oyuncu2Kart1.setBounds(550, 250, 120, 200);
                oyuncu2Kart1.setVisible(true);

                oyuncu2SecilenKart = oyuncu2Kart1;

            } else if (oyuncu2SecilenKartIndis == 1) {
                oyuncu2Kart2.setVisible(false);
                oyuncu2Kart2.setIcon(arkasiDonuk);
                oyuncu2Kart2.setBounds(550, 250, 120, 200);
                oyuncu2Kart2.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart2;
            } else if (oyuncu2SecilenKartIndis == 2) {
                oyuncu2Kart3.setVisible(false);
                oyuncu2Kart3.setIcon(arkasiDonuk);
                oyuncu2Kart3.setBounds(550, 250, 120, 200);
                oyuncu2Kart3.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart3;
            } else if (oyuncu2SecilenKartIndis == 3) {
                oyuncu2Kart4.setVisible(false);
                oyuncu2Kart4.setIcon(arkasiDonuk);
                oyuncu2Kart4.setBounds(550, 250, 120, 200);
                oyuncu2Kart4.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart4;
            } else if (oyuncu2SecilenKartIndis == 4) {
                oyuncu2Kart5.setVisible(false);
                oyuncu2Kart5.setIcon(arkasiDonuk);
                oyuncu2Kart5.setBounds(550, 250, 120, 200);
                oyuncu2Kart5.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart5;
            } else if (oyuncu2SecilenKartIndis == 5) {
                oyuncu2Kart6.setVisible(false);
                oyuncu2Kart6.setIcon(arkasiDonuk);
                oyuncu2Kart6.setBounds(550, 250, 120, 200);
                oyuncu2Kart6.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart6;
            } else if (oyuncu2SecilenKartIndis == 6) {
                oyuncu2Kart7.setVisible(false);
                oyuncu2Kart7.setIcon(arkasiDonuk);
                oyuncu2Kart7.setBounds(550, 250, 120, 200);
                oyuncu2Kart7.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart7;
            } else if (oyuncu2SecilenKartIndis == 7) {
                oyuncu2Kart8.setVisible(false);
                oyuncu2Kart8.setIcon(arkasiDonuk);
                oyuncu2Kart8.setBounds(550, 250, 120, 200);
                oyuncu2Kart8.setVisible(true);
                oyuncu2SecilenKart = oyuncu2Kart8;
            }

            int rastgeleSayi8 = 0;

            oyuncu1SecilenKartIndis = oyuncu1.kartSec(oyuncu1Kart1, oyuncu1Kart2, oyuncu1Kart3, oyuncu1Kart4, oyuncu1Kart5, oyuncu1Kart6, oyuncu1Kart7, oyuncu1Kart8);
            oyuncu1SecilenKartIndis = rastgeleSayi8;
            if (oyuncu1SecilenKartIndis == 0) {
                oyuncu1Kart1.setVisible(false);
                oyuncu1Kart1.setIcon(arkasiDonuk);
                oyuncu1Kart1.setBounds(680, 250, 120, 200);
                oyuncu1Kart1.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart1;
            } else if (oyuncu1SecilenKartIndis == 1) {
                oyuncu1Kart2.setVisible(false);
                oyuncu1Kart2.setIcon(arkasiDonuk);
                oyuncu1Kart2.setBounds(680, 250, 120, 200);
                oyuncu1Kart2.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart2;
            } else if (oyuncu1SecilenKartIndis == 2) {
                oyuncu1Kart3.setVisible(false);
                oyuncu1Kart3.setIcon(arkasiDonuk);
                oyuncu1Kart3.setBounds(680, 250, 120, 200);
                oyuncu1Kart3.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart3;
            } else if (oyuncu1SecilenKartIndis == 3) {
                oyuncu1Kart4.setVisible(false);
                oyuncu1Kart4.setIcon(arkasiDonuk);
                oyuncu1Kart4.setBounds(680, 250, 120, 200);
                oyuncu1Kart4.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart4;
            } else if (oyuncu1SecilenKartIndis == 4) {
                oyuncu1Kart5.setVisible(false);
                oyuncu1Kart5.setIcon(arkasiDonuk);
                oyuncu1Kart5.setBounds(680, 250, 120, 200);
                oyuncu1Kart5.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart5;
            } else if (oyuncu1SecilenKartIndis == 5) {
                oyuncu1Kart6.setVisible(false);
                oyuncu1Kart6.setIcon(arkasiDonuk);
                oyuncu1Kart6.setBounds(680, 250, 120, 200);
                oyuncu1Kart6.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart6;
            } else if (oyuncu1SecilenKartIndis == 6) {
                oyuncu1Kart7.setVisible(false);
                oyuncu1Kart7.setIcon(arkasiDonuk);
                oyuncu1Kart7.setBounds(680, 250, 120, 200);
                oyuncu1Kart7.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart7;
            } else if (oyuncu1SecilenKartIndis == 7) {
                oyuncu1Kart8.setVisible(false);
                oyuncu1Kart8.setIcon(arkasiDonuk);
                oyuncu1Kart8.setBounds(680, 250, 120, 200);
                oyuncu1Kart8.setVisible(true);
                oyuncu1SecilenKart = oyuncu1Kart8;
            }

            try {
                sleep(1500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }

            //Iki secilen kartin da resmi gösterilir
            oyuncu1SecilenKart.setIcon(oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getResim());
            oyuncu2SecilenKart.setIcon(oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getResim());

            //Kartinin puani daha yuksek olan oyuncuya puan eklenir
            Random kistas8 = new Random();
            String dizi8[] = new String[3];
            dizi8[0] = "İkilik";
            dizi8[1] = "Ucluk";
            dizi8[2] = "SerbestAtis";
            int indis8 = kistas6.nextInt(dizi8.length);
            if (indis8 == 0) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " İKİLİK\n" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getIkilik() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + " İKİLİK\n" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getIkilik());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("İKİLİK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raund Berabere ");
                }
            } else if (indis8 == 1) {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + " ÜÇLÜK " + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getUcluk() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "ÜÇLÜK" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getUcluk());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("ÜÇLÜK PUANLARI\nAYNI BERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            } else {
                if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() > oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu1.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis());
                    oyuncu1.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu1.getOyuncuAdi());
                } else if (oyuncu1.kartlar.get(oyuncu1SecilenKartIndis).getSerbestAtis() < oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis()) {
                    yazilar.setText(oyuncu2.getOyuncuAdi() + "SERBEST ATIŞ" + oyuncu2.kartlar.get(oyuncu2SecilenKartIndis).getSerbestAtis());
                    oyuncu2.puanEkle();
                    showMessageDialog(null, "Raundu kazanan: " + oyuncu2.getOyuncuAdi());
                } else {
                    yazilar.setText("SERBEST ATIŞ PUANLARI AYNI\nBERABERE");
                    showMessageDialog(null, "Raundu Berabere ");
                }
            }
            oyuncu1Yazi.setText(oyuncu1.getOyuncuAdi() + " : " + oyuncu1.getSkor());
            oyuncu2Yazi.setText(oyuncu2.getOyuncuAdi() + " : " + oyuncu2.getSkor());

            

            oyuncu1.kartlar.remove(oyuncu1SecilenKartIndis);
            oyuncu2.kartlar.remove(oyuncu2SecilenKartIndis);

           // kartlariSifirla();
            

        }// else if bloğum

        //Sonucu yazdir
        if (oyuncu1.getSkor() > oyuncu2.getSkor()) {
            oyunSonu.setText(oyuncu1.getOyuncuAdi() + " kazandi!");
        } else if (oyuncu1.getSkor() < oyuncu2.getSkor()) {
            oyunSonu.setText(oyuncu2.getOyuncuAdi() + " kazandi!");
        } else {
            oyunSonu.setText("Berabere!");
        }
    }

//Tum kartlarin secilme, one cikma ve gosterilme durumlarini sifirlar, her el basi cagirilir
    public void kartlariSifirla() {
        oyuncu1Kart1.setVisible(false);
        oyuncu1Kart2.setVisible(false);
        oyuncu1Kart3.setVisible(false);
        oyuncu1Kart4.setVisible(false);
        oyuncu1Kart5.setVisible(false);
        oyuncu1Kart6.setVisible(false);
        oyuncu1Kart7.setVisible(false);
        oyuncu1Kart8.setVisible(false);

        oyuncu2Kart1.setVisible(false);
        oyuncu2Kart2.setVisible(false);
        oyuncu2Kart3.setVisible(false);
        oyuncu2Kart4.setVisible(false);
        oyuncu2Kart5.setVisible(false);
        oyuncu2Kart6.setVisible(false);
        oyuncu2Kart7.setVisible(false);
        oyuncu2Kart8.setVisible(false);

        if (oyuncu1.kartlar.size() > 0) {
            oyuncu1Kart1.setBounds(160, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart1.setIcon(oyuncu1.kartlar.get(0).getResim());
            } else {
                oyuncu1Kart1.setIcon(arkasiDonuk);
            }
            oyuncu1Kart1.setVisible(true);
        }
        if (oyuncu1.kartlar.size() > 1) {
            oyuncu1Kart2.setBounds(290, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart2.setIcon(oyuncu1.kartlar.get(1).getResim());
            } else {
                oyuncu1Kart2.setIcon(arkasiDonuk);
            }
            oyuncu1Kart2.setVisible(true);
        }
        if (oyuncu1.kartlar.size() > 2) {
            oyuncu1Kart3.setBounds(420, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart3.setIcon(oyuncu1.kartlar.get(2).getResim());
            } else {
                oyuncu1Kart3.setIcon(arkasiDonuk);
            }
            oyuncu1Kart3.setVisible(true);
        }

        if (oyuncu1.kartlar.size() > 3) {
            oyuncu1Kart4.setBounds(550, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart4.setIcon(oyuncu1.kartlar.get(3).getResim());
            } else {
                oyuncu1Kart4.setIcon(arkasiDonuk);
            }
            oyuncu1Kart4.setVisible(true);
        }

        if (oyuncu1.kartlar.size() > 4) {
            oyuncu1Kart5.setBounds(680, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart5.setIcon(oyuncu1.kartlar.get(4).getResim());
            } else {
                oyuncu1Kart5.setIcon(arkasiDonuk);
            }
            oyuncu1Kart5.setVisible(true);
        }
        if (oyuncu1.kartlar.size() > 5) {
            oyuncu1Kart6.setBounds(810, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart6.setIcon(oyuncu1.kartlar.get(5).getResim());
            } else {
                oyuncu1Kart6.setIcon(arkasiDonuk);
            }
            oyuncu1Kart6.setVisible(true);
        }

        if (oyuncu1.kartlar.size() > 6) {
            oyuncu1Kart7.setBounds(940, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart7.setIcon(oyuncu1.kartlar.get(6).getResim());
            } else {
                oyuncu1Kart7.setIcon(arkasiDonuk);
            }
            oyuncu1Kart7.setVisible(true);
        }

        if (oyuncu1.kartlar.size() > 7) {
            oyuncu1Kart8.setBounds(1070, 10, 120, 200);
            if (hepsiniGor) {
                oyuncu1Kart8.setIcon(oyuncu1.kartlar.get(7).getResim());
            } else {
                oyuncu1Kart8.setIcon(arkasiDonuk);
            }
            oyuncu1Kart8.setVisible(true);
        }

        if (oyuncu2.kartlar.size() > 0) {
            oyuncu2Kart1.setBounds(160, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart1.setIcon(oyuncu2.kartlar.get(0).getResim());
            } else {
                oyuncu2Kart1.setIcon(arkasiDonuk);
            }
            oyuncu2Kart1.setVisible(true);
        }
        if (oyuncu2.kartlar.size() > 1) {
            oyuncu2Kart2.setBounds(290, 450, 120, 200);
            if (kartlariGor) {
                oyuncu2Kart2.setIcon(oyuncu2.kartlar.get(1).getResim());
            } else {
                oyuncu2Kart2.setIcon(arkasiDonuk);
            }
            oyuncu2Kart2.setVisible(true);
        }
        if (oyuncu2.kartlar.size() > 2) {
            oyuncu2Kart3.setBounds(420, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart3.setIcon(oyuncu2.kartlar.get(2).getResim());
            } else {
                oyuncu2Kart3.setIcon(arkasiDonuk);
            }
            oyuncu2Kart3.setVisible(true);
        }

        if (oyuncu2.kartlar.size() > 3) {
            oyuncu2Kart4.setBounds(550, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart4.setIcon(oyuncu2.kartlar.get(3).getResim());
            } else {
                oyuncu2Kart4.setIcon(arkasiDonuk);
            }
            oyuncu2Kart4.setVisible(true);
        }

        if (oyuncu2.kartlar.size() > 4) {
            oyuncu2Kart5.setBounds(680, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart5.setIcon(oyuncu2.kartlar.get(4).getResim());
            } else {
                oyuncu2Kart5.setIcon(arkasiDonuk);
            }
            oyuncu2Kart5.setVisible(true);
        }

        if (oyuncu2.kartlar.size() > 5) {
            oyuncu2Kart6.setBounds(810, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart6.setIcon(oyuncu2.kartlar.get(5).getResim());
            } else {
                oyuncu2Kart6.setIcon(arkasiDonuk);
            }
            oyuncu2Kart6.setVisible(true);
        }

        if (oyuncu2.kartlar.size() > 6) {
            oyuncu2Kart7.setBounds(940, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart7.setIcon(oyuncu2.kartlar.get(6).getResim());
            } else {
                oyuncu2Kart7.setIcon(arkasiDonuk);
            }
            oyuncu2Kart7.setVisible(true);
        }

        if (oyuncu2.kartlar.size() > 7) {
            oyuncu2Kart8.setBounds(1070, 450, 120, 200);
            if (kartlariGor || hepsiniGor) {
                oyuncu2Kart8.setIcon(oyuncu2.kartlar.get(7).getResim());
            } else {
                oyuncu2Kart8.setIcon(arkasiDonuk);
            }
            oyuncu2Kart8.setVisible(true);
        }

    }

    public void kartlariTanimla() {

        Cedi cedi;
        JimmyButler jimmyButler;
        KevinDurant kevinDurant;
        Kobe kobe;
        KyrieIrving kyrieIrving;
        Lebron lebron;
        Oneal oneal;
        StephanCurry stephanCury;

        cedi = new Cedi();
        jimmyButler = new JimmyButler();
        kevinDurant = new KevinDurant();
        kobe = new Kobe();
        kyrieIrving = new KyrieIrving();
        lebron = new Lebron();
        oneal = new Oneal();
        stephanCury = new StephanCurry();

        kartlar.add(cedi);
        kartlar.add(jimmyButler);
        kartlar.add(kevinDurant);
        kartlar.add(kobe);
        kartlar.add(kyrieIrving);
        kartlar.add(lebron);
        kartlar.add(oneal);
        kartlar.add(stephanCury);

        Random rand = new Random();
        Sporcu kart;
        int indis;
        for (int i = 0; i < 4; i++) {
            indis = rand.nextInt(kartlar.size());
            kart = kartlar.get(indis);
            oyuncu1.kartlar.add(kart);
            kartlar.remove(indis);

            indis = rand.nextInt(kartlar.size());
            kart = kartlar.get(indis);
            oyuncu2.kartlar.add(kart);
            kartlar.remove(indis);
        }

    }

    public void kartlariTanimla2() {
        Alves alves;
        Busqets busqets;
        Cengiz cengiz;
        Drogba drogba;
        Messi messi;
        Ramos ramos;
        Ronaldinho ronaldinho;
        Ronaldo ronaldo;

        alves = new Alves();
        busqets = new Busqets();
        cengiz = new Cengiz();
        drogba = new Drogba();
        messi = new Messi();
        ramos = new Ramos();
        ronaldinho = new Ronaldinho();
        ronaldo = new Ronaldo();

        kartlar.add(alves);
        kartlar.add(busqets);
        kartlar.add(cengiz);
        kartlar.add(drogba);
        kartlar.add(messi);
        kartlar.add(ramos);
        kartlar.add(ronaldinho);
        kartlar.add(ronaldo);
        Random rand = new Random();
        Sporcu kart;
        int indis;
        for (int i = 0; i < 4; i++) {
            indis = rand.nextInt(kartlar.size());
            kart = kartlar.get(indis);
            oyuncu1.kartlar.add(kart);
            kartlar.remove(indis);

            indis = rand.nextInt(kartlar.size());
            kart = kartlar.get(indis);
            oyuncu2.kartlar.add(kart);
            kartlar.remove(indis);
        }

    }

       //public static void main(String[] args) throws java.io.IOException {
      //  JFrame frame = new JFrame();
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  frame.setResizable(false);
        /*JLabel arkaPlan = new JLabel(new ImageIcon(ImageIO.read(new File("Arkaplan.jpg"))));
       frame.setContentPane(arkaPlan);*/
       // Main oyun = new Main(frame);
       // oyun.ekranOlustur();
   // }
}
