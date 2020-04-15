package com.planner.calc.service.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planner.calc.service.config.WebSecurityConfiguration;
import com.planner.calc.service.info.ExpenseInfo;
import com.planner.calc.service.services.ExpenseService;
import com.planner.calc.service.services.UserService;
import com.planner.calc.service.util.UserUtil;

@RestController
@RequestMapping(value = "api/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExpenseInfo> getDetails(HttpServletRequest request) {
		return expenseService.getExpensesByUserId(UserUtil.getUserId());
	}

	@RequestMapping(value = "/expense/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ExpenseInfo getDetailsById(@PathVariable("id") long incomeSourceId) {

		return expenseService.getExpenseById(incomeSourceId);
	}

	@RequestMapping(value = "/expense", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ExpenseInfo save(HttpServletRequest request, @RequestBody ExpenseInfo info) {

		info.setUserId(UserUtil.getUserId());
		return expenseService.createExpense(info);
	}

	@RequestMapping(value = "/expense", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ExpenseInfo update(HttpServletRequest request, @RequestBody ExpenseInfo info) {

		info.setUserId(UserUtil.getUserId());
		return expenseService.updateExpense(info);
	}

	@RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(HttpServletRequest request, @PathVariable("id") long incomeSourceId) {
		// String tokenPayload =
		// request.getHeader(WebSecurityConfiguration.AUTHENTICATION_HEADER_NAME);
		// info.setUserId(userService.getUserIdByToken(tokenPayload));
		expenseService.deleteExpense(incomeSourceId);
	}

}
