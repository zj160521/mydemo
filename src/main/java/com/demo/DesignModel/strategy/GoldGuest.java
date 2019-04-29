package com.demo.DesignModel.strategy;

public class GoldGuest implements StrategyInterface {

	@Override
	public double calculate(double d) {
		return d*0.8;
	}
}
