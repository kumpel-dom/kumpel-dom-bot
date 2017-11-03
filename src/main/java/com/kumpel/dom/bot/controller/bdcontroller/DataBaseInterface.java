package com.kumpel.dom.bot.controller.bdcontroller;

import java.util.List;

public interface DataBaseInterface<T> {

    void create(T table);
    List<T> read();
    void update(T table);
    void delete(T table);
}
