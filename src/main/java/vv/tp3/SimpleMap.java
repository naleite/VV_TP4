package vv.tp3;

import java.util.*;

public class SimpleMap<K,V> implements Map<K,V> {

    List<K> keyList = new ArrayList();
    List<V> valueList = new ArrayList();

    @Override
    public int size() {
        return keyList.size();
    }

    @Override
    public boolean isEmpty() {
        return keyList.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keyList.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return valueList.contains(value);
    }

    @Override
    public V get(Object key) {
        return valueList.get(keyList.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        keyList.add(key);
        valueList.add(value);
        return value;
    }

    @Override
    public V remove(Object key) {
        int index = keyList.indexOf(key);
        if(index==-1) //si le key n'existe pas
        {
            return null;
        }
        else
        {
            keyList.remove(index);
            V elt = valueList.get(index);
            valueList.remove(index);
            return elt;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {


        Iterator iterator = m.keySet().iterator();
        while(iterator.hasNext()){
            Object key   = iterator.next();
            Object value = m.get(key);
            keyList.add(((K) key));
            valueList.add(((V) value));
        }
    }

    @Override
    public void clear() {
        keyList.clear();
        valueList.clear();
    }

    @Override
    public Set<K> keySet() {

        return new HashSet(keyList);
    }

    @Override
    public Collection<V> values() {
        return valueList;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set s = new HashSet();
        Iterator iterator = keyList.iterator();
        while(iterator.hasNext())
        {
            K key   =(K) iterator.next();
            V value =get(key);
            Entry<K,V> e = new AbstractMap.SimpleEntry<K, V>(key, value);
            s.add(e);
        }
        return s;
    }
}
