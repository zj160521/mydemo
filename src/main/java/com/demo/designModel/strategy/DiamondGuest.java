package com.demo.designModel.strategy;

public class DiamondGuest implements StrategyInterface {

	@Override
	public double calculate(double d) {
		return d*0.7;
	}
}
