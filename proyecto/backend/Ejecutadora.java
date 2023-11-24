package proyecto.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class Ejecutadora {

	public static void main(String[] args) 
	{
		ArrayList<String> horas1 = new ArrayList<String>();
		Dentista dent1 = new Dentista("Ortodoncista", horas1, "1", "Balam", "Garcia", "Alvarado", deStringaDate("09/07/2002"));
		
		ArrayList<String> horas2 = new ArrayList<String>();
		Dentista dent2 = new Dentista("Endodoncia", horas2, "2", "Ariel", "Gonzales", "Ordaz", deStringaDate("28/01/2001"));
		
		ArrayList<String> horas3 = new ArrayList<String>();
		Dentista dent3 = new Dentista("Cirugía oral y maxilofacial", horas3, "3", "Jose", "Pablo", "Gonzales", deStringaDate("20/12/2004"));
		
		
		
		Paciente pac1 = new Paciente(null, "1", "Leonardo", "Aguilar", "Martinez", deStringaDate("31/03/2008"));
		
		Paciente pac2 = new Paciente(null, "2", "Roberto", "Perez", "Ordaz", deStringaDate("31/12/2002"));
		
		Paciente pac3 = new Paciente(null, "3", "Michelle", "Rosas", "Castro", deStringaDate("21/06/20010"));
	}
	
	public static Date deStringaDate(String fecha)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date fechaD = null;
		try
		{
			fechaD=sdf.parse(fecha);
		}
		catch(ParseException e)
		{
			JOptionPane.showMessageDialog(null, "Formato Fecha Incorrecta" + fecha);
			fechaD = null;
		}
		return fechaD;
	}
}