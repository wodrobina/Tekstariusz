import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class programGlowny extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1996364283427355738L;
	JButton bSortuj, bExit;
	JLabel lTworca, lSciezka, lNazwaPliku; 
	JTextField tSciezka, tNazwaPliku;
	JScrollPane scScroll;
	JTextArea taPosortowane;
	String nazwaPliku, sciezkaDostepu;
	

	public programGlowny()
	{
		//Okienko
		setSize(300,300);
		setTitle("Sorter alfabetyczny");
		
		setLayout(null);
		
		//przycisk "Sortuj"
		bSortuj = new JButton("Sortuj");
		bSortuj.setBounds(90, 35, 100, 30);
		add(bSortuj);
		bSortuj.addActionListener(this);
		
		bExit = new JButton("Wyjscie");
		bExit.setBounds(90, 5, 100, 20);
		add(bExit);
		bExit.addActionListener(this);
		
		//pola tekstowe
		tSciezka = new JTextField();
		tSciezka.setBounds(5, 100, 220, 20);
		add(tSciezka);
		tNazwaPliku = new JTextField();
		tNazwaPliku.setBounds(5, 150, 220, 20);
		add(tNazwaPliku);
		

		//text area
		taPosortowane = new JTextArea();
		taPosortowane.setBounds(5, 180, 275, 55);
		taPosortowane.setLineWrap(true);
		taPosortowane.setEditable(true);
		add(taPosortowane);
		

		//etykieta
		lSciezka = new JLabel("Podaj sciezke dostepu:");
		lSciezka.setBounds(5, 65, 220, 40);
		add(lSciezka);
		lNazwaPliku = new JLabel("Podaj nazwê pliku txt:");
		lNazwaPliku.setBounds(5, 115, 220, 40);
		add(lNazwaPliku);		
		lTworca = new JLabel("By wowik 2014");
		lTworca.setBounds(5, 230, 120, 40);
		add(lTworca);
		

	}
	
	public static void main(String[] args) 
	{
		programGlowny okno = new programGlowny();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object przycisk = ae.getSource(); 
		if (przycisk == bSortuj)
		{
			OdczytPliku opTest = new OdczytPliku();
			sciezkaDostepu = tSciezka.getText();
			nazwaPliku = tNazwaPliku.getText();
			taPosortowane.setText(opTest.odczytajPlikISortuj(nazwaPliku+".txt", ""));
			
		}
		else if(przycisk == bExit)
		{
			dispose();
		}
	}	
}
