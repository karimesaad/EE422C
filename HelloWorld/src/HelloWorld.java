
public class HelloWorld {

	public static void main(String[] args) {
		
		
		System.out.println(add(3,4));
		// TODO Auto-generated method stub
		System.out.print(add(2,3));
	}

	static int add(int x, int y){
		int sum = 0;
		for(int i = 0; i < x; i++){
			sum += y;
		}
		return sum;
	}
	
	public static int add(int x, int y){
		return x + y;
	}

}
