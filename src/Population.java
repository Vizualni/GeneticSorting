import java.util.ArrayList;


public class Population {
	int popSize;
	int numSize;
	ArrayList <Numbers> residents;
	
	public Population(int popSize){
		this.popSize = popSize;

		residents = new ArrayList<Numbers>(popSize);
		
	}
	
	public void init(){
		for(int i=0;i<popSize;++i){
			Numbers num = new Numbers();
			num.create();
			residents.add(num);
		}
	}
	
	public Numbers getRandom(){
		return residents.get((int)(Math.random()*popSize));
	}
	
	public Numbers getFittest(){
		Numbers fittest = residents.get(0);
		for(int i=0;i<popSize;++i){
			if(residents.get(i).getFitness()<fittest.getFitness())
				fittest = residents.get(i);
		}
		return fittest;
	}

	public void add(Numbers child) {
		this.residents.add(child);
		
	}

}
