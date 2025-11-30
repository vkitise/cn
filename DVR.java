import java.util.*;
class DVR {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("Enter number of nodes: ");
int n = in.nextInt();
int d[][] = new int[n][n];
int dist[][] = new int[n][n];
int via[][] = new int[n][n];
System.out.println("Enter cost matrix:");
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
d[i][j] = in.nextInt();
if(i==j) d[i][j] = 0;    
dist[i][j] = d[i][j];     
via[i][j] = j;           
}
}
int change;
do {
change = 0;
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
for(int k=0;k<n;k++){
if(dist[i][j] > dist[i][k] + dist[k][j]){
dist[i][j] = dist[i][k] + dist[k][j];
via[i][j] = k;
change = 1;  
}
}
}
}
} while(change == 1);
for(int i=0;i<n;i++){
System.out.println("State value for router " + i + ":");
for(int j=0;j<n;j++){
System.out.println("To " + j + " - Via " + via[i][j] +  " distance is " + dist[i][j]);
}
}
}
}