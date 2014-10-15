package vv.tp3;

/**
 * Created by Simon on 30/09/14.
 */
public class BiMap<K,V> extends SimpleMap<K,V> {


    public K getByValue(Object value) {

        int index =valueList.indexOf(value);
        if(index!= -1)
        {
            return keyList.get(index);
        }
        else
        {
            return null;
        }
    }

    public K removeValue(Object key) {


        return null;
    }//

    @Override
    public V put(K key, V value)
    {
        int index =valueList.indexOf(value);
        if(index != -1)
        {
            keyList.set(index, key);
        }
        else
        {
            int indexk =keyList.indexOf(value);
            if(indexk != -1)
            {
                valueList.set(indexk, value);
            }
            else
            {
                super.put(key, value);
            }
        }
        return value;
    }
}