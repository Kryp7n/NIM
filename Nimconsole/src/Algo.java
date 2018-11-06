import java.util.*; 
public class Algo {
   int pile_ind;
   int stones_rmvd;
   int humstones;
   int humpile;
   
   int i,j;
   Scanner s =new Scanner(System.in);
   Random rand = new Random();
   //get input from user
   void getinp() {
	   System.out.print("Enter the index of pile: ");
	   humpile=s.nextInt();
	   System.out.print("Enter the no.of stones to be removed: ");
	   humstones=s.nextInt();
	   
   }
   
   //checking whether the game ended
   boolean TerminalPoint(int[] Piles,int n) {
	   for(i=0;i<n;i++) {
		  if(Piles[i]!=0)
			  return false;
	   }
		  return true;
   }
   
   //printing the winner during the terminal point based on current move 
   void Winner(String move) {
	   if(move.equals("Computer"))
		   System.out.println("Human Wins!");
	   else if(move.equals("Human"))
		   System.out.println("Computer Wins!");
   }
   
   //finding the xor sum of piles
   int NimberSum(int[] Piles,int n) {
	   int s=Piles[0];
	   for(i=1;i<n;i++) {
		    	s=s^Piles[i];
	   }
	   return s;
   }
   
   //doing the optimal move
   void optimal(int[] Piles,int n) {
	    int curr_sum=NimberSum(Piles,n);
	    if(curr_sum!=0) {
	    for (i=0; i<n; i++) { 
            if ((Piles[i]^curr_sum)<Piles[i]) { 
                pile_ind=i; 
                stones_rmvd=Piles[i]-(Piles[i]^curr_sum);          
                Piles[i] = (Piles[i]^curr_sum); 
                break; 
            } 
        } }
	    else {
	    	int[] PilesIndex=new int[n];

	    	for (i=0,j=0;i<n;i++) 
	            if (Piles[i]>0) {
	            	PilesIndex[j]=i;
	            	++j;
	            } 
	    	pile_ind=PilesIndex[rand.nextInt(j)];//0 to j-1 
            stones_rmvd=1+rand.nextInt(Piles[pile_ind]); //atleast 1 stone will be removed
            Piles[pile_ind]=Piles[pile_ind]-stones_rmvd; 
            
            /*if (Piles[pile_ind]<0) 
                Piles[pile_ind]=0;*/
	    }
   }
   
   //display
    void display(int[] piles,int n) 
    { 
       System.out.print("Current Game Status -> "); 
       for (i=0; i<n; i++) 
           System.out.print(" "+piles[i]);  
       System.out.println();
    }
   
   //playing the game
   void play(int[] Piles,int n,String move) {
	   System.out.println("L3ts b3gin!");
	   
	   while(!TerminalPoint(Piles,n)) {
		  display(Piles,n);
		  if(move.equals("Computer")) {
			  optimal(Piles,n);
			  int tmp=pile_ind+1;
			  System.out.println("Computer removes "+stones_rmvd+" stone from pile at index "+tmp);
			  move="Human";
		  }
		  else if(move.equals("Human")){
			  getinp();
			  Piles[humpile-1]-=humstones;
			  System.out.println("Human removes "+humstones+" stone from pile at index "+humpile);
			  move="Computer";
		  }
		       
	   }
	   display(Piles,n);
	   Winner(move);
   }
}
