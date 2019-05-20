package br.com.scf.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.scf.stb.tipo.pojo.Tipo;


@FacesConverter("tipoConverter")
public class TipoConverter implements Converter<Object>{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) 
	        return null;

	    return this.getAttributesFrom(component).get(id);
		
	}

    @Override
	public String getAsString(FacesContext context, UIComponent component, Object tipo) {
		if (tipo == null || tipo.toString().isEmpty() )
	        return null;

		this.addAttribute(component, (Tipo) tipo);
	    
		Tipo tipoConta = (Tipo) tipo;
		if(tipoConta.getIdTipo() != null)
			return tipoConta.getIdTipo().toString();
		else
			return null;
	}

	protected void addAttribute(UIComponent component, Tipo tipo) {  
        String key = tipo.getIdTipo().toString(); 
        this.getAttributesFrom(component).put(key, tipo);  
    }  
  
    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    }
}
