package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class Fire extends Disaster {

	public Fire(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}

	public void strike() {
		super.strike();
		if (getTarget() != null) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();
			rb.setFireDamage(rb.getFireDamage() + 10);
		}
	}

	@Override
	public void cycleStep() {
		if (getTarget() != null) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();
			rb.setFireDamage(rb.getFireDamage() + 10);
		}
	}
}
