package edu.handong.csee.java.utils;

public class SeveralExceptions extends Exception{
	public SeveralExceptions() {
		super("Please check your argument.");
	}
	public SeveralExceptions(String message) {
		super(message);
	}

}