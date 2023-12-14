package br.com.infnet.controllers;

import br.com.infnet.model.Tarefa;
import br.com.infnet.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;
    Logger logger = LoggerFactory.getLogger(TarefaController.class);


    @GetMapping
    public List<Tarefa> getAll(){
        logger.info("Get all tarefas");
        return tarefaService.getAll();
    }
    @GetMapping("/{id}")
    public Tarefa getById(@PathVariable int id){
        logger.info("Get tarefa " + id);
        return tarefaService.getById(id);
    }

    @PostMapping()
    public void save(@RequestBody Tarefa tarefa){
        logger.info("Create tarefa" + tarefa);
        tarefaService.save(tarefa);
    }

    @DeleteMapping("/{id}")//as chaves representam que é uma variável
    public void delete(@PathVariable int id){
        logger.info("delete tarefa " + id);
        Tarefa removed = tarefaService.delete(id);
        logger.info("Tarefa deletada " + removed);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Tarefa tarefa){
        logger.info("Atualizar tarefa " + id + " nova tarefa: " + tarefa);
        tarefaService.update(id, tarefa);
    }
}
