package ru.itis.game.repositories;


import ru.itis.game.models.Shot;

// <Shot, Long> - Long здесь, т.к. мы храним id выстрела (Shot) в базе
public interface ShotsRepository extends CrudRepository<Shot, Long> {
}
