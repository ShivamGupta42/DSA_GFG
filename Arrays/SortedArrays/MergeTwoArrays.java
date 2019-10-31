package SortedArrays;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MergeTwoArrays {

	 static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 static class Reader 
	     { 
	         final private int BUFFER_SIZE = 1 << 16; 
	         private DataInputStream din; 
	         private byte[] buffer; 
	         private int bufferPointer, bytesRead; 
	   
	         public Reader() 
	         { 
	             din = new DataInputStream(System.in); 
	             buffer = new byte[BUFFER_SIZE]; 
	             bufferPointer = bytesRead = 0; 
	         } 
	   
	         public Reader(String file_name) throws IOException 
	         { 
	             din = new DataInputStream(new FileInputStream(file_name)); 
	             buffer = new byte[BUFFER_SIZE]; 
	             bufferPointer = bytesRead = 0; 
	         } 
	   
	         public String readLine() throws IOException 
	         { 
	             byte[] buf = new byte[64]; // line length 
	             int cnt = 0, c; 
	             while ((c = read()) != -1) 
	             { 
	                 if (c == '\n') 
	                     break; 
	                 buf[cnt++] = (byte) c; 
	             } 
	             return new String(buf, 0, cnt); 
	         } 
	   
	         public int nextInt() throws IOException 
	         { 
	             int ret = 0; 
	             byte c = read(); 
	             while (c <= ' ') 
	                 c = read(); 
	             boolean neg = (c == '-'); 
	             if (neg) 
	                 c = read(); 
	             do
	             { 
	                 ret = ret * 10 + c - '0'; 
	             }  while ((c = read()) >= '0' && c <= '9'); 
	   
	             if (neg) 
	                 return -ret; 
	             return ret; 
	         } 
	   
	         
	   
	         
	         private void fillBuffer() throws IOException 
	         { 
	             bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
	             if (bytesRead == -1) 
	                 buffer[0] = -1; 
	         } 
	   
	         private byte read() throws IOException 
	         { 
	             if (bufferPointer == bytesRead) 
	                 fillBuffer(); 
	             return buffer[bufferPointer++]; 
	         } 
	   
	         public void close() throws IOException 
	         { 
	             if (din == null) 
	                 return; 
	             din.close(); 
	         } 
	     } 

	 	public static void main(String[] args) throws IOException{
	 		Reader scan = new Reader();
	 		int T = 1;//scan.nextInt();

	 		while (T > 0) {
	 			T--;

	 			int n1 = 6;// scan.nextInt();
	 			int n2 = 4;//scan.nextInt();
	 			int[] arr1 = {1,5,9,10,15,20};
	 			int[] arr2 = {2,3,8,13};

	 			
	 			
	 			int k1=0;
	 			int k2=0;
	 			
	 			while(k1<n1&&k2<n2) {
	 			    
	 				if(arr1[k1]<arr2[k2]) {
	 					bw.write(arr1[k1++]+" ");
	 				}
	 				
	 				else {
	 					bw.write(arr2[k2++]+" ");
	 				}
	 			}//end of loop
	 		
	 		    if(k1<n1){
	 		        while(k1<n1){
	 		            	bw.write(arr1[k1++]+" ");
	 		        }
	 		    }
	 			
	 			if(k2<n2){
	 		        while(k2<n2){
	 		            	bw.write(arr2[k2++]+" ");
	 		        }
	 		    }
	 		    
	 		    bw.write("\n");
	             bw.flush();
	 		}

	 	}
	 	
}
