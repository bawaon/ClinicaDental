package front;

import backend.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import back.*;

public class MenuCita extends JPanel implements ActionListener
{
	private AgregarPaciente agregarPaciente;
	private AgregarDentista agregarDentista;
	private VerDoctores verDoctores;
	private ReprogramarCita reprogramarCita;
	private BuscarCita buscarCita;
	private VerPacientes verPacientes;
	
	private ArrayList<Dentista> dent;
	private ArrayList<Paciente> pacie;
	
	public MenuCita()
	{
		InterfazCita frame = (InterfazCita)SwingUtilities.getWindowAncestor(MenuCita.this);

		dent = new ArrayList<>();
		dent.add(new Dentista("A1","Ariel","Gonzalez","Ordaz",conversion("01/01/2001"),"Odontologia",null));
		dent.add(new Dentista("A2","Fernando","Aguilar","Martinez",conversion("02/02/2002"),"Odontologia",null));
		dent.add(new Dentista("A3","IyaquiBalam","Garcia","Alvarado",conversion("03/03/2003"),"Odontologia",null));
		dent.add(new Dentista("A4","Alondra Paloma","Gabriel","Cruz",conversion("04/04/2004"),"Odontologia",null));
		dent.add(new Dentista("A5","Angel Gabriel","Castro","Gonzalez",conversion("05/05/2005"),"Odontologia",null));
		dent.add(new Dentista("A6","Pablo","San Pedro","Avila",conversion("06/06/2006"),"Odontologia",null));
		dent.add(new Dentista("A7","Aldair","Arteaga","Reyes",conversion("07/07/2007"),"Odontologia",null));

		pacie = new ArrayList<>();
		pacie.add(new Paciente(new Cita("C1",dent.get(0),EstatusVisita.NOATENDIDA,
				"Receta",conversion("07/07/2007"),12.0,NumConsultorio.UNO),
				"B1","Pepe","Toño","Macias",conversion("01/01/2001")));
		pacie.add(new Paciente(new Cita("C2",dent.get(1),EstatusVisita.NOATENDIDA,
				"Cirugia",conversion("07/07/2007"),11.0,NumConsultorio.UNO),
				"B2","Angel","David","Revilla",conversion("03/08/2003")));
		
		setLayout(null);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Menu De Opciones");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		agregarPaciente = new AgregarPaciente(pacie,dent);
		agregarDentista = new AgregarDentista(dent);
		verPacientes = new VerPacientes(pacie);
		verDoctores = new VerDoctores(dent);
		reprogramarCita = new ReprogramarCita();
		buscarCita = new BuscarCita(pacie);

		JLabel etiquetaImagen = new JLabel(new ImageIcon("Logo.png"));
		etiquetaImagen.setLocation(0,200);
        add(etiquetaImagen);
        
		JLabel titulo = new JLabel("Seleccione Una Opcion");
		titulo.setBounds(20,20,200,20);
		titulo.setForeground(new Color(48,96,189));
		add(titulo);
		
		JButton btnAgregarPaciente = new JButton("Agregar Paciente");
		btnAgregarPaciente.setActionCommand("agregar_Paciente");
		btnAgregarPaciente.addActionListener(this);
		btnAgregarPaciente.setBounds(20,50,200,20);
		add(btnAgregarPaciente);
		
		JButton btnAgregarDentista = new JButton("Agregar Dentista");
		btnAgregarDentista.setActionCommand("agregar_Dentista");
		btnAgregarDentista.addActionListener(this);
		btnAgregarDentista.setBounds(20,50 + 30,200,20);
		add(btnAgregarDentista);

		JButton btnVerPacientes = new JButton("Ver Pacientes");
		btnVerPacientes.setActionCommand("ver_Pacientes");
		btnVerPacientes.addActionListener(this);
		btnVerPacientes.setBounds(20,50 + 60,200,20);
		add(btnVerPacientes);

		JButton btnVerDentistas = new JButton("Ver Dentistas");
		btnVerDentistas.setActionCommand("ver_Dentistas");
		btnVerDentistas.addActionListener(this);
		btnVerDentistas.setBounds(20,50 + 90,200,20);
		add(btnVerDentistas);

		JButton reprogramarCita = new JButton("Reprogramar Cita");
		reprogramarCita.setActionCommand("reprogramar_Cita");
		reprogramarCita.addActionListener(this);
		reprogramarCita.setBounds(20,50 + 120,200,20);
		add(reprogramarCita);

		JButton btnEncontrarCita = new JButton("Encontrar Cita Por ID");
		btnEncontrarCita.setActionCommand("encontrar_CitaID");
		btnEncontrarCita.addActionListener(this);
		btnEncontrarCita.setBounds(20,50 + 150,200,20);
		add(btnEncontrarCita);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String nombreEvento = e.getActionCommand();
		if(nombreEvento.equals("agregar_Paciente"))
		{
			AgregarPanelAgregarPaciente();
		}
		else if(nombreEvento.equals("agregar_Dentista"))
		{
			AgregarPanelAgregarDentista();
		}
		else if(nombreEvento.equals("ver_Dentistas"))
		{
			AgregarPanelVerDoctores();
		}
                else if(nombreEvento.equals("ver_Pacientes"))
                {
                    AgregarPanelVerPacientes();
                }
		else if(nombreEvento.equals("reprogramar_Cita"))
		{
			AgregarPanelModificarCita();
		}
		else if(nombreEvento.equals("encontrar_CitaID"))
		{
			AgregarPanelBuscarCita();
		}
	}

    public void AgregarPanelAgregarPaciente()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(agregarPaciente);
        revalidate();
        repaint();
    }

    public void AgregarPanelAgregarDentista()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(agregarDentista);
        revalidate();
        repaint();
    }

    public void AgregarPanelVerDoctores()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(verDoctores);
        revalidate();
        repaint();
    }

    public void AgregarPanelVerPacientes()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(verPacientes);
        revalidate();
        repaint();
    }

    public void AgregarPanelModificarCita()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(reprogramarCita);
        revalidate();
        repaint();
    }

    public void AgregarPanelBuscarCita()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(buscarCita);
        revalidate();
        repaint();
    }

    public void CerrarPaneles()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
    	remove(verPacientes);
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	
    	for(Dentista d:dent)
    	{
    		System.out.println(d.getNombre());
    	}
    	
        revalidate();
        repaint();
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
}
