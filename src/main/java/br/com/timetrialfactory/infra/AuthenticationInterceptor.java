package br.com.timetrialfactory.infra;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.timetrialfactory.annotations.Restrict;
import br.com.timetrialfactory.controller.UsersController;

@Intercepts
public class AuthenticationInterceptor implements Interceptor {

    private final UserWeb user;
    private final Result result;

    public AuthenticationInterceptor(UserWeb user, Result result) {
        this.user = user;
        this.result = result;
    }

    @Override
    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
        this.result.redirectTo(UsersController.class).loginForm();
    }

    public boolean accepts(ResourceMethod method) {
        return !this.user.isLogged() && method.containsAnnotation(Restrict.class);
    }

}
