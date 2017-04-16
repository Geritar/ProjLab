package sheldon;

public class Engine extends TrainPart {
public Engine(){

}

	public void MoveToRail(Rail next) {

	}

	public void Move (){ // mivel a Train Part specializációja ezért a current rail segítségével el tudja dönteni hogy hova kell lépnie
        Rail nextrail;
        Rail tmp = currentRail;
        nextrail=getNextRail(currentRail); // elmentjük a következő sínt
        tmp.Clear();//lelépünk a sínről
        currentRail=nextrail; // a mozdonynak is megadjuk hogy melyik sinen áll


        if(HasNextTrain()){
            MoveToRail(tmp); // ha van mögötte kocsi azon meghívjuk a mozgatást
        }
        currentRail.AddTrainToRail(this); // a következő sínhez beállítjuk a vonatot ráléptetjük
        System.out.println("Engine starts moving the train - cho cho!");

	}
	Rail getNextRail(Rail current){
	    if(current.neighbours[0].equals(behindMe)){
	        return current.neighbours[1];
            // ha annak a sínnek amin éppen áll a mozdony egyik szomszédja megegyezik a mögötte álló kocsi aktuális sínével
            //akkor a másik lesz a következő sín
        }
        else{
            return current.neighbours[0];
            // ha annak a sínnek amin éppen áll a mozdony egyik szomszédja nem egyezik meg a mögötte álló kocsi aktuális sínével
            //akkor  ő lesz a következő sín

        }
    }
}
