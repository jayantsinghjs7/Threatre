package Ticket;
import Canteen.*;
import Food.*;
public class Ticket
{
	String name,s_name,m_name;
	int n,fcount,po,fcounter=0,price;
	public int scounter=0;
	int seats[]=new int[10];
	Food flist[]=new Food[30];
	public Ticket(String name,String m_name,String s_name,int n,int fcount,int po,int price)
	{
		this.name=name;
		this.m_name=m_name;
		this.s_name=s_name;
		this.n=n;
		this.fcount=fcount;
		this.po=po;
		this.price=price;
	}
	public void GetFList(Food f)
	{
		flist[fcounter]=f;
		fcounter++;
	}
	public void GetSeat(int s)
	{
		seats[scounter]=s;
		scounter++;
	}
	public void ShowInfo()
	{
		System.out.printf("|------------------------------|\n");
		System.out.printf("|%-30s|\n"," Name:"+name);
		System.out.printf("|%-30s|\n"," ");
		System.out.printf("|%-30s|\n"," Movie:"+m_name);
		System.out.printf("|%-30s|\n"," Room No.:"+s_name);
		System.out.printf("|%-30s|\n"," ");
		System.out.printf("|%-30s|\n"," Seats:");
		for(int i=0;i<n;i++)
		{
			System.out.printf("|%-30s|\n"," -"+seats[i]);
		}
		System.out.printf("|%-30s|\n"," ");
		if(fcount!=0)
		{
			System.out.printf("|%-30s|\n"," Foods:");
			for(int i=0;i<fcount;i++)
			{
				System.out.printf("|%-30s|\n"," -"+flist[i].name);
			}
		}
		if(po==1)
		{
			System.out.printf("|%-30s|\n"," ");
			System.out.printf("|%-30s|\n"," Paid for parking.");
		}
		System.out.print("|------------------------------|\n");
	}
}