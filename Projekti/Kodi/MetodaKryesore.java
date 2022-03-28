import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;


// Klasa kryesore per thirrje dhe qka permban algoritmin gjenetik
public class MetodaKryesore {

   
   private static int generation = 1;
   private static double avgDistance;
   private static double fitness;
   
   private static ArrayList<ArrayList<Krijesa>> lastCreatures;
   private static double lastAvgDistance;
   
   private static double bestDistance;
   private static double lastBestDistance;
   
   private static boolean gjyk = false;
   
   private static int numrat_e_grupeve_te_testimit = 7;
   private static int krijesat_per_grup_testimi = 500;

   public static void main(String[] args) {
   
      ArrayList<ArrayList<Krijesa>> krijesat = new ArrayList<ArrayList<Krijesa>>();
      
      numrat_e_grupeve_te_testimit = Integer.parseInt(JOptionPane.showInputDialog("Shkruani numrin e grupeve te testimit:"));   
      krijesat_per_grup_testimi = Integer.parseInt(JOptionPane.showInputDialog("Shkruani numrin e krijesave"));  
      
      
      // Krijon krijesat me vlerat e dhena
      for(int i = 0; i < numrat_e_grupeve_te_testimit; i++) {
      
         krijesat.add(new ArrayList<Krijesa>());
         
         Color ngjyra = new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));
      
