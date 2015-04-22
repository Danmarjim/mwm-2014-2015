package es.us.mwm;

public class Entrance {
	
	private String texto;
	private String titulo;
	private String fecha;
	
	public Entrance (){
		this.texto = "";
		this.titulo = "";
		this.fecha = "";
	}
	
	public Entrance (String fecha, String texto, String titulo){
		super();
		this.texto=texto;
		this.titulo=titulo;
		this.fecha=fecha;
	}
	
	public String getTexto(){
		return texto;
	}
	
	public void setTexto(String texto){
		this.texto=texto;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}

}
