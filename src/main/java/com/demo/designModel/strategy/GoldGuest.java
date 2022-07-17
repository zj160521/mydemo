package com.demo.designModel.strategy;

public class GoldGuest implements StrategyInterface {

	@Override
	public double calculate(double d) {
		return d*0.8;
	}
}
