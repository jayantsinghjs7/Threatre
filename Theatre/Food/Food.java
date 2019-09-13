package Food;
public class Food
{
	public String name;
	public String type;
	public int price;
	public Food(String name,int price,int t)
	{
		this.name=name;
		this.price=price;
		if(t==0)
			type="Veg";
		else
			type="Non-Veg";
	}
}