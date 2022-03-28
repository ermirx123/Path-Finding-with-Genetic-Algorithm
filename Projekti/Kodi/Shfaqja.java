import java.awt.*;
import javax.swing.*;
import java.util.*;

// Klasa per shfaqjen e pamjes se krijesave dhe skemes me kufizimeve
public class Shfaqja extends JComponent  {

   int masa;
   Skema skema;
   ArrayList<ArrayList<Krijesa>> krijesat;
   
   public Shfaqja(Skema m,ArrayList<ArrayList<Krijesa>> c)  {
   
      skema = m;
      masa = 7; 
      krijesat = c;
   }
   
   public void vizato() {
   
      super.repaint();
   }
   
   public void paintComponent(Graphics g) {
   
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.fillRect(0,0,skema.maksimumX*masa,skema.maksimumY*masa);
      g.setColor(Color.WHITE);
      g.fillRect(masa,masa,(skema.maksimumX - 2)*masa,(skema.maksimumY-2)*masa);
      g.setColor(Color.RED);
   
       
      // Vizatimi i drejtkendshave te kufizave. 
      for(int i = 0; i < skema.vargu.length; i++) {
      
         for(int j = 0; j < skema.vargu[i].length; j++) {
         
            if(skema.vargu[i][j] == true) {
            
               g.fillRect(i*masa,j*masa,masa,masa);
            }
            
         }
         
      }
    
       
      // Vizatimi i pozites se krijesave 
      for(int i = 0; i < krijesat.size(); i++) {
        
         g.setColor(krijesat.get(i).get(0).ngjyra);
        
         for(int j = 0; j < krijesat.get(i).size(); j++) {
         
            g.fillOval(krijesat.get(i).get(j).pozita[0]*masa,krijesat.get(i).get(j).pozita[1]*masa,masa,masa);
            
         }
         
      }
      
      // Vizatimi i rrethit te Startit
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,masa + 8));
      g.drawString("Start",skema.pozicioni_fillimit[0]*masa,skema.pozicioni_fillimit[1]*masa-20);
      g.setColor(Color.RED);
      g.fillOval(skema.pozicioni_fillimit[0]*masa,skema.pozicioni_fillimit[1]*masa,masa + 8,masa + 8);
   
      
      // Vizatimi i rrethit te Fundit
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,15));
      g.drawString("End",skema.pozicioni_synimit[0]*masa - 2,skema.pozicioni_synimit[1]*masa - 15);
      g.setColor(Color.RED);
      g.fillOval(skema.pozicioni_synimit[0]*masa,skema.pozicioni_synimit[1]*masa,masa + 8,masa + 8);
      
      // Vizatimi i numrit te skemes
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,15));
      g.drawString("Skema : " + skema.merrNumrineSkemes(),15,25);
      
      // Vizatimi i gjenerates
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,12));
      g.drawString("Gjenerata : " + MetodaKryesore.getGeneration(),20,skema.maksimumY*masa - 45);
      
      // Vizatimi i distances
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,12));
      g.drawString("Distanca mesatare : " + MetodaKryesore.getDistance(),20,skema.maksimumY*masa - 35);
      
      // Vizatimi i fitnessit
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,12));
      g.drawString("Fitnesi : " + MetodaKryesore.getFitness(),20,skema.maksimumY*masa - 25);
      
      // Vizatimi i distances me te mire
      g.setColor(Color.BLACK);
      g.setFont(new Font("serif",Font.BOLD,12));
      g.drawString("Distance me e mire : " + MetodaKryesore.getBestDistance(),20,skema.maksimumY*masa - 15);
      
      
   }
   
   // Metoda qe vendos masen 
   public void vendosMasen(int masa) {
   
      this.masa = masa;
   }
   
   // Metoda qe merr masen 
   public int merrMasen() {
   
      return masa;
   }
   
   
}