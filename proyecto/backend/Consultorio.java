package backend;

import java.util.Map;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
public class Consultorio 
{
	private String lugar;
	private Map<String, Paciente> pacientes;
	private Map<String, Dentista> dentistas;
	private ArrayList<Cita> cita;
	

	 
	public Consultorio(String lugar) {
		super();
		this.lugar = lugar;
		this.pacientes = new HashMap<>();
		this.dentistas = new HashMap<>();
		this.cita = new ArrayList<>();
	}

	public void agregarDentista()
	{ Dentista dentista=new Dentista();
		
		dentista.setId(JOptionPane.showInputDialog("Ingrese Id "));
		
		if (dentistas.containsKey(dentista.getId())) {
			JOptionPane.showMessageDialog(null, "El dentista ya está registrado. No se puede agregar duplicados.");
		} else {
			
			// Si no existe, agregar el dentista a la lista
			dentista.setNombre(JOptionPane.showInputDialog("Ingrese Nombre"));
			dentista.setApellidoP(JOptionPane.showInputDialog("Ingrese Apellido Paterno"));
			dentista.setApellidoM(JOptionPane.showInputDialog("Ingrese Apellido Materno"));
			dentista.setTitulo(JOptionPane.showInputDialog("Ingrese Especialidad"));
			dentista.setFechaNac(transformaStringADate(
					JOptionPane.showInputDialog("Ingrese la fecha de Nacimiento de la forma dd/MM/yyyy")));
			Date fecha =transformaStringADate(
					JOptionPane.showInputDialog("Ingrese la fecha 1 disponible de la forma dd/MM/yyyy"));
			Double hora =Double.parseDouble(JOptionPane.showInputDialog("Ingrese la hora de la forma hh.mm"));
			Date fecha1 =transformaStringADate(
					JOptionPane.showInputDialog("Ingrese la fecha 1 disponible de la forma dd/MM/yyyy"));
			Double hora1 =Double.parseDouble(JOptionPane.showInputDialog("Ingrese la horade la forma hh.mm"));
			//dentista.setHorariosDisponibles((ArrayList<horarios>)creaListaHorarios(fecha,hora, fecha1,hora1));
			dentistas.put(dentista.getId(),dentista);
			JOptionPane.showMessageDialog(null, "Dentista agregado exitosamente.");
		}
		
	}
	
    public void agregarDentista(Dentista dentista) {
        if (dentistas.containsKey(dentista.getId())) {
            JOptionPane.showMessageDialog(null, "El dentista ya está registrado. No se puede agregar duplicados.");
        } else {
            dentistas.put(dentista.getId(), dentista);
        }
    }
	
	public void agregarPaciente(int num)
	{ 
	Paciente paciente=new Paciente();
	
	paciente.setId(JOptionPane.showInputDialog("Ingrese Id "));
	/*
	if (pacientes.containsKey(paciente.getId())) {
		JOptionPane.showMessageDialog(null, "El paciente ya está registrado. No se puede agregar duplicados.");
	} else {*/
		
		// Si no existe, agregar el dentista a la lista
		paciente.setNombre(JOptionPane.showInputDialog("Ingrese Nombre"));
		paciente.setApellidoP(JOptionPane.showInputDialog("Ingrese Apellido Paterno"));
		paciente.setApellidoM(JOptionPane.showInputDialog("Ingrese Apellido Materno"));
		paciente.setFechaNac(transformaStringADate(
				JOptionPane.showInputDialog("Ingrese la fecha de Nacimiento de la forma dd/MM/yyyy")));
		Cita cit = new Cita();
		paciente.setCita(null);
		// Agregar el paciente al mapa utilizando su ID como clave
        pacientes.put(paciente.getId(), paciente);
		JOptionPane.showMessageDialog(null, "Paciente agregado exitosamente.");
		
		
	}
        
	//}

