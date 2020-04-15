package com.planner.calc.service.services;

import java.util.List;

import com.planner.calc.service.info.ExpenseInfo;



public interface ExpenseService {
	
	public List<ExpenseInfo> getExpensesByUserId(long userId) ;

	public ExpenseInfo getExpenseById(long id) ;

	public ExpenseInfo updateExpense(ExpenseInfo info) ;

	public ExpenseInfo createExpense(ExpenseInfo info);

	public void deleteExpense(long incomeSourceId);

}
