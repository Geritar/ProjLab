package sheldon;

public class Carriage extends TrainPart{
	public Carriage(){
	}

public void MoveToRail (Rail next){ // következő sínre mozgat
	Rail tmp=currentRail; // tmpbe tároljuk azt a sínt ahonnan ellépünk
	currentRail=next; // a current rail az lesz ahová lépünk

	tmp.Clear(); // lelépünk az előző sínről
	if(HasNextTrain()){
		MoveToRail(tmp);
		// ha van mögötte kocsi akkor rekurzívan azon is meghívjuk a mozgatásta
	}
	currentRail.AddTrainToRail(this); // az új sínen a vonatot is eltároljuk

	if(!inFrontOfMe.HasPassenger() && HasPassenger()){
		boolean isSameColor = currentRail.CompareColors();//my color összehasonlítása
			if(isSameColor){
				System.out.println("I'm at a station, and the colors are matching - told by a carriage");
				System.out.println("So passangers, get off.. - shouted the carriage");
				currentRail.GetOffTheTrain(); // leszállnak utasok ha letudnak
				if(!HasNextTrain()){
					System.out.println("I was the last carriage, that had people on it! - said the carriage with a happy smile on its face");
					Program.EmptyTrainCounterPlusPlus();
				}
			}
		}
		//ra.AddTrainToRail();// hozzádha a kocsit a sínhez
}
}
