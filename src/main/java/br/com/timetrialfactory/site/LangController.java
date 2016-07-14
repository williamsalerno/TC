package br.com.timetrialfactory.site;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class LangController {

	private String lang = "pt_BR";

	public LangController(String lang) {
		this.lang = lang;
	}

	public String getLang() {
		return lang;
	}

	@Get("/langPt")
	public void setLangPt() {
		this.lang = "pt_BR";
	}

	@Get("/langEn")
	public void setLangEn() {
		this.lang = "en_US";
	}

}
