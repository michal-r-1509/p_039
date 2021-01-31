import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoGry extends JFrame implements ActionListener{

    private JLabel tyt1, tyt2, linia1, linia2, labwynik, labiloscprob1, komunikaty, dousuniecia, lwyswietlproby;
    private JTextField tliczba;
    private JButton zatwierdz, wskazowka;
    private int liczba = 0, iloscprob = 0;
    public double wynik=100;
    boolean czywygrana = false;

        Generator los = new Generator(50);
        int liczbalosowa = los.randomBetween(1, 99);

    public OknoGry(){
        setLayout(null);
        setSize(400, 260);
        setTitle("Odgadnij liczbę!");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tyt1 = new JLabel("ODGADNIJ LICZBĘ!");
        tyt1.setBounds(100,5, 300, 50);
        tyt1.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(tyt1);

        tyt2 = new JLabel("Zgadnij jaką liczbę wylosował komputer z zakresu od 1 do 99");
        tyt2.setBounds(20,45, 380, 20);
        tyt2.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(tyt2);

        linia1 = new JLabel("Twoja liczba:");
        linia1.setBounds(10,100, 120, 30);
        linia1.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(linia1);

        tliczba = new JTextField("");
        tliczba.setBounds(140,100, 50, 30);
        tliczba.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(tliczba);
        tliczba.addActionListener( this);
        tliczba.setToolTipText("Wpisz swoją liczbę i zatwierdź");

        zatwierdz = new JButton("OK");
        zatwierdz.setBounds(200,100, 60, 30);
        zatwierdz.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(zatwierdz);
        zatwierdz.addActionListener( this);

        wskazowka = new JButton("Wskazówka");
        wskazowka.setBounds(270,100, 110, 30);
        wskazowka.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(wskazowka);
        wskazowka.addActionListener( this);

        linia2 = new JLabel("Wynik:");
        linia2.setBounds(10,150, 80, 30);
        linia2.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(linia2);

        labwynik = new JLabel("");
        labwynik.setBounds(150,150, 60, 30);
        labwynik.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(labwynik);

        labiloscprob1 = new JLabel("Ilość prób:");
        labiloscprob1.setBounds(230,150, 100, 30);
        labiloscprob1.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(labiloscprob1);

        lwyswietlproby = new JLabel(String.valueOf(iloscprob));
        lwyswietlproby.setBounds(350,150, 50, 30);
        lwyswietlproby.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(lwyswietlproby);

        komunikaty = new JLabel("");
        komunikaty.setBounds(10,200, 380, 20);
        komunikaty.setFont(new Font("SansSerif", Font.PLAIN, 12));
        add(komunikaty);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if ((tliczba.getText()).equals("")) {
            komunikaty.setForeground(Color.BLACK);
            komunikaty.setText("Wpisz liczbę");
        }
        else{
            liczba = Integer.parseInt(tliczba.getText());
            if (liczba < 1 || liczba > 99) {
                komunikaty.setForeground(Color.RED);
                komunikaty.setText("Niewłaściwa liczba");
                tliczba.setText("");
                liczba = 0;
            }
            else{
                if (zrodlo == zatwierdz || zrodlo == tliczba) {
                    if (liczba == liczbalosowa) {
                        komunikaty.setForeground(Color.GREEN);
                        komunikaty.setText("Wygrana!");
                        Generator los = new Generator(10);
                        liczbalosowa = los.randomBetween(1, 99);
                        iloscprob += 1;
                        lwyswietlproby.setText(String.valueOf(iloscprob));
                        czywygrana = true;
                    }
                    else {
                        komunikaty.setForeground(Color.BLACK);
                        komunikaty.setText("Próbuj dalej");
                        iloscprob += 1;
                        lwyswietlproby.setText(String.valueOf(iloscprob));
                    }
                }
            }
        tliczba.setText("");
    }
        if (zrodlo == wskazowka) {
            //tliczba.setText("");
            if (iloscprob == 0) {
                komunikaty.setForeground(Color.BLACK);
                komunikaty.setText("Najpierw zagraj");
            }
            else {
                if (liczbalosowa > liczba){
                    komunikaty.setForeground(Color.BLACK);
                    komunikaty.setText("Liczba komputera jest większa");
                    iloscprob+=1;
                    lwyswietlproby.setText(String.valueOf(iloscprob));
                }
                else {
                    komunikaty.setForeground(Color.BLACK);
                    komunikaty.setText("Liczba komputera jest mniejsza");
                    iloscprob+=1;
                    lwyswietlproby.setText(String.valueOf(iloscprob));
                }
            }
        }
        if (iloscprob > 0) {
            wynik = 100 / ((double) iloscprob);
            String wynikout = String.format("%.2f", wynik);
            labwynik.setText(String.valueOf(wynikout));
            //System.out.println(czywygrana);
        }
        if (czywygrana == true){
            iloscprob = 0;
            wynik = 100;
            czywygrana = false;
            //System.out.println("wreszcie cos sie zmienilo");
        }
    }
}
