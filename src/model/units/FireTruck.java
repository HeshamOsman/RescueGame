package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;

public class FireTruck extends FireUnit {

	public FireTruck(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		super(unitID, location, stepsPerCycle,  worldListener);

	}

	@Override
	public void treat() {
		ResidentialBuilding rb = (ResidentialBuilding)getTarget();
		rb.getDisaster().setActive(false);
		rb.setFireDamage(rb.getFireDamage()-10);
		setState(UnitState.IDLE);
	}
}
