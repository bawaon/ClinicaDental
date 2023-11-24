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
	
	public Boolean verificaDisponibilidadDentista(Integer idDent, Date fecha, Double Hora)
	{
		Dentista dentTemp = dentistas.get(idDent);
		if (dentTemp!= null){
			return true
		}
		return false ;
	}
	
	public void reprogramarCita()
	{
		Cita citaTep= encontrarCitaPorId(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id de la cita a reprogramar")));
		if(citaTep!= null){
			
		}
		else{
			
		}
	}
	
	public Cita encontrarCitaPorId(Integer citaId)
	{
		for (Cita citatem : citas)
			if (citaTemp.id==citaId)
			{
				return 	citaTemp;
			}
			else {
				JOptionPane.showMessage(null, "Cita no encontrada");
			}
		return null;
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
