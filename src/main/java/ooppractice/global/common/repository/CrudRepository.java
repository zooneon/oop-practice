package ooppractice.global.common.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CrudRepository<T extends Entity, ID extends Long> {

    private Map<Long, Entity> store = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    public T save(T entity) {
        entity.setId(++sequence);
        store.put(sequence, entity);
        return entity;
    }

    public List<T> saveAll(Iterable<T> entities) {
        entities.forEach(entity -> save(entity));
        return (List<T>) entities;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable((T) store.get(id));
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    public List<T> findAll() {
        return store.values().stream().map(value -> (T) value).collect(Collectors.toList());
    }

    public List<T> findAllById(Iterable<Long> ids) {
        List<T> result = new ArrayList<>();
        ids.forEach(id -> result.add((T) store.get(id)));
        return result;
    }

    public long count() {
        return store.size();
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    public void delete(Entity entity) {
        store.remove(entity.getId());
    }

    public void deleteAll(Iterable<T> entities) {
        entities.forEach(entity -> delete(entity));
    }

    public void deleteAll() {
        store.clear();
    }
}
