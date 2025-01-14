package com.mx.pokemonapi.entity;



import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "BITACORA_POKEMON_API") 
public class BitacoraPokemonApiEntity  implements Serializable{
	
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_BITACORA_POKEMON")
    private Long id;
    
    @Column  (name = "IP_ORIGEN")
    private String ipOrigen;
    
    @Column  (name = "FECHA")
    private Timestamp fecha;
    
    @Column  (name = "METODO")
    private String metodo;

    @Column  (name = "TIEMPO_MILISEGUNDOS")
    private String tiempo;

    @Column  (name = "REQUEST")
    private String request;
    
   
    
    
    

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}




	/**
	 * @return the ipOrigen
	 */
	public String getIpOrigen() {
		return ipOrigen;
	}




	/**
	 * @param ipOrigen the ipOrigen to set
	 */
	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}



	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}




	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}




	/**
	 * @return the metodo
	 */
	public String getMetodo() {
		return metodo;
	}




	/**
	 * @param metodo the metodo to set
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}




	/**
	 * @return the tiempo
	 */
	public String getTiempo() {
		return tiempo;
	}




	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}




	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}




	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}














	@Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", ipOrigen='" + ipOrigen + '\'' +
                ", fecha=" + fecha +
                ", metodo='" + metodo + '\'' +
                 ", tiempo='" + tiempo + '\'' +
                 ", request='" + request + '\'' +
                 
                '}';
    }

}
