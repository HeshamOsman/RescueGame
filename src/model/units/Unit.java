package model.units;

import model.events.SOSResponder;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
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

	public Unit(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {

		this.unitID = unitID;
		this.location = location;
		this.stepsPerCycle = stepsPerCycle;
		this.state = UnitState.IDLE;
		this.worldListener = worldListener;
		//target
		//distanceToTarget

	}
	
	

	@Override
	public void cycleStep() {
		if(this.state != UnitState.IDLE&& this.target!=null) {
			if(this.state == UnitState.RESPONDING&& this.getLocation().equals(target.getLocation())) {
				
				this.state = UnitState.TREATING;
				treat();
			}else if(this.state == UnitState.RESPONDING) {
				distanceToTarget -= stepsPerCycle;
				if(distanceToTarget <= 0) {
					distanceToTarget=0;
					location = target.getLocation();
					
//					treat();
				}
			}else if(this.state == UnitState.TREATING) {
				if(this.getLocation().equals(target.getLocation())) {
					treat();
				}
				
				distanceToTarget -= stepsPerCycle;
				if(distanceToTarget <= 0) {
					distanceToTarget=0;
					location = target.getLocation();
					this.state = UnitState.TREATING;
//					treat();
				}
				
			}
		}
		
	}

	public abstract void treat();
	
	public void jobsDone() {
		if(getLocation().equals(getTarget().getLocation())) {
			setState(UnitState.IDLE);
		}
		target = null;
	}
	
	@Override
	public void respond(Rescuable r) {
//		if(this.target!=null && this.target instanceof ResidentialBuilding ) {
		if(this.target!=null ) {
			
			this.target.getDisaster().setActive(true);
		}
		
		setState(UnitState.RESPONDING);
		setDistanceToTarget(manhattenDistance(this.getLocation(),r.getLocation()));
		this.target = r;
		
		
		
	}
	
	protected int manhattenDistance(Address firstAdd , Address secondAdd) {
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
