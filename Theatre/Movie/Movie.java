package Movie;
import java.util.*;
public class Movie
{
	public String name;
	String genre,desc;
	int price_g,price_s,price_r,runs=0;
	Scanner sc=new Scanner(System.in);
	public void GetInfo()
	{
		System.out.print("Enter the name:");
		name=sc.next();
		System.out.print("Enter the genre:");
		genre=sc.next();
		System.out.print("Enter the description:");
		desc=sc.next();
		System.out.print("Enter the price of the tickets (Gold, Silver, Regular)\n");
		price_g=sc.nextInt();
		price_s=sc.nextInt();
		price_r=sc.nextInt();
	}
	public void ShowAllInfo()
	{
		System.out.print("Name:"+name+"\nGenre:"+genre+"\n\n"+desc+"\n\n");
		System.out.print("Prices of tickets in all the plans:\n");
		System.out.print("Gold: "+price_g+"\n");
		System.out.print("Silver: "+price_s+"\n");
		System.out.print("Regular: "+price_r+"\n");
	}
	public void ShowInfo()
	{
		String temp=name+"("+genre+")";
		System.out.printf("%-70s",temp);
	}
	public int GetPrice(int n)
	{
		if(n<3)
			return price_r;
		else if(n<6)
			return price_s;
		else
			return price_g;
	}
	public Movie()
	{
		GetInfo();
	}
	public Movie(String name,String genre,int price_g,int price_s,int price_r,String desc)
	{
		this.name=name;
		this.genre=genre;
		this.price_g=price_g;
		this.price_s=price_s;
		this.price_r=price_r;
		this.desc=desc;
	}
}