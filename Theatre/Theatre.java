import java.util.*;
import Movie.*;
import MovieCollection.*;
import Screen.*;
import Food.*;
import Canteen.*;
import Seat.*;
import Ticket.*;
class Theatre
{
	Ticket t[];
	Screen s[];
	Canteen canteen=new Canteen();
	int sl,tc=0,park=0;
	Theatre()
	{
		sl=4;tc=0;
		s=new Screen[sl];
		t=new Ticket[1440];
		s[0]=new Screen(1,2,3,4,"2A");
		s[1]=new Screen(5,3,4,1,"2B");
		s[2]=new Screen(3,4,5,2,"3A");
		s[3]=new Screen(4,1,2,5,"3B");
	}	
	void ShowPlaying()
	{
		for(int i=0;i<4;i++)
		{
			System.out.print("\n"+(i+1)+") ");
			s[i].ShowSPlaying();
		}
	}
	void booking()
	{
		Scanner sc=new Scanner(System.in);
		Food Flist[]=new Food[20];
		int o=1,o1=0,o2=0,o3=0,o4=0,b_movie=0,b_screen=0,n=0,fcount=0,pon=0,price=0;
		String b_name="0",confirm="0",po="0";
		while(o!=0)
		{
			System.out.print("\nEnter your name:");
			b_name=sc.next();
			System.out.print("Which movie would you like to go for?\n");
			ShowPlaying();
			System.out.print("\n");
			b_movie=sc.nextInt();
			b_screen=(b_movie/10)-1;
			b_movie=(b_movie%10)-1;
			if(b_screen==-1||b_movie==-1)
			{
				System.out.print("Exiting...");
				o=0;
				break;
			}
			else if(b_screen>=4||b_movie>=4)
			{
				System.out.print("Invalid entry. Try again (Enter 00 to exit menu)");
			}
			else
			{
				System.out.print("\nHow many tickets would you like to book?\n");
				n=sc.nextInt();
				if(n>10||n>(90-s[b_screen].booked[b_movie]))
				{
					System.out.print("Unable to proceed.\nYou cannot book more than 10 tickets at a time or insufficient seats left to proceed your order\n");
				}
				else
				{
					System.out.print("\nThe movie you have selected is:\n\n");
					s[b_screen].m[b_movie].ShowAllInfo();
					System.out.print("\nWould you like to proceed? (Yes/No)\n");
					confirm=sc.next();
					if(confirm.equalsIgnoreCase("Yes")||confirm.equalsIgnoreCase("Y"))
					{
						o=0;
						o1=1;
					}
				}
			}
		}
		int seat[]=new int[11];
		int r[]=new int[11];
		int c[]=new int[11];
		int scount=0;
		while(o1!=0)
		{
			s[b_screen].ShowSeats(b_movie);
			System.out.print("\n\nEnter the seat(s) you would like to book:\n");
			while(scount<n)
			{
				System.out.print("Seat "+(scount+1)+":");
				seat[scount]=sc.nextInt();
				if(99<seat[scount])
				{
					r[scount]=(seat[scount]/100)-1;
					c[scount]=(seat[scount]%100)-1;
				}
				else
				{
					r[scount]=(seat[scount]/10)-1;
					c[scount]=(seat[scount]%10)-1;
				}
				if(r[scount]>9||c[scount]>10)
				{
					System.out.print("Invalid entry...\n");
				}
				else if(r[scount]<0||c[scount]<0)
				{
					System.out.print("Exiting...");
					o1=0;
					price=0;
					break;
				}
				else if(s[b_screen].s[b_movie][r[scount]][c[scount]].vacancy!=1)
				{
					System.out.print("Seat already booked...\n");
				}
				else
				{
					int temp;
					temp=s[b_screen].m[b_movie].GetPrice(r[scount]);
					price=price+temp;
					scount++;
					s[b_screen].s[b_movie][r[scount]][c[scount]].vacancy=0;
				}
				if(scount==n)
				{
					o1=0;
					o2=1;
				}
			}
		}
		if(o2!=0)
		{
			String cc;
			int fc,fmax,oc=1;
			System.out.print("Would you like to order snacks? (Yes/No)\n");
			cc=sc.next();
			switch(cc)
			{
				case "Y":
				case "y":
				case "yes":
				case "YES":
				case "Yes":
				{
					fmax=canteen.ShowMenu();
					while(oc==1)
					{
						System.out.print("Enter your choice(0 to exit):");
						fc=sc.nextInt();
						if(fc>fmax)
						{
							System.out.print("Invalid entry...\n");
						}
						else if(fc==0)
						{
							oc=0;
							o2=0;
							o3=1;
						}
						else
						{
							int oprice,otype,nocn;
							String oname,ocn="0";
							System.out.print("Quanity:");
							nocn=sc.nextInt();
							ocn=String.format("%d",nocn);
							oprice=canteen.GetPrice(fc-1)*nocn;
							oname=canteen.GetName(fc-1).concat("x").concat(ocn);
							otype=canteen.GetType(fc-1);
							Flist[fcount]=new Food(oname,oprice,otype);
							price=price+oprice;
							fcount++;
						}
					}
					break;
				}
				default:
				{
					o2=0;
					o3=1;
					break;
				}
			}
		}
		if(o3!=0&&park<200)
		{
			System.out.print("\nWould you like to book for parking? (Yes/No)\n");
			po=sc.next();
			if(po.equalsIgnoreCase("yes")||po.equalsIgnoreCase("y"))
			{
				park++;
				price=price+150;
				pon=1;
			}
			o4=1;
		}
		if(o3!=0&&park>200)
		{
			o4=1;
		}
		if(o4==1)
		{	
			while(o4!=0)
			{
				System.out.print("\nProcessing...\n\nOrder ready for checkout\n\nPrice:"+price+"\n\nConfirm? (Yes/No)\n");
				confirm=sc.next();
				if(confirm.equalsIgnoreCase("Yes")||confirm.equalsIgnoreCase("Y"))
				{
					System.out.print("\nGenerating ticket...\n");
					t[tc]=new Ticket(b_name,s[b_screen].m[b_movie].name,s[b_screen].name,n,fcount,pon,price);
					for(int i=0;i<fcount;i++)
					{
						t[tc].GetFList(Flist[i]);
					}
					for(int i=0;i<scount;i++)
					{
						t[tc].GetSeat(seat[i]);
						s[b_screen].booked[b_movie]++;
						s[b_screen].s[b_movie][r[i]][c[i]].vacancy=0;
						
					}
					System.out.print("Your ticket has been booked successfully\n\n");
					t[tc].ShowInfo();
					tc=tc+n;
					o4=0;
				}
				else if(confirm.equalsIgnoreCase("no")||confirm.equalsIgnoreCase("n"))
				{
					System.out.print("Exiting...");
					price=0;
					o4=0;
				}
				else
				{
					System.out.print("Wrong entry. Try again");
				}
			}
		}
	}
	void AdminFunc()
	{
		Scanner sc=new Scanner(System.in);
		int Aom=1,Ao,cm;
		String confirm;
		while(Aom==1)
		{
			System.out.print("What would you like to do?\n1.Change playing list\n2.Add new movie to theatre\n3.Add new foods to canteen\n4.Show all tickets\n5.Delete a movie\n6.Delete item from canteen\n7.Abort\n\n");
			Ao=sc.nextInt();
			if(Ao==1)
			{
				System.out.print("Which screen should be changed?(Enter the screen numner):\n");
				ShowPlaying();
				cm=sc.nextInt();
				s[cm-1].Change();
			}
			else if(Ao==2)
			{
				String newname,newgenre,newdesc;
				int newpg,newps,newpr;
				System.out.print("Name:");
				newname=sc.next();
				System.out.print("Genre:");
				newgenre=sc.next();
				System.out.print("Price of the tickets:\nGold:");
				newpg=sc.nextInt();
				System.out.print("Silver:");
				newps=sc.nextInt();
				System.out.print("Regular:");
				newpr=sc.nextInt();
				System.out.print("Description:\n");
				newdesc=sc.nextLine();
				System.out.print("\nName:"+newname+"\nGenre:"+newgenre+"\n\nPrice of tickets:\nGold:"+newpg+"\nSilver:"+newps+"\nRegular:"+newpr+"\n\n"+newdesc);
				System.out.print("\n\nConfirm? (Yes/No)\n");
				confirm=sc.next();
				if(confirm.equalsIgnoreCase("yes")||confirm.equalsIgnoreCase("y"))
				{
					for(int i=0;i<sl;i++)
					{
						s[i].mc.GetEntry(newname,newgenre,newpg,newps,newpr,newdesc);
						System.out.print("\nProcessing..\nSuccessfully added..\n");
					}
				}
				else
				{
					System.out.print("Cancelled process..\n");
				}
			}
			else if(Ao==3)
			{
				canteen.AddFood();
			}
			else if(Ao==4)
			{
				for(int i=0;i<tc;i=i+t[i].scounter)
				{
					t[i].ShowInfo();
					System.out.print("\n");
				}
				System.out.print("\n\n");
			}
			else if(Ao==5)
			{
				int delo;
				System.out.print("Enter the movie to be deleted(make sure this movie isn't being played in any of the screens):");
				s[0].mc.ShowCollection();
				delo=sc.nextInt();
				for(int i=0;i<sl;i++)
				{
					s[i].mc.DeleteEntry(delo);
				}
				System.out.print("Movie has been deleted.");
			}
			else if(Ao==6)
			{
				int delc;
				System.out.print("Which item must be deleted:\n");
				canteen.ShowMenu();
				delc=sc.nextInt();
				canteen.DelFood(delc);
			}
			else if(Ao==7)
			{
				System.out.print("Exiting...");
				Aom=0;
			}
			else
			{
				System.out.print("Invalid entry... try again...");
			}
		}
	}
}
class run
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		Theatre T=new Theatre();
		int om=1,o1;
		System.out.print("\n\nWelcome...what would you like to do?\n");
		while(om!=0)
		{
			System.out.print("\n1.Show all movies playing\n2.Book a movie\n3.Exit\n\n");
			o1=sc.nextInt();
			switch(o1)
			{
				case 1:
				{
					T.ShowPlaying();
					break;
				}
				case 2:
				{
					T.booking();
					break;
				}
				case 3:
				{
					om=0;
					break;
				}
				case 16:
				{
					T.AdminFunc();
					break;
				}
				default:
				{
					System.out.print("Wrong entry..Try again..");
					break;
				}
			}
		}
	}
}