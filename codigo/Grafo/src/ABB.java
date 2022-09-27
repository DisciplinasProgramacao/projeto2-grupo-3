import java.util.TreeMap;

public class ABB<T> {

    private TreeMap<Integer, T> data;

    public ABB(){
        this.data = new TreeMap<>();
    }

    public T get(Integer i){
        return data.get(i);
    }

    public T find(int key){
        return this.data.get(key);
    }

    public boolean add(int key, T newElement){
        boolean result = false;
        if(!this.data.containsKey(key)){
            this.data.put(key, newElement);
            result = true;
        }
        return result;
    }

    public boolean remove(int key){
        boolean result = false;
        if(this.data.containsKey(key)){
            this.data.remove(key);
            result = true;
        }
        return result;
    }

    public boolean containsKey(Object key) {
        return data.containsKey((int)key);
    }

    public int size(){
        return this.data.size();
    }

    public T[] allElements(T[] array){
        T[] allData = this.data.values().toArray(array);
        return allData;
    }

    public Integer[] allKeys(){
        return (Integer[])this.data.keySet().toArray();
    }
}
