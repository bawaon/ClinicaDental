package front;

import backend.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BuscarCita extends JPanel implements ActionListener
{
        private JTextField txtId;
        private DefaultTableModel tamanioTabla;
	private ArrayList<Paciente> pacie;
	
	public BuscarCita(ArrayList<Paciente> pacie)
	{
		setLayout(null);
		setSize(585,405);
		setLocation(235,20);
		setBackground(new Color(215,245,240));
		TitledBorder border = BorderFactory.createTitledBorder("Encontrar Cita");
		border.setTitleColor(new Color(48,96,189));
		setBorder(border);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		this.pacie = pacie;
                
		JLabel lbTitulo = new JLabel("Ingrese ID para buscar una cita");
		lbTitulo.setBounds(20,20,200,20);
		lbTitulo.setForeground(new Color(48,96,189));
		add(lbTitulo);

		int x = 10,y = 0;
		
		JLabel lbId = new JLabel("ID");
		lbId.setBounds(x + 45,y + 50,75,20);
		lbId.setForeground(new Color(48,96,189));
		add(lbId);
		
		txtId = new JTextField();
		txtId.setBounds(x + 25,y + 50 + 20,50,20);
		txtId.setBackground(new Color(175,175,175));
		txtId.setForeground(new Color(48,96,189));
		txtId.setEditable(true);
		txtId.setColumns(20);
		add(txtId);
		
		JButton btnBuscar = new JButton("Buscar ID");
		btnBuscar.setActionCommand("buscar_ID");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(100,y + 50 + 20,100,20);
		add(btnBuscar);
		
		String[] tablaColumnas = {"Nombre Completo","Fecha Nacimiento","ID","Razon","Dentista","ID Paciente"};
		tamanioTabla = new DefaultTableModel(tablaColumnas,0);
		JTable tablaPacientes = new JTable(tamanioTabla);
		tablaPacientes.setEnabled(false);
		Border bordeListaDentistas = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0,0,0),1),BorderFactory.createEmptyBorder(5,5,5,5));
		tablaPacientes.setBorder(bordeListaDentistas);
		JScrollPane scrolltablaPacientes = new JScrollPane(tablaPacientes);
		scrolltablaPacientes.setBounds(20,100,540,250);
		add(scrolltablaPacientes);
		
	}

        public void actionPerformed(ActionEvent e)
        {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

                String nombreEvento = e.getActionCommand();
                Paciente auxPacie = null;
		if(nombreEvento.equals("buscar_ID"))
		{
                    for(Paciente p:pacie)
                    {
                            if(p.getCita().getId().equals(txtId.getText()))
                            {
                                    auxPacie = p;
                                    String auxNombre = "" +p.getNombre() +" " +p.getApellidoP() +" " +p.getApellidoM();
                                    Object[] datosPaciente = {auxNombre,sdf.format(p.getFechaNac()),p.getId(),
                                    p.getCita().getRazonVisita(),p.getCita().getDentista().getNombre(),
                                    p.getCita().getId()};
                                    tamanioTabla.addRow(datosPaciente);
                                    break;
                            }
                    }
                    if(auxPacie == null)
                    {
                        JOptionPane.showMessageDialog(null,"Ingrese Valor Correcto");
                    }
                }
        }
}
