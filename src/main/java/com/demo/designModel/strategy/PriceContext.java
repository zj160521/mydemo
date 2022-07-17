package com.demo.designModel.strategy;

public class PriceContext implements StrategyInterface {

	private StrategyInterface si;
	
	
	public PriceContext(StrategyInterface si) {
		super();
		this.si = si;
	}


	@Override
	public double calculate(double d) {
		
		return this.si.calculate(d);
	}

}
