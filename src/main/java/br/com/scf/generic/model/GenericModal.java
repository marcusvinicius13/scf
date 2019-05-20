package br.com.scf.generic.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.primefaces.PrimeFaces;

public class GenericModal implements Serializable{

	private static final long serialVersionUID = 4278907022649823243L;

	public void openModal(String pagina) {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 1400);
        options.put("height", 800);
        options.put("resizable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
         
        PrimeFaces.current().dialog().openDynamic(pagina, options, null);
	}
	
	public void closeModal() {
		PrimeFaces.current().dialog().closeDynamic(null);
	}

}
