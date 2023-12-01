package backend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class horarios {
	private Date fecha;
	private Double hora;
	private Boolean disponible;
	
	public horarios(Date fecha, Double hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.disponible = true;
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
    
    public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	@Override
    public String toString() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaHora = sdf.format(fecha) + " " + hora;
        return "Fecha y Hora: " + fechaHora + (disponible ? " (Disponible)" : " (No disponible)");
    }
	
    public boolean isDisponible() {
        return disponible;
    }
	

}

