/***
 * Written by lina on 2013/08/20
 */

package visulization;

public class Pairs {
	
	String source;
	String target;
	
	public Pairs(String source, String target){
		this.source = source;
		this.target = target;
	}
	
	public String getSource(){
		return source;
	}
	
	public String getTarget(){
		return target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		Pairs other = (Pairs) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pairs [source=" + source + ", target=" + target + "]";
	}
	
	

}
