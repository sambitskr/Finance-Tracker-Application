package com.example.FinanceTracker.Service;

import com.example.FinanceTracker.Model.Expense;
import com.example.FinanceTracker.Model.User;
import com.example.FinanceTracker.Repository.ExpenseRepository;
import com.example.FinanceTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepo;





    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense addAllExpenses(long userId, Expense expense) throws IOException {
        User user = userRepo.findById(userId).orElseThrow(() -> new IOException("User not found"));

        user.setTotalBalance(user.getTotalBalance().subtract(expense.getAmount()));

        userRepo.save(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUserId(long id) {
        return expenseRepository.getExpensesByUserId(id);
    }

    public Expense getExpenseByID(long id){
        return expenseRepository.findById(id).orElse(null);
    }

    public void updateExpense(long id, Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Expense expense) {
        expenseRepository.delete(expense);

    }
}
