public class Music4{
   	
	
	static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
			
	}
	
	static void tuneAll(Instrument[] e){
		for (Instrument i:e){
			tune(i);
			}
	}
	
	public static void main(String[] a){
		Instrument[] e={
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			new WoodWind()	
			};		
			
			tuneAll(e);
	}
}
	
	//
	 enum Note{
		MIDDLE_C,C_SHARP,B_FLAT;
	}

		 abstract class Instrument{
			private int i;
			
			public abstract void play(Note n);
			public String what(){return "Instrument";}
			public abstract void adjust();
		
		}
	
	 class Wind extends Instrument{

		public void play(Note n){
			System.out.println("wind.play() "+n);
		}
		
		public String what(){return "Wind";}
		
		
		public void adjust(){
		
		}
	}
	
	
	 class Percussion extends Instrument{
	public	void play(Note n){
			System.out.println("Percussion play() "+n);		
		}
	public	String what(){return "Percussion";}
		
	public	void adjust(){}
	}
	
	 class Stringed extends Instrument{
	public	void play(Note n){
			System.out.println("STringed play() "+n);
		}	
		
		public String what(){return "Stringed";}
		
	public	void adjust(){}
	}
	
	class Brass extends Wind{
		public void play(Note n){
			System.out.println("Brass.play() "+n);
		}
		public void adjust(){
			System.out.println("Brass.adjust()");
		}
		
	}
	
	class WoodWind extends Wind{
		public void play(Note n){
			System.out.println("Woodwind.play()"+n);	
		}
		
		public String what(){return "Woodwind";}
	}
