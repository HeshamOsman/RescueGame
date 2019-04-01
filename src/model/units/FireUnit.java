package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;

import simulation.Address;
import simulation.Rescuable;

public abstract class FireUnit extends Unit {

	public FireUnit(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		super(unitID, location, stepsPerCycle, worldListener);

	}
	
	@Override
	public void jobsDone() {
		super.jobsDone();
		ResidentialBuilding rb = (ResidentialBuilding)getTarget();
		
		if(rb != null&& rb.getStructuralIntegrity()==0) {
			setState(UnitState.IDLE);
		}
		
	}
}
