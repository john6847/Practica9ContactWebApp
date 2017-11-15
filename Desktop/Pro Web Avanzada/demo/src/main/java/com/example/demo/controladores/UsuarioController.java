package com.example.demo.controladores;


import com.example.demo.entidades.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Pude haber utilizado @RestController
@RequestMapping("/user")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/")
    public String showUser(Model model){
       // Usuario usuario= usuarioService.buscarUsuario("JOHN");
        model.addAttribute("usuario",new Usuario("John", "Ridore", "Dany","1234",null,1));
        return "demo";
    }
}
