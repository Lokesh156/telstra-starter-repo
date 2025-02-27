package au.com.telstra.simcardactivator;

public class ActuationResult {
    private boolean success;

    public ActuationResult(boolean success) {
        this.success = success;
    }

    public ActuationResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ActuationResult{" +
                "success=" + success +
                '}';
    }
}
