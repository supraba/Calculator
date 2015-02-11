import java.io.*;
class MyThread implements Runnable{
	int st,en;
	static LineNumberReader lmr1;
	static BufferedWriter bw;
        MyThread(int s,int e){
		st=s;
		en=e;
	} 
	public void run(){

		try{
			
				bw=new BufferedWriter(new FileWriter("EmpWritten.txt"));
                        	lmr1=new LineNumberReader(new FileReader("out3.txt"));
				String s=Thread.currentThread().getName();
                        	lmr1.skip(st);
				while(st++<en){
						bw.write(s+"\t"+lmr1.readLine());
						bw.newLine();
					
				}
				//bw.flush();//lmr1.flush();
			}
		catch(Exception e){
			e.printStackTrace();
		}	
	}
	void cleanup(){
		try{
			lmr1.close();
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
class FileDemoThreads{
	public static void main(String args[])throws Exception{
		LineNumberReader lmr=new LineNumberReader(new FileReader("out3.txt"));
		lmr.skip(Long.MAX_VALUE);
		int num=lmr.getLineNumber();
		int num1=num/3,num2=2*num1;
		
		MyThread mt1=new MyThread(0,num1);
		MyThread mt2=new MyThread(num1+1,num2);
		MyThread mt3=new MyThread(num2+1,num);
	
		Thread t1=new Thread(mt1);
		Thread t2=new Thread(mt2);
		Thread t3=new Thread(mt3);

		t1.start();
		t2.start();
		t3.start();	

				
		
		mt1.cleanup();
		mt2.cleanup();
		mt3.cleanup();lmr.close();


	}
}
