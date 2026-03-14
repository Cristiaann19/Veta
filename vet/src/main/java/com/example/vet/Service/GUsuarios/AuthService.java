package com.example.vet.Service.GUsuarios;

import com.example.vet.Config.JwtUtil;
import com.example.vet.DTO.LoginRequest;
import com.example.vet.DTO.LoginResponse;
import com.example.vet.Model.GestionUsuarios.Usuario;
import com.example.vet.Repository.GUsuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // Obtener el rol del usuario
        String rol = usuario.getRoles().stream()
                .findFirst()
                .map(r -> r.getNombre())
                .orElse("ROLE_USER");

        Long trabajadorId = usuario.getTrabajador() != null
                ? usuario.getTrabajador().getId()
                : null;

        String token = jwtUtil.generarToken(usuario.getUsername(), rol);

        return new LoginResponse(token, usuario.getUsername(), rol, trabajadorId);
    }
}