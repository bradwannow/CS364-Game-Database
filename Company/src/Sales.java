import java.math.BigInteger;

public class Sales {
	private BigInteger index;
	private BigInteger Rank;
	private Float Total_Shipped;
	private Float Global_Sales;
	private Float NA_Sales;
	private Float PAL_Sales;
	private Float JP_Sales;
	private Float Other_Sales;
	
	
	public Sales(BigInteger index, BigInteger Rank, Float Total_Shipped, Float Global_Sales, Float NA_Sales, Float PAL_Sales, Float JP_Sales, Float Other_Sales) {
		this.index = index;
		this.Rank = Rank;
		this.Total_Shipped = Total_Shipped;
		this.Global_Sales = Global_Sales;
		this.NA_Sales = NA_Sales;
		this.PAL_Sales = PAL_Sales;
		this.JP_Sales = JP_Sales;
		this.Other_Sales = Other_Sales;
	}
	
	
	public BigInteger getIndex() {
		return index;
	}
	
	public BigInteger getRank() {
		return Rank;
	}
	
	public Float getTotal_Shipped() {
		return Total_Shipped;
	}
	
	public Float getGlobal_Sales() {
		return Global_Sales;
	}
	
	public Float getNA_Sales() {
		return NA_Sales;
	}
	
	public Float getPAL_Sales() {
		return PAL_Sales;
	}
	
	public Float getJP_Sales() {
		return JP_Sales;
	}
	
	public Float getOther_Sales() {
		return Other_Sales;
	}
	
	
	public void setIndex(BigInteger index) {
		this.index = index;
	}
	
	public void setRank(BigInteger Rank) {
		this.Rank = Rank;
	}
	
	public void setTotal_Shipped(Float Total_Shipped) {
		this.Total_Shipped = Total_Shipped;
	}
	
	public void setGlobal_Sales(Float Global_Sales) {
		this.Global_Sales = Global_Sales;
	}
	
	public void setNA_Sales(Float NA_Sales) {
		this.NA_Sales = NA_Sales;
	}
	
	public void setPAL_Sales(Float PAL_Sales) {
		this.PAL_Sales = PAL_Sales;
	}
	
	public void setJP_Sales(Float JP_Sales) {
		this.JP_Sales = JP_Sales;
	}
	
	public void setOther_Sales(Float Other_Sales) {
		this.Other_Sales = Other_Sales;
	}
	
	@Override
	public String toString() {
		return "Sales [index=" + index + ", Rank=" + Rank + ", TotalShipped=" + Total_Shipped + ", GlobalSales=" + Global_Sales + ", NASales=" + NA_Sales
				+ ", PALSales" + PAL_Sales + ", JPSales=" + JP_Sales + ", OtherSales=" + Other_Sales   + "]";
	}
	

}
