import java.math.BigInteger;

import javax.xml.soap.Text;

public class Game {
	private BigInteger index;
	private BigInteger Rank;
	private String Name;
	private String Platform;
	private String Genre;
	private Float Year;
	
	
	
public Game(BigInteger index, BigInteger Rank, String Name, String Platform, String Genre, Float Year) {
	this.index = index;
	this.Rank = Rank;
	this.Name = Name;
	this.Platform = Platform;
	this.Genre = Genre;
	this.Year = Year;
}

public Game(BigInteger Rank, String Name, String Platform, String Genre, Float Year) {
	this.index = null;
	this.Rank = Rank;
	this.Name = Name;
	this.Platform = Platform;
	this.Genre = Genre;
	this.Year = Year;
}

public Game(String Name, String Platform, String Genre, Float Year) {
	final int MINIMUM = 70000;
	BigInteger tempRank = BigInteger.valueOf((long) (Math.random() + MINIMUM));
	this.index = null;
	this.Rank = tempRank;
	this.Name = Name;
	this.Platform = Platform;
	this.Genre = Genre;
	this.Year = Year;
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
	Rank = rank;
}



public String getName() {
	return Name;
}



public void setName(String name) {
	Name = name;
}



public String getPlatform() {
	return Platform;
}



public void setPlatform(String platform) {
	Platform = platform;
}



public String getGenre() {
	return Genre;
}



public void setGenre(String genre) {
	Genre = genre;
}



public Float getYear() {
	return Year;
}



public void setYear(Float year) {
	Year = year;
}


@Override
public String toString() {
	return "Game [index=" + index + ", Rank=" + Rank + ", Name=" + Name + ", Platform=" + Platform + ", Genre=" + Genre
			+ ", Year" + Year + "]";
}
	
}
