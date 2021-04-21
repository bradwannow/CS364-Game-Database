import java.math.BigInteger;

import javax.xml.soap.Text;

public class Rating {
	private BigInteger index;
	private BigInteger Rank;
	private String ESRB_Rating;
	private Float Critic_Score;
	private Float User_Score;
	
	
public Rating(BigInteger index, BigInteger Rank, String ESRB_Rating, Float Critic_Score, Float User_Score) {
	this.index = index;
	this.Rank = Rank;
	this.ESRB_Rating = ESRB_Rating;
	this.Critic_Score = Critic_Score;
	this.User_Score = User_Score;
}


public BigInteger getIndex() {
	return index;
}


public void setIndex(BigInteger index) {
	this.index = index;
}


public BigInteger getRank() {
	return Rank;
}


public void setRank(BigInteger rank) {
	this.Rank = rank;
}


public String getESRB_Rating() {
	return ESRB_Rating;
}


public void setESRB_Rating(String eSRB_Rating) {
	this.ESRB_Rating = eSRB_Rating;
}


public Float getCritic_Score() {
	return Critic_Score;
}


public void setCritic_Score(Float critic_Score) {
	this.Critic_Score = critic_Score;
}


public Float getUser_Score() {
	return User_Score;
}


public void setUser_Score(Float user_Score) {
	this.User_Score = user_Score;
}
	

@Override
public String toString() {
	return "Rating [index=" + index + ", Rank=" + Rank + ", ESRB_Rating=" + ESRB_Rating + ", Critic_Score=" + Critic_Score + ", User_Score=" + User_Score  + "]";
}
	

}
