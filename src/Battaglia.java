import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.*;

public class Battaglia extends JFrame 
{
	private TreeMap<Integer, String> records = new TreeMap<Integer, String>();
	
	public void passRecord(TreeMap<Integer, String> recs)
	{
		this.records = recs;
	}

	Battaglia(String selezionato) 
	{
		super("PokeBattle!");
		
		JPanel topPanel = new JPanel(new GridLayout(2, 2));
		
		JLabel scelta = new JLabel(selezionato + " scelgo te!");
		
		Pokemon selezione = null;
		
		Pokemon bulbasaur = new Pokemon("Bulbasaur", 5, 75, 79, 79, 95, 95, 75);
		Pokemon charmander = new Pokemon("Charmander", 5, 69, 82, 73, 90, 80, 95);
		Pokemon squirtle = new Pokemon("Squirtle", 5, 74, 78, 95, 80, 94, 73);
		
		try
		{
			if (selezionato == "Bulbasaur")
			{
				selezione = new Pokemon("Bulbasaur", 5, 75, 79, 79, 95, 95, 75);
			}
			else if (selezionato == "Charmander")
			{
				selezione = new Pokemon("Charmander", 5, 69, 82, 73, 90, 80, 95);
			}
			else if (selezionato == "Squirtle")
			{
				selezione = new Pokemon("Squirtle", 5, 74, 78, 95, 80, 94, 73);
			}
		}
		catch(Exception e)
		{ System.out.println("Errore riscontrato. Per favore, chiudi e riapri il programma."); }
		
		final Pokemon giocatore = selezione;
		
		
		HashMap<String, String> pokeList = new HashMap<String, String>();
		pokeList.put("1", "Bulbasaur");
		pokeList.put("2", "Charmander");
		pokeList.put("3", "Squirtle");
		pokeList.put("4", "Pikachu" );
		pokeList.put("5", "Rattata");
		
		HashMap<String, String>  psList = new HashMap<String, String>();
		psList.put("Bulbasaur", "45");
		psList.put("Charmander", "39");
		psList.put("Squirtle", "44");
		psList.put("Pikachu", "35" );
		psList.put("Rattata", "30" );
		
		HashMap<String, String> atList = new HashMap<String, String>();
		atList.put("Bulbasaur", "49");
		atList.put("Charmander", "52");
		atList.put("Squirtle", "48");
		atList.put("Pikachu", "55" );
		atList.put("Rattata", "56" );
		
		HashMap<String, String> atSList = new HashMap<String, String>();
		atSList.put("Bulbasaur", "65");
		atSList.put("Charmander", "60");
		atSList.put("Squirtle", "50");
		atSList.put("Pikachu", "50" );
		atSList.put("Rattata", "25" );
		
		HashMap<String, String> dfList = new HashMap<String, String>();
		dfList.put("Bulbasaur", "49");
		dfList.put("Charmander", "43");
		dfList.put("Squirtle", "65");
		dfList.put("Pikachu", "40" );
		dfList.put("Rattata", "35" );
		
		HashMap<String, String> vlList = new HashMap<String, String>();
		vlList.put("Bulbasaur", "45");
		vlList.put("Charmander", "65");
		vlList.put("Squirtle", "43");
		vlList.put("Pikachu", "90" );
		vlList.put("Rattata", "72" );
		
		
		int rand;
		rand = (int) (Math.random() * 6 +1);
		String diz = pokeList.get(String.valueOf(rand));

		Pokemon contro;
		if (diz == "Bulbasaur" && diz != selezionato)
		{
			contro = new Pokemon("Bulbasaur", 1, 45, 49, 49, 65, 65, 45);
		}
		else if (diz == "Charmander" && diz != selezionato)
		{
			contro = new Pokemon("Charmander", 1, 39, 52, 43, 60, 50, 65);
		}
		else if (diz == "Squirtle" && diz != selezionato)
		{
			contro = new Pokemon("Squirtle", 1, 44, 48, 65, 50, 64, 43);
		}
		else if (diz == "Pikachu" && diz != selezionato)
		{
			contro = new Pokemon("Pikachu", 1, 35, 55, 40, 50, 50, 90);
		}
		else
		{
			contro = new Pokemon("Rattata", 1, 30, 56, 35, 25, 35, 72);
		}
	
		final Pokemon avversario = contro;
		
	
		JLabel pg1 = new JLabel(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
		
		JProgressBar xpBar = new JProgressBar(0, (100+giocatore.getLv()*100));
		xpBar.setValue(0);
		xpBar.setStringPainted(true);
		xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
		
	
		JLabel pg2 = new JLabel(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
		

		JLabel firstPic = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ giocatore.nome +".png"));
		JLabel secondPic = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ avversario.nome +".png"));
		

		JTextArea battleLog = new JTextArea();
        battleLog.setEditable(false);
        

        Selezione rec = new Selezione();
        
	
        JButton tastoMossa1 = new JButton();
        JButton tastoMossa2 = new JButton();
        JButton tastoMossa3 = new JButton();
        JButton tastoMossa4 = new JButton();
        
        JButton tastoCura = new JButton("CURA");
        JButton tastoCambio = new JButton("CAMBIA POKEMON");

        if(giocatore.nome == "Bulbasaur")
        {
        	tastoMossa1.setText("AZIONE");
        	tastoMossa2.setText("RUGGITO");
        	tastoMossa3.setText("FRUSTATA");
        	tastoMossa4.setText("[VUOTO]");
        }
        
        if(giocatore.nome == "Charmander")
        {
        	tastoMossa1.setText("GRAFFIO");
        	tastoMossa2.setText("RUGGITO");
        	tastoMossa3.setText("BRACIERE");
        	tastoMossa4.setText("[VUOTO]");
        }
        
        if(giocatore.nome == "Squirtle")
        {
        	tastoMossa1.setText("AZIONE");
        	tastoMossa2.setText("COLPO CODA");
        	tastoMossa3.setText("BOLLA");
        	tastoMossa4.setText("[VUOTO]");
        }
       
        
		topPanel.add(firstPic);
		topPanel.add(pg1);
		topPanel.add(xpBar);
		topPanel.add(secondPic);
		topPanel.add(pg2);
		
		tastoMossa1.addActionListener((ActionListener) new ActionListener()
		{
			
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
							int v = 1;
							int damage = avversario.damage(avversario.getDf(), v);
							avversario.setPs(avversario.getPs() - damage);
							battleLog.append(giocatore.nome + " usa " + tastoMossa1.getText() + "! Hai inflitto " + damage + " danni!" + "\n");
							if(v>=2) {battleLog.append("L'attacco è Superefficace!" + "\n");}
							scelta.setText("");
							pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
							giocatore.addTurn();
						
							if (avversario.getDfDebuff() > 0)
							{
								avversario.setDf(avversario.getDf() + 6);
								avversario.remDfDebuff();
							}
							
							if (avversario.getAtDebuff() > 0)
							{
								avversario.setAt(avversario.getAt() + 6);
								avversario.remAtDebuff();
							} 
							
							
								
							if(avversario.KO())
							{							
										battleLog.setText("");
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha vinto! \nDifficoltà aumentata!");
										giocatore.addXp(giocatore.getXp()+avversario.getLv()*50);
										xpBar.setValue(giocatore.getXp());
										xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
										rec.addWin();
										giocatore.remTurn();
										
									
										if(giocatore.getXp() >= 100+giocatore.getLv()*100)
										{
											JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " è aumentato di livello! Le sue statistiche sono migliorate.");
											
											if(giocatore.getLv() == 16)
											{
												JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " è al livello 16. Finalmente potrà evolversi. YOU WIN!");
												rec.passRecord(records);
												rec.endRun(giocatore.nome);
												dispose();
											}
											
											giocatore.addLv();
											giocatore.addXp(giocatore.getXp()-(100+giocatore.getLv()*100));
											xpBar.setValue(giocatore.getXp());
											xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
											xpBar.setMaximum((100+giocatore.getLv()*100));
											giocatore.lvUp(6*giocatore.getLv());
											pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
											if(giocatore.getLv() == 9 && giocatore.nome == "Bulbasaur")
											{
												JOptionPane.showMessageDialog(Battaglia.this, "Bulbasaur ha imparato FOGLIALAMA");
												tastoMossa4.setText("FOGLIALAMA");
											}
											else if(giocatore.getLv() == 9 && giocatore.nome == "Squirtle")
											{
												JOptionPane.showMessageDialog(Battaglia.this, "Squirtle ha imparato PISTOLACQUA");
												tastoMossa4.setText("PISTOLACQUA");
											}
											else if(giocatore.getLv() == 9 && giocatore.nome == "Charmander")
											{
												JOptionPane.showMessageDialog(Battaglia.this, "Charmander ha imparato DRAGOSPIRO");
												tastoMossa4.setText("DRAGOSPIRO");
											}
											
										}
										
									
										int rand = (int) (Math.random() * 5 +1);
										String diz = pokeList.get(String.valueOf(rand));
										
										avversario.addLv();
										int stat = avversario.getStat();
										
										avversario.setName(diz);
										avversario.resetDebuff();
										avversario.setPs(Integer.valueOf(psList.get(String.valueOf(diz))) +stat);
										avversario.setAt(Integer.valueOf(atList.get(String.valueOf(diz))) +stat);
										avversario.setAtS(Integer.valueOf(atSList.get(String.valueOf(diz))) +stat);
										avversario.setDf(Integer.valueOf(dfList.get(String.valueOf(diz))) +stat);
										avversario.setVel(Integer.valueOf(vlList.get(String.valueOf(diz))) +stat);
										
										pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
										JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ diz +".png"));
										topPanel.removeAll();
										topPanel.add(firstPic);
										topPanel.add(pg1);
										topPanel.add(xpBar);
										topPanel.add(icon);
										topPanel.add(pg2);
										topPanel.add(tastoCura);
							
							}
						
					
						if(giocatore.getTurn() > avversario.getTurn())
						{
							
					
							CPU cpu = new CPU();
							if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) > 1)
							{
								giocatore.setPs(giocatore.getPs() - cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
										avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
										giocatore.getDf()));
								if(avversario.nome == "Charmander")
								{
									battleLog.append(avversario.nome + " usa Graffio! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								else
								{
									battleLog.append(avversario.nome + " usa Azione! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 1)
							{
								battleLog.append(avversario.nome + " usa Ruggito! L'attacco di " + giocatore.nome + " è diminuito!" + "\n");
								giocatore.setAt(giocatore.getAt() - 6);
								giocatore.addAtDebuff();
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 0)
							{
								battleLog.append(avversario.nome + " usa Colpo Coda! La difesa di " + giocatore.nome + " è diminuita!" + "\n");
								giocatore.setDf(giocatore.getDf() - 6);
								giocatore.addDfDebuff();
							}
							
							avversario.addTurn();
							
							if (giocatore.getDfDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 0)
							{
								giocatore.setDf(giocatore.getDf() + 6);
								giocatore.remDfDebuff();

							}
							 
							if (giocatore.getAtDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 1)
							{
								giocatore.setAt(giocatore.getAt() + 6);
								giocatore.remAtDebuff();
							}
							
							if(giocatore.KO())
							{
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha perso!");
										rec.passRecord(records);
										rec.endRun(giocatore.nome);
									    dispose();
							}
							
						}

					}
					
		 });
		
		tastoMossa2.addActionListener((ActionListener) new ActionListener()
		{
				
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
							if(tastoMossa2.getText() == "COLPO CODA")
							{
								avversario.setDf(avversario.getDf() - 6);
								avversario.addDfDebuff();
								battleLog.append(giocatore.nome + " usa " + tastoMossa2.getText() + "! La difesa di " + avversario.nome + " è diminuita!" + "\n");
								scelta.setText("");
								giocatore.addTurn();
							
								if (avversario.getAtDebuff() > 0)
								{
									avversario.setAt(avversario.getAt() + 6);
									avversario.remAtDebuff();
								}
							}
							else
							{
								avversario.setAt(avversario.getAt() - 6);
								avversario.addAtDebuff();
								battleLog.append(giocatore.nome + " usa " + tastoMossa2.getText() + "! L'attacco di " + avversario.nome + " è diminuito!" + "\n");
								scelta.setText("");
								giocatore.addTurn();
							
								if (avversario.getDfDebuff() > 0)
								{
									avversario.setDf(avversario.getDf() + 6);
									avversario.remDfDebuff();
								}
							}
					
						if(giocatore.getTurn() > avversario.getTurn())
						{
							
					
							CPU cpu = new CPU();
							if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) > 1)
							{
								giocatore.setPs(giocatore.getPs() - cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
										avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
										giocatore.getDf()));
								if(avversario.nome == "Charmander")
								{
									battleLog.append(avversario.nome + " usa Graffio! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								else
								{
									battleLog.append(avversario.nome + " usa Azione! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 1)
							{
								battleLog.append(avversario.nome + " usa Ruggito! L'attacco di " + giocatore.nome + " è diminuito!" + "\n");
								giocatore.setAt(giocatore.getAt() - 6);
								giocatore.addAtDebuff();
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 0)
							{
								battleLog.append(avversario.nome + " usa Colpo Coda! La difesa di " + giocatore.nome + " è diminuita!" + "\n");
								giocatore.setDf(giocatore.getDf() - 6);
								giocatore.addDfDebuff();
							}
							
							avversario.addTurn();
							
							if (giocatore.getDfDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 0)
							{
								giocatore.setDf(giocatore.getDf() + 6);
								giocatore.remDfDebuff();

							}
							 
							if (giocatore.getAtDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 1)
							{
								giocatore.setAt(giocatore.getAt() + 6);
								giocatore.remAtDebuff();
							}
							
							if(giocatore.KO())
							{
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha perso!");
										rec.passRecord(records);
										rec.endRun(giocatore.nome);
									    dispose();
							}
							
						}

					}
					
		 });
	
		tastoMossa3.addActionListener((ActionListener) new ActionListener()
		{
			
				
					@Override
					public void actionPerformed(ActionEvent e)
					{
					
							int v = 1;
							if(tastoMossa3.getText() == "FRUSTATA" && avversario.nome == "Squirtle") {v = 2;}
							if(tastoMossa3.getText() == "BRACIERE" && avversario.nome == "Bulbasaur") {v = 2;}
							if(tastoMossa3.getText() == "BOLLA" && avversario.nome == "Charmander") {v = 2;}
							int damage = avversario.damage(avversario.getDf(), v);
							avversario.setPs(avversario.getPs() - damage);
							battleLog.append(giocatore.nome + " usa " + tastoMossa3.getText() + "! Hai inflitto " + damage + " danni!" + "\n");
							if(v>=2) {battleLog.append("L'attacco è Superefficace!" + "\n");}
							scelta.setText("");
							pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
							giocatore.addTurn();
						
							if (avversario.getDfDebuff() > 0)
							{
								avversario.setDf(avversario.getDf() + 6);
								avversario.remDfDebuff();
							}
							
							if (avversario.getAtDebuff() > 0)
							{
								avversario.setAt(avversario.getAt() + 6);
								avversario.remAtDebuff();
							} 
							
									
							if(avversario.KO())
							{							
										battleLog.setText("");
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha vinto! \nDifficoltà aumentata!");
										giocatore.addXp(giocatore.getXp()+avversario.getLv()*50);
										xpBar.setValue(giocatore.getXp());
										xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
										rec.addWin();
										giocatore.remTurn();
										
									
										if(giocatore.getXp() >= 100+giocatore.getLv()*100)
										{
											JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " è aumentato di livello! Le sue statistiche sono migliorate.");
											
											if(giocatore.getLv() == 16)
											{
												JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " è al livello 16. Finalmente potrà evolversi. YOU WIN!");
												rec.passRecord(records);
												rec.endRun(giocatore.nome);
												dispose();
											}
											
											giocatore.addLv();
											giocatore.addXp(giocatore.getXp()-(100+giocatore.getLv()*100));
											xpBar.setValue(giocatore.getXp());
											xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
											xpBar.setMaximum((100+giocatore.getLv()*100));
											giocatore.lvUp(6*giocatore.getLv());
											pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
											if(giocatore.getLv() == 9 && giocatore.nome == "Bulbasaur")
											{
												JOptionPane.showMessageDialog(Battaglia.this, "Bulbasaur ha imparato FOGLIALAMA");
												tastoMossa4.setText("FOGLIALAMA");
											}
											else if(giocatore.getLv() == 9 && giocatore.nome == "Squirtle")
											{
												JOptionPane.showMessageDialog(Battaglia.this, "Squirtle ha imparato PISTOLACQUA");
												tastoMossa4.setText("PISTOLACQUA");
											}
											else if(giocatore.getLv() == 9 && giocatore.nome == "Charmander")
											{
												JOptionPane.showMessageDialog(Battaglia.this, "Charmander ha imparato DRAGOSPIRO");
												tastoMossa4.setText("DRAGOSPIRO");
											}
											
										}
										
									
										int rand = (int) (Math.random() * 5 +1);
										String diz = pokeList.get(String.valueOf(rand));
										
										avversario.addLv();
										int stat = avversario.getStat();
										
										avversario.setName(diz);
										avversario.resetDebuff();
										avversario.setPs(Integer.valueOf(psList.get(String.valueOf(diz))) +stat);
										avversario.setAt(Integer.valueOf(atList.get(String.valueOf(diz))) +stat);
										avversario.setAtS(Integer.valueOf(atSList.get(String.valueOf(diz))) +stat);
										avversario.setDf(Integer.valueOf(dfList.get(String.valueOf(diz))) +stat);
										avversario.setVel(Integer.valueOf(vlList.get(String.valueOf(diz))) +stat);
										
										pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
										JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ diz +".png"));
										topPanel.removeAll();
										topPanel.add(firstPic);
										topPanel.add(pg1);
										topPanel.add(xpBar);
										topPanel.add(icon);
										topPanel.add(pg2);
										topPanel.add(tastoCura);
							
							}
					
						if(giocatore.getTurn() > avversario.getTurn())
						{
							
					
							CPU cpu = new CPU();
							if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) > 1)
							{
								giocatore.setPs(giocatore.getPs() - cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
										avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
										giocatore.getDf()));
								if(avversario.nome == "Charmander")
								{
									battleLog.append(avversario.nome + " usa Graffio! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								else
								{
									battleLog.append(avversario.nome + " usa Azione! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 1)
							{
								battleLog.append(avversario.nome + " usa Ruggito! L'attacco di " + giocatore.nome + " è diminuito!" + "\n");
								giocatore.setAt(giocatore.getAt() - 6);
								giocatore.addAtDebuff();
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 0)
							{
								battleLog.append(avversario.nome + " usa Colpo Coda! La difesa di " + giocatore.nome + " è diminuita!" + "\n");
								giocatore.setDf(giocatore.getDf() - 6);
								giocatore.addDfDebuff();
							}
							
							avversario.addTurn();
							
							if (giocatore.getDfDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 0)
							{
								giocatore.setDf(giocatore.getDf() + 6);
								giocatore.remDfDebuff();

							}
							 
							if (giocatore.getAtDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 1)
							{
								giocatore.setAt(giocatore.getAt() + 6);
								giocatore.remAtDebuff();
							}
							
							if(giocatore.KO())
							{
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha perso!");
										rec.passRecord(records);
										rec.endRun(giocatore.nome);
									    dispose();
							}
							
						}

					}
					
		 });
		
		tastoMossa4.addActionListener((ActionListener) new ActionListener()
		{
			
				
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
						if(tastoMossa1.getText() != "[VUOTO]")
						{
							int v = 1;
							if(tastoMossa4.getText() == "FOGLIALAMA" && avversario.nome == "Squirtle") {v = 3;}
							if(tastoMossa4.getText() == "DRAGOSPIRO" && (avversario.nome == "Bulbasaur" || avversario.nome == "Rattata")) {v = 3;}
							if(tastoMossa4.getText() == "PISTOLACQUA" && avversario.nome == "Charmander") {v = 3;}
							int damage = avversario.damage(avversario.getDf(), v);
							avversario.setPs(avversario.getPs() - damage);
							battleLog.append(giocatore.nome + " usa " + tastoMossa1.getText() + "! Hai inflitto " + damage + " danni!" + "\n");
							if(v>=2) {battleLog.append("L'attacco è Superefficace!" + "\n");}
							scelta.setText("");
							pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
							giocatore.addTurn();
						
							if (avversario.getDfDebuff() > 0)
							{
								avversario.setDf(avversario.getDf() + 6);
								avversario.remDfDebuff();
							}
							
							if (avversario.getAtDebuff() > 0)
							{
								avversario.setAt(avversario.getAt() + 6);
								avversario.remAtDebuff();
							} 
							
							
								
							if(avversario.KO())
							{							
										battleLog.setText("");
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha vinto! \nDifficoltà aumentata!");
										giocatore.addXp(giocatore.getXp()+avversario.getLv()*50);
										xpBar.setValue(giocatore.getXp());
										xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
										rec.addWin();
										giocatore.remTurn();
										
									
										if(giocatore.getXp() >= 100+giocatore.getLv()*100)
										{
											JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " è aumentato di livello! Le sue statistiche sono migliorate.");
											
											if(giocatore.getLv() == 16)
											{
												JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " è al livello 16. Finalmente potrà evolversi. YOU WIN!");
												rec.passRecord(records);
												rec.endRun(giocatore.nome);
												dispose();
											}
											
											giocatore.addLv();
											giocatore.addXp(giocatore.getXp()-(100+giocatore.getLv()*100));
											xpBar.setValue(giocatore.getXp());
											xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
											xpBar.setMaximum((100+giocatore.getLv()*100));
											giocatore.lvUp(6*giocatore.getLv());
											pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
											
										}
										
										//CAMBIO CASUALE DEL NEMICO
										int rand = (int) (Math.random() * 5 +1);
										String diz = pokeList.get(String.valueOf(rand));
										
										avversario.addLv();
										int stat = avversario.getStat();
										
										avversario.setName(diz);
										avversario.resetDebuff();
										avversario.setPs(Integer.valueOf(psList.get(String.valueOf(diz))) +stat);
										avversario.setAt(Integer.valueOf(atList.get(String.valueOf(diz))) +stat);
										avversario.setAtS(Integer.valueOf(atSList.get(String.valueOf(diz))) +stat);
										avversario.setDf(Integer.valueOf(dfList.get(String.valueOf(diz))) +stat);
										avversario.setVel(Integer.valueOf(vlList.get(String.valueOf(diz))) +stat);
										
										pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
										JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ diz +".png"));
										topPanel.removeAll();
										topPanel.add(firstPic);
										topPanel.add(pg1);
										topPanel.add(xpBar);
										topPanel.add(icon);
										topPanel.add(pg2);
										topPanel.add(tastoCura);
							
							}
						}
						
						else
						{JOptionPane.showMessageDialog(Battaglia.this, "Nessuna azione assegnata al tasto!");}
						
				
						if(giocatore.getTurn() > avversario.getTurn())
						{
							
					
							CPU cpu = new CPU();
							if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) > 1)
							{
								giocatore.setPs(giocatore.getPs() - cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
										avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
										giocatore.getDf()));
								if(avversario.nome == "Charmander")
								{
									battleLog.append(avversario.nome + " usa Graffio! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								else
								{
									battleLog.append(avversario.nome + " usa Azione! Ha inflitto " + cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
											avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
											giocatore.getDf()) + " danni!" + "\n");
								}
								pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 1)
							{
								battleLog.append(avversario.nome + " usa Ruggito! L'attacco di " + giocatore.nome + " è diminuito!" + "\n");
								giocatore.setAt(giocatore.getAt() - 6);
								giocatore.addAtDebuff();
								
							}
							else if (cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) == 0)
							{
								battleLog.append(avversario.nome + " usa Colpo Coda! La difesa di " + giocatore.nome + " è diminuita!" + "\n");
								giocatore.setDf(giocatore.getDf() - 6);
								giocatore.addDfDebuff();
							}
							
							avversario.addTurn();
							
							if (giocatore.getDfDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 0)
							{
								giocatore.setDf(giocatore.getDf() + 6);
								giocatore.remDfDebuff();

							}
							 
							if (giocatore.getAtDebuff() > 0 && cpu.agisce(avversario.nome, avversario.getLv(), avversario.getPs(), giocatore.getPs(),
									avversario.getAt(), giocatore.getAt(), avversario.getAtS(), avversario.getDf(),
									giocatore.getDf()) != 1)
							{
								giocatore.setAt(giocatore.getAt() + 6);
								giocatore.remAtDebuff();
							}
							
							if(giocatore.KO())
							{
										JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha perso!");
										rec.passRecord(records);
										rec.endRun(giocatore.nome);
									    dispose();
							}
							
						}

					}
					
		 });

		
		tastoCura.addActionListener((ActionListener) new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
						if(giocatore.getCure() != 5)
						{
							giocatore.useCure();
							giocatore.setPs(giocatore.getPs()+35);
							JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " ha recuperato 35 PS! Rimangono " + (5-giocatore.getCure()) + " cure.");
							pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
						}
						else
						{
							JOptionPane.showMessageDialog(Battaglia.this, "Cure terminate!");
						}
						
					}
			});
				
		String [] pokemon = {"Bulbasaur", "Charmander", "Squirtle"};
		JComboBox<String> comboBox = new JComboBox<>(pokemon);
		
		tastoCambio.addActionListener((ActionListener) new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				String selezione = (String) comboBox.getSelectedItem();
				if(giocatore.nome == selezione)
				{
					JOptionPane.showMessageDialog(Battaglia.this, "Il Pokemon selezionato è già in combattimento!");
				}
				else if(selezione == "Bulbasaur")
				{
					JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " si ritira. " + selezione + " tocca a te!");

					if(giocatore.nome == "Charmander")
					{
						charmander.update("Charmander", giocatore.getLv(), giocatore.getPs(), giocatore.getAt(), giocatore.getDf(), 
								giocatore.getAtS(), giocatore.getXp(), giocatore.getVel());
					}
					else if(giocatore.nome == "Squirtle")
					{
						squirtle.update("Squirtle", giocatore.getLv(), giocatore.getPs(), giocatore.getAt(), giocatore.getDf(), 
								giocatore.getAtS(), giocatore.getXp(), giocatore.getVel());
					}
					
					giocatore.update("Bulbasaur", bulbasaur.getLv(), bulbasaur.getPs(), bulbasaur.getAt(), bulbasaur.getDf(), 
							bulbasaur.getAtS(), bulbasaur.getXp(), bulbasaur.getVel());
					
					pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
					JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ selezione +".png"));
					topPanel.removeAll();
					topPanel.add(icon);
					topPanel.add(pg1);
					topPanel.add(xpBar);
					topPanel.add(secondPic);
					topPanel.add(pg2);
					topPanel.add(tastoCura);
					pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
					xpBar.setValue(giocatore.getXp());
					xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
					xpBar.setMaximum((100+giocatore.getLv()*100));
					if(bulbasaur.getLv() < 9)
					{
						tastoMossa1.setText("AZIONE");
			        	tastoMossa2.setText("RUGGITO");
			        	tastoMossa3.setText("FRUSTATA");
			        	tastoMossa4.setText("[VUOTO]");
					}
					else if(bulbasaur.getLv() >= 9)
					{
						tastoMossa4.setText("FOGLIALAMA");
					}
					
					
				}
				else if(selezione == "Charmander")
				{
					JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " si ritira. " + selezione + " tocca a te!");

					if(giocatore.nome == "Bulbasaur")
					{
						bulbasaur.update("Bulbasaur", giocatore.getLv(), giocatore.getPs(), giocatore.getAt(), giocatore.getDf(), 
								giocatore.getAtS(), giocatore.getXp(), giocatore.getVel());
					}
					else if(giocatore.nome == "Squirtle")
					{
						squirtle.update("Squirtle", giocatore.getLv(), giocatore.getPs(), giocatore.getAt(), giocatore.getDf(), 
								giocatore.getAtS(), giocatore.getXp(), giocatore.getVel());
					}
					
					giocatore.update("Charmander", charmander.getLv(), charmander.getPs(), charmander.getAt(), charmander.getDf(), 
							charmander.getAtS(), charmander.getXp(), charmander.getVel());
					
					pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
					JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ selezione +".png"));
					topPanel.removeAll();
					topPanel.add(icon);
					topPanel.add(pg1);
					topPanel.add(xpBar);
					topPanel.add(secondPic);
					topPanel.add(pg2);
					topPanel.add(tastoCura);
					pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
					xpBar.setValue(giocatore.getXp());
					xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
					xpBar.setMaximum((100+giocatore.getLv()*100));
					if(charmander.getLv() < 9)
					{
						tastoMossa1.setText("GRAFFIO");
			        	tastoMossa2.setText("RUGGITO");
			        	tastoMossa3.setText("BRACIERE");
			        	tastoMossa4.setText("[VUOTO]");
					}
					else if(charmander.getLv() >= 9)
					{
						tastoMossa3.setText("DRAGOSPIRO");
					}
					
				}
				else if(selezione == "Squirtle")
				{
					JOptionPane.showMessageDialog(Battaglia.this, giocatore.nome + " si ritira. " + selezione + " tocca a te!");

					if(giocatore.nome == "Bulbasaur")
					{
						bulbasaur.update("Bulbasaur", giocatore.getLv(), giocatore.getPs(), giocatore.getAt(), giocatore.getDf(), 
								giocatore.getAtS(), giocatore.getXp(), giocatore.getVel());
					}
					else if(giocatore.nome == "Charmander")
					{
						squirtle.update("Charmander", giocatore.getLv(), giocatore.getPs(), giocatore.getAt(), giocatore.getDf(), 
								giocatore.getAtS(), giocatore.getXp(), giocatore.getVel());
					}
					
					giocatore.update("Squirtle",squirtle.getLv(), squirtle.getPs(), squirtle.getAt(), squirtle.getDf(), 
							squirtle.getAtS(), squirtle.getXp(), squirtle.getVel());
					
					pg2.setText(avversario.nome + " LV: " + avversario.getLv() + " PS: " + avversario.getPs());
					JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\PokemonBattles\\"+ selezione +".png"));
					topPanel.removeAll();
					topPanel.add(icon);
					topPanel.add(pg1);
					topPanel.add(xpBar);
					topPanel.add(secondPic);
					topPanel.add(pg2);
					topPanel.add(tastoCura);
					pg1.setText(giocatore.nome + " LV: "+ giocatore.getLv() + " PS: " + giocatore.getPs());
					xpBar.setValue(giocatore.getXp());
					xpBar.setString("XP: " + xpBar.getValue()+"/"+(100+giocatore.getLv()*100));
					xpBar.setMaximum((100+giocatore.getLv()*100));
					if(squirtle.getLv() < 9)
					{
						tastoMossa1.setText("AZIONE");
			        	tastoMossa2.setText("COLPO CODA");
			        	tastoMossa3.setText("BOLLA");
			        	tastoMossa4.setText("[VUOTO]");
					}
					else if(squirtle.getLv() >= 9)
					{
						tastoMossa3.setText("PISTOLACQUA");
					}
					
				}
			}
		});
				
		
		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		
		topPanel.add(tastoCura);
		add(topPanel, BorderLayout.NORTH);
		
        JScrollPane scrollPane = new JScrollPane(battleLog);
        add(scrollPane, BorderLayout.CENTER);

        JPanel botPanel = new JPanel();
       
        botPanel.add(tastoCambio);
		botPanel.add(comboBox);
        botPanel.add(tastoMossa1);
        botPanel.add(tastoMossa2);
		botPanel.add(tastoMossa3);
		botPanel.add(tastoMossa4);

        add(botPanel, BorderLayout.SOUTH);
		
	}
	
}
