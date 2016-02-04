
public class HelloWorld {

	public static void main(String[] args) {
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

}
