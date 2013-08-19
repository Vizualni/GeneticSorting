/*
 * Created by Matija Martinic.
 * It's a simple example of using genetic algorithms.
 * Although it's not the best solution to sort numbers but it's cool way of doing it.
 * 
 * */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Population init_population = new Population(1000);
		init_population.init();
		
		int generation = 0;
		Numbers fittest;
		while((fittest=init_population.getFittest()).getFitness()!=0.0){
			generation++;
			init_population = GA.evolve(init_population);
			System.out.println("Gen: "+generation + " Fitness: "+fittest.getFitness());
			//System.out.println(fittest);
		}
		
		System.out.println("Found solution at generation "+generation);
		System.out.println(fittest);
	}

}
