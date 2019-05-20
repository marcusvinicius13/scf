package br.com.scf.util;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.scf.usuario.dao.UsuarioDAO;
import br.com.scf.usuario.pojo.Usuario;
@Named
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 5317508654029129001L;
	
	@Inject
	private Usuario usuario;
	
	@Inject
	private UsuarioDAO usuarioDao;
	
	public String logar() {
		Usuario usuario = usuarioDao.existe(this.usuario);
		if(usuario != null && usuario.getId_usuario() != null)
			return "/comum/portal?faces-redirect=true";
		else
			return "login";
	}

	/*Geteres and Seteres*/
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
