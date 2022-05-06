package billionaire.concept.of.success;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hashtable write operation uses map wide lock which means it locks the complete map object.
 * Thread T1 calls get()/put() operation on Hashtable and acquires the lock on complete hashtable object.
 * link concurrent working <a>resources/0_qO64Hu9t5mBN7T4f.png</a>
 * <p></p>
 * 4.1 Threads acquiring lock on ConcurrentHashMap for Multi Threading Environment
 *
 * <br>
 * ConcurrentHashMap works a bit different as it acquires lock per Segment which means instead of single map wide lock, it has multiple Segment level locks. it uses a Locking technique name ReentrantLock
 * <br>
 * So 2 Threads operating on different segments can acquire lock on those segments without interfering with each other and can proceed simultaneously as they are working on separate Segment locks.
 *
 *6. LoadFactor and Rehashing
 * <p></p>
 * ConcurrentHashMap has loadFactor which decides when exactly to increase the capacity of ConcurrentHashMap by calculating threshold (initialCapacity*loadFactor) and accordingly rehashing the map.
 *  * <p></p>
 *  Basically, Rehashing is the process of re-calculating the hashcode of already stored entries (Key-Value pairs), to move them to another bigger size map when Load factor threshold of bucket inside the segment is reached. Also It is not only done to distribute items across the new length map, but also when there are too many key collisions which increases entries in one bucket so that get and put operation time complexity remains O(1).
 *
 *  * <p></p>
 *  In ConcurrentHashMap, Every segment is separately rehashed so there is no collision between Thread 1 writing to Segment index 1 and Thread 2 writing to Segment index 4.
 * <p></p>
 * Example:- If say Thread 1 is putting data in Segment[] array index 3 and finds that HashEntry[] array needs to be rehashed due to exceed Load factor capacity then it will rehash HashEntry[] array present at Segment[] array index 3 only. HashEntry[] array at other Segment indexes will still be intact, unaffected and continue to serve put and get request in parallel.
 * @param <K>
 * @param <V>
 */

public abstract class CustomConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    int initialCapacity,  concurrencyLevel;
    float loadFactor;

    //5.1 Constructor for the concurrent HashMap
  //  CustomConcurrentHashMap map = new CustomConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel){
  //      this.initialCapacity=initialCapacity;
  //  }

    static final class HashEntry<K, V> {
        final int hash;
        final K key;
        volatile V val;
        volatile HashEntry<K,V> next;

        HashEntry(int hash, K key, V val) {
            this.hash = hash;
            this.key = key;
            this.val = val;
        }

        HashEntry(int hash, K key, V val, HashEntry<K,V> next) {
            this(hash, key, val);
            this.next = next;
        }
    }

    static class Segment<K,V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;
        Segment(float lf) { this.loadFactor = lf; }

        //The number of elements in this segment's region.
        transient volatile int count;
        //The per-segment table.
        transient volatile HashEntry<K,V>[] table;
    }
    //Segment index calculation
   // final Segment<K,V> segmentFor(int hash) {
  //      return segments[(hash >>> segmentShift) & segmentMask];
   // }

        /** STEP-1 : calculation of Hashcode (hash index for the bucket(array)
         * which is present inside the segment) for the key
          */
        //CALCULATION OF HASHINDEX
        private static int hash(int h) {
            // Spread bits to regularize both segment and index locations,
            // using variant of single-word Wang/Jenkins hash.
            h += (h <<  15) ^ 0xffffcd7d;
            h ^= (h >>> 10);
            h += (h <<   3);
            h ^= (h >>>  6);
            h += (h <<   2) + (h << 14);
            return h ^ (h >>> 16);
        }

        //STEP-3 : Calculation of Segment Shift and Segment Mask with the Help of Concurrency Level provided in constructor

        private static void SegmentDetails(int concurrencyLevel) {
            int sshift = 0;
            int segmentMask = 0;
            int segmentShift = 0;

            int ssize = 1;
            while (ssize < concurrencyLevel) {
                ++sshift;
                ssize <<= 1;
            }
            segmentShift = 32 - sshift;
            segmentMask = ssize - 1;
            System.out.println("Segment array size :" + ssize);
            System.out.println("segmentShift : " + segmentShift);
            System.out.println("segmentMask : " + segmentMask);
        }
    }


