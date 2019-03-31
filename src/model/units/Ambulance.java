package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;

public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		super(unitID, location, stepsPerCycle, worldListener);

	}

	@Override
	public void treat() {
		Citizen c = (Citizen)getTarget();
		c.getDisaster().setActive(false);
		c.setBloodLoss(c.getBloodLoss()-getTreatmentAmount()); 
		if(c.getBloodLoss()==0) {
			c.setState(CitizenState.RESCUED);
			heal();
		}
	}

	
	
	
	

}
