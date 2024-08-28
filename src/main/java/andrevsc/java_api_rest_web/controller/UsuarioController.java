package andrevsc.java_api_rest_web.controller;

import java.util.List;
import andrevsc.java_api_rest_web.model.Usuario;
import andrevsc.java_api_rest_web.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UserRepository userRepository;
    
    public List<Usuario> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void addUsers(@RequestBody Usuario usuario){
        userRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id) {
        Usuario usuario = userRepository.findById(id);
        if (usuario != null) {
            return ""+ usuario;
        } else {
            return "Failed to find user with id: " + id;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        Usuario usuario = userRepository.findById(id);
        if (usuario != null) {
            userRepository.deleteById(id);
            return "User with id: " + id + " deleted";
        } else {
            return "Failed to find user with id: " + id;
        }
    }
}