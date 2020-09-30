package com.briup.bean;

public class Position {

	private int POS_ID;
	private String POS_NAME;
	private int DEPT_ID;

	@Override
	public String toString() {
		return "Position{" +
				"POS_ID=" + POS_ID +
				", POS_NAME='" + POS_NAME + '\'' +
				", DEPT_ID=" + DEPT_ID +
				'}';
	}

	public int getPOS_ID() {
		return POS_ID;
	}

	public void setPOS_ID(int POS_ID) {
		this.POS_ID = POS_ID;
	}

	public String getPOS_NAME() {
		return POS_NAME;
	}

	public void setPOS_NAME(String POS_NAME) {
		this.POS_NAME = POS_NAME;
	}

	public int getDEPT_ID() {
		return DEPT_ID;
	}

	public void setDEPT_ID(int DEPT_ID) {
		this.DEPT_ID = DEPT_ID;
	}

	public Position(int POS_ID, String POS_NAME, int DEPT_ID) {
		this.POS_ID = POS_ID;
		this.POS_NAME = POS_NAME;
		this.DEPT_ID = DEPT_ID;
	}

	public Position() {
	}
}
