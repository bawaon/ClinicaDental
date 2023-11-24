package front;

import javax.swing.JFrame;

public class InterfazCita extends JFrame
{
	private MenuCita menuCita;
	
	public InterfazCita()
	{
		setTitle("Sistema De Gestion De Citas Para Un Dentista");
		setSize(854,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		menuCita = new MenuCita();
		setContentPane(menuCita);

	}

	public static void main(String[] args)
	{
		InterfazCita interfaz = new InterfazCita();
		interfaz.setVisible(true);
	}
}