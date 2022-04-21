package br.com.academia.service;

import br.com.academia.model.Usuario;
import br.com.academia.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public ResponseEntity<Usuario> findUsuarioById(Long id){
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Usuario> updateUsuarioById(Usuario usuario, Long id){
        return usuarioRepository.findById(id)
                .map(usuarioToUpdate -> {
                    usuarioToUpdate.setCpf(usuario.getNome());
                    usuarioToUpdate.setEmail(usuario.getEmail());
                    usuarioToUpdate.setSenha(usuario.getSenha());
                    usuarioToUpdate.setDataNascimento(usuario.getDataNascimento());
                    usuarioToUpdate.setCpf(usuario.getCpf());
                    Usuario updated = usuarioRepository.save(usuarioToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id){
        return usuarioRepository.findById(id)
                .map(usuarioToDelete -> {
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
