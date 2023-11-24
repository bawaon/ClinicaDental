package front;

import java.awt.Color;
import java.awt.GradientPaint;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class VerDoctores extends JPanel
{
	public VerDoctores()
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Ver Lista De Doctores Disponibles");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		JLabel lbTitulo = new JLabel("Ingrese ID para buscar a un doctor");
		lbTitulo.setBounds(20,20,200,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);
		
		JPanel panelListaDentistas = new JPanel();
		panelListaDentistas.setSize(565,200);
		panelListaDentistas.setLocation(10,40);
		panelListaDentistas.setBackground(new Color(247,229,152));
        Border bordeListaDentistas = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0),1),BorderFactory.createEmptyBorder(5,5,5,5));
        panelListaDentistas.setBorder(bordeListaDentistas);
		add(panelListaDentistas);
	}
}
