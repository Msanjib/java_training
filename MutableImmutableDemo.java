/**
*  Demonstration of Immutable String Class and Mutable StringBuilder
*  Class.
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