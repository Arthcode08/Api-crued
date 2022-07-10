package com.myara.demo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myara.demo.entities.CadastroProfissional;
import com.myara.demo.repositories.ProfissionalRepository;

@RestController
@CrossOrigin
@RequestMapping({"/cadastroprofissional"})
public class ProfissionalResource {

	private ProfissionalRepository repository;
    
 ProfissionalResource(ProfissionalRepository profissionalrepository){
		this.repository = profissionalrepository;
	}
     @GetMapping
     public List findAll() {
    	 return repository.findAll();
     }
 
     @GetMapping(path = {"/{id}"})
     public ResponseEntity findById(@PathVariable long id) {
    	 return repository.findById(id)
    			 .map(record -> ResponseEntity.ok().body(record))
    			 .orElse(ResponseEntity.notFound().build());
     }
     @PostMapping
      public CadastroProfissional create(@RequestBody CadastroProfissional cadProfissional) {
     return repository.save(cadProfissional);
     }
     
     @PutMapping(value="/{id}")
     public ResponseEntity update(@PathVariable("id") long id,@RequestBody CadastroProfissional projeto) {
    	  return repository.findById(id)
    			  .map(record->{
    		       record.setCpf(projeto.getCpf());
    		       record.setEmail(projeto.getEmail());
    		       record.setNome(projeto.getNome());
    	           record.setTelefone(projeto.getTelefone());
    	           record.setRecursos_humanos(projeto.getRecursos_humanos());
    	           record.setAlmoxarifado(projeto.getAlmoxarifado());
    	           record.setAdministrativo(projeto.getAdministrativo());
    	           record.setOperacional(projeto.getOperacional());
    	           record.setComercial(projeto.getComercial());
    	           record.setTi(projeto.getTi());
    	           record.setHigienização(projeto.getHigienização());
    	           record.setFinanceiro(projeto.getFinanceiro());
    	           record.setSegurança(projeto.getSegurança());
    	           CadastroProfissional updated = repository.save(record);
    	           return ResponseEntity.ok().body(updated);
    			  }).orElse(ResponseEntity.notFound().build());
     }
     @DeleteMapping(path = {"/{id}"})
     public ResponseEntity <?> delete(@PathVariable long id){
    	 return repository.findById(id)
    			 .map(record ->{
    				 repository.deleteById(id);
    				 return ResponseEntity.ok().build();
    			 }).orElse(ResponseEntity.notFound().build());
     }
}
