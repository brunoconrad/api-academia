package br.com.academia.controller;

import br.com.academia.model.Usuario;
import br.com.academia.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class UsuarioController {

    UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getAllUsuarios(){
        return usuarioService.listAllUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable (value = "id") Long id){
        return usuarioService.findUsuarioById(id);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> updateUsuarioById(@PathVariable (value = "id") Long id, @RequestBody Usuario usuario){
        return usuarioService.updateUsuarioById(usuario, id);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteUsuarioById(@PathVariable (value = "id") Long id){
        return usuarioService.deleteById(id);
    }

}
