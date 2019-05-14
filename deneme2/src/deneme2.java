import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class deneme2 extends JFrame {
    public final JTextField highestPrimeJTextField = new JTextField(); 
   public final JButton getPrimesJButton = new JButton( "Deneme 2 butonu" );
   public final JTextArea displayPrimesJTextArea = new JTextArea(); 
   public final JButton cancelJButton = new JButton( "Cancel" );
   public final JProgressBar progressJProgressBar = new JProgressBar();
   public final JLabel statusJLabel = new JLabel();
   public deneme2(String k){
       
       super( k );
       setLayout( new BorderLayout() );

      // initialize panel to get a number from the user
      JPanel northJPanel = new JPanel();
      northJPanel.add( new JLabel( "Nickname: " ) );
      highestPrimeJTextField.setColumns( 5 );
      northJPanel.add( highestPrimeJTextField );
      
      northJPanel.add( getPrimesJButton );
      
      
      
        
      // add a scrollable JList to display results of calculation
      displayPrimesJTextArea.setEditable( false );
      add( new JScrollPane( displayPrimesJTextArea,
         ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) );

      // initialize a panel to display cancelJButton, 
      // progressJProgressBar, and statusJLabel 
      JPanel southJPanel = new JPanel( new GridLayout( 1, 3, 10, 10 ) );
      cancelJButton.setEnabled( true );
      
      southJPanel.add( cancelJButton );
      progressJProgressBar.setStringPainted( true );
      southJPanel.add( progressJProgressBar );
      southJPanel.add( statusJLabel );
     
      add( northJPanel, BorderLayout.NORTH );
      add( southJPanel, BorderLayout.SOUTH );
      setSize( 500, 500 );
      setVisible( true );
   }
   
   
   
   
            public void metodum(String i,String t){
                getPrimesJButton.addActionListener(
                new ActionListener()
                {
                   public void actionPerformed( ActionEvent e )
                   {
                      
                      displayPrimesJTextArea.append(t+ ": " + i + "\n");
                   } 
                } 
      );
                
                
        }
            
            
            
            
            public void metodum2(String k,deneme2 w,deneme2 e){
                k = highestPrimeJTextField.getText();
                e.displayPrimesJTextArea.append("aligun");
                      w.displayPrimesJTextArea.append("gunali");
                
                
            }
            

    
   
   
}
