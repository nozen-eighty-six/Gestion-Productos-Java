package pe.BoraBora.Interceptor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import pe.BoraBora.repository.AccountRepository;

public class AccessInterceptor implements HandlerInterceptor {
    private final AccountRepository accountRepository;
    private Map<String, Set<String>> rolesPermisos = new HashMap<>();


    public AccessInterceptor(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

        // Permisos
        Set<String> adminPermisos = new HashSet<>();
        adminPermisos.add("/borabora/admin/catalogo");
        adminPermisos.add("/borabora/admin/catalogobusquedad");
        adminPermisos.add("/borabora/admin/inventario");
        adminPermisos.add("/borabora/admin/inventariobusquedad");
        adminPermisos.add("/borabora/producto/agregar");
        rolesPermisos.put("admin", adminPermisos);
        
        Set<String> clientePermisos = new HashSet<>();
        clientePermisos.add("/borabora/catalogo");
        clientePermisos.add("/borabora/catalogobusquedad");
        clientePermisos.add("/borabora/AgregarAlCarrito"); clientePermisos.add("/borabora/MostrarCarrito"); 
        clientePermisos.add("/borabora/ActualizarCarrito"); clientePermisos.add("/borabora/EliminarDelCarrito"); 
        clientePermisos.add("/borabora/compra/procesar");
        clientePermisos.add("/borabora/compra/detalles");
        rolesPermisos.put("cliente", clientePermisos);

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String username = (String) request.getSession().getAttribute("usuarioIniciado");
        String requestedURI = request.getRequestURI();

        if (username != null && tieneAcceso(username, requestedURI)) {
            return true; // Permitir acceso
        } else {
        	String role = obtenerRolDeBaseDeDatos(username);
            response.sendRedirect("/borabora/accessDenied");
            return false; // Denegar acceso
        }
    }

    private boolean tieneAcceso(String username, String requestedURI) {
        String role = obtenerRolDeBaseDeDatos(username);

        // Verificacion
        Set<String> permisos = rolesPermisos.get(role);
        return permisos != null && permisos.contains(requestedURI);
    }

    private String obtenerRolDeBaseDeDatos(String username) {
        return accountRepository.obtenerRolPorUsuario(username);
    }
}



