import java.awt.*;
import java.applet.*;
public class Animation extends Applet implements Runnable {
	Thread t,v;
	int c;
	String s;
	Font f;
    int x1=0,x2=380,y1=0,y2=250;
    public void init()
    {
    	s=new String();
    	s="stop";
    	c=1;
    	f=new Font("Arial",Font.BOLD,50);
        v=new Thread(this);
    }
	@Override
	public void start() {
		// TODO Auto-generated method stub
	if(t==null)	
	{
		t=new Thread(this,"New Thread");
		t.start();
	}
	v.start();
	}
	@Override
	public void stop()
	{
		if(t!=null)
		{
			t=null;
		}
	}
	@Override
	public void run()
	{
		for(int i=1;i<100;i++)
		{
			try 
			{
				if(c==1)
				{
					Thread.sleep(2000);
					repaint();
					c=2;
					s="Ready";
				}
				else if(c==2)
				{
					Thread.sleep(1000);
					repaint();
					c=3;
					s="Go";
				}
				else if(c==3)
				{
					Thread.sleep(3000);
					repaint();
					c=1;
					s="Stop";

				}
			}
           catch(Exception e){
				
			}
		}
		Thread t1=Thread.currentThread();
		while(t==t1)
		{
			repaint();
			try
			{
				Thread.sleep(100);
			}
		catch(Exception e){
				
			}
		}
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		g.setFont(f);
		g.fillRoundRect(580, 80, 100, 200, 10, 10);
		g.setColor(Color.gray);
		g.fillRect(600, 280, 60, 100);
		g.setColor(Color.black);
		
		
		if (c==1)
		{
			g.drawString(s, 800, 150);
			g.setColor(Color.red);
			g.fillOval(600,100,50,50);
		}
		else if(c==2)
		{
			g.drawString(s, 800, 200);
			g.setColor(Color.yellow);
			g.fillOval(600,150,50,50);
		}
		else if(c==3)
		{
			g.drawString(s, 800, 250);
			g.setColor(Color.green);
			g.fillOval(600,200,50,50);
		}
		
		
		
		
		setBackground(Color.cyan);
		g.setColor(Color.BLACK);
		x1=(x1+16)%400;
		x2=x2-16;
		y1=(y1+12)%300;
		y2=y2-12;
		if(y2<0)
			y2=288;
		if(x2<0)
			x2=384;
		
		g.fillRect(0, 130, 400, 40);
		g.fillRect(180, 0, 40, 305);
		
		g.setColor(Color.white);
		
		for(int i=0;i<20;i++)
		{
			if(i!=9 && i!=10)
				g.drawLine(i*20,150,i*20, 150);
				
		}
		
		for(int j=0;j<15;j++)
		{
			if(j!=7 && j!=8)
				g.drawLine(200,j*20,200,j*20+10);
				
		}
		
		
		g.setColor(Color.red);
		g.fillRoundRect(x2, 152, 20, 8, 2, 2);
	
		g.fillRoundRect(x1, 140, 20, 8, 2, 2);
		
		g.fillRoundRect(190, y1, 8, 20, 2, 2);
		
		g.fillRoundRect(202,y2,8,20, 2, 2);
	}
	

}
