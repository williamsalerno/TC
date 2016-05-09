package br.com.timetrialfactory.site;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class SiteController {

    private final Result result;

    public SiteController(Result result) {
        this.result = result;
    }

    @Get("/home")
    public void home() {

    }
}
