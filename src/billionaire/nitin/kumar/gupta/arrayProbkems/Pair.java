package billionaire.nitin.kumar.gupta.arrayProbkems;

public class Pair<T, K> {
    T t;
    K k;

    public Pair(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }
}
