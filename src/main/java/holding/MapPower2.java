package holding;

/**
 * @author plusman
 * @since 2021/10/18 3:27 PM
 */
public class MapPower2 {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(17));
    }
    
    static final int tableSizeFor(int cap) {
        int n = cap - 1; // 如果输入是 2的整次幂，- 1 防止最后容量直接翻倍。
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        
        return n + 1;
    }
}
