package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.util.ErrorMessageMaker;

public class ApplicationContext {
    private Map<ApplicationContextKey, Object> beans;

    public ApplicationContext() {
        this(new HashMap<>());
    }

    public ApplicationContext(Map<ApplicationContextKey, Object> beans) {
        this.beans = beans;
    }

    public <T> T getBean(ApplicationContextKey key, Class<T> type) {
        if (!beans.containsKey(key)) {
            throw new IllegalArgumentException(ErrorMessageMaker.getErrorMessage("없는 빈조회 함. key:%s".formatted(key)));
        }
        return type.cast(beans.get(key));
    }

    public void addBean(ApplicationContextKey key, Object value) {
        beans.put(key, value);
    }
}
