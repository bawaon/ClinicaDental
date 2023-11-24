package proyecto.backend;

import java.util.Date;

public class Persona 
{
	private String id;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private Date fechaNac;
	
	public Persona(String id, String nombre, String apellidoP, String apellidoM, Date fechaNac)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.fechaNac = fechaNac;
	}
	
	public String imprimirDatos()
	{
		String datos = "ID: " + id + "\nNombre: " + nombre + "\nApellido paterno: " + apellidoP + "\nApellido materno: " + apellidoM + "\nFecha de nacimiento: " + fechaNac;
		return datos;
	}
	
	public Persona()
	{
		
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public String getApellidoP() 
	{
		return apellidoP;
	}
	
	public void setApellidoP(String apellidoP) 
	{
		this.apellidoP = apellidoP;
	}
	
	public String getApellidoM() 
	{
		return apellidoM;
	}
	
	public void setApellidoM(String apellidoM) 
	{
		this.apellidoM = apellidoM;
	}
	
	public Date getFechaNac() 
	{
		return fechaNac;
	}
	
	public void setFechaNac(Date fechaNac) 
	{
		this.fechaNac = fechaNac;
	}

	
}
