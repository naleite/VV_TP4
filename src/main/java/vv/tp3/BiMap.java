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


        int index = valueList.indexOf(key);
        if(index==-1) //si le key n'existe pas
        {
            return null;
        }
        else
        {
            valueList.remove(index);
            K elt = keyList.get(index);
            keyList.remove(index);
            return elt;
        }

    }//

    @Override
    public V put(K key, V value)
    {

        this.remove(key);

        int index= valueList.indexOf(value);
        if(index != -1)
        {
            valueList.remove(index);
            keyList.remove(index);
        }


        super.put(key, value);

        return value;
    }

}