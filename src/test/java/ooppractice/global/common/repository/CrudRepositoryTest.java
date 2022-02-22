package ooppractice.global.common.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CrudRepositoryTest {

    private CrudRepository<Entity, Long> crudRepository = new CrudRepository<>();

    @AfterEach
    void tearDown() {
        crudRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        Entity entity = new Entity();
        //when
        Entity saved = crudRepository.save(entity);
        //then
        assertThat(saved.getId()).isEqualTo(entity.getId());
    }

    @Test
    void saveAll() {
        //given
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity());
        entities.add(new Entity());
        //when
        List<Entity> saved = crudRepository.saveAll(entities);
        //then
        assertThat(saved.get(0).getId()).isEqualTo(entities.get(0).getId());
        assertThat(saved.get(1).getId()).isEqualTo(entities.get(1).getId());
    }

    @Test
    void findById() {
        //given
        Entity entity = new Entity();
        Entity saved = crudRepository.save(entity);
        //when
        Optional<Entity> byId = crudRepository.findById(saved.getId());
        //then
        assertThat(byId.get()).isNotNull();
        assertThat(byId.get()).isEqualTo(entity);
    }

    @Test
    void existsById() {
        //given
        Entity entity = new Entity();
        Entity saved = crudRepository.save(entity);
        //when
        boolean checkTrue = crudRepository.existsById(saved.getId());
        boolean checkFalse = crudRepository.existsById(100L);
        //then
        assertThat(checkTrue).isTrue();
        assertThat(checkFalse).isFalse();
    }

    @Test
    void findAll() {
        //given
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity());
        entities.add(new Entity());
        crudRepository.saveAll(entities);
        //when
        List<Entity> all = crudRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all.containsAll(entities)).isTrue();
    }

    @Test
    void findAllById() {
        //given
        Entity first = crudRepository.save(new Entity());
        Entity second = crudRepository.save(new Entity());
        List<Long> ids = new ArrayList<>();
        ids.add(first.getId());
        ids.add(second.getId());
        //when
        List<Entity> allById = crudRepository.findAllById(ids);
        //then
        assertThat(allById.get(0)).isEqualTo(first);
        assertThat(allById.get(1)).isEqualTo(second);
    }

    @Test
    void count() {
        //given
        crudRepository.save(new Entity());
        //when
        long count = crudRepository.count();
        //then
        assertThat(count).isEqualTo(1);
    }

    @Test
    void deleteById() {
        //given
        Entity saved = crudRepository.save(new Entity());
        //when
        crudRepository.deleteById(saved.getId());
        //then
        assertThat(crudRepository.findById(saved.getId()).isEmpty()).isTrue();
    }

    @Test
    void delete() {
        //given
        Entity saved = crudRepository.save(new Entity());
        //when
        crudRepository.delete(saved);
        //then
        assertThat(crudRepository.findById(saved.getId()).isEmpty()).isTrue();
    }

    @Test
    void deleteAll() {
        //given
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity());
        entities.add(new Entity());
        crudRepository.saveAll(entities);
        //when
        crudRepository.deleteAll(entities);
        //then
        assertThat(crudRepository.count()).isEqualTo(0);
    }

    @Test
    void testDeleteAll() {
        //given
        crudRepository.save(new Entity());
        crudRepository.save(new Entity());
        //when
        crudRepository.deleteAll();
        //then
        assertThat(crudRepository.count()).isEqualTo(0);
    }
}