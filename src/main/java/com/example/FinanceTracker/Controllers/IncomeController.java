package com.example.FinanceTracker.Controllers;

import com.example.FinanceTracker.Model.Income;
import com.example.FinanceTracker.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @RequestMapping("/")
    public String welcome(){
        return "Finance Tracker";
    }

    @GetMapping("/income")
    public ResponseEntity <List<Income>> getAllIncomes(){
        return new ResponseEntity<>(incomeService.getAllIncomes(), HttpStatus.OK);
    }

    @PostMapping("/income/{userId}")
    public void addAllIncomes(@PathVariable long userId, @RequestBody Income income) throws IOException {
         incomeService.addAllIncomes(userId , income);
    }

    @GetMapping("/income/{id}")
    public ResponseEntity<List<Income>>getIncomeByUserId(@PathVariable long id){

        List<Income> incomes = incomeService.getIncomeByUserId(id);
        return new ResponseEntity<>(incomes,HttpStatus.OK);
    }

    @PutMapping("/income/{id}")
    public ResponseEntity<String> updateIncome(@PathVariable long id, @RequestBody Income income) throws IOException {
        Income income1= null;

        try{
            income1 = incomeService.getIncomeByID(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
        }

        if(income1 != null) {
            incomeService.updateIncome(id, income);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Income id doesn't exists", HttpStatus.BAD_REQUEST);
    }





}
