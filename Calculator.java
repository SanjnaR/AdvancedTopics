import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;

public class Calculator {
	Stack<Double> numbers;
	Stack<Character> operators;

	public Calculator() {
		numbers = new Stack<Double>();
		operators = new Stack<Character>();

	}

	//character to perform operations
	double evaluate(char x) {
		return 0;
	}


	public double evaulateExpression(String expression) {
		Scanner s = new Scanner(expression).useDelimiter("\\s* \\s*");
		expression.trim();
		int index = 0;
		int stringLoca = 0;
		double solution = 0.0;
		numbers.push(s.nextDouble());
		operators.push(s.next().charAt(index));
		numbers.push(s.nextDouble());
		//operators.push(nextOp);
		//operators.push(s.next().charAt(index));

		char nextOp = s.next().charAt(index++); //what to do when only one operation
		while(expression != "" & !numbers.isEmpty() && !operators.isEmpty()) {
			//nextOp = s.nect
			if(isOperator(nextOp)) {
				System.out.println("nextOp: " + nextOp);
				//decide whether you empty or add 
				if(getPriority(nextOp) > operators.peek()) { //if the next one in string is > than one in stack
					System.out.println("operator: " + operators.peek());
					operators.push(nextOp);
					numbers.push(s.nextDouble());
					stringLoca = expression.indexOf(nextOp);
				}

				else { //if priority level is less than or equal to next one, do math
					//numbers.push(s.nextDouble());
					//operators.push(nextOp);
					solution += changeStack();
					stringLoca = expression.indexOf(nextOp);
					//take operation from string and put it in stack

				}
			}
			else {
				nextOp = expression.charAt(index++);
			}
			expression = expression.substring(stringLoca);
			System.out.print("expression: "+ expression);
		}
		return solution;
	}

	boolean isOperator(char x) {
		if(x == '+' || x == '-' || x == '*' || x == '/' || x == '^' ) {
			return true;
		}

		else {
			return false;
		}
	}

	//	int getNextInt(String s) {
	//		return 0;
	//	}
	//	
	//	char getNextChar(String s) {
	//		return 'x';
	//	}

	//returns int to check order of operators
	int getPriority(char x) {
		if(x == '+' || x == '-') {
			return 0;
		}

		else if(x == '*' || x == '/') {
			return 1;
		}

		else if(x == '^') {
			return 2;
		}

		else {
			return -1; //throw error 
		}
	}

	//adds operator to the stack or evaluates the top of the stack

	//evaluates stack
	double changeStack() {
		double newVal = 0;

		if(operators.peek() == '+') {
			newVal = numbers.pop() + numbers.pop();
			System.out.println("operator peek" + operators.peek());
			operators.pop();
			numbers.push(newVal);
		}

		else if(operators.peek() == '-') {
			newVal = numbers.pop() - numbers.pop();
			operators.pop();
			numbers.push(newVal);
		}

		else if(operators.peek() == '*') {
			newVal = numbers.pop() * numbers.pop();
			operators.pop();
			numbers.push(newVal);
		}

		else if(operators.peek() == '/') {
			newVal = numbers.pop() / numbers.pop();
			operators.pop();
			numbers.push(newVal);	
		}

		else {
			System.out.println("Invalid operation");
		}
		return newVal;		
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator ex = new Calculator();
		System.out.println(ex.evaulateExpression("4 * 5 + 3"));
	}


}
