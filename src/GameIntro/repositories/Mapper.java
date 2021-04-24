package GameIntro.repositories;

public interface Mapper<T, V> {
    // V - Возвращает, K - принимает
    V map(T object);
}
