import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class Calculator extends JFrame implements ActionListener
{
	
	JPanel jp[]=new JPanel[5];
	JButton jb[]=new JButton[16];
	JTextField jt1=new JTextField();
	JTextField jt2=new JTextField();
	Calculator(){
		//setResizable(false);
		setVisible(true);
		setLocation(200,200);
		setSize(250,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,1));
		setTitle("Calculator");
		
		Font font1=new Font("Sans_Serif",Font.BOLD,16);
		Font font2=new Font("Sans_Serif",Font.BOLD,32);
		jt1.setFont(font1);jt2.setFont(font2);



		jp[0]=new JPanel();
		jp[0].setLayout(new GridLayout(2,1));
		
		for(int i=1;i<5;i++){
			jp[i]=new JPanel();
			jp[i].setLayout(new GridLayout(1,4));
		}
		
		for(int i=0;i<10;i++){
			jb[i]=new JButton();
		/*	String s=Integer.toString(i);
			System.out.println(s);
			jb[i].setText("hello");
		*/
		}
		Font font=new Font("Sans_Serif",Font.PLAIN,18);
		for(int i=0;i<16;i++){
			jb[i]=new JButton();
			jb[i].setFont(font);
		}
		
		jb[1].setText("1");
		jb[2].setText("2");
		jb[3].setText("3");
		jb[4].setText("4");
		jb[5].setText("5");
		
		jb[6].setText("6");
		jb[7].setText("7");
		jb[8].setText("8");
		jb[9].setText("9");
		jb[0].setText("0");
		
		
		/*jb[10].setLabel("c");
		jb[11].setLabel("=");
		jb[12].setLabel("/");
		jb[13].setLabel("*");
		jb[14].setLabel("-");
		jb[15].setLabel("+");
		*/
		jb[10].setText("c");
		jb[11].setText("=");
		jb[12].setText("/");
		jb[13].setText("*");
		jb[14].setText("-");
		jb[15].setText("+");
		
		
		jp[0].add(jt1);jp[0].add(jt2);
		jp[1].add(jb[12]);jp[1].add(jb[7]);jp[1].add(jb[8]);jp[1].add(jb[9]);
		jp[2].add(jb[13]);jp[2].add(jb[4]);jp[2].add(jb[5]);jp[2].add(jb[6]);
		jp[3].add(jb[14]);jp[3].add(jb[1]);jp[3].add(jb[2]);jp[3].add(jb[3]);
		jp[4].add(jb[15]);jp[4].add(jb[0]);jp[4].add(jb[10]);jp[4].add(jb[11]);

		
		for(int i=0;i<5;i++)add(jp[i]);
	
		for(int i=0;i<16;i++)jb[i].addActionListener(this);
	}	
	public void actionPerformed(ActionEvent ae){
			int op1=-1,op2=-1,oper;
			String press=(String)ae.getActionCommand().trim(),p;
			
			if(press.equals("/")||press.equals("*")||press.equals("-")||press.equals("+")){
				if((!jt2.getText().equals(""))||jt2.getText().equals("0"))jt2.setText("");
				String s=jt1.getText();
				if(op1==-1){
					op1=Integer.parseInt(s);
				}
				else{
					op2=Integer.parseInt(s);
				}
				System.out.println(press);
				jt1.setText(s+press);
				oper=Integer.parseInt(press);
			}
			else if(press.equals("c")){
				String s=jt1.getText();
				//s.removeCharAt(s.length-1);
				jt1.setText(s);
			}
			else if(press.equals("=")){
				jt1.setText("");
				jt2.setText("0");
			}
			else if(press.equals("0")||press.equals("1")||press.equals("2")||press.equals("3")||press.equals("4")||press.equals("5")||press.equals("6")|press.equals("7")||press.equals("8")||press.equals("9")||press.equals("10")){
				jt1.setText(jt1.getText()+press);
				jt2.setText(jt2.getText()+press);
				
			}	
		
			/*

			***String s[]=jt1.getText().trim().split(" ");
			if(s.equals(""))throw new NullPointerException();
			int l=s.length;
			int num[]=new int[l];
			for(int i=0;i<l;i++)
				num[i]=Integer.parseInt(s[i]);
		
			int sum=0,prod=1,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
			for(int i=0;i<l;i++){
				sum+=num[i];
				prod*=num[i];
				if(num[i]<min)min=num[i];
				if(num[i]>max)max=num[i];
			}
			float mean=(float)sum/l;
			sum=0;
			
			//computing variance and standard deviation
			
			float var,stdDev;
			for(int i=0;i<l;i++){
				sum=(int)Math.pow((num[i]-mean),2);	//Type casting is done as loss of precision error thrown otherwise as Math.pow return double 		
			}
			var=(float)sum/l;
			stdDev=(float)Math.sqrt(var);	//Type casting is done as loss of precision error thrown otherwise as Math.sqrt return double
	
			jl[2].setText(Integer.toString(prod));	
			jl[4].setText(Float.toString(mean));
			jl[6].setText(Integer.toString(max));
			jl[8].setText(Integer.toString(min));
			jl[10].setText(Float.toString(stdDev));
			jl[12].setText(Float.toString(var));
			}
		catch(NullPointerException npe){
			JOptionPane.showMessageDialog(this,"Fill in the numbers","Empty error",JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(this,"Only whole numbers are allowed","Invalid Number error",JOptionPane.ERROR_MESSAGE);
		}
		*/		
		
	}
	
	
	
}
class Calculator1{
	public static void main(String args[]){
		new Calculator();	
	}
}
