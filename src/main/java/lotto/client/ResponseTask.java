package lotto.client;

public interface ResponseTask<R> extends TaskRunnable {
    
    @Override
    default void run() {
        R response = mappingResponse();
        printResponse(response);
        addBean(response);
    }

    void printResponse(R response);

    R mappingResponse();

    void addBean(R response);
}
