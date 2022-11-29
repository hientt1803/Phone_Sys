/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.dao;

import java.util.List;

/**
 *
 * @author NP
 */

public abstract class PhoneSysDAO<E, K> {

    abstract public void insert(E entity);

    abstract public void update(E entity);

    abstract public void delete(K key);

    abstract public List<E> selectAll();

    abstract E selectByid(K key);

    abstract public List<E> selectBySql(String sql, Object... args);
}
