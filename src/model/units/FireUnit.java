package model.units;

import simulation.Address;
import simulation.Rescuable;

public abstract class FireUnit extends Unit {

	public FireUnit(String unitID, Address location, int stepsPerCycle) {

		super(unitID, location, stepsPerCycle);

	}

	@Override
	public void respond(Rescuable r) {
		// TODO Auto-generated method stub
		
	}
}
