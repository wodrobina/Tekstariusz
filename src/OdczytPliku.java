import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OdczytPliku extends DzielenieTekstu
{

	public String odczytajPlikISortuj(String plik, String sciezka)
	{
		// Nazwa pliku do otworzeni
		String nazwaPliku = plik;
		String line = null;

		BufferedReader bReader = null ;
		
		
		
		try
		{
			ArrayList<ArrayList<String>> listaZbiorcza = new ArrayList<ArrayList<String>>();
			ArrayList<String> ciagWyrazow= new ArrayList<String>();
			
			FileReader fReader = new FileReader(sciezka + nazwaPliku);
			bReader = new BufferedReader(fReader);
			

			while ((line = bReader.readLine() ) != null)
			{
				OdczytPliku wyrazyZPliku = new OdczytPliku();
				listaZbiorcza.add(wyrazyZPliku.tworzTablicaSlow(line));	
				
			}	
			
			for (int i=0; i<listaZbiorcza.size();i++)
			{
				ciagWyrazow.addAll(listaZbiorcza.get(i));
			}
			
			Collections.sort(ciagWyrazow);
			String sCiagWyrazow = "";
			for (String s:ciagWyrazow)
			{
				sCiagWyrazow += s + " "; 
			}
			return sCiagWyrazow;
		}
		
		//Ponizej wylapywanie bledow ze zlym plikiem
		catch (FileNotFoundException ex)
		{
			return ("£i £u £i £u Error³ nie umiem znaleŸæ pliku o nazwie '" + nazwaPliku + "'");
		}
		catch (IOException ex)
		{
			System.out.println("Error reading file '" +nazwaPliku+"'");
			return ("Eeeee nie ogarniam odczytania pliku '" +nazwaPliku+"'");
		}
		finally
		{
			try
			{
				if(bReader != null)
				{
					bReader.close();
				}
			}
			catch (IOException ex)
			{
				// none in this statement
				return ("Coœ z mi siê pomiesza³o z zamkniêciêm pliku. Sorry :3");
			}
		}
	}
}
