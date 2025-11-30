import java.util.*;
class bucket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter bucket size: ");
        int bsize = in.nextInt();
        System.out.print("Enter output rate: ");
        int rate = in.nextInt();
        System.out.print("Enter number of seconds: ");
        int n = in.nextInt();
        int drop = 0, remain = 0;
        Random r = new Random();
        int packets[] = new int[n];
        for(int i=0;i<n;i++)
            packets[i] = (r.nextInt(9)+1)*10;
        System.out.println("Sec | Recv | Sent | Left | Drop");
        System.out.println("-------------------------------");
        for(int i=0;i<n;i++){
            remain += packets[i];
            if(remain > bsize){
                drop = remain - bsize;
                remain = bsize;
            }
            int sent = Math.min(remain, rate);
            remain -= sent;
            System.out.println((i+1)+"   "+packets[i]+"     "+sent+"     "+remain+"     "+drop);
            drop = 0;
        }
        while(remain > 0){
            int sent = Math.min(remain, rate);
            remain -= sent;
            System.out.println("    -     "+sent+"     "+remain);
        }
    }
}