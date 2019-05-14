
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MultiEchoServer
{       
    
	private static ServerSocket serverSocket;
	private static final int PORT = 1234;
        
	public static void main(String[] args)  throws IOException 
	{
            int i=0;
                    GameScreen i6 = new GameScreen(1000,1000,"server gamescreen");
                    i6.setDefaultCloseOperation( EXIT_ON_CLOSE );
                    deneme2 application = new deneme2("SERVER EKRANI");
                            application.setDefaultCloseOperation( EXIT_ON_CLOSE );
                            
                            
                
                        
                
		try
		{
			serverSocket = new ServerSocket(PORT);
		}
		catch (IOException ioEx)
		{
			System.out.println("\nUnable to set up port!");
			System.exit(1);
		}

		do
		{
                    i++;
                        if(i==1){
                            
                        }
			//Wait for client...
			Socket client = serverSocket.accept();
                        

			System.out.println("\nNew client accepted.\n");

			//Create a thread to handle communication with
			//this client and pass the constructor for this
			//thread a reference to the relevant socket...
			ClientHandler handler = new ClientHandler(client,application,i,i6);
                        
                        
			handler.start();//As usual, this method calls run.
                        
                        
		}while (true);
	}
}

class ClientHandler extends Thread
{
	private Socket client;
	private Scanner input;
	private PrintWriter output;
        private deneme2 i5;
        public GameScreen i6;
        private deneme2 clientekrani;
        private GameScreen clientgame;
        public String p="quit";
        String x;

	public ClientHandler(Socket socket,deneme2 application,int k,GameScreen o)
	{
                
                GameScreen clientGameScreen;
                x = Integer.toString(k);
                clientekrani = new deneme2(x);
                clientekrani.setDefaultCloseOperation( EXIT_ON_CLOSE );
		//Set up reference to associated socket...
		client = socket;
                i5=application;
                i6=o;
                
		try
		{
			input = new Scanner(client.getInputStream());
			output = new PrintWriter(
							client.getOutputStream(),true);
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
		}
	}

	public void run()
	{
                
                int t=0;
		String received="";
                String nick="";
                clientekrani.cancelJButton.setEnabled(false);
                int ğ=0;
                
		do
		{
                    
                    clientekrani.displayPrimesJTextArea.setText(i5.displayPrimesJTextArea.getText());
                    if(ğ==0){
                        i5.cancelJButton.addActionListener(
                new ActionListener()
                {
                   public void actionPerformed( ActionEvent e )
                   {
                      i5.setVisible(false);
                        i6.setVisible(true);
                        clientgame=new GameScreen(700,700,"Oyuncu: " + x + " Oyun ekranı");
                        clientekrani.setVisible(false);
 }  } );
                        ğ++;
                    }
                    
                    
                    
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        clientekrani.getPrimesJButton.addActionListener(
                new ActionListener()
                {
                    
                   public void actionPerformed( ActionEvent e )
                   {
                      p = clientekrani.highestPrimeJTextField.getText();
 }  } );
                        received=p;
                        while(p!="quit"){
                            
                        
                        if(t==0){
                            nick=received;
                            clientekrani.displayPrimesJTextArea.append("Nickiniz: "+ nick + "\n");
                            i5.displayPrimesJTextArea.append("Yeni oyuncu katıldı: "+nick+ "\n");
                        }
                        
                        
                        
                        
                        if(t>=1){
                            clientekrani.displayPrimesJTextArea.append(nick + ":"+ received+ "\n");
                            i5.displayPrimesJTextArea.append(nick + ":"+ received+ "\n");
                         
                            
                        }
                        t++;
                        p="quit";
                            
                        }
			
			
			//Echo message back to client on
			//the socket's output stream...
			output.println("ECHO: " + received);
                        if(received.equals("QUIT")){
                            
                        }
		//Repeat above until 'QUIT' sent by client...
		}while (!received.equals("QUIT"));

		try
		{
			if (client!=null)
			{
				System.out.println(
							"Closing down connection...");
				client.close();
			}
		}
		catch(IOException ioEx)
		{
			System.out.println("Unable to disconnect!");
		}
	}
}
