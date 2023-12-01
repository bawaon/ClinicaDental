package front;

import backend.Dentista;
import backend.Paciente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import backend.*;

public class CrearCita extends JPanel implements ActionListener{

	private JComboBox boxAnios;
	private JComboBox boxMeses;
	private JComboBox boxDias;
	private JComboBox boxEstatus;

	private JTextField txtRazon;
	private JTextField txtIDPaciente;
	private JTextField txtHora;
	
	private ArrayList<Dentista> dent;
	private ArrayList<Paciente> pacie;
	
	public CrearCita(ArrayList<Paciente> pacie,ArrayList<Dentista> dent)
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Crear Cita");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		this.pacie = pacie;
		this.dent = dent;
		
		JLabel lbTitulo = new JLabel("Ingrese Datos De La Cita");
		lbTitulo.setBounds(20,20,200,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		int x = 10,y = 0;
		LocalDate currentDate = LocalDate.now();

		JLabel lbIdPaciente = new JLabel("ID Paciente");
		lbIdPaciente.setBounds(x + 75,y + 50,75,20);
		lbIdPaciente.setForeground(new Color(48,96,189));
		add(lbIdPaciente);
		
		txtIDPaciente = new JTextField();
		txtIDPaciente.setBounds(x + 25,y + 50 + 20,150,20);
		txtIDPaciente.setBackground(new Color(175,175,175));
		txtIDPaciente.setForeground(new Color(48,96,189));
		txtIDPaciente.setEditable(true);
		txtIDPaciente.setColumns(20);
		add(txtIDPaciente);

		JLabel lbRazon = new JLabel("Razon de la Visita");
		lbRazon.setBounds(x + 230,y + 50,125,20);
		lbRazon.setForeground(new Color(48,96,189));
		add(lbRazon);
		
		txtRazon = new JTextField();
		txtRazon.setBounds(x + 200,y + 50 + 20,150,20);
		txtRazon.setBackground(new Color(175,175,175));
		txtRazon.setForeground(new Color(48,96,189));
		txtRazon.setEditable(true);
		txtRazon.setColumns(20);
		add(txtRazon);
		
		JLabel lbHora = new JLabel("Hora(HH.MM)");
		lbHora.setBounds(x + 75,y + 100 + 20 + 80,150,20);
		lbHora.setForeground(new Color(48,96,189));
		add(lbHora);
		
		txtHora = new JTextField();
		txtHora.setBounds(x + 25,y + 100 + 20 + 80 + 20,150,20);
		txtHora.setBackground(new Color(175,175,175));
		txtHora.setForeground(new Color(48,96,189));
		txtHora.setEditable(true);
		txtHora.setColumns(20);
		add(txtHora);

		JLabel lbFechaCita = new JLabel("Fecha De Cita");
		lbFechaCita.setBounds(x + 25,y + 50 + 20 + 40,150,20);
		lbFechaCita.setForeground(new Color(48,96,189));
		add(lbFechaCita);

		JLabel lbDias = new JLabel("Dia");
		lbDias.setBounds(x + 60 + 150,y + 50 + 40,100,20);
		lbDias.setForeground(new Color(48,96,189));
		add(lbDias);
		
		String[] dias = new String[31];
		for(int i = 0;i < 31;i += 1)
		{
			dias[i] = "" +(i + 1);
		}
		boxDias = new JComboBox<>(dias);
		boxDias.setBounds(x + 25 + 150,y + 50 + 20 + 40,100,20);
		add(boxDias);

		JLabel lbMeses = new JLabel("Mes");
		lbMeses.setBounds(x + 180 + 150,y + 50 + 40,100,20);
		lbMeses.setForeground(new Color(48,96,189));
		add(lbMeses);
		
		String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
				"Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		List<String> listaMeses = new ArrayList<String>();
		boxMeses = new JComboBox<>(meses);
		boxMeses.setActionCommand("detectar_Meses");
		boxMeses.addActionListener(this);
		boxMeses.setBounds(x + 150 + 150,y + 50 + 20 + 40,100,20);
		add(boxMeses);

		JLabel lbAnios = new JLabel("Año");
		lbAnios.setBounds(x + 300 + 150,y + 50 + 40,100,20);
		lbAnios.setForeground(new Color(48,96,189));
		add(lbAnios);
		
		String[] anios = new String[3];
		for (int i = 0; i <=2; i++) {
		    anios[i] = String.valueOf(currentDate.getYear() + i );
		}
		boxAnios = new JComboBox<>(anios);
		boxAnios.setBounds(x + 275 + 150,y + 50 + 20 + 40,100,20);
		add(boxAnios);
/*
		JLabel lbIdCita = new JLabel("ID De La Cita");
		lbIdCita.setBounds(x + 65,y + 50 + 100,150,20);
		lbIdCita.setForeground(new Color(48,96,189));
		add(lbIdCita);
		
		txtIdCita = new JTextField();
		txtIdCita.setBounds(x + 25,y + 50 + 20 + 100,150,20);
		txtIdCita.setBackground(new Color(175,175,175));
		txtIdCita.setForeground(new Color(48,96,189));
		txtIdCita.setEditable(true);
		txtIdCita.setColumns(20);
		add(txtIdCita);
*/
		JLabel lbDentista = new JLabel("Dentista");
		lbDentista.setBounds(x + 235,y + 50 + 100,150,20);
		lbDentista.setForeground(new Color(48,96,189));
		add(lbDentista);

		boxEstatus = new JComboBox<>();
		boxEstatus.setBounds(x + 60 + 140,y + 50 + 20 + 100,140,20);
		for(Dentista de:dent)
		{
			String aux = de.getNombre();
			boxEstatus.addItem(aux);
		}
		add(boxEstatus);
		
		JButton btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setActionCommand("guardar_Datos");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(20,300,100,20);
		add(btnGuardar);


	}

