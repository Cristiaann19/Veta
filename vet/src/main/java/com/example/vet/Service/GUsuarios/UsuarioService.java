package com.example.vet.Service.GUsuarios;

import com.example.vet.Model.GestionUsuarios.Usuario;
import com.example.vet.Repository.GUsuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // En la semana 8-9 usarás esto para encriptar claves
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario usuario) {
        // usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username).orElse(null);
    }
}