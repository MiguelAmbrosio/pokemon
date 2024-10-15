package com.mx.pokemonapi.vo;

import java.sql.Timestamp;

public class BitacoraPokemonApiVO {
	
	
	 private Long id;
	 private String ipOrigen;
	 private Timestamp fecha;
	 private String metodo;
	 private String tiempo;
	 private String request;
	 private String response;
	 
	 
	 
	 
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
	 * @param metodo the metodo to set
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
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
	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

}
