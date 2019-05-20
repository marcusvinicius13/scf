package br.com.scf.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TemaPrimeFaces implements Serializable{

	private static final long serialVersionUID = -3650608858132081033L;
	private String tema = "bootstrap";

	/*Geteres and Seteres*/
	
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
