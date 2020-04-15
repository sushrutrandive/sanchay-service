package com.planner.calc.service.calculators;

public class CalculatorContext<T> {

	private Calculator<T> calculator;

	public CalculatorContext(Calculator<T> calculator) {
		super();
		this.calculator = calculator;
	}
	
	public T calulateAmount(T info){
		return this.calculator.calculate(info);
	}
}
