package backend;


import java.util.Date;

public class Cita 
{
	private String id;
	private Dentista dentista;
	private EstatusVisita visita;
	private String razonVisita;
	private Date fechaCita;
	private Double hora;
	private NumConsultorio  numConsultorio;



	public Cita(String id, Dentista dentista, EstatusVisita visita, String razonVisita, Date fechaCita, Double hora, NumConsultorio numConsultorio) {
		super();
		this.id = id;
		this.dentista = dentista; 
		this.visita = visita;
		this.razonVisita = razonVisita;
		this.fechaCita = fechaCita;
		this.hora = hora;
		this.numConsultorio = numConsultorio;
	}
	
	public Cita() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Dentista getDentista() 
	{
		return dentista;
	}

	public void setDentista(Dentista dentista) 
	{
		this.dentista = dentista;
	}

	public EstatusVisita getVisita() 
	{
		return visita;
	}

	public void setVisita(EstatusVisita visita) 
	{
		this.visita = visita;
	}

	public String getRazonVisita() 
	{
		return razonVisita;
	}

	public void setRazonVisita(String razonVisita) 
	{
		this.razonVisita = razonVisita;
	}

	public Date getFechaCita() 
	{
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) 
	{
		this.fechaCita = fechaCita;
	}

	public Double getHora() 
	{
		return hora;
	}

	public void setHora(Double hora) 
	{
		this.hora = hora;
	}

	public NumConsultorio getNumConsultorio() 
	{
		return numConsultorio;
	}

	public void setNumConsultorio(NumConsultorio numConsultorio) 
	{
		this.numConsultorio = numConsultorio;
	}

	


	
	
	
}

