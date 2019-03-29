package model.disasters;

import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Disaster implements Simulatable {

	private int startCycle;// when the disaster starts
	private Rescuable target;//the object stroked by the disaster
	private boolean active;

	public Disaster(int startCycle, Rescuable target) {

		this.startCycle = startCycle;
		this.target = target;
		this.active = false;//by Default

	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getStartCycle() {
		return startCycle;
	}

	public Rescuable getTarget() {
		return target;
	}

}
