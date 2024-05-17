
import java.util.Scanner;

public class DirectCacheMapping {
    private int cacheSize; // Number of cache lines
    private int blockSize; // Size of each block in bytes
    
    private int[] cache;
    private int[] tags;

    public DirectCacheMapping(int cacheSize, int blockSize) {
        this.cacheSize = cacheSize;
        this.blockSize = blockSize;
        cache = new int[cacheSize];
        tags = new int[cacheSize];
        // Initialize the cache and tags
        for (int i = 0; i < cacheSize; i++) {
            cache[i] = -1; // -1 indicates an empty line
            tags[i] = -1; // -1 indicates an invalid tag
        }
    }

    private int getCacheIndex(int address) {
        return (address / blockSize) % cacheSize;
    }

    private int getTag(int address) {
        return (address / blockSize) / cacheSize;
    }

    public void accessMemory(int address) {
        int index = getCacheIndex(address);
        int tag = getTag(address);

        if (tags[index] == tag) {
            System.out.println("Cache hit! Address: " + address + " found in cache line " + index);
            cache[index] = address;
        } else {
            System.out.println("Cache miss! Address: " + address + " not found in cache line " + index);
            System.out.println("Loading block into cache line " + index);
            cache[index] = address;
            tags[index] = tag;
        }
    }

    public void displayCache() {
        System.out.println("Cache content:");
        for (int i = 0; i < cacheSize; i++) {
            if (cache[i] != -1) {
                System.out.println("Cache line " + i + ": Address " + cache[i] + ", Tag " + tags[i]);
            } else {
                System.out.println("Cache line " + i + ": empty");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cache size (number of lines): ");
        int cacheSize = scanner.nextInt();

        System.out.print("Enter block size (in bytes): ");
        int blockSize = scanner.nextInt();

        DirectCacheMapping cache = new DirectCacheMapping(cacheSize, blockSize);

        while (true) {
            System.out.print("Enter a memory address to access (-1 to exit): ");
            int address = scanner.nextInt();
            if (address == -1) {
                break;
            }
            cache.accessMemory(address);
            cache.displayCache();
        }

        scanner.close();
    }
}
