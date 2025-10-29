package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.util.ErrorMessageMaker;

public class ApplicationContext {
    private Map<String, Object> map;

    public ApplicationContext() {
        this(new HashMap<>());
    }

    public ApplicationContext(Map<String, Object> map) {
        this.map = map;
    }

    public <T> T getBean(String key, Class<T> type) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(ErrorMessageMaker.getErrorMessage("없는 빈조회 함. key:%s".formatted(key)));
        }
        return type.cast(map.get(key));
    }

    public void addBean(String key, Object value) {
        map.put(key, value);
    }
}
