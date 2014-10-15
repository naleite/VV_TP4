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
        int index = keyList.indexOf(key);
        if(index == -1)
        {
            return null;
        }
        else
        {
            return valueList.get(index);
        }

    }

    @Override
    public V put(K key, V value) {

        int index = keyList.indexOf(key);
        if(index!= -1)
        {
            valueList.set(index, value);
        }
        else
        {
            keyList.add(key);
            valueList.add(value);

        }
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

    @Override //redefinition de la methode equals
    public boolean equals(Object o)
    {
        //recupere la deuxieme
        Map<K, V> m2 = (Map<K, V>) o;
        Iterator iterator = keyList.iterator();

        //on regarde si le size des deux maps sont égaux
        if(m2.size() != this.size())
        {
            return false;
        }
        while(iterator.hasNext())
        {
            K key   =(K) iterator.next();
           if(m2.keySet().contains(key))
           {
               V val2 = m2.get(key);
               V val = this.get(key);
               if(!val2.equals(val))
               {
                    return false;
               }
           }

        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return this.entrySet().hashCode();
    }
}