	private boolean camposVacios()
	{
		return txtRazon.getText().isEmpty() ||
				txtIDPaciente.getText().isEmpty() ||
				txtHora.getText().isEmpty();
    }
	
	private Date conversion(String fecha)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date conv = null;
		try
		{
			conv = sdf.parse(fecha);
	    }catch(ParseException e)
	    {
	    	JOptionPane.showMessageDialog(null,"Ingrese Un Valor Correcto");
	      	conv = null;
	    }
	    return conv;
	}
	
	public Date guardarDatosFecha()
	{
		Date fecha = null;
		String diaObtenido = "" +boxDias.getSelectedItem();
		String mesObtenido = "" +(boxMeses.getSelectedIndex() + 1);
		String anioObtenido = "" +boxAnios.getSelectedItem();
		String data = diaObtenido +"/" +mesObtenido +"/" +anioObtenido;
		fecha = conversion(data);
		System.out.print(fecha);
		return fecha;
	}

	public void guardarDatos() {
	    String aux = txtIDPaciente.getText();
	    Paciente auxPc = null;

	    for (Paciente pc : pacie) {
	        if (aux.equals(pc.getId())) {
	            auxPc = pc;
	            break; // Salir del bucle una vez que se encuentra el paciente
	        }else {
	        	auxPc = null;
	        }
	    }
	    if (auxPc != null) {
	        String id = "C" + (dent.size() + 15);
	        String razon = txtRazon.getText();
	        Double hora = Double.parseDouble(txtHora.getText());
	        Date fecha = guardarDatosFecha();
	        Dentista auxDen = null;
	        String box = (String) boxEstatus.getSelectedItem();
	        for (Dentista de : dent) {
	            if (box.equals(de.getNombre())) {
	                auxDen = de;
	            }
	        }

	        boolean horarioDisponible = false;

	        for (horarios horario : auxDen.getHorariosDisponibles()) {
	            if (horario.getFecha().equals(fecha) &&
	                horario.getHora().equals(hora) &&
	                horario.getDisponible()) {

	                horario.setDisponible(false);
	                auxPc.setCita(new Cita(id, auxDen, EstatusVisita.NOATENDIDA,
	                        razon, fecha, hora, NumConsultorio.UNO));
	                JOptionPane.showMessageDialog(null, "ID de la Cita:" + id);
	                revalidate();
	                repaint();
	                horarioDisponible = true;
	                break; // Salir del bucle una vez que se asigna la cita
	            }
	        }

	        if (!horarioDisponible) {
	            JOptionPane.showMessageDialog(null, "Horario no Disponible");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "No existe el paciente ingresado");
	    }
	}


		
	
	
	public void actionPerformed(ActionEvent e)
	{
        int diasTotal = 0;
		String nombreEvento = e.getActionCommand();
		String mesObtenido = (String)boxMeses.getSelectedItem();
		
		if(nombreEvento.equals("detectar_Meses"))
		{
			if(mesObtenido.equals("Enero"))
			{
				diasTotal = 31;
			}
			else if(mesObtenido.equals("Febrero"))
			{
				diasTotal = 28;
			}
			else if(mesObtenido.equals("Marzo"))
			{
				diasTotal = 31;
			}
			else if(mesObtenido.equals("Abril"))
			{
				diasTotal = 30;
			}
			else if(mesObtenido.equals("Mayo"))
			{
				diasTotal = 31;
			}
			else if(mesObtenido.equals("Junio"))
			{
				diasTotal = 30;
			}
			else if(mesObtenido.equals("Julio"))
			{
				diasTotal = 31;
			}
			else if(mesObtenido.equals("Agosto"))
			{
				diasTotal = 31;
			}
			else if(mesObtenido.equals("Septiembre"))
			{
				diasTotal = 30;
			}
			else if(mesObtenido.equals("Octubre"))
			{
				diasTotal = 31;
			}
			else if(mesObtenido.equals("Noviembre"))
			{
				diasTotal = 30;
			}
			else if(mesObtenido.equals("Diciembre"))
			{
				diasTotal = 31;
			}
			boxDias.removeAllItems();
			String[] dias = new String[diasTotal];
			for(int i = 0;i < diasTotal;i += 1)
			{
				dias[i] = "" +(i + 1);
				boxDias.addItem(dias[i]);
			}
		}
		else if(nombreEvento.equals("guardar_Datos"))
		{
			if(camposVacios() == false)
			{
                guardarDatos();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Ingrese Todos Los Datos");
			}
		}

		
	}
}
