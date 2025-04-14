package com.example.FinanceTracker.Service;

import com.example.FinanceTracker.Model.Income;
import com.example.FinanceTracker.Model.User;
import com.example.FinanceTracker.Repository.IncomeRepository;
import com.example.FinanceTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepo;

    @Autowired
    UserRepository userRepo;

    public List<Income> getAllIncomes() {
       return incomeRepo.findAll();
    }

    public void addAllIncomes(long userId, Income income) throws IOException {
        User user = userRepo.findById(userId).orElseThrow(() -> new IOException("User not found"));

        user.setTotalBalance(user.getTotalBalance().add(income.getAmount()));

        userRepo.save(user);

        incomeRepo.save(income);
    }

    public List<Income> getIncomeByUserId(long id) {
        return incomeRepo.getIncomeByUserId(id);
    }

    public Income getIncomeByID(long id){
        return incomeRepo.findById(id).orElse(null);
    }

    public void updateIncome(long id, Income income) throws IOException {
        incomeRepo.save(income);
    }
}
