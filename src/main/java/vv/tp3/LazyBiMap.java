package vv.tp3;


import vv.tp3.factory.Factory;


public class LazyBiMap<K,V> extends BiMap<K,V> {

    Factory<K, V> keyFactory;
    Factory<V, K> valueFactory;

    public LazyBiMap(Factory<K, V> keyFactory, Factory<V, K> valueFactory) {

        this.keyFactory=keyFactory;
        this.valueFactory=valueFactory;

   }

    @Override
    public K getByValue(Object value) {
        if(valueList.indexOf(value)==-1){
            valueList.add((V)value);
            K key=keyFactory.transform((V)value);
            keyList.add(key);
            return key;
        }
        else{
            return super.getByValue(value);
        }

    }

    @Override
    public V get(Object key) {
        if (keyList.indexOf(key)==-1){
            keyList.add((K)key);
            V value=valueFactory.transform((K)key);
            valueList.add(value);
            return value;


        }
        else {

            return super.get((K) key);
        }
    }
}
