package sg.edu.ntu.Flibble;

public final class MyDebug {
	private static final int isWrite = 1;
	public static final void WriteDebug(String msg) {
		if(isWrite>0){
			System.out.println(msg);
		}
	}
}
