package br.com.fiap.ExpenseTracker.repositories;

import br.com.fiap.ExpenseTracker.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
