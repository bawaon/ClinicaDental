package proyecto.backend;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
public class Consultorio 
{
	private String lugar;
	private Map<String, Paciente> pacientes;
	private Map<String, Dentista> dentistas;
	private ArrayList<Cita> cita;
	
	public void agregarPaciente(Paciente paciente)
	{
        // Asegurémonos de que el mapa de pacientes esté inicializado
        if (pacientes == null) {
            pacientes = new HashMap<>();
        }

        // Agregar el paciente al mapa utilizando su ID como clave
        pacientes.put(paciente.getId(), paciente);
	}
	
	public void agregarDentista(Dentista dentista)
	{
		if(dentistas == null)
		{
			dentistas = new HashMap<>();
		}
		
		dentistas.put(dentista.getId(), dentista);
		
	}
	
	public Boolean verificaDisponibilidadDentista()
	{
		return null;
	}
	
	public void reprogramarCita()
	{
		
	}
	
	public void encontrarCitaPorId()
	{
		
	}
	
	public Paciente unPaciente()
	{
		return null;
	}
	
	public Dentista unDentista()
	{
		return null;
	}

	public Consultorio()
	{
		
	}

	public String getLugar() 
	{
		return lugar;
	}

	public void setLugar(String lugar) 
	{
		this.lugar = lugar;
	}

	public Map<String, Paciente> getPacientes() 
	{
		return pacientes;
	}

	public void setPacientes(Map<String, Paciente> pacientes) 
	{
		this.pacientes = pacientes;
	}

	public Map<String, Dentista> getDentistas() 
	{
		return dentistas;
	}

	public void setDentistas(Map<String, Dentista> dentistas) 
	{
		this.dentistas = dentistas;
	}

	public ArrayList<Cita> getCita() 
	{
		return cita;
	}

	public void setCita(ArrayList<Cita> cita) 
	{
		this.cita = cita;
	}
	
	
	
}
