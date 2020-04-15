package com.planner.calc.service.dao;

import java.util.List;

import com.planner.calc.service.exceptions.RecordNotFoundException;
import com.planner.calc.service.info.ExpenseInfo;


public interface ExpensesRepository {
	
	public List<ExpenseInfo> getExpensesByUserId(long userId) throws RecordNotFoundException;

	public ExpenseInfo getExpenseById(long id) throws RecordNotFoundException;

	public ExpenseInfo updateExpense(ExpenseInfo info) throws RecordNotFoundException;

	public ExpenseInfo createExpense(ExpenseInfo info);

	public void deleteExpense(long incomeSourceId);
	
	

}
