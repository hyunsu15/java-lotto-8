package lotto.client;

public interface ResponseTask<T, R> extends TaskRunnable {

    @Override
    default void run() {
        R response = mappingResponse(getRequest());
        printResponse(response);
        addBean(response);
    }

    void printResponse(R response);

    R mappingResponse(T request);

    T getRequest();

    void addBean(R response);
}
