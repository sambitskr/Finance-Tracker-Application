package com.example.FinanceTracker.Repository;

import com.example.FinanceTracker.Model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT i FROM Income i WHERE i.user.id = :userId")
    List<Income>getIncomeByUserId(@Param("userId") long id);
}

//{
//        "amount": 1000.50,
//        "source": "Salary",
//        "date": "2024-09-25",
//        "user": {
//        "id": 1
//        }
//        }
