package com.example.FinanceTracker.Controllers;

import com.example.FinanceTracker.Model.Expense;
import com.example.FinanceTracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expense")
    public ResponseEntity< List<Expense>> getAllExpenses(){
        return  new ResponseEntity<> (expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @PostMapping("/expense/{userId}")
    public ResponseEntity<Expense> addAllExpenses(@PathVariable long userId, @RequestBody Expense expense) throws IOException {
        return new ResponseEntity<>(expenseService.addAllExpenses(userId,expense), HttpStatus.OK);

    }

    @GetMapping("/expense/{id}")
    public ResponseEntity <List<Expense>>getExpensesByUserId(@PathVariable long id ){
        List<Expense> expenses = expenseService.getExpensesByUserId(id);
        return  new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping("/expense/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable long id, @RequestBody Expense expense){
        Expense expense1 = null;

        try{
          expense1 = expenseService.getExpenseByID(id);
        }catch (Exception e){
            return  new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }

        if(expense1 != null){
            expenseService.updateExpense(id, expense);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable long id){
        Expense expense2 = expenseService.getExpenseByID(id);

        if(expense2!=null) {
            expenseService.deleteExpense(expense2);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Doesn't Exist", HttpStatus.BAD_REQUEST);
        }

    }

}
