package lotto.client;

import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.input.CustomConsole;
import lotto.util.ErrorMessageMaker;

/*
    T는 요청
    R는 응답
 */
abstract public class TaskTemplate<T, R> implements TaskRunnable {
    private final CustomConsole customConsole;
    private final ApplicationContext applicationContext;

    protected TaskTemplate(CustomConsole customConsole, ApplicationContext applicationContext) {
        this.customConsole = customConsole;
        this.applicationContext = applicationContext;
    }


    @Override
    public void run() {
        System.out.println(getInputMessage());
        T input = getRequest();

        R response = mappingResponse(input);
        printResponse(response);
        applicationContext.addBean(getApplicationContextKey(), response);
    }

    public T getRequest() {
        try {
            String readLine = customConsole.readLine();
            T request = mappingRequest(readLine);
            validateRequest(request);
            return request;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessageMaker.getErrorMessage(e.getMessage()));
            return getRequest();
        }
    }

    protected abstract String getInputMessage();

    protected abstract T mappingRequest(String readLine);

    protected abstract void validateRequest(T request);

    protected abstract void printResponse(R response);

    protected abstract R mappingResponse(T request);

    protected abstract ApplicationContextKey getApplicationContextKey();
}
