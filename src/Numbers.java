import java.util.ArrayList;
import java.util.Collections;


public class Numbers {
	private int size=100;
	private ArrayList <Integer> data;
	private int RAND_MAX=100;
	double fitness = -1;

	public Numbers(){
		this.data = new ArrayList<Integer>(size);
		for(int i=0;i<this.size;++i){
			this.data.add(null);
		}
	}
	
	public void create(){
		/*it's easier to do this like this*/
		for(int i=0;i<this.size;++i){
			this.data.set(i,i);
		}
		Collections.shuffle(data);
	}

	public int getSize() {
		return size;
	}

	public void setElement(int index, int element){
		this.data.set(index, element);
	}
	
	public int getElement(int index){
		return this.data.get(index);
	}
	
	public ArrayList<Integer> getData() {
		return data;
	}
	
	public void addToNextFreeSpace(int element){
		int first = this.data.indexOf(null);
		this.data.set(first, element);
	}

	@Override
	public String toString(){
		String ret="";
		for(Integer i: data){
			if(i==null){
				ret += "null"+ " ";
			}else{
				ret += i.toString()+ " ";
			}
		}
		return ret;
	}
	
	
	/*
	 * Less is better :P
	 * */
	public double getFitness(){
		return heuristics3();
		
	}
	
	
	/*
	 * It was made by mistake but it works great :D.
	 * */
	public double heuristics3(){
		if(fitness!=-1)
			return fitness;
		int sum = 0;
		for(Integer i: this.data){
			sum +=i;
		}
		int j=1;
		int new_sum=0;
		int temp_sum = 0;
		
		for(int i=0;i<size-1;++i){
			if(data.get(i)<data.get(i+1)){
				new_sum += j*temp_sum;
				j++;
				temp_sum = 0;
			}else{
				temp_sum += data.get(i);
			}
		}
		new_sum += temp_sum;
		//System.out.println(sum +" "+new_sum);
		return (double)new_sum/sum;
		
	}
	
	public double heuristics2(){
		if(fitness!=-1)
			return fitness;
		int k=size;
		int i=0,j=0;
		int average = 0;
		while(k>0){
			while(i==j){
				i = (int)(Math.random()*this.size);
				j = (int)(Math.random()*this.size);
			}
			if(this.data.get(Math.min(i, j))<this.data.get(Math.max(i, j))){
				average++;
			}
			k--;
		}
		this.fitness = (double)1/average;
		return this.fitness;
	}
	
	public double heuristics1(){
		if(this.fitness!=-1)
			return fitness;
		int count = 0; //
		for(int i=0;i<size-1;++i){

			if(data.get(i)==null || data.get(i+1)==null){System.out.println("NULLLL");return 0.0;}
			if(data.get(i)>data.get(i+1))
				count++;
		}
		fitness = (double)count/size;
		return fitness;
	}

}
