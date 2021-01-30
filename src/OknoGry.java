import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoGry extends JFrame implements ActionListener{

    private JLabel tyt1, tyt2, linia1, linia2, komunikaty;
    private JTextField liczba;
    private JButton zatwierdz, wskazowka;

    public OknoGry(){
        setLayout(null);
        setSize(400, 300);
        setTitle("Odgadnij liczbę!");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tyt1 = new JLabel("ODGADNIJ LICZBĘ!");
        tyt1.setBounds(100,5, 300, 50);
        tyt1.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(tyt1);

        tyt2 = new JLabel("Zgadnij jaką liczbę wylosował komputer z zakresu od 1 do 100");
        tyt2.setBounds(20,45, 380, 20);
        tyt2.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(tyt2);

        linia1 = new JLabel("Twoja liczba:");
        linia1.setBounds(10,80, 120, 30);
        linia1.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(linia1);

        liczba = new JTextField("");
        liczba.setBounds(140,80, 50, 30);
        liczba.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(liczba);
        liczba.addActionListener( this);
        liczba.setToolTipText("Wpisz swoją liczbę i zatwierdź");

        zatwierdz = new JButton("OK");
        zatwierdz.setBounds(200,80, 60, 30);
        zatwierdz.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(zatwierdz);
        zatwierdz.addActionListener( this);

        wskazowka = new JButton("Wskazówka");
        wskazowka.setBounds(270,80, 110, 30);
        wskazowka.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(wskazowka);
        wskazowka.addActionListener( this);

        linia2 = new JLabel("Wynik:");
        linia2.setBounds(10,120, 80, 30);
        linia2.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(linia2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
