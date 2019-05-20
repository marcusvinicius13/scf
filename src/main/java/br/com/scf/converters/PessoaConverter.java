package br.com.scf.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.scf.pessoa.pojo.PessoaFisica;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter<Object> {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) 
	        return null;
	    return this.getAttributesFrom(component).get(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object pessoa) {
		if (pessoa == null || pessoa.toString().isEmpty() )
	        return null;
		this.addAttribute(component, (PessoaFisica) pessoa);
		PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
		if(pessoaFisica.getIdPessoaFisica() != null)
			return pessoaFisica.getIdPessoaFisica().toString();
		else
			return null;
	}

	protected void addAttribute(UIComponent component, PessoaFisica pessoa) {  
        String key = pessoa.getIdPessoaFisica().toString(); // codigo da empresa como chave neste caso  
        this.getAttributesFrom(component).put(key, pessoa);  
    }  
  
    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    }

}
