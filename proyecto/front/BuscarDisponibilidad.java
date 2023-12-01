package front;

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
import java.util.Date;
import java.util.List;

import backend.*;

public class BuscarDisponibilidad extends JPanel implements ActionListener{
	private String[] tablaColumnas;
    private DefaultTableModel tamanioTabla;
	private ArrayList<Dentista> dent;
	
	public BuscarDisponibilidad(ArrayList<Dentista> dent)
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
		
		JLabel lbTitulo = new JLabel("Horarios Disponibles De Los Doctores ");
		lbTitulo.setBounds(20,20,400,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		String[] tablaColumnas = {"Nombre Completo","ID","Fecha","Especialidad","Hora"};
		tamanioTabla = new DefaultTableModel(tablaColumnas,0);
		JTable tablaDoctores = new JTable(tamanioTabla);
		tablaDoctores.setEnabled(false);
		Border bordeListaDentistas = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0,0,0),1),BorderFactory.createEmptyBorder(5,5,5,5));
		tablaDoctores.setBorder(bordeListaDentistas);
		Date fecha;
		Double hora;
		Boolean dispo;
		List<Object[]> datosDoctores = new ArrayList<>();
		for (Dentista d : dent) {
		    String auxNombre = "" + d.getNombre() + " " + d.getApellidoP() + " " + d.getApellidoM();

		    // Crear una lista para almacenar los datos de cada horario del dentista
		    List<Object> datosHorarios = new ArrayList<>();

		    for (horarios horario : d.getHorariosDisponibles()) {
		        fecha = horario.getFecha();
		        hora = horario.getHora();
		        dispo = horario.getDisponible();

		        if(dispo==true) {
		        // Agregar los datos del horario a la lista si existe disponibilidad
		        datosHorarios.add(auxNombre);
		        datosHorarios.add(d.getId());
		        datosHorarios.add(sdf.format(fecha));
		        datosHorarios.add(d.getTitulo());
		        datosHorarios.add(hora);	
		        }
		       
		        // Agregar la lista de datos del horario a la lista principal
		        datosDoctores.add(datosHorarios.toArray());
		    }
		}

		// Agregar los datos al modelo de la tabla
		for (Object[] datosDoctor : datosDoctores) {
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
	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String nombreEvento = e.getActionCommand();
		if(nombreEvento.equals("actualizar_Datos"))
		{
			tamanioTabla.setNumRows(0);
			Date fecha;
			Double hora;
			Boolean dispo;
			List<Object[]> datosDoctores = new ArrayList<>();
			for (Dentista d : dent) {
			    String auxNombre = "" + d.getNombre() + " " + d.getApellidoP() + " " + d.getApellidoM();

			    // Crear una lista para almacenar los datos de cada horario del dentista
			    List<Object> datosHorarios = new ArrayList<>();

			    for (horarios horario : d.getHorariosDisponibles()) {
			        fecha = horario.getFecha();
			        hora = horario.getHora();
			        dispo = horario.getDisponible();

			        if(dispo==true) {
			        // Agregar los datos del horario a la lista si existe disponibilidad
			        datosHorarios.add(auxNombre);
			        datosHorarios.add(d.getId());
			        datosHorarios.add(sdf.format(fecha));
			        datosHorarios.add(d.getTitulo());
			        datosHorarios.add(hora);	
			        }
			       
			        // Agregar la lista de datos del horario a la lista principal
			        datosDoctores.add(datosHorarios.toArray());
			    }
			}

			// Agregar los datos al modelo de la tabla
			for (Object[] datosDoctor : datosDoctores) {
			    tamanioTabla.addRow(datosDoctor);
			}
	        revalidate();
	        repaint();
		}
	}

}
