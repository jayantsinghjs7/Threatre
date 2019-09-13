package Canteen;
import java.util.*;
import Food.*;
public class Canteen
{
	Scanner sc=new Scanner(System.in);
	Food f[]=new Food[20];
	int fl=10;
	public Canteen()
	{
		f[0]=new Food("Popcorn[Medium]",40,0);
		f[1]=new Food("Popcorn[Small]",25,0);
		f[2]=new Food("Chips",35,0);
		f[3]=new Food("Nachos",65,0);
		f[4]=new Food("Coke[M]",50,0);
		f[5]=new Food("Coke[S]",30,0);
		f[6]=new Food("Hot dogs",60,1);
		f[7]=new Food("Pretzels",50,0);
		f[8]=new Food("Pizza",90,1);
		f[9]=new Food("Sweet tarts",30,0);
	}
	public void AddFood()
	{
		String name;
		int type,n,price;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the name of the food item:");
		name=sc.next();
		System.out.print("Enter the price of the item:");
		price=sc.nextInt();
		System.out.print("Is it\n1.Veg\n2.Non-Veg\n");
		n=sc.nextInt();
		f[fl]=new Food(name,price,n);
		fl++;
	}
	public void DelFood(int c)
	{
		for(int i=(c-1);i<fl-1;i++)
		{
			f[i]=f[i+1];
		}
		fl--;
	}
	public int ShowMenu()
	{
		String tempname="Name",tempprice="Price",temptype="Type";
		System.out.printf("  %-15s %-15s %-15s %n",tempname,temptype,tempprice);
		for(int i=0;i<fl;i++)
		{
			System.out.printf("%2d %-15s %-15s %d %n",i+1,f[i].name,f[i].type,f[i].price);
		}
		System.out.print("\n");
		return fl;
	}
	public String GetName(int n)
	{
		return f[n].name;
	}
	public int GetPrice(int n)
	{
		return f[n].price;
	}
	public int GetType(int n)
	{
		int t;
		if(f[n].type.equals("Veg"))
			t=0;
		else
			t=1;
		return t;
	}
}