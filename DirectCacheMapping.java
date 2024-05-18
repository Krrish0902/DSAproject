import javax.swing.*;
import java.awt.*;
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
            JOptionPane.showMessageDialog(null, "Cache hit! Address: " + address + " found in cache line " + index);
            cache[index] = address;
        } else {
            JOptionPane.showMessageDialog(null, "Cache miss! Address: " + address + " not found in cache line " + index+"\nLoading block into cache line " + index);
            cache[index] = address;
            tags[index] = tag;
        }
    }

    public void displayCache() {
        ImageIcon im = new ImageIcon("caheph.jpg");
        JFrame fr =new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setTitle("Cache Content");
        fr.setIconImage(im.getImage());
        fr.setSize(250,650);
        fr.setVisible(true);
        fr.setLayout(new GridLayout(cacheSize,1));
        //System.out.println("Cache content:");
        for (int i = 0; i < cacheSize; i++) {
            if (cache[i] != -1) {
                JButton butt= new JButton("cache line "+String.valueOf(i)+": Address "+String.valueOf(cache[i])+", Tag "+String.valueOf(tags[i]));
                butt.setBackground(Color.green);
                butt.setOpaque(true);
                fr.add(butt);
                //System.out.println("Cache line " + i + ": Address " + cache[i] + ", Tag " + tags[i]);
            } else {
                JButton butt= new JButton("Cache line " + String.valueOf(i) + ": empty");
                butt.setBackground(Color.red);
                butt.setOpaque(true);
                fr.add(butt);
                //System.out.println("Cache line " + i + ": empty");
            }
        }
    }
        

    public static void main(String[] args){

        String message ="Select Which Option to Perform ";

        String title = "Cache Mapping Techniques";

        Object[] options = {"Direct", "Assosiative", "Set-Assosiative"};
        
        int result = JOptionPane.showOptionDialog(
                null, 
                message, 
                title,
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]
        );
        

        if(result== JOptionPane.YES_OPTION){

        int cacheSize =Integer.parseInt(JOptionPane.showInputDialog("Enter cache size (number of lines): "));

        int blockSize = Integer.parseInt(JOptionPane.showInputDialog("Enter block size (in bytes): "));

        DirectCacheMapping cache = new DirectCacheMapping(cacheSize, blockSize);

        while (true) {
            int address =  Integer.parseInt(JOptionPane.showInputDialog("Enter a memory address to access (-1 to exit): "));
            if (address == -1) {
                JOptionPane.showMessageDialog(null,"EXITING...");
                break;
            }
            cache.accessMemory(address);
            cache.displayCache();
        }
    }
    }
}
