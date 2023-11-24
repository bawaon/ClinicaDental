package proyecto.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Ejecutadora {

	public static void main(String[] args) 
	{ 
		int ciclo = 0;
		int contPaciente = 4;
		
		Consultorio cons1 = new Consultorio("El diente blanco");
		ArrayList<horarios> horariosLunesViernes = crearHorariosLunesMartes();
		
		ArrayList<horarios> horas1 = new ArrayList<>(horariosLunesViernes);
		Dentista dent1 = new Dentista("Ortodoncista", horas1, "1", "Balam", "Garcia", "Alvarado", deStringaDate("09/07/2002"));
		
		ArrayList<horarios> horas2 = new ArrayList<>(horariosLunesViernes);
		Dentista dent2 = new Dentista("Endodoncia", horas2, "2", "Ariel", "Gonzales", "Ordaz", deStringaDate("28/01/2001"));
		
		ArrayList<horarios> horas3 = new ArrayList<>(horariosLunesViernes);
		Dentista dent3 = new Dentista("Cirugía oral y maxilofacial", horas3, "3", "Jose", "Pablo", "Gonzales", deStringaDate("20/12/2004"));
		
		
		
		Paciente pac1 = new Paciente(null, "1", "Leonardo", "Aguilar", "Martinez", deStringaDate("31/03/2008"));
		
		Paciente pac2 = new Paciente(null, "2", "Roberto", "Perez", "Ordaz", deStringaDate("31/12/2002"));
		
		Paciente pac3 = new Paciente(null, "3", "Michelle", "Rosas", "Castro", deStringaDate("21/06/20010"));
		
		
		cons1.agregarDentista(dent1);
		cons1.agregarDentista(dent2);
		cons1.agregarDentista(dent3);
		
		cons1.agregarPaciente(pac1);
		cons1.agregarPaciente(pac2);
		cons1.agregarPaciente(pac3);
		/*
		Dentista leer= cons1.econtarDentistaPorId("1");
		
		JOptionPane.showMessageDialog(null, leer.imprimirDatos());
		
		Paciente leePaciente = cons1.encontrarPaciente("1");
		JOptionPane.showMessageDialog(null, leePaciente.imprimirDatos());*/
		do {
            try {
                String aux = JOptionPane.showInputDialog("Ingrese el número de la operación que desea realizar: \n1. Reservar cita con Dentista"
                		+ "\n2. Verificar disponibilidad de horarios. \n3. Reprogramar cita");
                
                int opcion = Integer.parseInt(aux);

                switch (opcion)
                {
                    case 1:
                    	
                    	String id = "";
                    	String horario = "";
                        String.valueOf(contPaciente);
                        id = JOptionPane.showInputDialog(null,"Eliga su doctor\n\n" + cons1.imprimirDentistas());
                        horario = JOptionPane.showInputDialog(null,cons1.obtenerHorariosDisponiblesDentista(id));
                        int hor = Integer.parseInt(horario);
                        hor = hor - 1;
                        cons1.agregarPaciente(hor);
                        
                        
                        
                        break;

                    case 2:
                    	JOptionPane.showInputDialog(null,"Eliga su doctor\n\n" + cons1.imprimirDentistas());
                    	
                        break;
                        
                    case 3:
               
                        ciclo = 1;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Dato inválido");
                        
                        break;
                }
            } catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                
            }
        } while (ciclo != 1);
		
		

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
	
	public static ArrayList<horarios> crearHorariosLunesMartes() {
	    ArrayList<horarios> horariosLunesMartes = new ArrayList<>();

	    // Crear horarios de Lunes y Martes de 2 pm a 5 pm
	    Calendar calendarLunes = Calendar.getInstance();
	    calendarLunes.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    calendarLunes.set(Calendar.HOUR_OF_DAY, 14); // 2 pm
	    calendarLunes.set(Calendar.MINUTE, 0);

	    Calendar calendarMartes = Calendar.getInstance();
	    calendarMartes.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	    calendarMartes.set(Calendar.HOUR_OF_DAY, 14); // 2 pm
	    calendarMartes.set(Calendar.MINUTE, 0);

	    for (int i = 0; i < 6; i++) { // Seis bloques de una hora
	        horariosLunesMartes.add(new horarios(calendarLunes.getTime(), (double) calendarLunes.get(Calendar.HOUR_OF_DAY), true));
	        horariosLunesMartes.add(new horarios(calendarMartes.getTime(), (double) calendarMartes.get(Calendar.HOUR_OF_DAY), true));

	        calendarLunes.add(Calendar.HOUR_OF_DAY, 1);
	        calendarMartes.add(Calendar.HOUR_OF_DAY, 1);
	    }

	    return horariosLunesMartes;
	}


}
