
// Klasa per krijimin e kufizimeve
public class Skema  {

   boolean[][] vargu;
   int[] pozicioni_fillimit; // pozita e fillimit te krijesave
   int[] pozicioni_synimit; // pozita e synimit te krijesave
   int maksimumX;
   int maksimumY;
   int numri_skemes;

   public Skema(int numri_skemes)  {
   
      maksimumX = 100;
      maksimumY = 40;
      pozicioni_fillimit = new int[]{10,10};
      this.numri_skemes = numri_skemes;
      merrSkemen(numri_skemes);
   }
   
   
   // Metoda per krijimin e skemes 
   public void merrSkemen(int numri_skemes) {
   
      if(numri_skemes == 0) { 
         
         maksimumX = 65;
         maksimumY = 50;
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,16};
       
         for(int y = 0; y < 30; y++){
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++){
         
            vargu[x][40] = true;
         }
                  
         for(int i = 8; i >= 0; i--) { 
           
            vargu[52-i][15-i] = true;
         }
         
         for(int i = 0; i <= 8; i++) {
         
            vargu[52-i][15+i] = true;
         }    
         
         pozicioni_synimit = new int[]{5,12};
      
      } else if(numri_skemes == 1) {
         
         maksimumX = 65;
         maksimumY = 50;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,15};
       
         for(int y = 0; y < 30; y++){
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++){
         
            vargu[x][40] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][15-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][15+i] = true;
         }    
         
         pozicioni_synimit = new int[]{5,13};
      
      } else if(numri_skemes == 2) { 
         
         maksimumX = 65;
         maksimumY = 50;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,16};
       
         for(int y = 0; y < 30; y++) {
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++) {
         
            vargu[x][40] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][15-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][15+i] = true;
         }    
         
         pozicioni_synimit = new int[]{5,16};
      
      } else if(numri_skemes == 3) {
         
         maksimumX = 65;
         maksimumY = 50;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,16};
       
         for(int y = 0; y < 30; y++) {
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++) {
         
            vargu[x][40] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][16-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][16+i] = true;
         }    
         
         pozicioni_synimit = new int[]{5,14};
      
      } else if(numri_skemes == 4) { 
         
         maksimumX = 65;
         maksimumY = 50;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,12};
       
         for(int y = 0; y < 30; y++) {
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++) {
         
            vargu[x][40] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][12-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][12+i] = true;
         }    
         
         pozicioni_synimit = new int[]{5,12};
         
      } else if(numri_skemes == 5) { 
         
         maksimumX = 65;
         maksimumY = 50;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,12};
       
         for(int y = 0; y < 30; y++) {
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++) {
         
            vargu[x][40] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][12-i] = true;
         }
         
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52+i][12-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][12+i] = true;
         }   
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[25-i][25+i] = true;
         }  
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[45-i][23+i] = true;
         }  
         
         pozicioni_synimit = new int[]{5,12};
      
      } else if(numri_skemes == 6) { 
         
         maksimumX = 65;
         maksimumY = 50;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,12};
       
         for(int y = 0; y < 30; y++) {
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 25; x++) {
         
            vargu[x][40] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][12-i] = true;
         }
         
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52+i][12-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][12+i] = true;
         }   
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[25-i][25+i] = true;
         }  
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[45-i][23+i] = true;
         }  
         
         for(int i = 0; i <= 20; i++) {
         
            vargu[1 + (int)(Math.random()*50)][1 + (int)(Math.random()*40)] = true; 
         }
         
         pozicioni_synimit = new int[]{5,12};
         
      } else if(numri_skemes == 7) { 
         
         maksimumX = 65;
         maksimumY = 40;
         
         vargu = new boolean[maksimumX][maksimumY];
         
         pozicioni_fillimit = new int[]{57,18};
       
         for(int y = 0; y < 20; y++) {
          
            vargu[30][y] = true;
         }
         
         for(int x = 0; x < 30; x++) {
         
            vargu[x][30] = true;
         }
                  
         for(int i = 7; i >= 0; i--) { 
           
            vargu[52-i][18-i] = true;
         }
         
         for(int i = 0; i <= 7; i++) {
         
            vargu[52-i][18+i] = true;
         }    
         
         pozicioni_synimit = new int[]{5,18};
         
      }
        
   
       
   }
   
   // Kontrollon perplasjen nese krijesat kan goditur skajet ose kufizen
   public boolean kontrolloniPerplasjen(int[] l)  {
   
      if(l[0] < 1 || l[1] < 1 || l[0] >= maksimumX - 1 || l[1] >= maksimumY - 1) {
      
         return true;
      
      }  else if(vargu[l[0]][l[1]] == true) {
      
         return true;
      }
      
      return false;
   }
   
   // Metod qe kthen numrin e skemes
   public int merrNumrineSkemes() {
   
      return numri_skemes;
   }
      

}