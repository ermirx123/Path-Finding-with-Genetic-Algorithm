import java.awt.*;

// Klasa per krijimin e krijesave
public class Krijesa  {

   String kodi_gjenetik;
   int gjatesia_stringut;
   int[] pozita;
   boolean eshte_gjalle;
   Color ngjyra;
   int indeksi_gjenetik;
   
   public Krijesa(Color c) {
   
      gjatesia_stringut = 600; 
      kodi_gjenetik = randomize(gjatesia_stringut);
      ngjyra = c;
      filloniRaundin(new int[2]);
   }
   
   // Metoda per fillimin e rundit
   public void filloniRaundin(int[] pika_fillimit) {
     
      pozita = new int[]{pika_fillimit[0],pika_fillimit[1]};
      eshte_gjalle = true;
      indeksi_gjenetik = 0;
   }
   
   
   //0 == lart,1 == djathtas, 2 == posht, 3 == majtas
   public void leviz() {
     
     int temp = Integer.parseInt(kodi_gjenetik.substring(indeksi_gjenetik % 200,indeksi_gjenetik % 200 + 1));
      
      if(temp == 0) {
      
         pozita[1] --;
      
      } else if(temp == 1){
      
         pozita[0] ++;
      
      } else if(temp == 2){
      
         pozita[1] ++;
      
      } else {
      
         pozita[0] --;
      }
      
      indeksi_gjenetik++;
   }
   
   public Krijesa(String gc, Color c) {
   
      kodi_gjenetik = gc;
      ngjyra = c;
   }
   
   public Krijesa(String gc, Color c, int[] location) {
   
      kodi_gjenetik = gc;
      ngjyra = c;
      pozita = location;
   }
   
   private String randomize(int a) {
      
      String temp = "";
      
      for(int b = 0; b < a; b++) {
      
         temp += (int)(Math.random()*4);
      }
      
      return temp;
   }
   
   public Krijesa klono() {
   
      return new Krijesa(kodi_gjenetik,ngjyra,pozita);
   }
   
}