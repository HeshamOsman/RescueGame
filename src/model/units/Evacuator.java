package model.units;

import java.util.ArrayList;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;

public class Evacuator extends PoliceUnit {

	public Evacuator(String unitID, Address location, int stepsPerCycle, WorldListener worldListener, int maxCapacity) {

		super(unitID, location, stepsPerCycle, worldListener, maxCapacity);

	}

	@Override
	public void treat() {

//			if (getTarget() != null && getTarget() instanceof Citizen) {
//				Citizen c = (Citizen) getTarget();
//				c.getDisaster().setActive(false);
////				c.setState(CitizenState.RESCUED);
//				getPassengers().add(c);
//				if (getPassengers().size() >= getMaxCapacity()) {
//					setDistanceToBase(manhattenDistance(c.getLocation(), new Address(0, 0)));
//				}
//			}

		if (getTarget() != null && getTarget() instanceof ResidentialBuilding) {
			ResidentialBuilding rb = (ResidentialBuilding) getTarget();

			if (rb.getOccupants().isEmpty()) {
				jobsDone();
			}

			ArrayList<Citizen> rescued = new ArrayList<>();
			for (Citizen c : rb.getOccupants()) {
				if (getPassengers().size() >= getMaxCapacity()) {
					setDistanceToBase(manhattenDistance(rb.getLocation(), new Address(0, 0)));
					break;
				}
//					c.getDisaster().setActive(false);
//					c.setState(CitizenState.RESCUED);
				getPassengers().add(c);
				rescued.add(c);

			}
			rb.getOccupants().removeAll(rescued);
		}

	}

	@Override
	public void cycleStep() {
		if (!(getPassengers().size() >= getMaxCapacity())) {
			super.cycleStep();
		} else {
			setDistanceToBase(getDistanceToBase() - getStepsPerCycle());
//			setDistanceToTarget(getDistanceToBase());
			if (getDistanceToBase() <= 0) {
				setDistanceToBase(0);
				this.setLocation(new Address(0, 0));

				for (Citizen c : getPassengers()) {
					c.setState(CitizenState.RESCUED);
					c.setLocation(new Address(0, 0));
				}

				getPassengers().removeAll(getPassengers());

				if (getTarget() != null && getTarget() instanceof ResidentialBuilding) {
					setDistanceToTarget(manhattenDistance(this.getLocation(), getTarget().getLocation()));
//					setState(UnitState.TREATING);
				}
			}
		}

	}


//	@Override
//	public void respond(Rescuable r) {
//		if(r.getDisaster().isActive()) {
//			if (getState() == UnitState.IDLE) {
//				if (getTarget() != null && getState() == UnitState.RESPONDING) {
//					getTarget().getDisaster().setActive(true);
//				}
//				super.respond(r);
//			}
//		}
//		
//
//	}

}
