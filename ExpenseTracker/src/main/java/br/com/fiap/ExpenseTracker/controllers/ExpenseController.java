package br.com.fiap.ExpenseTracker.controllers;

import br.com.fiap.ExpenseTracker.models.Expense;
import br.com.fiap.ExpenseTracker.services.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expense")
@Slf4j
public class ExpenseController {
    @Autowired
    private ExpenseService service;// Injeção de dependência - IoC

    @GetMapping
    public List<Expense> listAll(){
        return service.getAllExpense();
    }

    @PostMapping
    public ResponseEntity<Expense> createMovie(@RequestBody Expense expense){ //binding
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addExpense(expense));
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> getMovieById(@PathVariable Long id){
        log.info("Obtendo dados da despesa {}", id);
        return ResponseEntity.ok(service.getExpenseById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        log.info("Deletando despesa com id {}", id );
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Expense> updateMovie(@PathVariable Long id, @RequestBody Expense expense){
        log.info("Atualizando despesa com id {} com os dados {}", id, expense);
        return ResponseEntity.ok( service.updateExpense(id, expense) );
    }

}