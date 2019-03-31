package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;

public class GasControlUnit extends FireUnit {

	public GasControlUnit(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		super(unitID, location, stepsPerCycle,  worldListener);

	}

	@Override
	public void treat() {
		ResidentialBuilding rb = (ResidentialBuilding)getTarget();
		rb.getDisaster().setActive(false);
		rb.setGasLevel(rb.getGasLevel()-10);
		setState(UnitState.IDLE);
	}
}
