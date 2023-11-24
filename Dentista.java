package proyecto.backend;

import java.util.ArrayList;
import java.util.Date;

public class Dentista extends Persona
{
	private String titulo;
	private ArrayList<horarios> horariosDisponibles;
	

	public Dentista(String titulo, ArrayList<horarios> horariosDisponibles, String id, String nombre, String apellidoP, String apellidoM, Date fechaNac) {
		super(id, nombre, apellidoP, apellidoM, fechaNac);
		this.titulo = titulo;
		this.horariosDisponibles = horariosDisponibles;
	}

	public Dentista()
	{
		
	}
	
	public String imprimirDatos()
	{
		String datos = super.imprimirDatos() + imprimir();
		return datos;
	}
	
	public String imprimir() {
	    StringBuilder datos = new StringBuilder("\nTitulo: " + titulo + "\nHorarios disponibles: \n");

	    for (horarios h : horariosDisponibles) 
	    {
	       // if (h.isDisponible()) 
	       // {
	            datos.append("\n").append(h);
	        //}
	    }

	    return datos.toString();
	}
	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public ArrayList<horarios> getHorariosDisponibles() 
	{
		return horariosDisponibles;
	}

	public void setHorariosDisponibles(ArrayList<horarios> horariosDisponibles) 
	{
		this.horariosDisponibles = horariosDisponibles;
	}
	
    public boolean verificarDisponibilidad(Date fecha, Double hora) {
        for (horarios horario : horariosDisponibles) {
            if (horario.getFecha().equals(fecha) && horario.getHora().equals(hora) && horario.isDisponible()) {
                return true;
            }
        }
        return false;
    }
	

}
