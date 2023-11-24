package front;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BuscarCita extends JPanel
{
	public BuscarCita()
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Encontrar Cita");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		JLabel lbTitulo = new JLabel("Ingrese ID para buscar una cita");
		lbTitulo.setBounds(20,20,200,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		int x = 10,y = 0;
		
		JLabel lbId = new JLabel("ID");
		lbId.setBounds(x + 45,y + 50,75,20);
		lbId.setForeground(new Color(48,96,189));
		add(lbId);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(x + 25,y + 50 + 20,50,20);
		txtId.setBackground(new Color(175,175,175));
		txtId.setForeground(new Color(48,96,189));
		txtId.setEditable(true);
		txtId.setColumns(20);
		add(txtId);
		
		JButton btnBuscar = new JButton("Buscar ID");
		btnBuscar.setBounds(100,y + 50 + 20,100,20);
		add(btnBuscar);
		
		JPanel listaDentistas = new JPanel();
		listaDentistas.setSize(565,210);
		listaDentistas.setLocation(10,180);
		listaDentistas.setBackground(new Color(247,229,152));
	    Border bordeListaDentistas = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0,0,0),1),BorderFactory.createEmptyBorder(5,5,5,5));
	    listaDentistas.setBorder(bordeListaDentistas);
		add(listaDentistas);
	}
}
