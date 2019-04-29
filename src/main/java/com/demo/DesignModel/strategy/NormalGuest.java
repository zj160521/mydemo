package com.demo.DesignModel.strategy;

public class NormalGuest implements StrategyInterface {

	@Override
	public double calculate(double d) {
		return d;
	}
}
