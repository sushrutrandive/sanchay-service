package com.planner.calc.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planner.calc.service.dao.ExpensesRepository;
import com.planner.calc.service.info.ExpenseInfo;
import com.planner.calc.service.services.ExpenseService;


@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpensesRepository expensesRepository;
	
	public ExpenseServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ExpenseInfo createExpense(ExpenseInfo info) {
		// TODO Auto-generated method stub
		return this.expensesRepository.createExpense(info);
	}
	@Override
	public ExpenseInfo updateExpense(ExpenseInfo info) {
		// TODO Auto-generated method stub
		return this.expensesRepository.updateExpense(info);
	} 
	@Override
	public void deleteExpense(long expenseId) {
		this.expensesRepository.deleteExpense(expenseId);
		
	}
	@Override
	public ExpenseInfo getExpenseById(long id) {
		// TODO Auto-generated method stub
		return this.expensesRepository.getExpenseById(id);
	}
	@Override
	public List<ExpenseInfo> getExpensesByUserId(long userId) {
		// TODO Auto-generated method stub
		return this.expensesRepository.getExpensesByUserId(userId);
	}

}
