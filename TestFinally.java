class TestFinally
{
public static void main(String[] args) {
	System.out.println(testFinal());
}
	private static int testFinal() {
	int x = 0;
	try {
		x = 1;
		// throw new Exception();
		return x;
	} catch (Exception e) {
		x = 2;
		return x;
	} finally {
		x = 3;
	}

}
}

