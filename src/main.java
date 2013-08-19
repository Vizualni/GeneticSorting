
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Population init_population = new Population(500);
		init_population.init();
		
		int generation = 0;
		Numbers fittest;
		while((fittest=init_population.getFittest()).getFitness()!=0.0){
			generation++;
			init_population = GA.evolve(init_population);
			System.out.println("Gen: "+generation + " Fitness: "+fittest.getFitness());
			System.out.println(fittest);
		}
		
		System.out.println("Found solution at generation "+generation);
		System.out.println(fittest);
	}

}
