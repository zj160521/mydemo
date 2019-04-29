package com.demo.DesignModel.factory.simple;


public class SimpleTest {

	public static void main(String[] args) {

		BMWFactory f= getF("3x");
		f.makeBMW();
	}
	
	public static BMWFactory getF(String bmw){
		BMWFactory bf = null;
		switch(bmw){
		case "3x":
			bf = new BMW3x();
			break;
		case "5x":
			bf = new BMW5x();
			break;
		case "7x":
			bf = new BMW7x();
			break;
		}
		return bf;
		
	}

}
