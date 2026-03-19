package br.com.fiap.ExpenseTracker.services;

import br.com.fiap.ExpenseTracker.models.Expense;
import br.com.fiap.ExpenseTracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository repository;

    //get all
    public List<Expense> getAllExpense(){
        return repository.findAll();
    }

    //post
    public Expense addExpense(Expense expense){
        return repository.save(expense);
    }

    //get by id
    public Expense getExpenseById(Long id){
        return findExpenseById(id);
    }

    //delete
    public void deleteExpense(Long id) {
        findExpenseById(id);
        repository.deleteById(id);
    }

    //update
    public Expense updateExpense(Long id, Expense newExpense) {
        findExpenseById(id);
        newExpense.setId(id);
        return repository.save(newExpense);
    }

    //find by id
    private Expense findExpenseById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa com id " + id + " não encontrada")
        );
    }
}
