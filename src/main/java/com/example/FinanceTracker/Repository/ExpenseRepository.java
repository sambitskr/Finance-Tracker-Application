package com.example.FinanceTracker.Repository;

import com.example.FinanceTracker.Model.Expense;
import com.example.FinanceTracker.Model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query("SELECT i FROM Expense i WHERE i.user.id = :userId")
    List<Expense> getExpensesByUserId(@Param("userId") long id);




}
