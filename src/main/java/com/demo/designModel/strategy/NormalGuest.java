package com.demo.designModel.strategy;

public class NormalGuest implements StrategyInterface {

	@Override
	public double calculate(double d) {
		return d;
	}
}
