package br.com.academia.service;

import br.com.academia.model.InfoEmpresa;
import br.com.academia.repository.InfoEmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InfoEmpresaService {

    private InfoEmpresaRepository infoEmpresaRepository;

    public InfoEmpresa createInfoEmpresa(InfoEmpresa empresa){
        return infoEmpresaRepository.save(empresa);
    }

    public List<InfoEmpresa> listAllInfoEmpresa(){
        return infoEmpresaRepository.findAll();
    }

    public ResponseEntity<InfoEmpresa> findInfoEmpresaById(Long id){
        return infoEmpresaRepository.findById(id)
                .map(empresa -> ResponseEntity.ok().body(empresa))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<InfoEmpresa> updateInfoEmpresaById(InfoEmpresa infoEmpresa, Long id){
        return infoEmpresaRepository.findById(id)
                .map(empresaToUpdate -> {
                    empresaToUpdate.setBairro(infoEmpresa.getBairro());
                    empresaToUpdate.setCidade(infoEmpresa.getCidade());
                    empresaToUpdate.setCnpj(infoEmpresa.getCnpj());
                    empresaToUpdate.setLogradouro(infoEmpresa.getLogradouro());
                    empresaToUpdate.setNome(infoEmpresa.getNome());
                    empresaToUpdate.setNumero(infoEmpresa.getNumero());
                    empresaToUpdate.setUf(infoEmpresa.getUf());
                    empresaToUpdate.setTelefone(infoEmpresa.getTelefone());
                    empresaToUpdate.setEmail(infoEmpresa.getEmail());
                    InfoEmpresa updated = infoEmpresaRepository.save(empresaToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id){
        return infoEmpresaRepository.findById(id)
                .map(empresaToDelete -> {
                    infoEmpresaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
