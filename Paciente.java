package proyecto.backend;

import java.util.Date;

public class Paciente extends Persona
{
	private Cita cita;
	
	public Paciente(Cita cita, String id, String nombre, String apellidoP, String apellidoM, Date fechaNac)
	{
		super(id, nombre, apellidoP, apellidoM, fechaNac);
		this.cita = cita;
	}
	
	public Paciente()
	{
		
	}

	public Cita getCita() 
	{
		return cita;
	}

	public void setCita(Cita cita) 
	{
		this.cita = cita;
	}
	
	
}
