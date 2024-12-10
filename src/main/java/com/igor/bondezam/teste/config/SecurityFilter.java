package com.igor.bondezam.teste.config;

import com.igor.bondezam.teste.config.serviceConfig.auth.TokenService;
import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if(Objects.nonNull(token)){
            String subject = tokenService.validToken(token); //pega as informações do token
            Usuario user = userRepository.findUsuarioByEmail(subject);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth); //seta as informações do usuário que estava no token no contexto para o spring security conseguir fazer as próximas validações (ter o usuário no contexto para ver se é válido, sem esse cara ele n vai ter o usuário com isso quebrar as validações se está logado e tem permissão)
        }
        filterChain.doFilter(request, response); // executa o próximo filtro
    }

    private String getToken(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if(Objects.nonNull(auth)){
           return auth.replace("Bearer ", "");
        }
        return null;
    }
}