         for(int j = 0; j < krijesat_per_grup_testimi; j++) {
         
            krijesat.get(i).add(new Krijesa(ngjyra));
         }
      
      }
      
      JFrame korniza = new JFrame("Skema");
      
      //frame.setUndecorated(true);
      
      
      korniza.addMouseListener(
         
         new MouseAdapter() { 
         
            public void mousePressed(MouseEvent e) {  
            
               System.out.println(e.getX() + " " + e.getY());
            }
         }
         );
     
     
      int numri_skemes = Integer.parseInt(JOptionPane.showInputDialog("Shkruani numrin e skemes: [0,1,2,3,4,5,6,7] "));
      
      Skema skema;
     
      if(0 <= numri_skemes && numri_skemes <= 7) { 
      
         skema = new Skema(numri_skemes);
      
      } else {
            
         JOptionPane.showMessageDialog(null,"Nuk ekziston skema do te krijojm nje skem random prej skemave: [0,1,2,3,4,5,6]"); 
         skema = new Skema((int)(Math.random()*5));
      }
      
      
      Shfaqja ekrani = new Shfaqja(skema,krijesat);
      
      int masa = ekrani.merrMasen();
      
      int numri_mases = Integer.parseInt(JOptionPane.showInputDialog("Shkruani numrin e madhesise se skemes (masen): [7,8,9,10,11,12] "));
      
      if(7 <= numri_mases && numri_mases <= 12) { 
      
         ekrani.vendosMasen(numri_mases); 
         masa = ekrani.merrMasen();
      
      } else {
      
         JOptionPane.showMessageDialog(null,"Nuk lejohet madhesia e skemes do te krijojm nje madhesi random prej : [7,8,9,10,11,12]"); 
         ekrani.vendosMasen((int)(7 + Math.random()*6)); 
         masa = ekrani.merrMasen();
      }
      
      vendosMadhesineKornizes(masa,korniza,ekrani);
      
      rifilloniKrijesat(krijesat,skema.pozicioni_fillimit);
      
      while(true) {
         
         for(int i = 0; i < 600; i++) {
            
            ekrani.vizato();
            levizKrijesat(krijesat,skema);
            
            if(kontrolloFundin(krijesat, skema)) {
              
               break;
            }
             
            try {
            
               Thread.sleep(1);
            
            } catch(Exception e) {
            
               System.out.println(e);
            }
            
         }
         
         generation++;
         krijesat = gjenerataRe(krijesat,skema);
         rifilloniKrijesat(krijesat,skema.pozicioni_fillimit);
         ekrani.krijesat = krijesat;
      }
      
   }
   
   public static void rifilloniKrijesat(ArrayList<ArrayList<Krijesa>> cs,int[] sl) {
   
      for(int i = 0; i < cs.size(); i++) {
      
         for(int j = 0; j < cs.get(i).size(); j++) {
         
            cs.get(i).get(j).filloniRaundin(sl);
         }
         
      }
      
   }
   
   // Metoda per levizjen e krijesave
   public static void levizKrijesat(ArrayList<ArrayList<Krijesa>> cs,Skema m) {
   
      for(int i = 0; i < cs.size(); i++){
      
         for(int j = 0; j < cs.get(i).size(); j++) {
         
            if(cs.get(i).get(j).eshte_gjalle) {  // Nese krijesa eshte gjall levize ate
            
               cs.get(i).get(j).leviz();
               
               if(m.kontrolloniPerplasjen(cs.get(i).get(j).pozita)) { // Nese krijesa godet skajet ose kufizen vdes
               
                  cs.get(i).get(j).eshte_gjalle = false;
               
               }
            
            }
         
         }
      
      }
   }
   
   // Metoda per krijimin e gjenereatave te reja te krijesave
   public static ArrayList<ArrayList<Krijesa>> gjenerataRe(ArrayList<ArrayList<Krijesa>> c,Skema m) {
   
      double topPercent = 0.2;//0.2;
   
      c = rendit(c,m,topPercent);
      
      ArrayList<ArrayList<Krijesa>> gen = new ArrayList<ArrayList<Krijesa>>();
   
      for(int i = 0; i < c.size(); i++){
      
         ArrayList<Krijesa> temp = new ArrayList<Krijesa>();
      
         for(int j = 0; j < c.get(i).size(); j++) {
         
            temp.add(new Krijesa(cross(c.get(i).get((int)(c.get(i).size()*topPercent*Math.random())).kodi_gjenetik,c.get(i).get((int)(c.get(i).size()*topPercent*Math.random())).kodi_gjenetik),c.get(i).get(j).ngjyra));
            
         }
      
         gen.add(temp);
      }
      
      return gen;
   }
   
   // Metoda per Crossover 
   public static String cross(String c1, String c2) {
   
      String temp = "";
   
      for(int i = 0; i < c1.length(); i++){
      
         if(Math.random() < 0.008){
         
            temp += (int)(Math.random()*4);
         
         } else {
            
            if(Math.random() < 0.5) {
            
               temp += c1.substring(i,i+1);
            
            } else {
            
               temp += c2.substring(i,i+1);
            }
         }
      }
      
      return temp;
   }
   
   // Metoda per te shiquar nese krijesat e kan arritur sunimin
   public static boolean kontrolloFundin(ArrayList<ArrayList<Krijesa>> cs, Skema m)  {
   
      for(ArrayList<Krijesa> a: cs){
      
         for(Krijesa c: a) {
         
            if(c.pozita[0] == m.pozicioni_synimit[0] && c.pozita[1] == m.pozicioni_synimit[1]) {
            
               return true;
            }
         }
      }
   
      return false;
   }
   
   
   public static ArrayList<ArrayList<Krijesa>> rendit(ArrayList<ArrayList<Krijesa>> c, Skema m, double tP)  {
   
      ArrayList<ArrayList<Krijesa>> gen = new ArrayList<ArrayList<Krijesa>>();
      
      // rradhit krijesat duke u bazuar nga distanca e synimit te pozicionit 
      for(int i = 0; i < c.size(); i++) {
       
         gen.add(new ArrayList<Krijesa>());
         gen.get(i).add(c.get(i).get(0).klono());
       
         for(int j = 1; j < c.get(i).size(); j++){
          
            int count = 0;
            boolean contin = true;
            
            while(count < gen.get(i).size() && contin) {
             
               if(merrDistancen(c.get(i).get(j).pozita,m.pozicioni_synimit) < merrDistancen(gen.get(i).get(count).pozita, m.pozicioni_synimit)) {
               
                  gen.get(i).add(count,c.get(i).get(j).klono());
                  contin = false;
               }
               
               count++;
            }
            
            if(contin) {
            
               gen.get(i).add(c.get(i).get(j).klono());
            }
         
         }
         
      }
      
      if(gjyk) {
      
         for(int i = 0; i < lastCreatures.size(); i++) {
         
            for(int j = 0; j < lastCreatures.get(i).size(); j++) {
            
               lastAvgDistance = lastAvgDistance + merrDistancen(lastCreatures.get(i).get(j).pozita,m.pozicioni_synimit); 
               
               if(j < (int)(gen.get(i).size()*0.2)) {
               
                  lastBestDistance = lastBestDistance + merrDistancen(lastCreatures.get(i).get(j).pozita,m.pozicioni_synimit); 
               }
               
            }
         
         }
      
      }
      
      
      for(int i = 0; i < gen.size(); i++) {
         
         for(int j = 0; j < gen.get(i).size(); j++) {
         
            avgDistance = avgDistance + merrDistancen(gen.get(i).get(j).pozita,m.pozicioni_synimit); 
            
            if(j < (int)(gen.get(i).size()*tP)) {
               
            
               if(Math.abs(bestDistance + 0.000000001) > 0.0000000001 && (i == 1)) {
               
                  bestDistance = bestDistance + merrDistancen(gen.get(i).get(j).pozita,m.pozicioni_synimit);  
               
               } else if(Math.abs(bestDistance) > 0.0000000001) {
               
                  bestDistance = bestDistance + merrDistancen(gen.get(i).get(j).pozita,m.pozicioni_synimit);  
               } 
                  
            }
            
         }
      }
      
   
      lastAvgDistance = lastAvgDistance/(numrat_e_grupeve_te_testimit*krijesat_per_grup_testimi);
      avgDistance = avgDistance/(numrat_e_grupeve_te_testimit*krijesat_per_grup_testimi);
      
      if(Math.abs(bestDistance) > 0.0000000001) {
      
         lastBestDistance = lastBestDistance/(numrat_e_grupeve_te_testimit* (krijesat_per_grup_testimi * (int)(krijesat_per_grup_testimi*tP)));
         bestDistance = bestDistance/(numrat_e_grupeve_te_testimit* (krijesat_per_grup_testimi * (int)(krijesat_per_grup_testimi*tP)));
      
      }
      
      if(gjyk) {
      
       //  fitness = Math.abs(avgDistance - lastAvgDistance);
       
         if(Math.abs(bestDistance - lastBestDistance) > 0.000000000001) {
         
            fitness = Math.abs(bestDistance - lastBestDistance);
         
         }
      }
      
      gjyk = true;
      
     // lastAvgDistance = 0;
     // lastBestDistance = 0;
      
      
      lastCreatures = gen;
      
      return gen;
   }

   
   public static double merrDistancen(int[] p1,int[] p2) {
     
      return Math.sqrt(Math.pow(p1[0]-p2[0],2) + Math.pow(p1[1]-p2[1],2));
   }
   
   // Metoda per madhesine e kornzies ne baze te mases
   public static void vendosMadhesineKornizes(int masa,JFrame korniza,Shfaqja screen) {
      
      //frame.setLocationRelativeTo(null);
      korniza.add(screen);
      korniza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      if(masa == 7) {
        
         korniza.setSize(470,385);
      
      } else if(masa == 8) {
      
         korniza.setSize(535,438);
         
      } else if(masa == 9) {
      
         korniza.setSize(598,488);
         
      } else if(masa == 10) {
      
         korniza.setSize(664,538);
         
      } else if(masa == 11) {
      
         korniza.setSize(728,588);
         
      } else if(masa == 12) {
      
         korniza.setSize(792,636);
      }
   
      korniza.setVisible(true);
   }
   
   public static int getGeneration() {
   
      return generation;
   }
   
   public static double getDistance() {
   
      return avgDistance;
   }
   
   public static double getFitness() {
   
      return fitness;
   }
   
   public static double getBestDistance() {
   
      return bestDistance;
   }
   

   
}