package proyecto.backend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class horarios {
	private Date fecha;
	private Double hora;
	private Boolean disponible;
	
	public horarios(Date fecha, Double hora, Boolean disponible) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.disponible = disponible;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getHora() {
		return hora;
	}
	public void setHora(Double hora) {
		this.hora = hora;
	}
	
    public boolean isDisponible() {
        return disponible;
    }
    
    @Override
    public String toString() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaHora = sdf.format(fecha) + " " + hora;
        return "Fecha y Hora: " + fechaHora + (disponible ? " (Disponible)" : " (No disponible)");
    }
	
	

}

