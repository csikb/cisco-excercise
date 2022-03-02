package dev.csik.cisco.exercise.common;

public interface ModelEntityMapper<M, E> {
    E modelToEntity(M model);
}
