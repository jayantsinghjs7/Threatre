package MovieCollection;
import Movie.*;
public class MovieCollection
{
	int ml=5;
	Movie m[]=new Movie[200];
	public MovieCollection()
	{
		m[0]=new Movie("NIL","NIL",0,0,0,"NIL");
		m[1]=new Movie("IT:Chapter 2","Horror",1100,850,600,"The evil clown Pennywise returns 27 years later to torment the grown-up members of the Losers' \nClub.");
		m[2]=new Movie("The Lego Movie 2: The Second Part","Animation",1350,1100,850,"The citizens of Bricksburg face a dangerous new threat when LEGO DUPLO invaders from outer \nspace start to wreck everything. It's now up to Emmet, Lucy, Batman and their friends to \ndefeat the giant marauders and restore harmony to the LEGO universe.");
		m[3]=new Movie("MIB","Science Fiction/Action",1100,850,600,"MIB is an upcoming American science fiction action comedy film directed by F. Gary Gray \nfrom a screenplay written by Art Marcum and Matt Holloway. The film is a spin-off of the \nMen in Black film series, which is loosely based on the Malibu/Marvel comics of the same \nname by Lowell.");
		m[4]=new Movie("The Secret Life of Pets 2","Adventure/Comedy",1150,800,550,"The Secret Life of Pets 2 will follow summer 2016's blockbuster about the lives our \npets lead after we leave for work or school each day.");
		m[5]=new Movie("Pet Sematary","Thriller/Horror",1100,900,550,"Dr. Louis Creed and his wife, Rachel, relocate from Boston to rural Maine with their two \nyoung children. The couple soon discover a mysterious burial ground hidden deep in the woods \nnear their new home. When tragedy strikes, Louis turns to his neighbor Jud Crandall, setting \noff a perilous chain reaction that unleashes an unspeakable evil with horrific consequences.");
	}
	public Movie SendEntry(int n)
	{
		if((n<=ml)&&(n!=0))
		{
			return m[n];
		}
		else
		{
			return m[0];
		}
	}
	public void GetEntry(String name,String genre, int pg,int ps,int pr,String desc)
	{
		ml++;
		m[ml]=new Movie(name,genre,pg,ps,pr,desc);
	}
	public void DeleteEntry(int n)
	{
		for(int i=n;i<=(ml-1);i++)
		{
			m[i]=m[i+1];
		}
		ml--;
	}
	public void ShowCollection()
	{
		for(int i=1;i<=ml;i++)
		{
			System.out.print("\n"+i+".");
			m[i].ShowInfo();
		}
		System.out.print("\n");
	}
}