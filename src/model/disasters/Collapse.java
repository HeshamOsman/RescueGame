package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class Collapse extends Disaster {

	public Collapse(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}

	public void strike() {
		super.strike();
		if (getTarget() != null) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();
			rb.setFoundationDamage(rb.getFoundationDamage() + 10);
		}
	}

	@Override
	public void cycleStep() {
		if (getTarget() != null) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();
			rb.setFoundationDamage(rb.getFoundationDamage() + 10);
		}

	}

}
