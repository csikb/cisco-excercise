package dev.csik.cisco.exercise.common;

public interface EntityModelMapper<E, M> {
    M entityToModel(E entity);
}
