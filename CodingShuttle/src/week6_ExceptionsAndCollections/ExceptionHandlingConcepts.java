package week6_ExceptionsAndCollections;

public class ExceptionHandlingConcepts {

	public static void main(String[] args) {
		// Normal try catch example
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		/*
		 * multiple catch, In this case since we have catch for Arithmetic Exception it
		 * will be called first and program would not go in Exception Catch block.
		 * Output : In arithmetic exception catch
		 * 
		 * IMP : If we try to write Exception catch above Arithmetic Exception block
		 * then it will give us an unreachable code error as Exception is a parent class
		 * the code will go in that block itself.
		 */
		try {
			int i = 1 / 0;
		} catch (ArithmeticException e) {
			System.out.println("In arithmetic exception catch");
		} catch (Exception e) {
			System.out.println("In exception catch");
		}

		/*
		 * IMP : We cannot have a try without a catch block generally, however we can
		 * have a try block if we have a finally block
		 */
		try {
			int i = 1 / 0;
		} finally {
			System.out.println("Hey");
		}

	}
}


