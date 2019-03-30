package model.units;

import model.events.SOSResponder;
import model.events.WorldListener;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Unit implements Simulatable,SOSResponder {

	private String unitID;
	private UnitState state;
	private Address location;
	private Rescuable target;
	private int distanceToTarget;
	private int stepsPerCycle;
	private WorldListener worldListener;

	public Unit(String unitID, Address location, int stepsPerCycle) {

		this.unitID = unitID;
		this.location = location;
		this.stepsPerCycle = stepsPerCycle;
		this.state = UnitState.IDLE;
		//target
		//distanceToTarget

	}
	
	

	abstract void treat();
	void jobsDone() {
		
	}
	
	@Override
	public void respond(Rescuable r) {
		
		setState(UnitState.RESPONDING);
		setDistanceToTarget(manhattenDistance(this.getLocation(),r.getLocation()));
		
		if(getTarget() != null) {
			getTarget().getDisaster().setActive(true);
		}
		
		this.target = r;
		
		//Healing issue
		
		
	}
	
	private int manhattenDistance(Address firstAdd , Address secondAdd) {
		return Math.abs(firstAdd.getX()-secondAdd.getX())+Math.abs(firstAdd.getY()-secondAdd.getY());
	}
	
	public UnitState getState() {
		return state;
	}

	public void setState(UnitState state) {
		this.state = state;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getUnitID() {
		return unitID;
	}

	public Rescuable getTarget() {
		return target;
	}

	public int getStepsPerCycle() {
		return stepsPerCycle;
	}

	public void setDistanceToTarget(int distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
	}

	public WorldListener getWorldListener() {
		return worldListener;
	}

	public void setWorldListener(WorldListener worldListener) {
		this.worldListener = worldListener;
	}
	
	
}
