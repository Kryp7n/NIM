import java.util.*;
public class Game {
	public static void main(String[] args) {
		Algo a= new Algo();
		Scanner s =new Scanner(System.in);
		int n,i;
		String choice;
		System.out.print("Enter the no.of piles: ");
		n=s.nextInt();
		
		System.out.print("Enter the no.of stones: ");
		int[] Piles=new int[n];
		for(i=0;i<n;i++) {
			Piles[i]=s.nextInt();
		}
		System.out.print("Do you want to start first:(yes/no):");
		choice=s.next();
		if(choice.equals("yes"))
		   a.play(Piles,n,"Human");
		else
		   a.play(Piles,n,"Computer");	
	}

}
