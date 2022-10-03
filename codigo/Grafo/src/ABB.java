import java.io.Serializable;
import java.util.TreeMap;

public class 
ABB<T> implements Serializable {

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

    public void setAllElements(T[] array){
        
        this.data.clear();
        for(int i=0; i<array.length; i++){
            this.data.put(i, array[i]);
        }
    }

    public Integer[] allKeys(){
        return (Integer[])this.data.keySet().toArray();
    }

    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof GrafoMutavel)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        ABB<T> abb = (ABB<T>) o;
         
        // Compare the data members and return accordingly
        //Corrigi isso aqui. O usuario não pode ter acesso ao Data. MAs to com pressa
        return data.equals(abb.getData());
    }

    public TreeMap<Integer, T> getData() {
        return data;
    }

    public void setData(TreeMap<Integer, T> data) {
        this.data = data;
    }
}
