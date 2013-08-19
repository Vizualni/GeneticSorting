
public class GA {
	public static int TOURNAMENT_SIZE = 50;
	public static double MUTATION_RATE = 0.002;
	
	public static Population evolve(Population population){
		Population newPopulation = new Population(population.popSize);
		for(int i=0;i<newPopulation.popSize;++i){
			Numbers mom = tournament(population);
			Numbers dad = tournament(population);

			Numbers child = crossover(mom, dad);
			//System.out.println(child);
			mutate(child);
			newPopulation.add(child);
		}
		
		return newPopulation;
	}

	private static void mutate(Numbers child) {
		for(int i=0;i<child.getSize();++i){
			if(Math.random()<=MUTATION_RATE){
				int id_first  = (int)(Math.random()*child.getSize());
				int id_second = (int)(Math.random()*child.getSize());
				
				int temp = child.getElement(id_first);
				child.setElement(id_first, child.getElement(id_second));
				child.setElement(id_second, temp);
			}
		}
		
	}

	private static Numbers crossover(Numbers mom, Numbers dad) {
		Numbers child = new Numbers();
		int start = (int)(Math.random()*mom.getSize());
		int end = (int)(Math.random()*mom.getSize());
		if(start>end){
			int tmp = start;
			start = end;
			end = tmp;
		}

		//System.out.println(start + " " + end);
		
		for(int i=start;i<=end;++i){
			child.setElement(i, mom.getElement(i));
		}
		for(int i=0;i<mom.getSize();++i){

			int part_from_dad = dad.getElement(i);
			if(!child.getData().contains(part_from_dad)){
				child.addToNextFreeSpace(part_from_dad);
			}
		}
		
		return child;
		
	}

	private static Numbers tournament(Population population) {
		Population pop = new Population(TOURNAMENT_SIZE);
		for(int i=0;i<TOURNAMENT_SIZE;++i){
			pop.add(population.getRandom());
		}
		Numbers fittest = pop.getFittest();
		return fittest;
	}
	
	

}
