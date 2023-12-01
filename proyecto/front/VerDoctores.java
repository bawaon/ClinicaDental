package front;

import backend.Dentista;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import backend.*;

public class VerDoctores extends JPanel implements ActionListener
{
	private String[] tablaColumnas;
    private DefaultTableModel tamanioTabla;
	private ArrayList<Dentista> dent;
	
	public VerDoctores(ArrayList<Dentista> dent)
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Ver Lista De Doctores Disponibles");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		this.dent = dent;
		
		JLabel lbTitulo = new JLabel("Busque Los Doctores Disponibles Hasta El Momento");
		lbTitulo.setBounds(20,20,400,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		String[] tablaColumnas = {"Nombre Completo","Fecha Nacimiento","ID","Especialidad","Horario"};
		tamanioTabla = new DefaultTableModel(tablaColumnas,0);
		JTable tablaDoctores = new JTable(tamanioTabla);
		tablaDoctores.setEnabled(false);
		Border bordeListaDentistas = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0,0,0),1),BorderFactory.createEmptyBorder(5,5,5,5));
		tablaDoctores.setBorder(bordeListaDentistas);
		for(Dentista d:dent)
		{
			String auxNombre = "" +d.getNombre() +" " +d.getApellidoP() +" " +d.getApellidoM();
			Object[] datosDoctor = {auxNombre,sdf.format(d.getFechaNac()),d.getId(),d.getTitulo(),"Disponible"};
			tamanioTabla.addRow(datosDoctor);
		}
		JScrollPane scrollTablaDoctores = new JScrollPane(tablaDoctores);
		scrollTablaDoctores.setBounds(20,50,540,300);
		add(scrollTablaDoctores);
		
		JButton btnActualizar = new JButton("Actualizar Datos");
		btnActualizar.setActionCommand("actualizar_Datos");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(20,370,200,20);
		add(btnActualizar);
	}

	public void actionPerformed(ActionEvent e)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String nombreEvento = e.getActionCommand();
		if(nombreEvento.equals("actualizar_Datos"))
		{
			tamanioTabla.setNumRows(0);
			for(Dentista d:dent)
			{
				String auxNombre = "" +d.getNombre() +" " +d.getApellidoP() +" " +d.getApellidoM();
				Object[] datosDoctor = {auxNombre,sdf.format(d.getFechaNac()),d.getId(),d.getTitulo(),"Disponible"};
				tamanioTabla.addRow(datosDoctor);
			}
	        revalidate();
	        repaint();
		}
	}
}
