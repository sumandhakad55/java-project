import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int n=sc.nextInt();
		int a=new int[3];
		
		int count=0;
		
		while(t-->0){
		    for(int i=0;i<3;i++){
		    a[i]=sc.nextInt();
		    if(a[i]!=n){
		        count+=(n-a[i]);
		    }
		}
		}
		System.out.println(count);

	}
}
