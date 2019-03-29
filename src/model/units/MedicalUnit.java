package model.units;

import simulation.Address;

public abstract class MedicalUnit extends Unit {

	private int healingAmount;//to citizen hp +
	private int treatmentAmount;//to citizen bloodloss -

	public MedicalUnit(String unitID, Address location, int stepsPerCycle) {

		super(unitID, location, stepsPerCycle);
		healingAmount = 10;
		treatmentAmount = 10;

	}

}
