package br.com.academia.service;

import br.com.academia.model.Produto;
import br.com.academia.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto createProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listAllProdutos(){
        return produtoRepository.findAll();
    }

    public ResponseEntity<Produto> findProdutoById(Long id){
        return produtoRepository.findById(id)
                .map(produto -> ResponseEntity.ok().body(produto))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Produto> updateProdutoById(Produto produto, Long id){
        return produtoRepository.findById(id)
                .map(produtoToUpdate -> {
                    produtoToUpdate.setNome(produto.getNome());
                    produtoToUpdate.setDescricao(produto.getDescricao());
                    produtoToUpdate.setPreco(produto.getPreco());
                    produtoToUpdate.setFoto(produto.getFoto());
                    Produto updated = produtoRepository.save(produtoToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById( Long id ) {
        return produtoRepository.findById(id)
                .map(produtoToDelete -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
