package br.com.scf.parlamentar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.scf.parlamentar.pojo.Deputado;
import br.com.scf.parlamentar.pojo.Parlamentar;
import br.com.scf.services.RoboClient;

@Named(value = "parlamentarBean")
@ViewScoped
public class ParlamentarBean implements Serializable{

	private static final long serialVersionUID = 570694399963047169L;
	
	Parlamentar parlamentar = new Parlamentar();
	List<Parlamentar> parlamentarList = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		
	}
	
	public void consultar() {
		List<Parlamentar> parlamentares = new RoboClient("https://dadosabertos.camara.leg.br").capturarTodosParlamentares();
		System.out.println(parlamentares.toString());
	}

	public void buscarPorId() {
		Parlamentar parlamentar = new RoboClient("https://dadosabertos.camara.leg.br").capturarParlamentarPorId("");
		System.out.println(parlamentar.getNomeCivil());
	}
	
	
	public void voltar() {
		
	}
	
	public void selecionar(Deputado parlamentar) {
		
	}
	
	public void excluirParlamentar(Deputado parlamentar) {
		
	}
	
	public void showMessage() {
		
	}

	
	/* Geteres and Seteres*/

	public Parlamentar getParlamentar() {
		return parlamentar;
	}

	public void setParlamentar(Parlamentar parlamentar) {
		this.parlamentar = parlamentar;
	}

	public List<Parlamentar> getParlamentarList() {
		return parlamentarList;
	}

	public void setParlamentarList(List<Parlamentar> parlamentarList) {
		this.parlamentarList = parlamentarList;
	}
	
}
