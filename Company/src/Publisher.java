import java.math.BigInteger;

import javax.xml.soap.Text;

public class Publisher {
	private BigInteger index;
	private BigInteger Rank;
	private String Publisher;
	
	
	
	public Publisher(BigInteger index, BigInteger Rank, String Publisher) {
		super();
		this.index = index;
		this.Rank = Rank;
		this.Publisher = Publisher;
	}
	
	public BigInteger getIndex() {
		return index;
	}
	
	public BigInteger getRank() {
		return Rank;
	}
	
	public String getPublisher() {
		return Publisher;
	}
	
	public void setIndex(BigInteger index) {
		this.index = index;
	}
	
	public void setRank(BigInteger Rank) {
		this.Rank = Rank;
	}
	
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	
	
	@Override
	public String toString() {
		return "Publisher [index=" + index + ", Rank=" + Rank + ", Publisher=" + Publisher + "]";
	}
	
	
	
}
