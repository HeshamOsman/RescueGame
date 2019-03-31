package model.units;

import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;

public class DiseaseControlUnit extends MedicalUnit {

	public DiseaseControlUnit(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		super(unitID, location, stepsPerCycle,  worldListener);

	}

	@Override
	public void treat() {
		Citizen c = (Citizen)getTarget();
		c.getDisaster().setActive(false);
		c.setToxicity(c.getToxicity()-getTreatmentAmount()); 
		if(c.getToxicity()==0) {
			c.setState(CitizenState.RESCUED);
			heal();
		}
	}
}
