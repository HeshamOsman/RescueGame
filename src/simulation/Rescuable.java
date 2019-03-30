package simulation;

import model.disasters.Disaster;

public interface Rescuable {
	void struckBy(Disaster d); //should update the target (building/citizen) state and SOSListener
	Address getLocation(); 
	Disaster getDisaster();
}
