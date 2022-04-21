package br.com.academia.controller;

import br.com.academia.model.InfoEmpresa;
import br.com.academia.service.InfoEmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class InfoEmpresaController {

    InfoEmpresaService infoEmpresaService;

    @PostMapping("/infoEmpresa")
    @ResponseStatus(HttpStatus.CREATED)
    public InfoEmpresa createEmpresa(@RequestBody InfoEmpresa empresa){
        return infoEmpresaService.createInfoEmpresa(empresa);
    }

    @GetMapping("/infoEmpresa")
    @ResponseStatus(HttpStatus.OK)
    public List<InfoEmpresa> getAllEmpresas(){
        return infoEmpresaService.listAllInfoEmpresa();
    }

    @GetMapping("/infoEmpresa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InfoEmpresa> getEmpresaById(@PathVariable (value = "id") Long id){
        return infoEmpresaService.findInfoEmpresaById(id);
    }

    @PutMapping("/infoEmpresa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InfoEmpresa> updateEmpresaById(@PathVariable (value = "id") Long id, @RequestBody InfoEmpresa empresa){
        return infoEmpresaService.updateInfoEmpresaById(empresa, id);
    }

    @DeleteMapping("/infoEmpresa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteEmpresaById(@PathVariable (value = "id") Long id){
        return infoEmpresaService.deleteById(id);
    }

}
