package model.units;

import java.util.ArrayList;

import simulation.Address;
import simulation.Rescuable;
import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
//police car
public abstract class PoliceUnit extends Unit {

	private ArrayList<Citizen> passengers;
	private int maxCapacity;
	private int distanceToBase;//police base

	public PoliceUnit(String unitID, Address location, int stepsPerCycle, WorldListener worldListener, int maxCapacity) {

		super(unitID, location, stepsPerCycle, worldListener);
		passengers = new ArrayList<Citizen>();
		this.maxCapacity = maxCapacity;

	}
	
	
	
	@Override
	public void jobsDone() {
		super.jobsDone();
		Citizen c = (Citizen)getTarget();
		
		if(c != null&& c.getState()==CitizenState.DECEASED) {
			setState(UnitState.IDLE);
		}
		
	}

	public int getDistanceToBase() {
		return distanceToBase;
	}

	public void setDistanceToBase(int distanceToBase) {
		this.distanceToBase = distanceToBase;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public ArrayList<Citizen> getPassengers() {
		return passengers;
	}

}
