

public class FunNumber {
	private int original;
	public FunNumber(int num) {
		original = num;
	}

	public int findNumDigits() {
		int c = 0;
		int x = original;
		while(x  > 0) {
			x = x / 10;
			c++;
		}
		
		return c;
	}
	
	public int sumDigits() {
		int sum = 0;
		int x = original;
		while(x > 0) {
			sum += x % 10;
			x = x / 10;

		}
		return sum;
		 
	}
	
	public int sumInts(){
		int sum = 0;
		for(int i = 1; i <= original; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public void printFactors() {
		System.out.println("The factors are: ");
		for(int i = 1; i <= original; i++) {
			if(original % i == 0 ) {
				System.out.println(i + " ");
			}
		}
	}
	
	public boolean isPrime() {
		for(int i = 2; i < original; i++) {
			if(original % i == 0) {
				return false;
			}
		}
		return true;
	}

	
	public int findFactorial() {
		int product = 1;
		for(int i = 1; i <= original; i++) {
			product *= i;
		}
		
		return product;
	}
	
	public static int factorialRecurs(int n) {
		if (n == 1) {
			return 1;
		}
		
		return n * factorialRecurs(n - 1);
		
	}
	
	public boolean isPerfect() {
		int sum = 0;
		for(int i = 1; i < original; i++) {
			if(original % i == 0) {
				sum += i;
			}
		}
		
		if(sum == original) {
			return true;
		}
		
		return false;
	} 
	
	public int reverseNum() { 
		int num = original;
		int x = 0;
		int t = 0;
		while(num > 0) {
			x = num % 10;
			t = t * 10 + x;
			num = num  / 10;
		}
		return t;
	}

	public static void main(String[] args) {
		//System.out.println(factorialRecurs(9));
		FunNumber a =  new FunNumber(13);
		System.out.println("The number of digits is: " + a.findNumDigits());
		System.out.println("The sum of digits is: " + a.sumDigits());		
		a.printFactors();
		System.out.println("The sum of the integers are: " + a.sumInts());
		System.out.println(a.isPrime());
		System.out.println(a.isPerfect());
		System.out.print(a.reverseNum());
		
	}
	

}
