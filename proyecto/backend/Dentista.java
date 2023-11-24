package proyecto.backend;

import java.util.ArrayList;
import java.util.Date;

public class Dentista extends Persona
{
	private String titulo;
	private ArrayList<String> horariosDisponibles;
	
	public Dentista(String titulo, ArrayList<String> horariosDisponibles, String id, String nombre, String apellidoP, String apellidoM, Date fechaNac)
	{
		super(id, nombre, apellidoP, apellidoM, fechaNac);
		this.titulo = titulo;
		this.horariosDisponibles = horariosDisponibles;
	}
	
	public Dentista() {}
	public String imprimirDatos()
	{
		String datos = super.imprimirDatos() + imprimir();
		return datos;
	}	
	public String imprimir()
	{
		String datos = "Titulo: " + titulo + "Horarios disponibles: ";
		
		for(String h: horariosDisponibles)
		{
			datos += "\n" + h; 
		}
		return datos;
	}
	public String getTitulo() 
	{
		return titulo;
	}
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	public ArrayList<String> getHorariosDisponibles() 
	{
		return horariosDisponibles;
	}
	public void setHorariosDisponibles(ArrayList<String> horariosDisponibles) 
	{
		this.horariosDisponibles = horariosDisponibles;
	}
}