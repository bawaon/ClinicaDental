package front;

import backend.*;

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

import back.*;

public class VerPacientes extends JPanel implements ActionListener
{private String[] tablaColumnas;
        private DefaultTableModel tamanioTabla;
	private ArrayList<Paciente> pacie;
	
	public VerPacientes(ArrayList<Paciente> pacie)
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Ver Lista De Pacientes Ingresados");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		this.pacie = pacie;
		
		JLabel lbTitulo = new JLabel("Busque Los Pacientes Ingresados Hasta El Momento");
		lbTitulo.setBounds(20,20,400,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		String[] tablaColumnas = {"Nombre Completo","Fecha Nacimiento","ID","Razon","Dentista","ID Paciente"};
		tamanioTabla = new DefaultTableModel(tablaColumnas,0);
		JTable tablaPacientes = new JTable(tamanioTabla);
		tablaPacientes.setEnabled(false);
		Border bordeListaDentistas = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0,0,0),1),BorderFactory.createEmptyBorder(5,5,5,5));
		tablaPacientes.setBorder(bordeListaDentistas);
		for(Paciente p:pacie)
		{
			String auxNombre = "" +p.getNombre() +" " +p.getApellidoP() +" " +p.getApellidoM();
			Object[] datosPaciente = {auxNombre,sdf.format(p.getFechaNac()),p.getId(),
                            p.getCita().getRazonVisita(),p.getCita().getDentista().getNombre(),
                            p.getCita().getId()};
			tamanioTabla.addRow(datosPaciente);
		}
		JScrollPane scrolltablaPacientes = new JScrollPane(tablaPacientes);
		scrolltablaPacientes.setBounds(20,50,540,300);
		add(scrolltablaPacientes);
		
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
                        for(Paciente p:pacie)
        		{
        			String auxNombre = "" +p.getNombre() +" " +p.getApellidoP() +" " +p.getApellidoM();
        			Object[] datosPaciente = {auxNombre,sdf.format(p.getFechaNac()),p.getId(),
                                p.getCita().getRazonVisita(),p.getCita().getDentista().getNombre(),
                                p.getCita().getId()};
                                tamanioTabla.addRow(datosPaciente);
                        }
	        revalidate();
	        repaint();
		}
	}
}
