import javax.swing.*;

public class CPU 
{
	
	private Boolean colpoCoda = false;
	private Boolean ringhio = false;
	
	public int agisce(String nome, int lv, int ps1, int ps2, int atk1, int atk2, int asp, int df1, int df2)
	{
		
		
		int damage, rand;
		rand = (int) (Math.random() * 16 +85);
		damage = (((((((2*lv)/(7))*atk1*45)/df2)/50)+2)*(int)1.5*1*rand)/10;
			
		if(nome == "Squirtle" || nome == "Pikachu" || nome == "Rattata")
		{
			colpoCoda = true;
		}
		
		if(nome == "Charmander" || nome == "Bulbasaur")
		{
			ringhio = true;
		}

		if(ps2 > ps1) 
		{
			
			return damage;
		}
		else
		{
			if(atk2 - atk1 > 5 && atk2 - atk1 < 12  &&  ringhio == true)
			{
				return 1;
			}
			else if(df2 - df1 > 5 && df2 - df1 < 12 && colpoCoda == true)
			{
				return 0;
			}
			else
			{
				return damage;
			}
		}
		
	}
}



