package br.com.academia.controller;

import br.com.academia.model.Produto;
import br.com.academia.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class ProdutoController {

    ProdutoService produtoService;

    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody Produto produto){
        return produtoService.createTask(produto);
    }

    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getAllProdutos(){
        return produtoService.listAllTasks();
    }

    @GetMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> getProdutoById(@PathVariable (value = "id") Long id){
        return produtoService.findProdutoById(id);
    }

    @PutMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> updateProdutoById(@PathVariable (value = "id") Long id, @RequestBody Produto produto){
        return produtoService.updateProdutoById(produto, id);
    }

    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteProdutoById( @PathVariable (value = "id") Long id){
        return produtoService.deleteById(id);
    }


}
