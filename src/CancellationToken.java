
public class CancellationToken {
	private boolean wasCancelled = false;
	
	public void cancel() {
		wasCancelled = true;
	}
	
	public boolean wasCanceled() {
		return wasCancelled;
	}
}
