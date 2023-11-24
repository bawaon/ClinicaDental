package front;

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

public class AgregarDentista extends JPanel implements ActionListener
{
	private JComboBox boxAnios;
	private JComboBox boxMeses;
	private JComboBox boxDias;
	
	public AgregarDentista()
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Agregar Dentista");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		JLabel lbTitulo = new JLabel("Ingrese Datos Del Dentista");
		lbTitulo.setBounds(20,20,200,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		int x = 10,y = 0;
		LocalDate currentDate = LocalDate.now();
		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(x + 75,y + 50,75,20);
		lbNombre.setForeground(new Color(48,96,189));
		add(lbNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(x + 25,y + 50 + 20,150,20);
		txtNombre.setBackground(new Color(175,175,175));
		txtNombre.setForeground(new Color(48,96,189));
		txtNombre.setEditable(true);
		txtNombre.setColumns(20);
		add(txtNombre);

		JLabel lbApellidoP = new JLabel("Apellido Paterno");
		lbApellidoP.setBounds(x + 230,y + 50,125,20);
		lbApellidoP.setForeground(new Color(48,96,189));
		add(lbApellidoP);
		
		JTextField txtApellidoP = new JTextField();
		txtApellidoP.setBounds(x + 200,y + 50 + 20,150,20);
		txtApellidoP.setBackground(new Color(175,175,175));
		txtApellidoP.setForeground(new Color(48,96,189));
		txtApellidoP.setEditable(true);
		txtApellidoP.setColumns(20);
		add(txtApellidoP);

		JLabel lbApellidoM = new JLabel("Apellido Materno");
		lbApellidoM.setBounds(x + 405,50,125,20);
		lbApellidoM.setForeground(new Color(48,96,189));
		add(lbApellidoM);
		
		JTextField txtApellidoM = new JTextField();
		txtApellidoM.setBounds(x + 375,y + 50 + 20,150,20);
		txtApellidoM.setBackground(new Color(175,175,175));
		txtApellidoM.setForeground(new Color(48,96,189));
		txtApellidoM.setEditable(true);
		txtApellidoM.setColumns(20);
		add(txtApellidoM);

		JLabel lbId = new JLabel("ID");
		lbId.setBounds(x + 45,y + 50 + 40,75,20);
		lbId.setForeground(new Color(48,96,189));
		add(lbId);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(x + 25,y + 50 + 20 + 40,50,20);
		txtId.setBackground(new Color(175,175,175));
		txtId.setForeground(new Color(48,96,189));
		txtId.setEditable(true);
		txtId.setColumns(20);
		add(txtId);

		JLabel lbEspecialidad = new JLabel("Especialidad");
		lbEspecialidad.setBounds(x + 140,y + 50 + 40,75,20);
		lbEspecialidad.setForeground(new Color(48,96,189));
		add(lbEspecialidad);
		
		JTextField txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(x + 100,y + 50 + 20 + 40,150,20);
		txtEspecialidad.setBackground(new Color(175,175,175));
		txtEspecialidad.setForeground(new Color(48,96,189));
		txtEspecialidad.setEditable(true);
		txtEspecialidad.setColumns(20);
		add(txtEspecialidad);

		JLabel lbFechaNacimiento = new JLabel("Fecha De Nacimiento");
		lbFechaNacimiento.setBounds(x + 25,y + 50 + 20 + 80,150,20);
		lbFechaNacimiento.setForeground(new Color(48,96,189));
		add(lbFechaNacimiento);

		JLabel lbDias = new JLabel("Dia");
		lbDias.setBounds(x + 60 + 150,y + 50 + 80,100,20);
		lbDias.setForeground(new Color(48,96,189));
		add(lbDias);
		
		String[] dias = new String[31];
		for(int i = 0;i < 31;i += 1)
		{
			dias[i] = "" +(i + 1);
		}
		boxDias = new JComboBox<>(dias);
		boxDias.setBounds(x + 25 + 150,y + 50 + 20 + 80,100,20);
		add(boxDias);

		JLabel lbMeses = new JLabel("Mes");
		lbMeses.setBounds(x + 180 + 150,y + 50 + 80,100,20);
		lbMeses.setForeground(new Color(48,96,189));
		add(lbMeses);
		
		String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
				"Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		List<String> listaMeses = new ArrayList<String>();
		boxMeses = new JComboBox<>(meses);
		boxMeses.setActionCommand("detectar_Meses");
		boxMeses.addActionListener(this);
		boxMeses.setBounds(x + 150 + 150,y + 50 + 20 + 80,100,20);
		add(boxMeses);

		JLabel lbAnios = new JLabel("Año");
		lbAnios.setBounds(x + 300 + 150,y + 50 + 80,100,20);
		lbAnios.setForeground(new Color(48,96,189));
		add(lbAnios);
		
		String[] anios = new String[currentDate.getYear() + -1950];
		for(int i = currentDate.getYear() - 1;i >= 1950;i -= 1)
		{
			anios[i + -1950] = "" +(i + 1);
		}
		boxAnios = new JComboBox<>(anios);
		boxAnios.setBounds(x + 275 + 150,y + 50 + 20 + 80,100,20);
		add(boxAnios);
		
		JButton btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setActionCommand("guardar_Datos");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(20,280,100,20);
		add(btnGuardar);
	}

	private Date conversion(String fecha)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date conv = null;
		try
		{
			conv = sdf.parse(fecha);
		}
		catch(ParseException e)
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
			guardarDatosFecha();
		}
	}
}
