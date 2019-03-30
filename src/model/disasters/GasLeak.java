package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class GasLeak extends Disaster {

	public GasLeak(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}

	public void strike() {
		super.strike();

		if (getTarget() != null) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();
			rb.setGasLevel(rb.getGasLevel() + 10);
		}
	}

	@Override
	public void cycleStep() {
		if (getTarget() != null) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();
			rb.setGasLevel(rb.getGasLevel() + 15);
		}

	}
}