	public Cita crearCita()
	{ Cita nCita=new Cita();
	
		nCita.setId(JOptionPane.showInputDialog("Ingrese Id "));
	
	if (pacientes.containsKey(nCita.getId())) {
		JOptionPane.showMessageDialog(null, "La cita ya está registrado. No se puede agregar duplicados.");
		return null;
	} else {
		
		// Si no existe, agregar el cita
		nCita.setDentista(unDentista());
		nCita.setVisita(EstatusVisita.NOATENDIDA);
		nCita.setRazonVisita(JOptionPane.showInputDialog("Ingrese Motivo de Visita"));
		Date fecha =transformaStringADate(
				JOptionPane.showInputDialog("Ingrese la fecha 1 disponible de la forma dd/MM/yyyy"));
		Double hora =Double.parseDouble(JOptionPane.showInputDialog("Ingrese la hora de la forma hh.mm"));
		nCita.setFechaCita(fecha);
		nCita.setHora(hora);
		//nCita.setNumConsultorio(NumConsultorio.UNO);
		// Agregar cita a Arfray List
        cita.add(nCita);
		JOptionPane.showMessageDialog(null, "Cita agregado exitosamente.");
		return nCita;
		}
        
	}

	public void asignarCita() {
		Paciente pac=unPaciente();
		Dentista den=unDentista();
		Date fecha =transformaStringADate(
				JOptionPane.showInputDialog("Ingrese la fecha 1 disponible de la forma dd/MM/yyyy"));
		Double hora =Double.parseDouble(JOptionPane.showInputDialog("Ingrese la hora de la forma hh.mm"));
		if(verificaDisponibilidadDentista(den, fecha, hora)) {
			pac.setCita(crearCita());
			horarios horarioAEliminar = null;
			List<horarios> horariosDisponibles = den.getHorariosDisponibles();
	        for (horarios horario : horariosDisponibles) {
	            if (horario.getFecha().equals(fecha) && horario.getHora().equals(hora)) {
	                horarioAEliminar = horario;
	                break;
	            }
	        }
	        horariosDisponibles.remove(horarioAEliminar);
            den.setHorariosDisponibles((ArrayList<horarios>)horariosDisponibles);
		}
		else {
	        JOptionPane.showMessageDialog(null, "No se puede asignar cita.");
		}
		
	}
	
	public Boolean verificaDisponibilidadDentista(Dentista dentista, Date fecha, Double hora) {
	    if (dentista != null) {
	        List<horarios> horariosDisponibles = dentista.getHorariosDisponibles();

	        // Verificar si hay disponibilidad para la fecha y hora especificadas
	        for (horarios horario : horariosDisponibles) {
	            if (horario.getFecha().equals(fecha) && horario.getHora().equals(hora)) {
	                return true; // Hay disponibilidad
	            }
	        }

	        // Si no se encontró disponibilidad
	        JOptionPane.showMessageDialog(null, "No hay disponibilidad para la fecha y hora especificadas.");
	        return false;
	    } else {
	        JOptionPane.showMessageDialog(null, "Dentista no encontrado.");
	        return false;
	    }
	}

