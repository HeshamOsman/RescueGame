package model.units;

import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;

public abstract class MedicalUnit extends Unit {

	private int healingAmount;//to citizen hp +
	private int treatmentAmount;//to citizen bloodloss -

	public MedicalUnit(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		super(unitID, location, stepsPerCycle,  worldListener);
		healingAmount = 10;
		treatmentAmount = 10;

	}

	public int getTreatmentAmount() {
		return treatmentAmount;
	}

	@Override
	public void respond(Rescuable r) {
		if (getTarget() != null) {
			Citizen c = (Citizen) getTarget();

			if (c.getToxicity() == 0 || c.getBloodLoss() == 0) {
				c.getDisaster().setActive(false);
			} else {

				getTarget().getDisaster().setActive(true);
			}
		}
		
		super.respond(r);
	}
	
	public void heal() {
		Citizen c = (Citizen)getTarget();
		c.setHp(c.getHp()+healingAmount);
		setState(UnitState.IDLE);
	}

	@Override
	public void jobsDone() {
		
		super.jobsDone();
		
		Citizen c = (Citizen)getTarget();
		
		if(c != null&& c.getState()==CitizenState.DECEASED) {
			setState(UnitState.IDLE);
		}
		
	}
	
	

}
