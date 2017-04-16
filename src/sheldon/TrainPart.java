package sheldon;

public abstract class TrainPart {
	public TrainPart(){

	}
TrainPart behindMe;
TrainPart inFrontOfMe;
Rail currentRail;
boolean hasPassengers = true;

	public abstract void MoveToRail (Rail r);
	public boolean HasPassenger (){// ülnek e a vonaton

		System.out.println("This carriage has passangers : " + hasPassengers);
		return hasPassengers;
	}
	public boolean HasNextTrain(){
		return behindMe!=null;
	}
}
