package lotto.client;

import lotto.input.CustomConsole;
import lotto.util.ErrorMessageMaker;

public interface RequestTask<T> extends TaskRunnable {

    @Override
    default void run() {
        T request = makeRequest();
        printRequest(request);
        addBean(request);
    }


    default T makeRequest() {
        System.out.println(getInputMessage());
        return getRequest();
    }


    private T getRequest() {
        try {
            String readLine = getConsole().readLine();
            return mappingRequest(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessageMaker.getErrorMessage(e.getMessage()));
            return getRequest();
        }
    }

    String getInputMessage();

    T mappingRequest(String readLine);

    void printRequest(T request);

    CustomConsole getConsole();

    void addBean(T request);
}
