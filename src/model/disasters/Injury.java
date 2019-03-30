package model.disasters;

import model.people.Citizen;

public class Injury extends Disaster {

	public Injury(int startCycle, Citizen target) {

		super(startCycle, target);

	}

	public void strike() {
		super.strike();
		if (getTarget() != null) {
			Citizen c = (Citizen) getTarget();
			c.setBloodLoss(c.getBloodLoss() + 30);
		}
	}

	@Override
	public void cycleStep() {
		if (getTarget() != null) {
			Citizen c = (Citizen) getTarget();
			c.setBloodLoss(c.getBloodLoss() + 10);
		}

	}
}
