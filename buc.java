import java.lang.*;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
class buc
{
public static void main(String args[])
{
int drop=0,mini,nsec,p_remain=0;
int o_rate,b_size,i,packet[];
packet = new int[100];
Scanner in = new Scanner(System.in);
System.out.println("Enter bucket size:");
b_size = in.nextInt();
System.out.println("Enter the output rate:");
o_rate = in.nextInt();
System.out.println("Enter the number of seconds you want to simulate:");
nsec = in.nextInt();
Random rand = new Random();
for(i=0;i<nsec;i++)
packet[i]=((rand.nextInt(9)+1)*10);
System.out.println("Seconds|packets received|packets sent|packets left|packets dropped");
System.out.println(".................................................................");
for(i=0;i<nsec;i++)
{
p_remain+=packet[i];
if(p_remain>b_size)
{
drop=p_remain-b_size;
p_remain=b_size;
System.out.print(i+1+"      ");
System.out.print(packet[i]+"             ");
mini=Math.min(p_remain,o_rate);
System.out.print(mini+"                  ");
p_remain=p_remain-mini;
System.out.print(p_remain+"              ");
System.out.print(drop+"                  ");
System.out.println();
drop=0;
}
}
while(p_remain!=0)
{
if(p_remain>b_size)
{
drop=p_remain-b_size;
p_remain=b_size;
}
mini=Math.min(p_remain,o_rate);
System.out.print(" "+p_remain+"        "+mini);
p_remain=p_remain-mini;
System.out.println(p_remain+"      "+drop);
drop=0;
}
}
}
