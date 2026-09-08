import javax.swing.JOptionPane;

public class Pokemon {

	String nome;
	int lv;
	int xp = 0;
	int ps;
	int attacco;
	int difesa;
	int asp;
	int dsp;
	int velocita;
	int dfDebuff = 0;
	int atDebuff = 0;
	int turn = 0;
	
	Pokemon (String nome, int lv, int ps, int attacco, int difesa, int asp, int dsp, int velocita)
	{
		this.nome = nome;
		this.lv = lv;
		this.ps = ps;
		this.attacco = attacco;
		this.difesa = difesa;
		this.asp = asp;
		this.dsp = dsp;
		this.velocita = velocita;
	}
	
	public void setName(String newName)
	{
		nome = newName;
	}
	public String getName()
	{
		return nome;
	}

	public int getLv()
	{
		return lv;
	}
	
	public void addLv()
	{
		lv++;
	}
	
	public void lvUp(int add)
	{
		ps += add;
		attacco += add;
		asp += add;
		difesa += add;
		velocita += add;
	}

	public int getXp()
	{
		return xp;
	}
	public void addXp(int newXp)
	{
		xp = newXp;
	}
	
	public int getPs()
	{
		return ps;
	}
	
	public void setPs(int newPs) 
	{
		ps = newPs;
		if (ps <= 0)
		{
			ps = 0;
		}
	}
	
	public int getAt()
	{
		return attacco;
	}
	
	public void setAt(int newAt) 
	{
		attacco = newAt;
	}
	
	public int getAtS()
	{
		return asp;
	}
	
	public void setAtS(int newAtS) 
	{
		asp = newAtS;
	}
	
	public int getDf()
	{
		return difesa;
	}
	
	public void setDf(int newDf) 
	{
		difesa = newDf;
	}
	
	public int getVel() 
	{
		return velocita;
	}
	
	public void setVel(int newVel)
	{
		velocita = newVel;
	}
	
	public int getTurn()
	{
		return turn;
	}
	
	public void addTurn()
	{
		turn++;
	}
	
	public void remTurn()
	{
		turn--;
	}
	
	public void addDfDebuff()
	{
		dfDebuff++;
	}
	
	public void remDfDebuff()
	{
		dfDebuff--;
	}
	
	public int getDfDebuff()
	{
		return dfDebuff;
	}
	
	public void addAtDebuff()
	{
		atDebuff++;
	}
	
	public void remAtDebuff()
	{
		atDebuff--;
	}
	public int getAtDebuff()
	{
		return atDebuff;
	}
	 
	public void resetDebuff()
	{
		atDebuff = 0;
		dfDebuff = 0;
	}
	
	public boolean KO()
	{
		if(ps<=0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getStat()
	{
		int stat = 0;
		for (int i = lv-1; i > 0; i--)
		{
			stat += i;
		}
		return stat;
	}
	
	public int damage(int dfNemico, int v)
	{
		int danno, rand; 
		double n = 0;
		if(v==0)
		{
			n = 1; 
		}
		else if (v==1)
		{
			n = 1.5;
		}
		else
		{
			n = 2;
		}
		rand = (int) (Math.random() * 16 +85);
		danno = (((((((2*lv)/(7))*attacco*45)/dfNemico)/50)+2)*(int)n*1*rand)/10;
		return danno;
	}

	int cureCount = 0;
	public void useCure()
	{
		cureCount++;
	}
	
	public int getCure()
	{
		return cureCount;
	}
	
	public void update(String newName, int newLv, int newPs, int newAtk, int newDf, int newAsp, int newXp, int newVel)
	{
		nome = newName;
		lv = newLv;
		ps = newPs;
		attacco = newAtk;
		difesa = newDf;
		asp = newAsp;
		xp = newXp;
		velocita = newVel;
	}
	
	
	
}
