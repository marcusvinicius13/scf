package br.com.scf.telefonema.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.scf.telefonema.pojo.Telefonema;

@Named(value = "telefonemaBean")
@ViewScoped
public class TelefonemaBean implements Serializable{

	private static final long serialVersionUID = 54320095784700978L;
	
	@Inject
	private Telefonema telefonema;
	
	@PostConstruct
	public void init() {
		
	}

	public Telefonema getTelefonema() {
		return telefonema;
	}

	public void setTelefonema(Telefonema telefonema) {
		this.telefonema = telefonema;
	}
}
