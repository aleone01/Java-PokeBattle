import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.*;

public class Selezione extends JFrame 
{	
	
	String [] pokemon = {"Bulbasaur", "Charmander", "Squirtle"};
	
	JTextArea topTen = new JTextArea();
	JPanel botPanel = new JPanel();

	private JComboBox<String> comboBox;
	private JButton button;
	private JLabel label;
	
	Selezione()
	{
		super("<PokéBattles>");
		
		comboBox = new JComboBox<>(pokemon);
		
		button = new JButton("Seleziona");
		
		label = new JLabel("Nessun Pokemon selezionato!");
		
		button.addActionListener(new ActionListener() 
		{
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 String selezionato = (String) comboBox.getSelectedItem();
				 label.setText("Hai selezionato. " + selezionato);
				 Battaglia battle = new Battaglia(selezionato);
				 battle.passRecord(records);
				 dispose();
			 }
		});
	
	setSize(500, 300);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLayout(new BorderLayout());
	
		
	topTen.setText("(LEADERBOARD) \n");
	JPanel topPanel = new JPanel();
	
	topPanel.add(new JLabel("Benvenuto! Scegli un Pokemon per iniziare!"));
	add(topPanel, BorderLayout.NORTH);
		
	JPanel midPanel = new JPanel();
	midPanel.add(label);
	midPanel.add(comboBox);
	midPanel.add(button);
	add(midPanel, BorderLayout.CENTER);
	
	topTen.setEditable(false);
	JScrollPane scroll = new JScrollPane(topTen);
	add(scroll, BorderLayout.SOUTH);
	
	setVisible(true);
		
	}
	
	private int enemiesCounter = 0;
	
	public void addWin()
	{
		enemiesCounter++;
	}
	
	private TreeMap<Integer, String> records = new TreeMap<Integer, String>();
	
	public void passRecord(TreeMap<Integer, String> rec)
	{
		this.records = rec;
	}
	
	
	public void endRun(String nome)
	{
		if(enemiesCounter < 10)
		{
			records.put(enemiesCounter,"0" +  String.valueOf(enemiesCounter) + " wins: " + nome);
		}
		else
		{
			records.put(enemiesCounter, String.valueOf(enemiesCounter) + " wins: " + nome);
		}
		
		enemiesCounter = 0;
		List<String> sorted = new ArrayList<>(records.values());
		if(sorted.size() == 10)
		{
			sorted.removeFirst();
		}
		Collections.sort(sorted);
		topTen.setText(String.valueOf(sorted));
	}
	


}	
