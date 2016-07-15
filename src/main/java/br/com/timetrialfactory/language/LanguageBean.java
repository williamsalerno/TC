package br.com.timetrialfactory.language;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.caelum.vraptor.ioc.SessionScoped;

@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String localeCode;
	
	private static Map<String, Object> countries;
	static{
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("Portuguese", Locale.getDefault());
	}
	
	public Map<String, Object> getCountriesInMap(){
		return countries;
	}
	
	public String getLocaleCode(){
		return localeCode;
	}
	
	public void setLocaleCode(String localeCode){
		this.localeCode = localeCode;
	}
	
	public void countryLocaleCodeChanged(ValueChangeEvent e){
		String newLocaleValue = e.getNewValue().toString();
		
		for(Map.Entry<String, Object> entry : countries.entrySet()){
			if(entry.getValue().toString().equals(newLocaleValue)){
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
			}
		}
	}

}
