package front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class MenuCita extends JPanel implements ActionListener
{
	private AgregarPaciente agregarPaciente;
	private AgregarDentista agregarDentista;
	private VerDoctores verDoctores;
	private ReprogramarCita reprogramarCita;
	private BuscarCita buscarCita;
	
	public MenuCita()
	{
		InterfazCita frame = (InterfazCita)SwingUtilities.getWindowAncestor(MenuCita.this);
		
		setLayout(null);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Menu De Opciones");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		agregarPaciente = new AgregarPaciente();
		agregarDentista = new AgregarDentista();
		verDoctores = new VerDoctores();
		reprogramarCita = new ReprogramarCita();
		buscarCita = new BuscarCita();

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

		JButton btnVerDentistas = new JButton("Ver Dentistas");
		btnVerDentistas.setActionCommand("ver_Dentistas");
		btnVerDentistas.addActionListener(this);
		btnVerDentistas.setBounds(20,50 + 60,200,20);
		add(btnVerDentistas);

		JButton reprogramarCita = new JButton("Reprogramar Cita");
		reprogramarCita.setActionCommand("reprogramar_Cita");
		reprogramarCita.addActionListener(this);
		reprogramarCita.setBounds(20,50 + 90,200,20);
		add(reprogramarCita);

		JButton btnEncontrarCita = new JButton("Encontrar Cita Por ID");
		btnEncontrarCita.setActionCommand("encontrar_CitaID");
		btnEncontrarCita.addActionListener(this);
		btnEncontrarCita.setBounds(20,50 + 120,200,20);
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
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(verDoctores);
        revalidate();
        repaint();
    }

    public void AgregarPanelModificarCita()
    {
    	remove(agregarPaciente);
    	remove(agregarDentista);
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
    	remove(verDoctores);
    	remove(reprogramarCita);
    	remove(buscarCita);
    	add(buscarCita);
        revalidate();
        repaint();
    }
}
