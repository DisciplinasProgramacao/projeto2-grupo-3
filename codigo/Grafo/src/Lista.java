
import java.io.Serializable;
import java.util.LinkedList;

public class Lista<T> implements Serializable{

    private LinkedList<T> data;

    public Lista() {
        this.data = new LinkedList<>();
    }

    public boolean add(T newElement) {
        return this.data.add(newElement);
    }

    public T[] allElements(T[] array) {
        T[] allData = this.data.toArray(array);
        return allData;
    }
    
    public boolean exist(T element){
        return data.contains(element);
    }
    
    public int size(){
        return data.size();
    }

}
