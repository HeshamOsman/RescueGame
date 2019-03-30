package model.disasters;

import model.people.Citizen;

public class Infection extends Disaster {

	public Infection(int startCycle, Citizen target) {

		super(startCycle, target);

	}

	public void strike() {
		super.strike();
		if (getTarget() != null) {
			Citizen c = (Citizen) getTarget();
			c.setToxicity(c.getToxicity() + 25);
		}
	}

	@Override
	public void cycleStep() {
		if (getTarget() != null) {
			Citizen c = (Citizen) getTarget();
			c.setToxicity(c.getToxicity() + 15);
		}
	}
}