	public void reprogramarCita() {
	    String citaId = JOptionPane.showInputDialog("Ingrese el Id de la cita a reprogramar");
	    Cita citaTemp = encontrarCitaPorId(citaId);

	    if (citaTemp != null) {
	    	

	        Date nuevaFecha = transformaStringADate(JOptionPane.showInputDialog("Ingrese la nueva fecha de la forma dd/MM/yyyy"));
	        Double nuevaHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva hora de la forma hh.mm"));
	        if(verificaDisponibilidadDentista(unDentista(),nuevaFecha,nuevaHora)) {
	        	// Actualizar la fecha y hora de la cita
		        citaTemp.setFechaCita(nuevaFecha);
		        citaTemp.setHora(nuevaHora);

		        JOptionPane.showMessageDialog(null, "Cita reprogramada exitosamente.");
	        }
	        else {
	        	JOptionPane.showMessageDialog(null, "No se puede reprogramar, horario no disponible");
	        }
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "No se puede reprogramar, cita inexistente");
	    }
	}

	
	public Cita encontrarCitaPorId(String citaId)
	{
		for (Cita citaTem : cita)
			if (citaTem.getId()==citaId)
			{
				return 	citaTem;
			}
			else {
				JOptionPane.showMessageDialog(null,  "Cita no encontrada");
			}
		return null;
	}
	
	public Paciente unPaciente()
	{
		String id=JOptionPane.showInputDialog("Ingrese el Id del paciente");
			if (pacientes.containsKey(id))
			{
				return 	pacientes.get(id);
			}
			else {
				JOptionPane.showMessageDialog(null,  "Paciente no Encontrado");
			}
		return null;
	}
	
	public Dentista unDentista()
	{
		String id=JOptionPane.showInputDialog("Ingrese el Id del doctor");
		if (dentistas.containsKey(id))
		{
			return 	dentistas.get(id);
		}
		else {
			JOptionPane.showMessageDialog(null,  "Dentista no Encontrado");
		}
	return null;
	}
	
	public Dentista econtarDentistaPorId(String dentId) 
	{
	    for (Dentista dentista : dentistas.values()) 
	    {
	        if (dentista.getId().equals(dentId)) 
	        {
	            return dentista;
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Dentista no encontrado");
	    return null;
		
	}
	
	public void agregarPaciente(Paciente paciente) {
		
	    if (pacientes.containsKey(paciente.getId())) {
	        JOptionPane.showMessageDialog(null, "El paciente ya está registrado. No se puede agregar duplicados.");
	    } else {
	        pacientes.put(paciente.getId(), paciente);
	    }
	}
	

	public Paciente encontrarPaciente(String pacId) 
	{
	    for (Paciente paciente : pacientes.values()) 
	    {
	        if (paciente.getId().equals(pacId)) 
	        {
	            return paciente;
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Paciente no encontrado");
	    return null;
	}
	
	public String imprimirDentistas() {
        StringBuilder result = new StringBuilder("Lista de Dentistas:\n");

        for (Map.Entry<String, Dentista> entry : dentistas.entrySet()) {
            Dentista dentista = entry.getValue();
            result.append("ID: ").append(dentista.getId())
                    .append("\nNombre: ").append(dentista.getNombre())
                    .append("\nApellido Paterno: ").append(dentista.getApellidoP())
                    .append("\nApellido Materno: ").append(dentista.getApellidoM())
                    .append("\nEspecialidad: ").append(dentista.getTitulo())
                    .append("\n\n\n");
        }

        return result.toString();
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
	
	public static Date transformaStringADate(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaD = null;
		try {
			fechaD = sdf.parse(fecha);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Formato Fecha Incorrecto" + fecha);
			fechaD = null;
		}
		return fechaD;
	}
	/*
	public static List<horarios> creaListaHorarios(Date fecha, Double hora, Date fecha1, Double hora1) {
		List<horarios> listaHorarios = new ArrayList<horarios>();
		Date fechat = fecha;
		Double horat= hora;
		listaHorarios.add(new horarios(fechat,horat));
		 fechat = fecha1;
		 horat= hora1;
		listaHorarios.add(new horarios(fechat,horat));
		
		return listaHorarios;
	}*/
	/*
	 public String cadDatos()
	{
		String cad="";
		cad= "Titulo: "+titulo
				+"\nEditorial: "+editorial 
				+"\nAutores:";
		for(Autor buf: autores)
			cad+=buf.getNombre()+", ";
		cad+="\nISBN: "+isbn
				+"\nFecha de adquisicion: "+fechaAd
				+"\nAño de publicacion: "+anioPu
			;
		
		
		return cad;
	}*/

	public String obtenerHorariosDisponiblesDentista(String dentistaId) 
	{
	    Dentista dentista = encontrarDentistaPorId(dentistaId);

	    if (dentista != null) 
	    {
	        StringBuilder datos = new StringBuilder("Horarios disponibles del doctor:\n");
	        
	        for (horarios h : dentista.getHorariosDisponibles()) 
	        {
	        	int i = 1;
	            if (h.isDisponible()) {
	                datos.append("\n" + i +". Fecha: ").append(h.getFecha()).append(", Hora: ").append(h.getHora());
	            }
	            i++;
	        }

	        return datos.toString();
	    } else {
	        return "Dentista no encontrado.";
	    }
	}

	public Dentista encontrarDentistaPorId(String dentistaId) {
	    for (Dentista dentista : dentistas.values()) {
	        if (dentista.getId().equals(dentistaId)) {
	            return dentista;
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Dentista no encontrado");
	    return null;
	}
	
	private String formatoHora(Double hora) {
	    int horaEntera = hora.intValue();
	    int minutos = (int) ((hora - horaEntera) * 60);

	    return String.format("%02d:%02d", horaEntera, minutos);
	}


}