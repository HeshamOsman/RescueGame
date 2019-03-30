package model.units;

import java.util.ArrayList;

import simulation.Address;
import simulation.Rescuable;
import model.people.Citizen;
//police car
public abstract class PoliceUnit extends Unit {

	private ArrayList<Citizen> passengers;
	private int maxCapacity;
	private int distanceToBase;//police base

	public PoliceUnit(String unitID, Address location, int stepsPerCycle, int maxCapacity) {

		super(unitID, location, stepsPerCycle);
		passengers = new ArrayList<Citizen>();
		this.maxCapacity = maxCapacity;

	}
	
	@Override
	public void respond(Rescuable r) {
		// TODO Auto-generated method stub
		
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
