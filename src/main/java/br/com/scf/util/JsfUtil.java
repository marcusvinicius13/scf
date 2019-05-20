package br.com.scf.util;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class JsfUtil {
	
	@Produces
	@RequestScoped
	public FacesContext  getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	@Produces
	public <T> List <T> getList () {  
		return new ArrayList<T>();   
	} 
}
