package andrevsc.java_api_rest_web.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import andrevsc.java_api_rest_web.model.Usuario;

@Repository
public class UserRepository {
    private List<Usuario> usuarios = new ArrayList<>();
    private int nextId = 1; // Campo para gerenciar o próximo ID
    
    public void save(Usuario usuario){
        if(usuario.getId() == null){
            usuario.setId(nextId++); // Atribui o próximo ID e incrementa
            System.out.println("Usuário salvo com sucesso!");
            usuarios.add(usuario); // Adiciona o novo usuário à lista
        } else {
            System.out.println("Usuário atualizado com sucesso!");
            // Atualiza o usuário existente na lista
            usuarios = usuarios.stream()
                .map(u -> u.getId().equals(usuario.getId()) ? usuario : u)
                .collect(Collectors.toList());
            System.out.println(usuario);
        }
    }
    
    public void deleteById(Integer id){
        System.out.println("Usuário excluído com sucesso!");
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
        System.out.println(id);
    }
    
    public List<Usuario> findAll(){
        return usuarios;
    }
    
    public Usuario findById(Integer id) {
        return usuarios.stream()
            .filter(usuario -> usuario.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    public Usuario findByLogin(String login){
        return usuarios.stream()
            .filter(usuario -> usuario.getLogin().equals(login))
            .findFirst()
            .orElse(null);
    }
}
