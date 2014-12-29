package dec26;
/*
*  
*  Q.Create a class MutableImmutableDemo. Inside that class crreate object 
*  greeting of String and another object welcome of StringBuilder.
*  Try to modify both object by concatenating some string on a suffix on both
*  
*
*/

/**
* 
*  Demonstration of Immutable String Class and Mutable StringBuilder
*  Class.
*  
*  @author  Sanjib Maharjan
*
*/
class MutableImmutableDemo {
		
	public static void main(String[] args){
		String greeting = new String("Greetings");
		System.out.println("String:"+greeting);
		greeting.concat(" to all");
		System.out.println("String:"+greeting);

		StringBuilder welcome = new StringBuilder("Welcome");
		System.out.println("StringBuilder:"+welcome);
		welcome.append(" to all");	
		System.out.println("StringBuilder:"+welcome);

	}
}