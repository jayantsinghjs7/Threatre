package Screen;
import Movie.*;
import MovieCollection.*;
import Seat.*;
import java.util.*;
public class Screen
{
	Scanner sc=new Scanner(System.in);
	public MovieCollection mc;
	public String name;
	public Seat s[][][]=new Seat[4][9][10];
	public int booked[]=new int[4];
	public Movie m[]=new Movie[4];
	int op,op2;
	public Screen(int a,int b,int c,int d,String name)
	{
		mc=new MovieCollection();
		this.name=name;
		m[0]=mc.SendEntry(a);
		m[1]=mc.SendEntry(b);
		m[2]=mc.SendEntry(c);
		m[3]=mc.SendEntry(d);
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<9;j++)
			{
				for(int k=0;k<10;k++)
				{
					s[i][j][k]=new Seat();
				}
			}
		}
	}
	public Screen()
	{
		m[0]=mc.SendEntry(0);
		m[1]=mc.SendEntry(0);
		m[2]=mc.SendEntry(0);
		m[3]=mc.SendEntry(0);
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<9;i++)
			{
				for(int k=0;k<10;j++)
				{
					s[i][j][k]=new Seat();
				}
			}
		}
	}
	String GetTime(int n)
	{
		switch(n)
		{
			case 0:
			{
				return "9AM";
			}
			case 1:
			{
				return "2PM";
			}
			case 2:
			{
				return "6PM";
			}
			case 3:
			{
				return "9PM";
			}
			default:
			{
				return "Error.";
			}
		}
	}
	public void ShowSPlaying()
	{
		System.out.print(name+"\n");
		for(int i=0;i<4;i++)
		{
			System.out.print(i+1+".");
			System.out.print(GetTime(i)+": ");
			m[i].ShowInfo();
			if(booked[i]==90)
			{
				System.out.print("\t[HOUSE FULL]\n");
			}
			else
			{
				System.out.print("\t["+(90-booked[i])+"]\n");
			}
		}
	}
	public void Change()
	{
		System.out.print("Enter the movie to be changed:\n");
		ShowSPlaying();
		op=sc.nextInt();
		System.out.print("Enter the movie which should be played instead:\n");
		mc.ShowCollection();
		op2=sc.nextInt();
		m[op-1]=mc.SendEntry(op2);
	}
	public void ShowSeats(int n)
	{
		int i,j;
		System.out.print(" ");
		for(int r=0;r<10;r++)
		{
			System.out.printf("%4d",(r+1));
		}
		System.out.print("\n");
		for(int r=0;r<11;r++)
		{
			System.out.printf("%4s","----");
		}
		for(i=0;i<9;i++)
		{
			String X="X",O="O";
			System.out.printf("\n%-2d%-2s",(i+1),"|");
			for(j=0;j<10;j++)
			{
				if(s[n][i][j].vacancy==1)
					System.out.printf("%-4s",O);
				else
					System.out.printf("%-4s",X);
			}
		if(i<3)
			System.out.print("Regular");
		else if(i<6)
			System.out.print("Silver");
		else if(i<9)
			System.out.print("Gold");
		}
	}
}