package com.example.demo.Service;

import com.example.demo.entidades.Usuario;
import com.example.demo.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UserRepository userRepository;
    public Usuario buscarUsuario(String username){
        return userRepository.findUsuarioByUsername(username);
    }
}
