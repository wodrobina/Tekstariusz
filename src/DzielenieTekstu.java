

import java.util.ArrayList;


public class DzielenieTekstu {
	
	public ArrayList<String> tworzTablicaSlow(String st)
	{
		String str = st;

		str = str + ' ';
		int l = str.length();
		String world = "";
		
		ArrayList<String> wyrazy = new ArrayList<String>();
		
		for (int i=0;i<l;i++)
		{
			world=world+str.charAt(i);
			
			if (str.charAt(i+1) == ' ')
			{    
				wyrazy.add(world);
				world="";
				i++; 
			}
		}
		return wyrazy;
	}
}
