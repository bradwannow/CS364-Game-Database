import java.math.BigInteger;

import javax.xml.soap.Text;

public class Developer {
	private BigInteger index;
	private BigInteger Rank;
	private String Developer;
	
	public Developer(BigInteger index, BigInteger Rank, String Developer) {
		super();
		this.index = index;
		this.Rank = Rank;
		this.Developer = Developer;
	}
	
	
	public BigInteger getIndex() {
		return index;
	}
	
	public BigInteger getRank() {
		return Rank;
	}
	
	public String getDeveloper() {
		return Developer;
	}
	
	public void setIndex(BigInteger index) {
		this.index = index;
	}
	
	public void setRank(BigInteger Rank) {
		this.Rank = Rank;
	}
	
	public void setPublisher(String Developer) {
		this.Developer = Developer;
	}
	
	
	@Override
	public String toString() {
		return "Developer [index=" + index + ", Rank=" + Rank + ", Developer=" + Developer + "]";
	}
	
	
}
