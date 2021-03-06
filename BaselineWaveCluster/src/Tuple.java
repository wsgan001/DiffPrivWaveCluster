

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tuple {
	private static boolean isDebug = false;
	private List<Double> values = new ArrayList<Double>();
	public int dominatingCount = 0; 
	public double[] distance;
	public double x = 0;
	public double y = 0;
	public int diffDomCount = 0;
	public double probability = 0.0;

	private static void debug(String text) {
		// TODO Auto-generated method stub
		if(isDebug){
			System.out.println(text);
		}
	}
	
	public Tuple(double[] data) {
		// TODO Auto-generated constructor stub
		values.clear();
		for(double i : data){
			values.add(i);
		}
	}

	public Tuple() {
		// TODO Auto-generated constructor stub
	}

	public Tuple(ArrayList<Object> data) {
		values.clear();
		for(Object i : data){
			values.add((Double) i);
		}
	}

	public Tuple(Object[] data) {
		values.clear();
		for(Object i : data){
			values.add((Double) i);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer("");
//        StringBuffer sb = new StringBuffer("<");
        for(double i : values){
        	sb.append(i +", ");
        }
//        sb.append(">\n");
        return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else {
			if(other == null){
				return false;
			}
			if(values.size() != other.values.size()){
				return false;
			}
			for(int i = 0;i< values.size();i++){
				if(!values.get(i).equals(other.values.get(i))){
					return false;					
				}
			}
		}
		return true;
	}

	public int size() {
		// TODO Auto-generated method stub
		return values.size();
	}

	public int dominate(Tuple otherTuple, List<Comparison> comparisons) {
		return dominate(otherTuple,comparisons.toArray(new Comparison[comparisons.size()]));
	}
	
	public int dominate(Tuple otherTuple, Comparison[] comparisons) {
		
		if(values.size() != otherTuple.size()){
			return -1;
		}
		
		boolean strickRelation = false;
		int equalTimes = 0;
		for(int i = 0;i < values.size();i++){
			Double self = values.get(i);
			Double other = otherTuple.values.get(i);
			debug("self: " + self);
			debug("other: " + other);
			Comparison comparison = null;
			if(comparisons == null){
				comparison = Comparison.MAX;
			}
			else{
				if(i < comparisons.length ){
					comparison = comparisons[i];
				}else{
				comparison = Comparison.MAX;
				}
			}
			
			debug("comparison: " + comparison);
			
			if(self.equals(other)){
				
				equalTimes++;
				debug("self == other");
				debug("equalTimes: " + equalTimes);
				debug("values: " + values.size());
				if(equalTimes == values.size()){
					debug("tuples equal! ");
					return 0;
				}
				continue;
			}
			
			if(comparison == Comparison.JOIN){
				continue;
			}
			
			if(comparison == Comparison.MAX){
				debug("inside max ");
				if(self > other){
					strickRelation = true;
					continue;
				}
				debug("begin return -1 ");
				return -1;
			}
			if(comparison == Comparison.MIN){
				if(self < other)
				{
					strickRelation = true;
					continue;
				}
				return -1;
			}			
		}
		if(strickRelation){
			return 1;
		}
		
		return -1;
	}

	public double getValue(int index) {
		// TODO Auto-generated method stub
		return values.get(index);
	}

	public List<Double> getValues() {
		// TODO Auto-generated method stub
		return values;
	}

	public void addValues(List<Double> list) {
		// TODO Auto-generated method stub
		values.addAll(list);
		
	}

	public void add(Double value) {
		// TODO Auto-generated method stub
		values.add(value);
	}
	
	
	public double computeDistance(Tuple t) throws Exception  {
		double dist = 0.0;
		if (values.size() != t.size()) {
			throw new Exception("t1.size does not equal with t2.size!");
		}

		int dim = values.size();

		for (int i = 0; i < dim; i++) {
			dist += Math.pow((values.get(i) - t.getValue(i)), 2);
		}

		dist = Math.sqrt(dist);

		return dist;
	}

	
	
}
