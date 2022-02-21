package ooppractice.global.common.repository;

import ooppractice.domain.category.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CrudRepositoryImpl implements CrudRepository<Entity, Long> {

    private static Map<Long, Entity> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public <S extends Entity> S save(S entity) {
        entity.setId(++sequence);
        store.put(sequence, entity);
        return entity;
    }

    @Override
    public <S extends Entity> Iterable<S> saveAll(Iterable<S> entities) {
        entities.forEach(entity -> save(entity));
        return entities;
    }

    @Override
    public Optional<Entity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<Entity> findAll() {
        return store.values().stream().collect(Collectors.toList());
    }

    @Override
    public Iterable<Entity> findAllById(Iterable<Long> ids) {
        List<Entity> result = new ArrayList<>();
        ids.forEach(id -> result.add(store.get(id)));
        return result;
    }

    @Override
    public long count() {
        return store.size();
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public void delete(Entity entity) {
        deleteById(entity.getId());
    }

    @Override
    public void deleteAll(Iterable<? extends Entity> entities) {
        entities.forEach(entity -> delete(entity));
    }

    @Override
    public void deleteAll() {
        store.clear();
    }
}
