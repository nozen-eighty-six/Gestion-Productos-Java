package pe.BoraBora.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pe.BoraBora.repository.AccountRepository;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AccountRepository accountRepository;

    public WebMvcConfig(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessInterceptor(accountRepository))
                .addPathPatterns("/**")
                
                // URLs de excepciones
        		.excludePathPatterns("/include/**","/images/**","/img/**","/js/**","/layer/**","/styles/**",
        				"/home","/account/redirectByRole", 
        				"/accessDenied",
        				"/account/login",
        				"/account/reset",
        				"/account/create",
        				 "/admin/producto/{id}","/producto/editar-{id}", 
        				"/producto/eliminar/{id}", "/producto/{id}"); 
    }
}
